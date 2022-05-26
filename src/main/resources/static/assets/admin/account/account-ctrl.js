app.controller("account-ctrl", function($scope, $http, $location) {
    $scope.items = [];

    $scope.form = {};
    

    $scope.initialize = function() {
        $http.get("/rest/accounts2s?admin=true").then(resp => {
            $scope.items = resp.data;
            
        }).catch(error =>{
            $location.path("/");
        })
       
    }
    $scope.initialize();
    $scope.reset = function() {
        $scope.form = {
            image: 'cloud-upload.jpg',
        }
    }
    $scope.edit = function(item){
		$scope.form = angular.copy(item);
		$('#pills-home-tab').tab('show');
    }
    $scope.create = function() {
        var item = angular.copy($scope.form); 
        console.log(item);
        $http.post(`/rest/accounts2s`, item).then(resp => {
            $scope.items.push(resp.data);
           
            $scope.reset();
            alert("Thêm tài khoản thành công");
        }).catch(error => {
            alert("Lỗi thêm tài khoản");
            console.log("Error", error);
        })
    }
    $scope.update = function(item) {
        var item = angular.copy($scope.form);
        $http.put(`/rest/accounts2s/${item.username}`, item).then(resp => {
            var index = $scope.items.findIndex(p => p.username == item.username);
            $scope.items[index] = item;
            alert("Cập nhật thành công");
        }).catch(error => {
            alert("Lỗi cập nhật");
            console.log("Error", error);
        })
    }
    $scope.delete = function(item) {
        $http.delete(`/rest/accounts2s/${item.username}`, item).then(resp => {
            var index = $scope.items.findIndex(p => p.username == item.username);
            $scope.items.splice(index, 1);
            $scope.reset();
            alert("Xóa thành công");
        }).catch(error => {
            alert("Xóa thất bại");
            console.log("Error", error);
        })
    }
    $scope.imageChanged = function(files) {
        var data = new FormData();
        console.log(data);
        data.append('file', files[0]);
        $http.post('/rest/upload/images', data, {
            transformRequest: angular.identity,
            headers: { 'Content-Type': undefined }
        }).then(resp => {
            $scope.form.image = resp.data.name;
        }).catch(error => {
            alert("Lỗi upload");
            console.log("Error", error);
        })
    }
    $scope.pager = {
        page: 0,
        size: 10,
        get items() {
            var start = this.page * this.size;
            return $scope.items.slice(start, start + this.size);
        },
        get count() {
            return Math.ceil(1 * $scope.items.length / this.size);
        },
        first() {
            this.page = 0;
        },
        prev() {
            this.page--;
            if (this.page < 0) {
                this.last();
            }
        },
        next() {
            this.page++;
            if (this.page >= this.count) {
                this.first();
            }
        },
        last() {
            this.page = this.count - 1;
        }
    }
});
app.controller("glass-ctrl", function($scope, $http) {
    $scope.items = [];

    $scope.form = {};

    $scope.initialize = function() {
        $http.get("/rest/glasses").then(resp => {
            $scope.items = resp.data;
            console.log(data)
           
        });

        
    }
    $scope.initialize();
    $scope.reset = function() {
        $scope.form = {
            
        }
    }
    $scope.edit = function(item){
		$scope.form = angular.copy(item);
		$('#pills-home-tab').tab('show');
    }
    $scope.create = function() {
        var item = angular.copy($scope.form);
        $http.post(`/rest/glasses`, item).then(resp => {
            resp.data, createDate = new Date(resp.data.createDate);
            $scope.items.push(resp.data);
            $scope.reset();
            alert("Thêm mới thành công");
        }).catch(error => {
            alert("Lỗi thêm sản phẩm");
            console.log("Error", error);
        })
    }
    $scope.update = function(item) {
        var item = angular.copy($scope.form);
        $http.put(`/rest/glasses/${item.id}`, item).then(resp => {
            var index = $scope.items.findIndex(p => p.id == item.id);
            $scope.items[index] = item;
            alert("Cập nhật thành công");
        }).catch(error => {
            alert("Lỗi cập nhật");
            console.log("Error", error);
        })
    }
    $scope.delete = function(item) {
        $http.delete(`/rest/glasses/${item.id}`, item).then(resp => {
            var index = $scope.items.findIndex(p => p.id == item.id);
            $scope.items.splice(index, 1);
            $scope.reset();
            alert("Xóa thành công");
        }).catch(error => {
            alert("Lỗi xóa sản phẩm");
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
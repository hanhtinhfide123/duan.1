app.controller("order-ctrl", function($scope, $http) {
    $scope.items = [];
    $scope.orderds = [];
    $scope.form = {};

    $scope.initialize = function() {
        $http.get("/rest/orders").then(resp => {
            $scope.items = resp.data;
            console.log(resp.data)
    
        });
     	 //load categories
       $http.get("/rest/status").then(resp =>{
           $scope.stus = resp.data;
       })
        
        
 
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
    
    
    $scope.update = function(item) {
        var item = angular.copy($scope.form);
        $http.put(`/rest/orders/${item.id}`, item).then(resp => {
            var index = $scope.items.findIndex(p => p.id == item.id);
            $scope.items[index] = item;
            console.log(item);
       
            alert("Cập nhật thành công");
        }).catch(error => {
            alert("Lỗi cập nhật");
            console.log("Error", error);
        })
    }
 	 $scope.delete = function(item) {
        $http.delete(`/rest/orders/${item.id}`, item).then(resp => {
            var index = $scope.items.findIndex(p => p.id == item.id);
            $scope.items.splice(index, 1);
            $scope.reset();
            alert("Xóa thành công");
        }).catch(error => {
            alert("Lỗi xóa hóa đơn");
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
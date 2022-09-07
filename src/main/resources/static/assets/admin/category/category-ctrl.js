app.controller("category-ctrl", function ($scope, $http) {

    $scope.items = [];
    $scope.form = {};
    $scope.initialize = function () {
        $http.get("/rest/categories").then(resp => {
            alert("rest");
            $scope.items = resp.data;
        });
    }
    //khởi đàu
    $scope.initialize();

    //xóa form
    $scope.reset = function () {
        $scope.form = {}
    };

    //hiển thị form
    $scope.edit = function (item) {
        $scope.form = angular.copy(item);
        $(".nav-tabs a:eq(0)").tab('show')
    }

    //thêm mới sản phảm
    $scope.create = function () {
        var item = angular.copy($scope.form);
        $http.post('/rest/categories', item).then(resp => {
            $scope.items.push(resp.data);
            $scope.reset();
            alert("Thêm mới thành công")
        }).catch(error => {
            alert("Lỗi thêm mới sản phẩm");
            console.log("Error", error);
        });
    }
    //Cập nhật sản phẩm
    $scope.update = function () {
        var item = angular.copy($scope.form);
        $http.put(`/rest/categories/${item.id}`, item).then(resp => {
            var index = $scope.items.findIndex(p => p.id == item.id);
            $scope.items[index] = item;
            alert("Cập nhật thành công");
        }).catch(error => {
            alert("Lỗi cập nhật sản phẩm")
            console.log("Error", error);
        });
    }
    //Xóa sản phẩm
    $scope.delete = function (item) {
        // alert("delete")
        $http.delete(`/rest/categories/${item.id}`).then(resp => {
            var index = $scope.items.findIndex(p => p.id == item.id);
            $scope.items.splice(index, 1);
            $scope.reset();
            alert("Xóa thành công");
        }).catch(error => {
            alert("Lỗi xóa sản phẩm")
            console.log("Error", error);
        });
    }

});

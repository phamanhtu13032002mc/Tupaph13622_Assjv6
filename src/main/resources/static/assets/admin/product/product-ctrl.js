app.controller("product-ctrl", function ($scope, $http) {

    $scope.items = [];
    $scope.cates = [];
    $scope.form = {};
    $scope.initialize = function () {
        //load product
        $http.get("/rest/products").then(resp => {
            $scope.items = resp.data;

            alert("produc");
            $scope.items.forEach(item => {
                item.createdata = new Date(item.createdata)
            })
        });
        //load category
        $http.get("/rest/categories").then(resp => {
            $scope.cates = resp.data;

        });
    }
    //khởi đàu
    $scope.initialize();

    //xóa form
    $scope.reset = function () {
        $scope.form = {
            createdata: new Date(),
            image: 'cloud-upload.jpg',
            available: true,
        }
    };

    //hiển thị form
    $scope.edit = function (item) {
        $scope.form = angular.copy(item);
        $(".nav-tabs a:eq(0)").tab('show')
    }

    //thêm mới sản phảm
    $scope.create = function () {
        var item = angular.copy($scope.form);
        $http.post('/rest/products', item).then(resp => {
            resp.data.createdata = new Date(resp.data.createdata)
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
        $http.put(`/rest/products/${item.id}`, item).then(resp => {
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
        $http.delete(`/rest/products/${item.id}`).then(resp => {
            var index = $scope.items.findIndex(p => p.id == item.id);
            $scope.items.splice(index, 1);
            $scope.reset();
            alert("Xóa thành công");
        }).catch(error => {
            alert("Lỗi xóa sản phẩm")
            console.log("Error", error);
        });

    }
    //uoload hình
    $scope.imageChanged = function (files) {
        var data = new FormData();
        data.append('file', files[0]);
        $http.post('/rest/upload/img', data, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        }).then(resp => {
            $scope.form.image = resp.data.name;
        }).catch(error => {
            alert("Lỗi load hình ảnh");
            console.log("Error", error)
        })
    }
    $scope.pager={
        page:0,
        size:10,
        get items(){
            var start = this.page*this.size;
            $scope.items.slice(start,start+this.size);

        },
        get count(){
            return Math.ceil(1.0*$scope.items.length/this.size);
        },
        first(){
            this.page=0;
        },
        prev(){
            this.page --;
            if (this.page < 0){
                this.last();
            }
        },
        next(){
            this.page ++;
            if (this.page >= this.count){
                this.first();
            }
        },
        last(){
            this.page = this.count -1;
        }
    }
});

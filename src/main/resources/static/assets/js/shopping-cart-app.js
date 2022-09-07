const app = angular.module("shopping-cart-app", []);
app.controller("shopping-cart-ctrl", function ($scope, $http) {
    /**
     Quản lý giỏ hàng
     */
    $scope.cart = {
        items: [],
        //thêm sản phẩm vào giỏ hàng
        add(id) {
            // alert(id);
            var item = this.items.find(item => item.id == id);
            if (item) {
                item.qty++;
                this.saveToLocalStorage();
            } else {
                $http.get(`/rest/products/${id}`).then(resp => {
                    resp.data.qty = 1;
                    this.items.push(resp.data);
                    this.saveToLocalStorage();
                })
            }
        },
        //xóa sản phẩm khỏi giỏ hàng
        remove(id) {
            var index = this.items.findIndex(item => item.id == id);
            this.items.splice(index, 1);
            this.saveToLocalStorage();
        },
        //xóa sạch sản phẩm khỏi giỏ hàng
        clear() {
            this.items = []
            this.saveToLocalStorage();
        },
        //tính tiền của 1 sản phẩm
        amt_of(item) {
        },
        //tính tổng số lượng các mặt hàng trong giỏ
        get count() {
            return this.items
                .map(item => item.qty)
                .reduce((total, qty) => total += qty, 0);
        },
        //Tổng thành tiền các mặt hàng trong giỏ
        get amount() {
            return this.items
                .map(item => item.qty * item.price)
                .reduce((total, qty) => total += qty, 0);
        },
        //lưu giỏ hàng váo local storage
        saveToLocalStorage() {
            var json = JSON.stringify(angular.copy(this.items));
            localStorage.setItem("cart", json);
        },
        //đọc giỏ hàng từ local storage
        loadFromLocalStorage() {
            var json = localStorage.getItem("cart");
            this.items = json ? JSON.parse(json) : [];
        }
    }
    $scope.cart.loadFromLocalStorage();
    $scope.order = {
        createdate: new Date(),
        address: "",
        account: {username: $("#username").text()},
        get orderDetails() {
            return $scope.cart.items.map(item => {
                return {
                    product: {id: item.id},
                    price: item.price,
                    quantity: item.qty,
                    status: 1
                }
            });
        },
        purchase() {
            var order = angular.copy(this);
            //thực hiện đặt hàng
            $http.post("/rest/orders", order).then(resp => {
                alert("đặt hàng thành công");
                $scope.cart.clear();
                location.href = "/order/detail/" + resp.data.id;
            }).catch(error => {
                alert("đặt hàng lỗi")
                console.log(error)
            })

        }
    }
})

function dat() {
    var number = document.getElementById("keyword").value;
    window.location.assign("http://localhost:8080/home/search?keyword" + "=" + number);
}

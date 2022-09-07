var app = angular.module("admin-app", ["ngRoute"]);

app.config(function ($routeProvider) {

    $routeProvider
        // .when("/baocao", {
        //     templateUrl: "/admin/baocao/thongke.html",
        //     controller: "thongke-ctrl"
        // })
        .when("/product", {
            templateUrl: "/assets/admin/product/index.html",
            controller: "product-ctrl"
        })
        .when("/category", {

            templateUrl: "/assets/admin/category/index.html",
            controller: "category-ctrl"
        })
        // .when("/account", {
        //     templateUrl: "/admin/account/index.html",
        //     controller: "account-ctrl"
        // })
        .when("/authorize", {
            templateUrl: "/assets/admin/authority/index.html",
            controller: "authority-ctrl"
        })
        .when("/unauthorized", {
            templateUrl: "/assets/admin/authority/unauthorized.html",
            controller: "authority-ctrl"
        })

})
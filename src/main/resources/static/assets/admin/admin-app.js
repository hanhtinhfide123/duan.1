app = angular.module("admin-app",["ngRoute"]);

app.config(function($routeProvider) {
    $routeProvider
    .when("/product",{
        templateUrl:"/assets/admin/product/index.html",
        controller: "product-ctrl"
    })
    .when("/account",{
        templateUrl:"/assets/admin/account/index.html",
        controller: "account-ctrl"
    })
    .when("/summary",{
        templateUrl:"/assets/admin/summary/index.html",
        controller: "summary-ctrl"
    })
     .when("/category",{
        templateUrl:"/assets/admin/category/index.html",
        controller: "category-ctrl"
    })
    .when("/authorize",{
        templateUrl:"/assets/admin/authority/index.html",
        controller: "authority-ctrl"
    })

    .when("/brand",{
        templateUrl:"/assets/admin/brand/index.html",
        controller: "brand-ctrl"
    })
     .when("/movement",{
        templateUrl:"/assets/admin/movement/index.html",
        controller: "movement-ctrl"
    })
     .when("/material",{
        templateUrl:"/assets/admin/material/index.html",
        controller: "material-ctrl"
    })
    .when("/glass",{
        templateUrl:"/assets/admin/glass/index.html",
        controller: "glass-ctrl"
    })
    .when("/water",{
        templateUrl:"/assets/admin/water/index.html",
        controller: "water-ctrl"
    })
     .when("/strap",{
        templateUrl:"/assets/admin/strap/index.html",
        controller: "strap-ctrl"
    })
    .when("/collection",{
        templateUrl:"/assets/admin/collection/index.html",
        controller: "collection-ctrl"
    })
    .when("/order", {
        templateUrl: "/assets/admin/order/index.html",
        controller: "order-ctrl"
        })
    .when("/unauthorized",{
        templateUrl:"/assets/admin/authority/unauthorized.html",
        controller: "authority-ctrl"
    })
    .otherwise({
        redirectTo: "/product",
        controller: "product-ctrl"
    })
})
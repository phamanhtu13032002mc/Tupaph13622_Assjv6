app.controller("authority-ctrl", function ($scope, $http, $location) {
    $scope.roles = [];
    $scope.admins = [];
    $scope.authorities = [];
    //load all

    $scope.initialize = function () {
        $http.roles("/rest/roles").then(resp =>{
            $scope.roles = resp.data;
        })
        //load staff admiitrations
        $http.get("/rest/accounts?admin=true").then(resp =>{
            $scope.admins = resp.data;
        })
        //load authories va director (adminnatration)
        $http.get("/rest/authorities?admin=true").then(resp =>{
            $scope.authorities=resp.data;
        }).catch(error =>{
            $location.path("/unauthorized")
        })
    }
})
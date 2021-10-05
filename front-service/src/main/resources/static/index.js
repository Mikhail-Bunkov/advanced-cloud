angular.module('app').controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:5555/product-service/api/v1/products';


    $scope.load = function () {
        $http({
            url: contextPath,
            method: 'GET',
        }).then(function (response) {
            $scope.products = response.data;
            console.log(response.data);
        });
    };

    $scope.load();
});
'use strict'

angular.module('app', ['ngRoute'])
    .config(function($routeProvider, $httpProvider) {

        $routeProvider.when('/', {
            templateUrl: 'home.html',
            controller: 'home'
        }).otherwise('/');

        $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
    })
    .controller('home', function($rootScope, $scope, $http) {

        $scope.sqlValue = "";
        $scope.sqlState = "";

        $scope.isSqlEmpty = function() {
            var value = $scope.sqlValue.length <= 0 ? true : false;
            return value;
        },

        $scope.submit = function(){

            var requestUrl = '/sqlvalidate?query=' + $scope.sqlValue;
            $http.get(requestUrl).success(function(data) {
               var myjson = data;
               // alert(data.state + data.message);
               $scope.sqlState = data.state + data.message;
            })
        },

        $scope.clear = function(){
            $scope.sqlValue = "";
            $scope.sqlState = "";
        },

        $scope.greeting = {id: '0', content: 'Hello World!'}
        $http.get('/resource/').success(function(data) {
            $scope.greeting = data;
            $rootScope.authenticated = true;
        })
    })

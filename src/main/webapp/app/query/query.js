'use strict';

angular.module('myApp.query', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/query', {
    templateUrl: 'query/query.html',
    controller: 'queryCtrl'
  });
}])

.controller('queryCtrl', ["$scope", function($scope) {
    
}]);
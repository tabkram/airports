'use strict';

angular.module('myApp.query', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/query', {
    templateUrl: 'query/query.html',
    controller: 'queryCtrl'
  });
}])

.controller('queryCtrl', ["$scope","QueryService", function($scope, QueryService) {

    $scope.selectedCountry = function(selection){
        console.log(QueryService.findAirports(selection.originalObject.code));
        QueryService.findAirports(selection.originalObject.code).then(function(reponse){
           $scope.airports = reponse.data ;
        });
    };

    $scope.getRunways = function(ident){
        QueryService.findRunways(ident).then(function(reponse){
            $scope.runwways = reponse.data ;
        });
    };

}]);
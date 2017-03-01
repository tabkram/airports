'use strict';

angular.module('myApp.reports', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/reports', {
    templateUrl: 'reports/reports.html',
    controller: 'reportsCtrl'
  });
}])

.controller('reportsCtrl', ['$scope', 'ReportsService', function($scope, ReportsService) {
  ReportsService.getAllCountries().then(function(reponse){
    $scope.countries = reponse.data ;
  });
}]);
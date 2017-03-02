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

  ReportsService.getAirportsNumberPerCountry(false).then(function(reponse){
    $scope.lowestAirportsNumber = reponse.data ;
  });

  ReportsService.getAirportsNumberPerCountry(true).then(function(reponse){
    $scope.highestAirportsNumber = reponse.data ;
  });

  $scope.getRunwayTypes = function(country){
    ReportsService.getRunwayTypes(country.code).then(function(reponse){
      $scope.selectedCountry = country;
      $scope.runwayTypes = reponse.data ;
    });
  }

    ReportsService.getCommonRunways().then(function(reponse){
      $scope.commonRunways = reponse.data ;
    });
}]);
'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
  'ngRoute',
  "angucomplete-alt",
  'myApp.query',
  'myApp.reports',
  'myApp.version',
]).
config(['$locationProvider', '$routeProvider', function($locationProvider, $routeProvider) {
  $locationProvider.hashPrefix('!');

  $routeProvider.otherwise({redirectTo: '/query'});
}]);

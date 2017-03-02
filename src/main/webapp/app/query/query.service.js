(function() {
    'use strict';

    angular.module("myApp.query").service('QueryService', QueryService);

    QueryService.$inject =  ["$http"];

    function QueryService($http) {

        return  {
            findAirports : findAirports,
            findRunways: findRunways
        };

        function findAirports(country){
           return  $http({
               method: 'GET',
               url: 'api/rest/countries/'+ country +'/airports'
           });
        }
        
        function findRunways(airport){
            return  $http({
                method: 'GET',
                url: 'api/rest/airports/' + airport  + '/runways'
            });
        }
    }
})();
(function() {
    'use strict';

    angular.module("myApp.query").service('ReportsService', ReportsService);

    ReportsService.$inject =  ["$http"];

    function ReportsService($http) {

        return  {
            getAllCountries : getAllCountries,
            getRunwayTypes : getRunwayTypes,
            getAirportsNumberPerCountry : getAirportsNumberPerCountry,
            getCommonRunways : getCommonRunways
        };

       function getAllCountries(){
            return  $http({
                method: 'GET',
                url: 'api/rest/countries'
            });
        }

        function getAirportsNumberPerCountry(order) {
            return  $http({
                method: 'GET',
                url: 'api/rest/airports?order=' + order + '&max=10'
            });
        }

        function getRunwayTypes(code) {
            return  $http({
                method: 'GET',
                url: 'api/rest/countries/'+ code + '/runways/types'
            });
        }

        function getCommonRunways(){
            return  $http({
                method: 'GET',
                url: 'api/rest/runways/identifications?order=true&max=10'
            });
        }
    }
})();
(function() {
    'use strict';

    angular.module("myApp.query").service('ReportsService', ReportsService);

    ReportsService.$inject =  ["$http"];

    function ReportsService($http) {

        return  {
            getAllCountries : getAllCountries
        };

        function getAllCountries(){
            return  $http({
                method: 'GET',
                url: 'api/rest/countries'
            });
        }

    }
})();
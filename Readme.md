# Airports example


### Country Service

http://localhost:8080/api/rest/countries

http://localhost:8080/api/rest/countries/:country

example http://localhost:8080/api/rest/countries/tun
 
### Airport Service

http://localhost:8080/api/rest/countries/:country/airports

example http://localhost:8080/api/rest/countries/TN/airports

example http://localhost:8080/api/rest/countries/Tunisia/airports

### Runway Service

http://localhost:8080/api/rest/airports/:ident/runways

example http://localhost:8080/api/rest/airports/DTTA/runways


http://localhost:8080/api/rest/airports?order=false&max=2

http://localhost:8080/api/rest/countries/:country/runways/types

http://localhost:8080/api/rest/runways/identifications?order=false&max=10

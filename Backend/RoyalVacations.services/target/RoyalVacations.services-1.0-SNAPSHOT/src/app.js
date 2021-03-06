(function () {

    var mainApp = angular.module('mainApp', ['ngRoute', 'itinerarioModule', 'ciudadModule','paisModule','visitaModule','loginModule','eventoModule','eventoVisitaModule']);

    mainApp.config(['$routeProvider', function ($routeProvider) {
            $routeProvider.when('/itinerarios', {
                templateUrl: 'src/modules/itinerario/itinerario.tpl.html'
            }).when('/ciudades', {
                templateUrl: 'src/modules/ciudad/ciudad.tpl.html'
            }).when('/paises', {
                templateUrl: 'src/modules/pais/pais.tpl.html'
            }).when('/visitas', {
                templateUrl: 'src/modules/visita/visita.tpl.html'
            }).when('/login', {
                templateUrl: 'src/modules/login/login.tpl.html'
            }).when('/sesion', {
                templateUrl: 'src/modules/sesion/sesion.tpl.html'
            }).when('/evento', {
                templateUrl: 'src/modules/evento/evento.tpl.html'
            }).when('/eventoVisita', {
                templateUrl: 'src/modules/eventoVisita/eventoVisita.tpl.html'
            }).otherwise('/'); 
        }]);
})();
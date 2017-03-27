angular
    .module('app.routes', ['ngRoute'])
    .config(routes);

function routes($routeProvider) {
    $routeProvider
        .when('/',{
            templateUrl: 'sections/tpl.html',
            controller: 'defaultController',
            controllerAs:'defaultCtl'
        })
        .when('/404', {
            templateUrl: 'sections/404/404.tpl.html'
        })
        .otherwise({
            redirectTo: '/404'
        });
}
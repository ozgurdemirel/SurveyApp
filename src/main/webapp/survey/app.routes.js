angular
    .module('app.routes', ['ngRoute'])
    .config(routes);

function routes($routeProvider) {
    $routeProvider
        .when('/',{
            templateUrl: 'sections/default/default.tpl.html',
            controller: 'defaultController',
            controllerAs:'defaultCtl'
        })
        .when('/surveys',{
            templateUrl: 'sections/survey/survey.tpl.html',
            controller:'surveyController',
            controllerAs:'surveyCtl'
        })
        .when('/404', {
            templateUrl: 'sections/404/404.tpl.html'
        })
        .otherwise({
            redirectTo: '/404'
        });
}
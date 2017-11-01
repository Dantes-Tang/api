var app = angular.module('app', ['ngRoute','ui.router','ui.router.stateHelper','ui.bootstrap.datetimepicker']).config(['$routeProvider',
function($routeProvider) {
	$routeProvider.when('/skillset', {
		templateUrl : 'views/skillset.html'
	}).when('/flexibility', {
		templateUrl : 'views/flexibility.html'
	}).when('/search', {
		templateUrl : 'views/search.html'
	}).when('/source', {
		templateUrl: "views/source.html"
	}).when('/dict', {
		templateUrl: "views/dict.html"
	}).when('/roleManagement', {
		templateUrl : 'views/roleManagement.html'
	});
	$routeProvider.otherwise({
		redirectTo : '/skillset'
	});
}]);

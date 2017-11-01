/**
 *  @author Cornelius Huang
 *  on site controller
 */
app.controller('onsiteController', ['$scope', 'getCountriesSerivce', function($scope, getCountriesSerivce) {
	
	$scope.countries;
	
	getCountriesSerivce.getCountries().then(function(result) {
		$scope.countries = result;
	}, function(result) {
		console.log(result);
	})
}]);

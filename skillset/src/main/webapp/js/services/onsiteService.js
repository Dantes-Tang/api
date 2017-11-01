/**
 *  @author Cornelius Huang
 */
app.factory('getCountriesSerivce', ['$http', '$q', function($http, $q) {
	var baseUrl = '/DRMS/api';
	return {
		getCountries: function() {
			var promise = $q(function(resolve, reject) {
					$http({
						url: baseUrl + '/flexibility/getCountrys',
						method: 'GET'
					}).then(function(response) {
						resolve(response.data);
					}, function(response) {
						reject('getCountriesSerivce - getCountries REJECT');
					});
				});
			return promise;
		},
		getFlexibility: function(name) {
			var promise = $q(function(resolve, reject) {
				$http({
					url: baseUrl + '/flexibility/getFlexibility',
					method: 'GET'
				}).then(function(response) {
					resolve(response.data);
				}, function(response) {
					reject('getCountriesSerivce - getCountries REJECT');
				})
			})
		}
	}
}]);
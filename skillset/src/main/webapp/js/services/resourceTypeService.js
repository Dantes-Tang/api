/**
 *  @author Cornelius Huang
 *  resource type load service
 */
app.factory('resourceTypeService', ['$http', '$q', function($http, $q) {
	baseUrl = '/DRMS/api';
	return $q(function(resolve, reject) {
		$http({
			url: baseUrl + '/DrmsResourceType/searchAllResourceType',
			method: 'GET',
			headers: {
				
			}
		}).then(function(response) {
			resolve(response.data);
		}, function() {
			reject('resourceTypeService - reject');
		});
	});
}]);

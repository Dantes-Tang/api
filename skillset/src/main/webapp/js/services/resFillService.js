/**
 *  @author Cornelius Huang
 *  Resource fill service
 */
app.factory('resFillService', ['$http', '$q', function($http, $q) {
	baseUrl = '/DRMS/api';
	return function(dmdId, resId, capId) {
		var promise = $q(function(resolve, reject) {
			$http({
				url: baseUrl + '/DrmsDemand/updateMatchedResourceId',
				method: 'POST',
				headers: {
					'Content-Type': 'application/x-www-form-urlencoded'
				},
				data: 'dmdId='+dmdId+'&resourceId='+resId+'&capId='+capId
			}).then(function(response) {
				resolve(response.data);
			}, function(response) {
				reject('resFillService - reject');
			});
		})
		return promise;
	}
}]);

app.factory('slideEmailService', ['$http', '$q', function($http, $q) {
	var baseUrl = '/DRMS/api';
	return function(mailContent) {
		var promise = $q(function(resolve, reject) {
			$http({
				url: baseUrl + '/drmsEmail/send',
				method: 'POST',
				headers: {
					'Content-Type': 'application/json'
				},
				data: mailContent
			}).then(function(response) {
				resolve(response.data);
			}, function(response) {
				reject('slideEmailService - reject');
			})
		})
		return promise;
	}
}]);
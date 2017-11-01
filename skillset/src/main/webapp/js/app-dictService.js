/**
 * 
 */
app.factory('dictService', ['$http', function($http) {
	var baseUrl = '/skillset/api/AppDictionary';
	var dictService = {
			search: function() {
				var promise = $http({
					url: baseUrl+'/search',
					method: 'POST',
					data:{},
					headers: {
						'Content-Type': 'application/json'
					}
					}).then(function successCallback(response) {
						console.log('Load data from dictionary:');
						console.log(response);
						return response.data;
					}, function errorCallback(response) {
						console.log(response);
					});
				return promise;
			},
			update: function(update) {
				//TODO: define update data structures
				var promise = $http({
					url: baseUrl+'/update',
					method: 'POST',
					data: update,
					headers: {
						'Content-Type': 'application/json'
					}
				}).then(function successCallback(response) {
					console.log(response);
					var result = {result: response.data};
					return result;
				}, function errorCallback(response) {
					
				});
				return promise;
			},
			add: function(insert) {
				//TODO: define insert data structures
				var promise = $http({
					url: baseUrl+'/add',
					method: 'POST',
					data: insert,
					headers: {
						'Content-Type': 'application/json'
					}
				}).then(function successCallback(response) {
					console.log(response);
					return response.data;
				}, function errorCallback(response) {
					console.log(response);
				});
				return promise;
			},
			del: function(id) {
				//TODO: define delete id
				var promise = $http({
					url: baseUrl+'/delele?'+id,
					method: 'GET',
				}).then();
				return promise;
			}
			
		};
	return dictService;
}]);
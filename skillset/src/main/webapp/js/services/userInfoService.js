/**
 *  @author Cornelius Huang
 *  get current user info
 */
app.factory('userInfoService', ['$http', '$q', function($http, $q) {
	var baseUrl = '/DRMS/api' 
		
	return $q(function(resolve, reject) {
		var promise = $http({
			url: baseUrl+'/user/getLoginUserName',
			method: 'GET'
		}).then(function(response) {
			resolve(response.data);
		}, function(response) {
			reject('userInfoService - reject');
		});
		
	})
}]);

app.factory('userRoleService', ['$http', '$q', function($http, $q) {
	var baseUrl = '/DRMS/api';
	return {
		getCurrRole: $q(function(resolve, reject) {
			var promise = $http({
				url: baseUrl + '/control/getRoles',
				method: 'POST'
			}).then(function(response) {
				resolve(response.data);
			}, function(response) {
				reject('userRoleService - getCurrRole reject');
			})
		}),
		getRolesList: $q(function(resolve, reject) {
			var promise = $http({
				url: baseUrl + '/AppRole/selectAppRole',
				method: 'GET'
			}).then(function(response) {
				resolve(response.data);
			}, function() {
				reject('userRoleService - getRolesList reject');
			})
		})
	}
}]);

app.factory('userFullInfoService', ['$http', '$q', function($http, $q) {
	var baseUrl = '/DRMS/api' 
		
	return $q(function(resolve, reject) {
		var promise = $http({
			url: baseUrl+'/user/getUserInfo',
			method: 'GET'
		}).then(function(response) {
			resolve(response.data);
		}, function(response) {
			reject('userInfoService - reject');
		});
		
	})
}]);
app.factory('userService', ['$http',
function($http) {
	var baseUrl = '/skillset/api/user';
	var service = {
		getCurrentUserInfo : function() {
			var promise = $http.get(baseUrl + '/getCurrentUserInfo').then(function(response) {
				return response.data;
			});
			return promise;
		},
		search : function(data) {
			var promise = $http.get(baseUrl + '/searchCapgUser', {
				params : data
			}).then(function(response) {
				return response.data;
			});
			return promise;
		}
	};
	return service;
}]);



app.factory('roleManagementService',['$http',
function($http){
	var baseUrl = '/skillset/api/AppRole';
	var service = {
			getRoles :function(data){
				var promise = $http.post(baseUrl +'/search',data).then(function(response){
					return response.data;
				});
				return promise;
			},
			addRoles : function(data){
				var promise = $http.post(baseUrl +'/add',data).then(function(response){
					return response.data;
				});
				return promise;
				
			},
			editRoles : function(data){
				var promise = $http.post(baseUrl +'/update',data).then(function(response){
					console.log(response);
					return response.data;
				
				});
				return promise;
				
			},
			deleteRoles : function(data){
				var promise = $http.get(baseUrl+'/delete?id='+data).then(function(response){
					return response.data;
				});
				return promise;
			}
			
	};
	return service;
	
}]);

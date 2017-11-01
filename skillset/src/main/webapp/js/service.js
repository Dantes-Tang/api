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
app.factory('skillsetService', ['$http',
function($http) {
	var baseUrl = '/skillset/api/skillmatrix';
	var service = {
		getCategories : function() {
			var promise = $http.get(baseUrl + '/getCategorys').then(function(response) {
				return response.data;
			});
			return promise;
		},
		getUserSkills : function(userName) {
			var promise = $http.get(baseUrl + '/getSkillMatrix', {
				params : {
					username : userName
				}
			}).then(function(response) {
				return response.data;
			});
			return promise;
		},
		save : function(data) {
			var promise = $http.post(baseUrl + '/add', data).then(function(response) {
				return response.data;
			});
			return promise;
		}
	};
	return service;
}]);
app.factory('flexibilityService', ['$http',
function($http) {
	var baseUrl = '/skillset/api/flexibility';
	var service = {
		getCountries : function() {
			var promise = $http.get(baseUrl + '/getCountrys').then(function(response) {
				return response.data;
			});
			return promise;
		},
		getUserFlexibilities : function(userName) {
			var promise = $http.get(baseUrl + '/getFlexibility', {
				params : {
					username : userName
				}
			}).then(function(response) {
				return response.data;
			});
			return promise;
		},
		save : function(data) {
			var promise = $http.post(baseUrl + '/add', data).then(function(response) {
				return response.data;
			});
			return promise;
		}
	};
	return service;
}]);

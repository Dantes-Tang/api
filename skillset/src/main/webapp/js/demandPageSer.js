app.factory('drmsSkillFlexibilityService',["$http",function($http){
	var baseUrl="/DRMS/api/skillmatrix";
	var service={
		getInformation: function(data){
			var promise = $http.get(baseUrl+'/getSkillFlexibility',data).then(function(response){
				console.log(123);
				return response.data;
			});
			return promise;
		},
	};
	return service;
}]);
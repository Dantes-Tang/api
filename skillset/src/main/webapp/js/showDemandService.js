app.factory('showDemandService',["$http",function($http){
	var baseUrl="/DRMS/api/DrmsDemand";
	var service={			
			searchTBD: function(data){
				var promise = $http.post(baseUrl+'/searchTBD',data).then(function(response){
					console.log(response);
					return response.data;
				});
				return promise;
			},
			matchedResource: function(dmdId){
				var promise = $http.post(baseUrl +'/matchedResource?dmdId='+dmdId).then(function(response){
					console.log("dddd");
					console.log(response);
					return response.data;
				});
				return promise;
			},
			exportExcel:function(data){
				var promise = $http.get(baseUrl+'/exportExcel',data).then(function(response){
					console.log(response);
					return response.data;
				});
				return promise;
			}, 
	};
		
	return service;
}]);

app.factory('drmsCategoryService',["$http",function($http){
	var baseUrl="/DRMS/api/DrmsCategory";
	var service={
			getCategories: function(data){
				var promise = $http.post(baseUrl+"/fianAllCategories",data).then(function(response){
					console.log(response);
					console.log(123);
					return response.data;
				});
				return promise;
			},
	};
	return service;
}]);


app.factory('flexibilityService',["$http",function($http){
	var baseUrl="/DRMS/api/flexibility";
	var service={
			getCategories: function(data){
				var promise = $http.get(baseUrl+"/searchAllCountry",data).then(function(response){
					console.log(response);
					console.log(123);
					return response.data;
				});
				return promise;
			},
	};
	return service;
}]);
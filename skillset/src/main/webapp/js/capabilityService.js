app.factory('capabilityService',["$http",function($http){
	var baseUrl="/DRMS/api/DrmsDemand";
	var service={
			
			getCapabilities:function(data){
				var promise=$http.post(baseUrl +'/searchTBD',data).then(function(response){
					console.log(response);
					return response.data;
					
				});
				return promise;	
			},
			getMatchedResources:function(data){
				var promise = $http.post(baseUrl+'/matchedResource?dmdId='+data).then(function(response){
					console.log("data"+data)
					console.log(response);
					return response.data;
				});
				return promise;
			},
			matchedSuccess:function(dmdId,resourceId){
				var promise = $http.post(baseUrl+'/updateMacthedResourceId?dmdId='+dmdId+'&resourceId='+resourceId).then(function(response){
					console.log(response);
					return response.data;
				});
				return promise;
			}
			
			
	};
	return service;
}]);
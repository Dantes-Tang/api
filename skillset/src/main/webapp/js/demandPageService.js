app.factory('demandService',["$http",function($http){
	var baseUrl="/DRMS/api/DrmsDemand";
	var service={
			
			getDemands:function(data){
				var promise=$http.get(baseUrl +'/search?oppId='+data).then(function(response){
					//console.log("dddd");
					//console.log(response);
					return response.data;
				}, function(response) {
					console.log('REJECT - getDemands reject, status: '+ response.status);
				});
				return promise;	
			},			
	};
	return service;
}]);
app.factory('weeklyReportService',["$http",function($http){
	var baseUrl="/DRMS/api/reports";
	var service={
		getInformation: function(data){
			var promise = $http.get(baseUrl+'/getReport',data).then(function(response){
				console.log(123);
				return response.data;
			});
			return promise;
		},
		getSummaryDesignation: function(data){
			var promise = $http.get(baseUrl+'/getSummaryDesignationReport',data).then(function(response){
				console.log(123);
				return response.data;
			});
			return promise;
		},
	};
	return service;
}]);
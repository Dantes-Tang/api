app.factory('demandService',["$http",'$q', function($http, $q){
	var baseUrl="/DRMS/api/DrmsDemand";
	var service={
			
			getDemands:function(data){
				var promise=$http.get(baseUrl +'/search?oppId='+data).then(function(response){
					console.log('getDemand - get demand resolve');
					//console.log(response);
					return response.data;
				}, function(response) {
					console.log('REJECT - getDemands reject, status: '+ response.status);
				});
				return promise;	
			},
			
			getSelects:function(data){
				var promise = $http.post('/DRMS/api/DrmsSDAC/search').then(function(response){
					console.log(response);
					return response.data;
				}, function(response) {
					console.log('REJECT - getSelects reject, status: '+ response.status);
				});
				return promise;
			},
			
			addUpDemands: function(data){
				var promise = $http.post(baseUrl+'/updateOrAdd',data).then(function(response){
					///console.log(response);
					return response.data;
				});
				return promise;
			},
			getOneDemand: function(dmdId) {
				var promise = $q(function(resolve, reject) {
					$http({
						url: baseUrl + '/reloadPage',
						method: 'POST',
						headers: {
							'Content-Type': 'application/x-www-form-urlencoded'
						},
						data: 'dmdId='+dmdId
					}).then(function(response) {
						resolve(response.data);
					}, function(response) {
						reject('demandService - getOneDemand reject');
					})
				});
				return promise;
			}
	};
	return service;
}]);

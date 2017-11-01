/**
 * 
 */
app.factory('oppodmdService', ['$http', function($http) {
	var baseUrl = '/DRMS/api';	
	var oppodmdService = {
		oppReq: function(oppos) {
		    var promise = $http({
		    	url:baseUrl+'/drmsOpp/updateInsert',
		    	method: 'POST',
		    	headers: {
		    		'Content-Type': 'application/json'
		    	},
		    	data: oppos
		    }).then(function successCallback(response) {
		    	console.log(response);
		    	return response.data;
		    },function errorCallback(response) {
		    	console.log(response);
		    });
		    return promise;
		},
		staLoad: function() {
			var promise = $http({
				url: baseUrl+'/drmsStatus/get',
				method: 'POST',
				headers: {
					'Content-Type': 'application/json'
				},
				data: {},
			}).then(function successCallback(response) {
				//console.log(response);
				return response.data;
			}, function errorCallback(response) {
				console.log('REJECT - staLoad reject, status: ' + response.status);
			});
			return promise;
		},
		accLoad: function() {
				var promise = $http({
					url: baseUrl+'/drmsAccount/get',
					method: 'POST',
					headers: {
						'Content-Type': 'aplication/json'
					},
					data:{}
				}).then(function successCallback(response) {
					console.log(response);
					return response.data;
				}, function errorCallback(response) {
					console.log(response);
				});
			return promise;
		},
		oppoLoad: function(account_id) {
			//TODO: Http request
			var promise = $http({
				url: baseUrl+'/drmsOpp/get',
				method: 'POST',
				data: {},
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
		selectedId: null
	};
	return oppodmdService;
}]);


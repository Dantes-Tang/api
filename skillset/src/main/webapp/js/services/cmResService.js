/**
 *  @author Cornelius Huang
 *  resource info and demand
 */
app.factory('resSearService', ['$http', '$q', function($http, $q) {
	var baseUrl = '/DRMS/api';
	return function(resName) {
		console.log('resSearService - ' + resName);
		var promise =  $q(function(resolve, reject) {
			$http({
				url: baseUrl + '/DrmsResourceSkills/find',
				method: 'POST',
				headers: {
					'Content-Type': 'application/json',
				},
				data:{
					resourceId: null,
					resourceName: resName,
					skills: null,
					desigation: null,
				}
			}).then(function(response) {
				resolve(response.data);
			}, function() {
				reject('resSearService - reject');
			});
		});
		return promise;
	}
}]);

app.factory('resFullService', ['$http', '$q', function($http, $q) {
	var baseUrl = '/DRMS/api';
	return {
		searFullName: function(fullname) {
			var promise = $q(function(resolve, reject) {
				$http({
					url: baseUrl + '/DrmsResourceSkills/find',
					method: 'POST',
					headers: {
						'Content-Type': 'application/json',
					},
					data:{
						resourceId: null,
						resourceName: null,
						name: fullname,
						skills: null,
						desigation: null,
					}
				}).then(function(response) {
					resolve(response.data)
				}, function() {
					reject('resFullService - searFullName reject');
				});
			})
			return promise;
		}
	}
}]);

app.factory('cmDemandService', ['$http', '$q', function($http, $q) {
	var baseUrl = '/DRMS/api';
	return function(capa, stat) {
		var promise = $q(function(resolve, reject) {
			$http({
				url: baseUrl + '/DrmsDemandStatusCapability/find',
				method: 'POST',
				headers: {
					'Content-Type': 'application/json',
				},
				data: {
					dmdID: null,
					accountName: null,
					capability: capa,
					project: null,
					site: null,
					resourceType: null,
					startDate: null,
					endDate: null,
					resourceName: null,
					status: stat
				}
			}).then(function(response) {
				resolve(response.data);
			}, function(response) {
				reject('cmDemandService - reject');
			});
		});
		return promise;
	}
}]);

app.factory('acmDemandService', ['$http', '$q', function($http, $q) {
	var baseUrl = '/DRMS/api';
	return {
		reloadADemand: function(dmdId) {
			var promise = $q(function(resolve, reject) {
				$http({
					url: baseUrl + '/DrmsDemandStatusCapability/find',
					method: 'POST',
					headers: {
						'Content-Type': 'application/json',
					},
					data: {
						dmdID: dmdId,
						accountName: null,
						capability: null,
						project: null,
						site: null,
						resourceType: null,
						startDate: null,
						endDate: null,
						resourceName: null,
						status: null
					}
				}).then(function(response) {
					resolve(response.data);
				}, function(response) {
					reject('acmDemandService - reject');
				});
			}); 
			
			return promise;
		}
	}
}]);

app.factory('DemandStatusService', ['$http', '$q', function($http, $q) {
	var baseUrl = '/DRMS/api';
	return $q(function(resolve, reject) {
		$http({
			url: baseUrl + '/DrmsDemandStatus/searchAllDemandStatus',
			method: 'POST',
		}).then(function(response) {
			resolve(response.data);
		}, function(response) {
			reject('DemandStatusService - reject');
		})
	});
}]);
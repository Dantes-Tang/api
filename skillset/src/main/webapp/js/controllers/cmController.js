/**
 *  @author Cornelius Huang
 *  capability manager module
 */
app.controller('mailTabController', ['$scope', '$uibModal', 'cmSlideCacheService', 'dateFilter', 'slideEmailService', function($scope, $uibModal, cmSlideCacheService, dateFilter, slideEmailService) {
	$scope.mail = {
		to: '',
		cc: '',
		attachPath: '',
		attachName: '',
		opnDate: '',
		capa: '',
		posTit: '',
		desDsg: '',
		hirRes: '',
		hcReq: '',
		billDate: '',
		wrkLoc: '',
		cusInter: '',
		projIntr: '',
		duty: '',
		other: '',
		teches: [],
		langs: []
	};
	
	var cmDmd = cmSlideCacheService.cmCache;
	
	$scope.mail.opnDate = dateFilter(cmDmd.startDate, 'yyyy-MM-dd');
	$scope.mail.capa = cmDmd.capability;
	$scope.mail.desDsg = cmDmd.desigation;
	$scope.mail.billDate = dateFilter(cmDmd.startDate, 'yyyy-MM-dd');
	$scope.mail.wrkLoc = cmDmd.site;
	
	$scope.$watch('mail.teches.length', function(newValue, oldValue) {
		console.log('teches length is ' + newValue);
		console.log($scope.mail.teches);
	});
	
	$scope.$watch('mail.langs.length', function(newValue, oldValue) {
		console.log('langs length is ' + newValue);
		console.log($scope.mail.langs);
	});
	
	$scope.send = function() {
		console.log($scope.mail);
		slideEmailService($scope.mail).then(function(result) {
			console.log(result);
			
			var modalInstance = $uibModal.open({
				animation: false,
				size: 'sm',
				templateUrl: './views/coralert.html',
				controller: 'alertController',
				resolve: {
					item: function() {
						return 'Email Sending SUCCESS.';
					}
				}
			});
			
			modalInstance.result.then(function() {
				//slideCallbackService.promiseDeferd.notify('promise noitfy');
				$state.go('^');
			}, function() {
				//slideCallbackService.promiseDeferd.notify('promise noitfy');
				$state.go('^');
			});
		}, function(result) {
			console.log(result);
		});
	}
}]);

app.controller('resTabController', ['$scope', '$state', '$uibModal', 'resFullService', 'capabilityService', 'cmSlideCacheService', 'resFillService', 'slideCallbackService', function($scope, $state, $uibModal, resFullService, capabilityService, cmSlideCacheService, resFillService, slideCallbackService) {
	
	$scope.name = '';
	$scope.resources;
	
	$scope.resourceId = null;
	$scope.assCapId = null;
		
	console.log(cmSlideCacheService.cmCache);
	
	
	
	$scope.$watch('name', function(newValue, oldValue) {
		//console.log('Name watch - ' + newValue);
		
		resFullService.searFullName(newValue).then(function(result) {
			$scope.resources = result;
		}, function(result) {
			console.log(result)
		})
		
		/*resSearService(newValue).then(function(result) {
			$scope.resources = result;
		}, function(result) {
			console.log(result);
		});*/
	})
	
	$scope.$watch('resources.length', function(newValue, oldValue) {
		if(newValue == 1) {
			$scope.resourceId = $scope.resources[0].resourceId;
		} else {
			$scope.resourceId = null;
		}
	});
	
	$scope.$watch('resourceId', function(newValue, oldValue) {
		console.log('Request resourceId: ' + newValue);
	});
	
	$scope.$watch('assCap', function(newValue, oldValue) {
		if(newValue != undefined) {
			$scope.assCapId = newValue.capId;
		}
	});
	
	$scope.confirm = function() {
		if($scope.resourceId != null && $scope.assCapId != null) {
			resFillService(cmSlideCacheService.cmCache.dmdID, $scope.resourceId, $scope.assCapId).then(function(result) {
				console.log(result);
				var modalInstance = $uibModal.open({
					animation: false,
					size: 'sm',
					templateUrl: './views/coralert.html',
					controller: 'alertController',
					resolve: {
						item: function() {
							return 'result filling SUCCESS.';
						}
					}
				});
				
				modalInstance.result.then(function() {
					slideCallbackService.promiseDeferd.notify('promise noitfy');
					$state.go('^');
				}, function() {
					slideCallbackService.promiseDeferd.notify('promise noitfy');
					$state.go('^');
				});
			}, function(result) {
				
			});
		}
	}
	
	$scope.iptBlur = function() {
		if($scope.resources.length == 1) {
			$scope.name = $scope.resources[0].name;
		} else {
				
		}
	}
	
	$scope.matching = function(id, name) {
		$scope.name = name;
		$scope.resourceId = id;
	}
}]);

app.controller('DetailTabController', ['$scope', '$state', 'cmSlideCacheService', 'dateFilter', function($scope, $state, cmSlideCacheService, dateFilter) {
	$scope.dmdDetail = cmSlideCacheService.cmCache;
	$scope.dmdDetail.startDate = dateFilter($scope.dmdDetail.startDate, 'dd-MM-yyyy');
	$scope.dmdDetail.endDate = dateFilter($scope.dmdDetail.endDate, 'dd-MM-yyyy');
}]);

app.controller('CMController', ['$scope', '$q', '$state', 'cmDemandService', 'cmSlideCacheService', 'pagingFilter', 'filterFilter', function($scope, $q, $state, cmDemandService, cmSlideCacheService, pagingFilter, filterFilter) {
	
	$scope.currPage = 1;
	$scope.totalItems;
	$scope.itemsPer = 15;
	
	$scope.capa1;
	$scope.capa2;
	
	var names = ['capa1', 'capa2'];
	
	var codRequest = function(capa, status) {
		var promise = $q(function(resolve, reject) {
			if(capa != undefined && status != undefined) {
				cmDemandService(capa.capName, status.dmdStatusName).then(function(result) {
					reqResult = result;
					resolve(reqResult);
				}, function(result) {
					reject('codRequest - reject');
				});
			} else if(capa != undefined && status == undefined){
				cmDemandService(capa.capName, '').then(function(result) {
					reqResult = result;
					resolve(reqResult);
				}, function(result) {
					reject('codRequest - reject');
				});
			} else if(capa == undefined && status != undefined) {
				cmDemandService('', status.dmdStatusName).then(function(result) {
					reqResult = result;
					resolve(reqResult);
				}, function(result) {
					reject('codRequest - reject');
				});
			} else {
				cmDemandService('', '').then(function(result) {
					reqResult = result;
					resolve(reqResult);
				}, function(result) {
					reject('codRequest - reject');
				});
			}
		});
		return promise;
	}
	
	$scope.doTask = function(disDmd, $event) {
		cmSlideCacheService.cmCache = disDmd;
		$state.go('capa.tbd.twom');
		$event.stopPropagation();
		$event.preventDefault();
	}
	
	$scope.$watchGroup(names, function(newNames, oldNames) {
		console.log(newNames);
		codRequest(newNames[0], newNames[1]).then(function(result) {
			var reqresult = filterFilter(result, $scope.keyword);
			pagingFilter.listLoad(reqresult, $scope.itemsPer);
			$scope.totalItems = pagingFilter.getPgInfo().resArylength;
			$scope.disDmds = pagingFilter.getCurrentPage($scope.currPage);
		});
	});

	$scope.$watch('keyword', function(newValue, oldValue) {
		codRequest($scope.capa1, $scope.capa2).then(function(result) {
			var reqresult = filterFilter(result, newValue);
			pagingFilter.listLoad(reqresult, $scope.itemsPer);
			$scope.totalItems = pagingFilter.getPgInfo().resArylength;
			$scope.disDmds = pagingFilter.getCurrentPage($scope.currPage);
		});
	});
	
	$scope.$watch('currPage', function(newValue, oldValue) {
		$scope.disDmds = pagingFilter.getCurrentPage(newValue);
	});
	
}]);
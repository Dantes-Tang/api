/**
 *  @author Cornelius huang
 */
app.controller('OppoEditController', ['$scope', '$state', '$uibModal', 'filterFilter', 'pagingFilter', 'slideCallbackService', 'oppodmdService', function($scope, $state, $uibModal, filterFilter, pagingFilter, slideCallbackService, oppodmdService) {
	
	$scope.ttoppos = [];	
	$scope.oppos = [];
	
	$scope.currPage = 1;
	$scope.totalItems;
	$scope.itemsPer = 15;
			
	$scope.$watch('keyword', function(newValue, oldValue) {
		console.log('keyword - check');
		var ttoppos = filterFilter($scope.ttoppos, newValue);
		pagingFilter.listLoad(ttoppos, $scope.itemsPer);
		$scope.totalItems = pagingFilter.getPgInfo().resArylength;
		$scope.oppos = [];
		$scope.oppos = pagingFilter.getCurrentPage($scope.currPage);
	});	
	
	oppodmdService.oppoLoad().then(function(oppos) {
		$scope.ttoppos = [];
		$scope.ttoppos = oppos;
		
		pagingFilter.listLoad(oppos, $scope.itemsPer);
		$scope.totalItems = pagingFilter.getPgInfo().resArylength;
		
		/* watch the current page and reload display array */
		$scope.$watch('currPage', function(newValue, oldValue) {
			$scope.oppos = [];
			$scope.oppos = pagingFilter.getCurrentPage(newValue);
		});
	}, function() {
		
	});
	
	slideCallbackService.getPromise.then(function(result) {
		console.log('compinent resolve' + result);
	}, function(result) {
		console.log('compinent reject' + result);
	}, function(result) {
		console.log('compinent notify' + result);
		oppodmdService.oppoLoad().then(function(oppos) {
			$scope.ttoppos = [];
			$scope.ttoppos = oppos;
			
			pagingFilter.listLoad(oppos, $scope.itemsPer);
			$scope.totalItems = pagingFilter.getPgInfo().resArylength;
			
			/* watch the current page and reload display array */
			$scope.$watch('currPage', function(newValue, oldValue) {
				$scope.oppos = [];
				$scope.oppos = pagingFilter.getCurrentPage(newValue);
			});
		}, function() {
			
		});	
	});
	
}]);

app.controller('EditOppController', ['$scope', '$state', '$uibModal', '$stateParams', 'oppodmdService', 'slideCallbackService', 'validNotifyService', function($scope, $state, $uibModal, $stateParams, oppodmdService, slideCallbackService, validNotifyService) {
	console.log('EditOppController '+$stateParams.oppId);
	
	$scope.oppdmd = null;
	
	oppodmdService.oppoLoad().then(function(oppos) {
		oppos.forEach(function(oppo) {
			if(oppo.oppId == $stateParams.oppId) {
				$scope.oppo = angular.copy(oppo);
				//console.log($scope.oppdmd);
			}
		})
	});
	
	$scope.editsubmit = function() {
		var oppo = null;
		var oppos = [];
		oppo = $scope.oppo;
		oppos.push(oppo);
		if($scope.oppo.oppName == "" || $scope.oppo.oppProbability == "" || $scope.oppo.drmsAccount == "" || $scope.oppo.drmsStatus == "") {
			validNotifyService.promiseDeferd.notify();
		} else {
			oppodmdService.oppReq(oppos).then(function(data) {
				if(data[0]) {
					console.log('success');
					
					var modalInstance = $uibModal.open({
						animation: false,
						size: 'sm',
						templateUrl: './views/coralert.html',
						controller: 'alertController',
						resolve: {
							item: function() {
								return 'opporunity edit SUCCESS.';
							}
						}
					});
					
					modalInstance.result.then(function() {
						slideCallbackService.promiseDeferd.notify('promise noitfy');
						//$state.go('^');
					}, function() {
						slideCallbackService.promiseDeferd.notify('promise noitfy');
						//$state.go('^');
					});
					
					$state.go('^');
				}
			}, function() {
				
			});
		}
		
		
	}
	
	$scope.$watch('slmodel', function(newValue, oldValue) {
		console.log(newValue);
	});
			
}]);

app.controller('AddOppController', ['$scope', '$state', '$uibModal', 'oppodmdService', 'slideCallbackService', 'validNotifyService', function($scope, $state, $uibModal, oppodmdService, slideCallbackService, validNotifyService) {
	$scope.oppo = {
		oppId: 0,
		oppName: null,
		oppProbability: null,
		drmsAccount: null,
		drmsStatus: null
	};
	
	$scope.addsubmit = function() {
		var oppos = [];
		
		if($scope.oppo.oppName == null || $scope.oppo.oppProbability == null || $scope.oppo.drmsAccount == null || $scope.oppo.drmsStatus == null) {
			//notify the validate component
			validNotifyService.promiseDeferd.notify();
		} else {
			oppos.push($scope.oppo);
			oppodmdService.oppReq(oppos).then(function() {
				console.log('add success');
				
				var modalInstance = $uibModal.open({
					animation: false,
					size: 'sm',
					templateUrl: './views/coralert.html',
					controller: 'alertController',
					resolve: {
						item: function() {
							return 'opporunity ADD SUCCESS.';
						}
					}
				});
				
				modalInstance.result.then(function() {
					slideCallbackService.promiseDeferd.notify('promise noitfy');
				}, function() {
					slideCallbackService.promiseDeferd.notify('promise noitfy');
				});
				
			}, function() {
				
			});
		}
	}
}]);

app.controller('DmdAddEditController', ['$scope', '$uibModal', 'filterFilter', 'oppodmdService', 'pagingFilter', 'matrixFilter', 'validNotifyService', 'matrixService', function($scope, $uibModal, filterFilter, oppodmdService, pagingFilter, matrixFilter, validNotifyService, matrixService) {
	$scope.ttoppdmds = [];
	$scope.oppdmds = [];
	
	
	$scope.currPage = 1;
	$scope.totalItems;
	$scope.itemsPer = 6;
	
	$scope.keyword2 = '';
	
	$scope.$watch('keyword', function(newValue, oldValue) {
		console.log('keyword - check');
		var ttoppdmds = matrixFilter($scope.ttoppdmds, newValue);
		pagingFilter.listLoad(ttoppdmds, $scope.itemsPer);
		$scope.totalItems = pagingFilter.getPgInfo().resArylength;
		$scope.oppdmds = pagingFilter.getCurrentPage($scope.currPage);
		console.log($scope.ttoppdmds);
	});
	
	/*oppodmdService.oppoLoad().then(function(result) {
		$scope.ttopps = result;
		console.log(result);
		pagingFilter.listLoad(result, $scope.itemsPer);
		$scope.totalItems = pagingFilter.getPgInfo().resArylength;
		
		$scope.$watch('currPage', function(newValue, oldValue) {
			pagingFilter.listLoad(result, $scope.itemsPer);
			$scope.opps = pagingFilter.getCurrentPage(newValue);
		});
		
	});*/
	
	matrixService.then(function(oppdmds) {
		//var jsonStr = JSON.stringify(oppdmds);
		//console.log(jsonStr);
		$scope.ttoppdmds = [];
		$scope.ttoppdmds = oppdmds;
		
		pagingFilter.listLoad(oppdmds, $scope.itemsPer);
		$scope.totalItems = pagingFilter.getPgInfo().resArylength;
		
		$scope.oppdmds = pagingFilter.getCurrentPage($scope.currPage);
		
	}, function(result) {
		console.log(result);
	});
	
	$scope.$watch('currPage', function(newValue, oldValue) {
		pagingFilter.listLoad($scope.ttoppdmds, $scope.itemsPer);
		$scope.totalItems = pagingFilter.getPgInfo().resArylength;
		$scope.oppdmds = pagingFilter.getCurrentPage(newValue);
	})
	
}]);

app.controller('DmdAddController', ['$scope', '$state', '$stateParams', '$uibModal', 'demandService', 'matrixService', 'slideCallbackService', 'validNotifyService', function($scope, $state, $stateParams, $uibModal, demandService, matrixService, slideCallbackService, validNotifyService) {
	console.log('DmdAddController');
	console.log($stateParams.oppId);
	
	var oppId = $stateParams.oppId;
	var oppShowId = null;
	var drmsOpp = null;
	
	$scope.dmd = {
			dmdId: 0,
			drmsOpp: null,
			drmsSite: null,
			drmsDesigation: null,
			dmdAlterdsg: null,
			dmdProjName: null,
			dmdPosition: null,
			drmsAssCapability: null,
			drmsAllocationType: null,
			dmdAllocRatio: null,
			startDate: null,
			endDate: null,
			drmsCapability: null,
			dmdShowId: oppShowId,
			dmdResType: null,
			drmsResource: {
				resourceId: 1,
	            resourceName: 'TBD'
			},
			resourceId: null,
			drmsDemandStatus: null
	}
	
	if(oppId != undefined) {
		matrixService.then(function(oppdmds) {
			oppdmds.forEach(function(oppdmd) {
				if(oppdmd.oppo.oppId == oppId) {
					oppShowId = oppdmd.oppo.oppShowId;
					drmsOpp = oppdmd.oppo;
				}
			});
		})
	}
	
	$scope.dmdAddSave = function() {
		console.log($scope.dmd);
		if($scope.dmd.drmsSite == null || $scope.dmd.drmsDesigation == null || $scope.dmd.dmdProjName == null || $scope.dmd.dmdPosition == null || $scope.dmd.drmsAllocationType == null || $scope.dmd.dmdAllocRatio == null || $scope.dmd.startDate == null || $scope.dmd.endDate == null) {
			validNotifyService.promiseDeferd.notify();
		} else {
			var dmds = [];
			var adddmd = {
					dmdId: 0,
					drmsOpp: drmsOpp,
					drmsSite: $scope.dmd.drmsSite,
					drmsDesigation: $scope.dmd.drmsDesigation,
					dmdAlterdsg: $scope.dmd.dmdAlterdsg,
					dmdProjName: $scope.dmd.dmdProjName,
					dmdPosition: $scope.dmd.dmdPosition,
					drmsAssCapability: $scope.dmd.drmsCapability,
					drmsAllocationType: $scope.dmd.drmsAllocationType,
					dmdAllocRatio: $scope.dmd.dmdAllocRatio,
					startDate: $scope.dmd.startDate,
					endDate: $scope.dmd.endDate,
					drmsCapability: $scope.dmd.drmsCapability,
					dmdShowId: oppShowId,
					dmdResType: $scope.dmd.dmdResType,
					
					drmsResource: {
						resourceId: 1,
			            resourceName: 'TBD'
					}
				}
			dmds.push(adddmd);
			demandService.addUpDemands(dmds).then(function() {
				console.log('resolve');
				
				var modalInstance = $uibModal.open({
					animation: false,
					size: 'sm',
					templateUrl: './views/coralert.html',
					controller: 'alertController',
					resolve: {
						item: function() {
							return 'DEmand ADD SUCCESS.';
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
			});
		}
		
		
	}
	
	
	
}]);

app.controller('DmdEditController', ['$scope', '$state', '$stateParams', '$uibModal', 'matrixService', 'demandService', 'validNotifyService', 'slideCallbackService', function($scope, $state, $stateParams, $uibModal, matrixService, demandService, validNotifyService, slideCallbackService) {
	
	var oppId = $stateParams.oppId;
	var dmdId = $stateParams.dmdId;
	
	$scope.dmd;
			
	$scope.$watch('alloct.atpName', function(newValue, oldValue) {
		console.log(newValue);
	});
	
	console.log($stateParams.oppId);
	console.log($stateParams.dmdId);
		
	if(oppId != undefined) {
		matrixService.then(function(oppdmds) {
			console.log(oppdmds);
			
			oppdmds.forEach(function(oppdmd) {
				if(oppdmd.oppo.oppId == oppId) {
					oppdmd.dmds.forEach(function(dmd) {
						if(dmd.dmdId == dmdId)
							$scope.dmd = angular.copy(dmd);
					});
				}
			});
			console.log($scope.dmd);
		});
	}
	
	$scope.dmdEditSave = function() {
		var dmds = [];
		
		dmds.push($scope.dmd);
		
		if($scope.dmd.drmssite == '' || $scope.dmd.drmsDesigation == '' || $scope.dmd.dmdProjName == ''|| $scope.dmd.dmdPosition == '' || $scope.dmd.drmsAssCapability == '' || $scope.dmd.drmsAllocationType == '' || $scope.dmd.dmdAllocRatio == '' || $scope.dmd.startDate == '' || $scope.dmd.endDate == '') {
			var jsonStr = JSON.stringify(dmds);
			console.log(jsonStr);
			validNotifyService.promiseDeferd.notify();
		} else {
			demandService.addUpDemands(dmds).then(function() {
				console.log('resolve');
				var modalInstance = $uibModal.open({
					animation: false,
					size: 'sm',
					templateUrl: './views/coralert.html',
					controller: 'alertController',
					resolve: {
						item: function() {
							return 'Demand Edit SUCCESS.';
						}
					}
				});
				
				modalInstance.result.then(function() {
					slideCallbackService.promiseDeferd.notify('promise noitfy');
				}, function() {
					slideCallbackService.promiseDeferd.notify('promise noitfy');
					$state.go('^');
				});
				
				$state.go('^');
			});
		}
		
		
	}
	
}]);
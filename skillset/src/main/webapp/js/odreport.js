/**
 * 
 */
app.controller('OdReportController', ['$q', '$scope', '$uibModal', '$document', '$window', 'oppodmdService', 'demandService', 'oppShowIdFilter', function($q, $scope, $uibModal, $document, $window, oppodmdService, demandService, oppShowIdFilter) {
    
    var $ctrl = this;
    
    $scope.oppdmds = [];    // opportunity & demand matrix
    
    $scope.disoppdmds = []; // filtered opportunity & demand matrix
    
    $scope.statuses = [];
    $scope.accounts = [];
    
    $scope.allocType = [];
    $scope.capabilitys = [];
    $scope.desgations = [];
    $scope.sites = [];
    
    $scope.elements = [];
/**
 * 	statuses Load
 */    
    oppodmdService.staLoad().then(function(status) {
    	console.log('INFO - opportunity statuses load success.');
    	for(var i = 0; i < status.length; i++) {
    		$scope.statuses.push(status[i]);
    	}
    	console.log('INFO - $scope.statuses build success.');
    }, function() {
    	//TODO: status load reject
    });

/**
 *	accounts load
 */
    oppodmdService.accLoad().then(function(accts) {
    	console.log('INFO - opportunity accounts load success. ');
    	for(var i = 0; i < accts.length; i++) {
    		$scope.accounts.push(accts[i]);
    	}
    	console.log('INFO - $scope.accounts build success. ');
    }, function() {
    	console.log('WARNING - accounts load reject');
    	//TODO: account load reject
    });

/**
 *  Site AlloctionType Capabilities Desigation 
 */
    demandService.getSelects().then(function(adac) {
    	console.log('INFO - adac load success. ');
    	for(var i = 0; i < adac.drmsAllocationType.length; i++) {
    		$scope.allocType.push(adac.drmsAllocationType[i]);
    	}
    	console.log('INFO - Allcation Type build finish.');
    	for(var j = 0; j < adac.drmsAssCapability.length; j++) {
    		$scope.capabilitys.push(adac.drmsAssCapability[j]);
    	}
    	console.log('INFO - capbilities build finish.');
    	for(var k = 0; k < adac.drmsSite.length; k++) {
    		$scope.sites.push(adac.drmsSite[k]);
    	}
    	console.log('INFO - site build finish.');
    	for(var l = 0; l < adac.drmsDesigation.length; l++) {
    		$scope.desgations.push(adac.drmsDesigation[l]);
    	}
    }, function() {
    	console.log('WARNING - demand selects load reject');
    	//TODO: account load reject
    });
/**
 * 	opportunity & demand matrix async load
 */
	oppodmdService.oppoLoad().then(function(resultOppos) {
		//console.log('oppos resolve')	
		demandCount = 0;
		for(var i = 0; i<resultOppos.length; i++) {
			demandService.getDemands(resultOppos[i].oppId).then(function(demands) {
				var oppdmd = {
						oppo: undefined,
						dmds: undefined
					};
				oppdmd.oppo = resultOppos[demandCount];
				oppdmd.dmds = demands;
				$scope.oppdmds.push(oppdmd);
				demandCount++;
			});
		}
		
	}, function() {
		//TODO: oppoLoad reject
	});
    
	$scope.matrixReload = function() {
		oppodmdService.oppoLoad().then(function(resultOppos) {
			//console.log('oppos resolve')	
			demandCount = 0;
			for(var i = 0; i<resultOppos.length; i++) {
				demandService.getDemands(resultOppos[i].oppId).then(function(demands) {
					var oppdmd = {
							oppo: undefined,
							dmds: undefined
						};
					oppdmd.oppo = resultOppos[demandCount];
					oppdmd.dmds = demands;
					$scope.oppdmds.push(oppdmd);
					demandCount++;
				});
			}
			
		}, function() {
			//TODO: oppoLoad reject
		});		
	}	
	
/**
 * 	modal test
 */	
    $scope.edit = function(size) {
		
		var modalInstance = $uibModal.open({
		    animation: true,
		    ariaLabelledBy: 'modal-title',
		    ariaDescribedBy: 'modal-body',
		    templateUrl: './views/oppmodal.html',
		    controller: function($uibModalInstance, selects) {
				this.openStart = false;
				this.openEnd = false;
				
				this.selects = selects;   //all select options
				
				this.ok = function() {
				    console.log('startIsOpen');
				    $uibModalInstance.close(this.selected.item);
				};
				
				this.cancel = function() {
				    $uibModalInstance.dismiss('cancel');
				}
				
				this.startIsOpen = function() {
				    console.log('startIsOpen');
				    this.openStart = true;
				}
				
				this.endIsOpen = function() {
				    console.log('startIsOpen');
				    this.openEnd = true;
				}
				
			    },
			    controllerAs: '$ctrl',
			    size: size,
			    appendTo: undefined,
			    resolve: {
					selects: function() {
						var selects = new Object();
						
						selects.allocType = $scope.allocType;
						selects.capabilitys = $scope.capabilitys;
						selects.desgations = $scope.desgations;
						selects.sites = $scope.sites;
						
					    return selects;
					}
					
		    }
		});
	
		modalInstance.result.then(function() {
		    
		}, function() {
		   console.log('cancel'); 
		});
    };

/**
  * 	Opportunity add and edit modal
  */ 
    $scope.addeditopp = function(size, opp) {
		
		var modalInstance = $uibModal.open({
		    animation: true,
		    ariaLabelledBy: 'modal-title',
		    ariaDescribedBy: 'modal-body',
		    templateUrl: './views/oppmodal.html',
		    controller: function($uibModalInstance, selects) {
				this.openStart = false;
				this.openEnd = false;
				
				this.selects = selects;   //all select options
				
				this.opp = opp;
				
				if(opp != null) {
					this.opp = opp;
				}else {
					this.opp = new Object();
				}
				
				this.ok = function() {
				    console.log('startIsOpen');
				    $uibModalInstance.close(this.opp);
				};
				
				this.cancel = function() {
				    $uibModalInstance.dismiss('cancel');
				}
				
				this.startIsOpen = function() {
				    console.log('startIsOpen');
				    this.openStart = true;
				}
				
				this.endIsOpen = function() {
				    console.log('startIsOpen');
				    this.openEnd = true;
				}
				
			    },
			    controllerAs: '$ctrl',
			    size: size,
			    appendTo: undefined,
			    resolve: {
					selects: function() {
						var selects = new Object();
						
						selects.statuses = $scope.statuses;
						selects.accounts = $scope.accounts;
						
					    return selects;
					}
					
		    }
		});
	
		modalInstance.result.then(function(resultopp) {
		    var oppos = [];
		    oppos.push(resultopp);
		    oppodmdService.oppReq(oppos).then(function(response) {
		    	console.log('INFO - updateInsert success');
		    });
		}, function() {
		   console.log('cancel'); 
		});
    };  
    
    
/**
 * 	Demand add and edit modal
 */    
    $scope.addeditdmd = function(size, opp, dmd) {
		var modalInstance = $uibModal.open({
		    animation: true,
		    ariaLabelledBy: 'modal-title',
		    ariaDescribedBy: 'modal-body',
		    templateUrl: './views/editdmdmodal.html',
		    controller: function($uibModalInstance, selects, demandService) {
				this.openStart = false;
				this.openEnd = false;
							
				this.selects = selects;   //all select options
				
				this.dmd = new Object();
				
				if(dmd != null) {
					this.dmd = dmd;
				}else {
					this.dmd = new Object();
					this.dmd.drmsOpp = opp;
					this.dmd.dmdId = 0;
					this.dmd.drmsResource = {
						resourceId: 8,
						resourceName: 'TBD'
					}
					this.dmd.drmsAssCapability = {
						capId: 2,
						capName: 'Guidewire'
					}
				}
				
				this.ok = function() {
				    console.log('startIsOpen');
				    $uibModalInstance.close(this.dmd);
				};
				
				this.cancel = function() {
				    $uibModalInstance.dismiss('cancel');
				}
				
				this.startIsOpen = function() {
				    console.log('startIsOpen');
				    this.openStart = true;
				}
				
				this.endIsOpen = function() {
				    console.log('startIsOpen');
				    this.openEnd = true;
				}
				
			    },
			    controllerAs: '$ctrl',
			    size: size,
			    appendTo: undefined,
			    resolve: {
					selects: function() {
						var selects = new Object();
						
						selects.allocType = $scope.allocType;
						selects.capabilitys = $scope.capabilitys;
						selects.desgations = $scope.desgations;
						selects.sites = $scope.sites;
						
					    return selects;
					},
					demand: function() {
						var demand = null;
						return demand;
					}
					
		    }
		});
	
		modalInstance.result.then(function(dmdresult) {
			console.log('close callback');
			var adupdateArrays = [];
		    adupdateArrays.push(dmdresult);
			demandService.addUpDemands(adupdateArrays).then(function(response) {
		    	console.log('INFO - '+response);
		    	$scope.matrixReload();
		    }, function() {
		    	
		    });
		}, function() {
		   console.log('cancel'); 
		});
    };
    
    $scope.setFiltered = function(result) {
    	$scope.disoppdmds = [];
    	$scope.disoppdmds = $scope.disoppdmds.concat(result);
    }
    
    $scope.setElements = function(elements) {
    	$scope.elements = $scope.elements.concat(elements);
    	console.log('this is set Elements');
    	console.log($scope.elements);
    }
    
    $scope.collapseAll = function() {
		$scope.elements.forEach(function(element) {
			element.addClass('collapse');
		});
	}
    
	$scope.extendAll = function() {
		$scope.elements.forEach(function(element) {
			element.removeClass('collapse');
		});
	}
	
	$scope.scopeTest = function() {
		console.log('Great - from dropdown click');
	}
	
	$scope.excelExpt = function() {
		oppodmdService.excelExpt();
	}
	
/*    
    $scope.filter = function() {
    	var result = oppShowIdFilter($scope.oppdmds, '*', 2);
    	console.log(result);
    }*/
    
}]);

/**
 *  test environment
 */
app.controller('accordtestController', ['$scope', '$uibModal', function($scope, $uibModal) {
		$scope.test = 'str';
		var ctrl = this;
		$scope.method = function() {
			$scope.test = 'haha';
		}
		
		$scope.openCompModal = function() {
			var modalInstance = $uibModal.open({
				animation: true,
				component: 'mailSendComponent',
				resolve: {
					dmd: null
				}
			});
			modalInstance.result.then(function(result) {
				
			});
		}
		
		$scope.alterTest = function() {
			var modalInstance = $uibModal.open({
				animation: true,
				component: 'alertComponent',
				resolve: {
					items: null
				}
			});
			
			modalInstance.result.then(function() {
				
			})
		}
}]);

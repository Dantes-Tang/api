app.controller('MobileDemandController',['$scope','demandService','$stateParams','$window','$uibModal','$log','$document',
                                         function($scope,demandService,$stateParams,$window,$uibModal,$log,$document){
	
	moment.locale('en');
	
	var $ctrl=this;
	/*
	 * select demands by oppId;
	 */
	var oppId = $stateParams.id;
	 demandService.getDemands(oppId).then(function(demandData){
			if(demandData&&demandData.length){
				//2alert("select success");
				//$scope.demands.push(demandData);
				//console.log(demandData);
				$ctrl.demands=demandData;
			}
			
		});
	 
	 /*
	  * all selects's data;
	  */
	 demandService.getSelects().then(function(selectsData){
		
		 $ctrl.selects=selectsData;
		 $ctrl.allocationTypes=$ctrl.selects.drmsAllocationType;
		 $ctrl.sites=$ctrl.selects.drmsSite;
		 $ctrl.desigations=$ctrl.selects.drmsDesigation;
		 $ctrl.capabilities=$ctrl.selects.drmsCapability;
		 $ctrl.resources=$ctrl.selects.drmsResource;
		 
	 });
	 /*
	  * accordion
	  */
	 $ctrl.status={
			 isCustomHeaderOpen:false,
			 isFirstOpen:true,
			 isFirstDisabled:false
	 };
	 
	 /*
	  * open edit-demand-modal
	  */
	 $ctrl.animationsEnabled = true;
	 $ctrl.openEdit = function(index,size,parentSelector){
		 var parentParams = parentSelector?
				 angular.element($document[0].querySelctor('.modal-demand'+parentSelctor)):undefined;
		 var modalInstance = $uibModal.open({
			 animation:$ctrl.animationEnabled,
				ariaLabelledBy :'modal-title',
				ariaDescribedBy : 'modal-body',
				templateUrl : 'views/xs-modal-demandEdit.html',
				controller :'ModalDemandEditInstanceController',
				controllerAs:'$ctrl',
				size:size,
				appendTo:parentParams,
				resolve:{
					demand:function(){
						return $ctrl.demands[index];
					},
					allocationTypes:function(){
						return $ctrl.selects.drmsAllocationType;
					},
					sites:function(){
						return $ctrl.selects.drmsSite;
					},
					desigations :function(){
						return $ctrl.selects.drmsDesigation;
					},
					capabilities :function(){
						return $ctrl.selects.drmsCapability;
					},
					resources :function(){
						return $ctrl.selects.drmsResource;
					}
					
				}
		 });
		 modalInstance.result.then(function(currentDemand){
				$ctrl.demands.push(currentDemand);
				console.log($ctrl.demands);
				demandService.addUpDemands($ctrl.demands).then(function(data){
						if(data){
								 alert("saved success");
						}
				 	})
			},function(){
				$log.info('Modal dismissed at :'+new Date());
			})
	 };
	 /*
	  * open add-modal-demand
	  */
	 $ctrl.openAdd = function(index,size,parentSelector){
		 var parentParams = parentSelector?
				 angular.element($document[0].querySelctor('.modal-demand'+parentSelctor)):undefined;
		 var modalInstance = $uibModal.open({
			 animation:$ctrl.animationEnabled,
				ariaLabelledBy :'modal-title',
				ariaDescribedBy : 'modal-body',
				templateUrl : 'views/xs-modal-demandAdd.html',
				controller :'ModalDemandAddInstanceController',
				controllerAs:'$ctrl',
				size:size,
				appendTo:parentParams,
				resolve:{
					demand:function(){
						return $ctrl.demands[index];
					},
					oppId:function(){
						//console.log(oppId);
						return oppId;
					},
					allocationTypes:function(){
						return $ctrl.selects.drmsAllocationType;
					},
					sites:function(){
						return $ctrl.selects.drmsSite;
					},
					desigations :function(){
						return $ctrl.selects.drmsDesigation;
					},
					capabilities :function(){
						return $ctrl.selects.drmsCapability;
					},
					resources :function(){
						return $ctrl.selects.drmsResource;
					}
					
				}
		 });
		 modalInstance.result.then(function(currentDemand){
				$ctrl.demands.push(currentDemand);
				console.log($ctrl.demands);
				demandService.addUpDemands($ctrl.demands).then(function(data){
						if(data){
								 alert("saved success");
						}
				 	})
			},function(){
				$log.info('Modal dismissed at :'+new Date());
			})
	 };
	 
	 
	 /*
		 * date-Calender
		 * start_date and end_date
		 */
		 	$scope.endDateBeforeRender = endDateBeforeRender
			$scope.endDateOnSetTime = endDateOnSetTime
			$scope.startDateBeforeRender = startDateBeforeRender
			$scope.startDateOnSetTime = startDateOnSetTime

			function startDateOnSetTime () {
			  $scope.$broadcast('start-date-changed');
			};

			function endDateOnSetTime () {
			  $scope.$broadcast('end-date-changed');
			};

			function startDateBeforeRender ($dates) {
			  if ($scope.endDate) {
			    var activeDate = moment($scope.endDate);

			    $dates.filter(function (date) {
			      return date.localDateValue() >= activeDate.valueOf()
			    }).forEach(function (date) {
			      date.selectable = false;
			    })
			  }
			};

			function endDateBeforeRender ($view, $dates) {
			  if ($scope.startDate) {
			    var activeDate = moment($scope.startDate).subtract(1, $view).add(1, 'minute');

			    $dates.filter(function (date) {
			      return date.localDateValue() <= activeDate.valueOf()
			    }).forEach(function (date) {
			      date.selectable = false;
			    })
			  }
			};
			
	 }]);
app.controller('ModalDemandAddInstanceController',function($uibModalInstance,demand,oppId,allocationTypes,sites,desigations,capabilities,resources){
	var $ctrl = this;
	$ctrl.demand=demand;
	//$ctrl.oppId=oppId;
	console.log("oppId"+oppId);
	$ctrl.allocationTypes = allocationTypes;
	$ctrl.sites =sites;
	$ctrl.desigations=desigations;
	$ctrl.capabilities=capabilities;
	$ctrl.resources=resources;
	$ctrl.obj =   {
		    "dmdId": 0,
		    "drmsOpp": {
		      "oppId": oppId,
		      "oppShowId": "",
		      "oppName": "",
		      "oppProbability": "",
		      "drmsStatus": {
		        "statusId": 0,
		        "statusName": ""
		      },
		      "drmsAccount": {
		        "accountId": 0,
		        "accountName": ""
		      }
		    },
		    "dmdResType": "",
		    "drmsResource": {
		      "resourceId": 0,
		      "resourceName": ""
		    },
		    "drmsSite": {
		      "siteId": 0,
		      "siteName": ""
		    },
		    "drmsDesigation": {
		      "dsgId": 0,
		      "dsgName": ""
		    },
		    "dmdAlterdsg": "",
		    "dmdProjName": "",
		    "dmdPosition": "",
		    "drmsAssCapability": {
		      "capId": 0,
		      "capName": ""
		    },
		    "drmsAllocationType": {
		      "atpId": 0,
		      "atpName": ""
		    },
		    "dmdAllocRatio": "",
		    "startDate": "",
		    "endDate": "",
		    "drmsCapability": {
		      "capId": 0,
		      "capName": ""
		    },
		    "dmdShowId": ""
		  }

	$ctrl.ok = function(){
		console.log($ctrl.demand);
		$uibModalInstance.close($ctrl.obj);

	};
	$ctrl.cancel = function(){
		$uibModalInstance.dismiss('cancel');
	}
	
});
app.controller('ModalDemandEditInstanceController',function($uibModalInstance,demand,allocationTypes,sites,desigations,capabilities,resources){
	var $ctrl = this;
	$ctrl.demand=demand;
	$ctrl.allocationTypes = allocationTypes;
	$ctrl.sites =sites;
	$ctrl.desigations=desigations;
	$ctrl.capabilities=capabilities;
	$ctrl.resources=resources;
	$ctrl.ok = function(){
		console.log($ctrl.demand);
		$uibModalInstance.close($ctrl.demand);

	};
	$ctrl.cancel = function(){
		$uibModalInstance.dismiss('cancel');
	}
})


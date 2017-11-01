app.controller("PC-DemandController",["$scope","demandService","$stateParams","$window",function($scope,demandService,$stateParams,$window){
	 moment.locale('en');  
	 $scope.visible=false;
	 $scope.showToggle=function(){
		 $scope.visible=true;
	 };
	
	 /*
	  * demands depends on opp-id
	  */
	
	var oppId = $stateParams.id;
	
	 console.log("oppId" +oppId);
	 demandService.getDemands(oppId).then(function(demandData){
		if(demandData&&demandData.length){
			//2alert("select success");
			//$scope.demands.push(demandData);
			//console.log(demandData);
			$scope.demands=demandData;
		}
		
	});
	 /*
	  * all selects data 
	  */
	 demandService.getSelects().then(function(selectsData){
		 //$scope.sites = selectsData.siteData;
		// $scope.resources = selectsData.resourceData;
		$scope.selects=selectsData;
		//console.log($scope.selects);
		//console.log($scope.selects.drmsAllocationType);
		$scope.allocationTypes=$scope.selects.drmsAllocationType;
		$scope.sites=$scope.selects.drmsSite;
		$scope.desigations=$scope.selects.drmsDesigation;
		$scope.capabilities=$scope.selects.drmsCapability;
		$scope.resources=$scope.selects.drmsResource;
		 
	 });
	 
	 
	 
	          		 
	 

	//$scope.desigations = ["CC","C","MM" ];
	//$scope.selected=$scope.allocationTypes[0].atpName;
	//$scope.selected=$scope.site.site_name;
	 /*
	  * insert demands 
	  */
	$scope.addDemand=function(){
		$scope.visible=true;
		var obj=  {
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
			  
			    "drmsResource": {
			    	 "resourceId": 1,
			         "resourceName": "Ting Liu"
			    },

			    "drmsAssCapability": {
			      "capId": 9,
			      "capName": "Digital & TDI"
			    },

			    "dmdShowId": "0"
			  }

	
		this.$edit=true;
		obj.$edit=true;
		$scope.demands.push(obj);
		//console.log($scope.demands);
		
	};
	$scope.edit = function(){
		 //$scope.demands.$edit=true;
	};
	$scope.save = function(){
		//$scope.demands.$edit=false;
		
	}
	/*
	 * update an insert request
	 */
	$scope.submit = function(){
		$scope.visible=false;
		
		for(var x in $scope.demands){
			delete $scope.demands[x].$edit;
			//console.log($scope.demands);
		}
		
		demandService.addUpDemands($scope.demands).then(function(data){
			
			console.log("addOrUpdate"+$scope.demands);
				if(data){
						 alert("saved success");	 
						 
					 	}
		 	})};
		
	
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
		/*
		 * modal alert
		 */
		
		
//		var $ctrl = this;
//		$ctrl.items=['item1','item2','item3'];
//		$ctrl.animationsEnabled = true;
//		$ctrl.open = function(size,parentSelector){
//			var parentParams=parentSelector ? 
//					angular.element($document[0].querySelector('.demandmodal'+parentSelector)) : undefined;
//			var modalInstance = $uibModal.open({
//				animation:$ctrl.animationsEnabled,
//				ariaLabelledBy : 'modal-title',
//				ariaDescribedBy  : 'modal-body',
//				templateUrl : 'views/modalDemandcontent.html',
//				controller: 'ModalInstanceController',
//				controllerAs: '$ctrl',
//				size: size,
//				appendTo : parentParams,
//				resolve: {
//					items: function(){
//						return $ctrl.items;
//					}
//				}
//				
//				
//			});
//			modalInstance.result.then(function(selectedItem){
//				$ctrl.selected = selectedItem;
//				
//			},function(){
//				$log.info('Modal dismissed at :'+new Date());
//			})
//		}
//		
//		
//}]);
//		
//		
//		
// 
//app.controller('ModalInstanceController',function($uibModalInstance,items){
//	var $ctrl = this;
//	$ctrl.items = items;
//	$ctrl.selected={
//			item: $ctrl.items[0]
//	};
//	$ctrl.ok = function(){
//		$uibModalInstance.close($ctrl.selectd.item)
//	};
//	$ctrl.cancel = function(){
//		$uibModalInstance.dismiss('cancel');
//	}
//	
//})

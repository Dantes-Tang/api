/**
 * 
 */
app.controller('OppMngController', ['$scope', 'oppodmdService','$window','$uibModal','$log','$document',function($scope, oppodmdService,$window,$uibModal,$log,$document) {
	var $ctrl = this;
	
	$ctrl.oppos = [];
	$ctrl.accs = [];
	$ctrl.stas = [];
	
	$scope.iseditable = 'uneditable';
	$scope.lockStatus = 'unLock';
	
	/*
	 * the size of screen
	 */
	$ctrl.isXs = function(){
		if($window.innerWidth<768){
			 //$scope.width  = $window.innerWidth;
			 return "detail-xs"
			  }else
				  return 'detail-pc'
			 console.log("scannerwidth"+$ctrl.width);
	}
	/*
	 * open opp-add modal
	 */
	
	$ctrl.animationsEnabled = true;
	$ctrl.openOppAdd = function(index,size,parentSelector){
		console.log("the oppppp is"+$ctrl.oppos[index]);
		console.log("the status selects is "+$ctrl.stas)
		var parentParams = parentSelector?
							angular.element($document[0].querySelector('.modal-demand '+parentSelector)) : undefined;
		var modalInstance = $uibModal.open({
			animation:$ctrl.animationEnabled,
			ariaLabelledBy :'modal-title',
			ariaDescribedBy : 'modal-body',
			templateUrl : 'views/xs-modal-OppAdd.html',
			controller :'ModalOppAddInstanceController',
			controllerAs:'$ctrl',
			size:size,
			appendTo:parentParams,
			resolve:{
				oppo: function(){
					console.log($ctrl.oppos[index]);
						return $ctrl.oppos[index];
				},
				status: function(){
					console.log("the status is "+$ctrl.stas);
					return $ctrl.stas;
				},
				accounts: function(){
					return $ctrl.accs;
				}
			}
		});	
		modalInstance.result.then(function(currentOpp){
			$ctrl.oppos.push(currentOpp);
			 

			var isvalid = false;
			for(var i = 0; i < $ctrl.oppos.length; i++) {
				isvalid = $scope.isNotNull(i);
			}
			if(isvalid) {
				oppodmdService.oppReq($ctrl.oppos)
							  .then(function(data) {
								  console.log(data);
								  if(data[0] == true) {
									  alert('submit success');
									  $ctrl.oppos = [];
										oppodmdService.oppoLoad().then(function(resultOppos) {
											//console.log('oppos resolve')
											for(var i = 0; i<resultOppos.length; i++) {
												$ctrl.oppos.push(resultOppos[i]);
											}
											//$scope.$apply();
										});
									  
								  }

							  });			
			}
			else
				alert('data invalid !');
		
			
		},function(){
			$log.info('Modal dismissed at :'+new Date());
		})
	};
	
	
	/*
	 * open opp-edit modal
	 */

	
	//$ctrl.items=['item1','item2','item3'];
	
	$ctrl.openOppEdit = function(index,size,parentSelector){
		console.log("the oppppp is"+$ctrl.oppos[index]);
		console.log("the status selects is "+$ctrl.stas)
		var parentParams = parentSelector?
							angular.element($document[0].querySelector('.modal-demand '+parentSelector)) : undefined;
		var modalInstance = $uibModal.open({
			animation:$ctrl.animationEnabled,
			ariaLabelledBy :'modal-title',
			ariaDescribedBy : 'modal-body',
			templateUrl : 'views/xs-modal-OppEdit.html',
			controller :'ModalOppEditInstanceController',
			controllerAs:'$ctrl',
			size:size,
			appendTo:parentParams,
			resolve:{
				oppo: function(){
					console.log($ctrl.oppos[index]);
						return $ctrl.oppos[index];
				},
				status: function(){
					console.log("the status is "+$ctrl.stas);
					return $ctrl.stas;
				},
				accounts: function(){
					return $ctrl.accs;
				}
			}
		});	
		modalInstance.result.then(function(currentOpp){
			$ctrl.oppos.push(currentOpp);
			 

			var isvalid = false;
			for(var i = 0; i < $ctrl.oppos.length; i++) {
				isvalid = $scope.isNotNull(i);
			}
			if(isvalid) {
				oppodmdService.oppReq($ctrl.oppos)
							  .then(function(data) {
								  console.log(data);
								  if(data[0] == true) {
									  alert('submit success');
									  $ctrl.oppos = [];
										oppodmdService.oppoLoad().then(function(resultOppos) {
											//console.log('oppos resolve')
											for(var i = 0; i<resultOppos.length; i++) {
												$ctrl.oppos.push(resultOppos[i]);
											}
											//$scope.$apply();
										});
									  
								  }

							  });			
			}
			else
				alert('data invalid !');
		
			
		},function(){
			$log.info('Modal dismissed at :'+new Date());
		})
	};
	
	
	oppodmdService.oppoLoad().then(function(resultOppos) {
		//console.log('oppos resolve')
		for(var i = 0; i<resultOppos.length; i++) {
			$ctrl.oppos.push(resultOppos[i]);
			
		}
		//$scope.$apply();
	
		
	});
	

	oppodmdService.staLoad().then(function(resultStas) {
		for(var i = 0; i<resultStas.length; i++) {
			$ctrl.stas.push(resultStas[i]);
		}
		//$scope.$apply();
	});
	
	oppodmdService.accLoad().then(function(resultAccs) {
		for(var i = 0; i<resultAccs.length; i++) {
			$ctrl.accs.push(resultAccs[i]);
		}
		//$scope.$apply();
	});
/**
 * 	
 */	
	$scope.editTurn = function() {
	    if($scope.iseditable == 'editable') {
	    	$scope.iseditable = 'uneditable';
	    	$scope.lockStatus = 'unLock'
	    }else {
	    	$scope.iseditable = 'editable';
	    	$scope.lockStatus = 'Lock'
	    }
	}
	
	$scope.hasId = function(data) {
	    if(data != undefined){
		return 'has';
	    }
	    return 'hasNot';
	};
	
	$scope.addOppo = function() {
	    var oppo = {
            oppId: 0,
        	oppShowId: '',
        	oppName: '',
        	drmsAccount: {accountId: null, accountName: ''},
        	oppProbability: null,
        	drmsStatus: {statusId: null, statusName: ''}
	    };
	    $ctrl.oppos.push(oppo);
	};
	
	$scope.remove = function(index) {
		$ctrl.oppos.splice(index, 1);
	}
	
	$scope.submitOppos = function() {
	    
	    oppodmdService.oppReq($scope.oppos);
	}
	
	$scope.isNotNull = function(index) {
	    console.log('this is not null?'+index);
	    var validate = $ctrl.oppos[index];
	    if(validate.oppId == null)
		return false;
	    else if(validate.oppShowId == null)
		return false;
	    else if(validate.oppName == '')
		return false;
	    else if(validate.drmsAccount.accountId == null | validate.drmsAccount.accountName == '')
		return false;
	    else if(validate.oppProbability == null)
		return false;
	    else if(validate.drmsStatus.statusId == null | validate.drmsStatus.statusName == '')
		return false;
	    return true;
	};
		
	$scope.submitall = function() {}
	
}]);

app.controller('DmdMngController', ['$scope', 'oppodmdService', function($scope, oppodmdService) {
	$scope.oppos = [];
	oppodmdService.oppoLoad().then(function(resultOppos) {
		//console.log('resolve');
		//console.log(resultOppos);
		for(var i = 0; i<resultOppos.length; i++) {
			$scope.oppos.push(resultOppos[i]);
		}
		//$scope.$apply();
	});
	oppodmdService.selectedId = 8;		
}]);

app.controller('ModalOppEditInstanceController',function($uibModalInstance,oppo,status,accounts){
	var $ctrl = this;
	$ctrl.oppo = oppo;
	$ctrl.stas = status;
	$ctrl.accs = accounts;

	$ctrl.ok = function(){

		$uibModalInstance.close($ctrl.oppo);
	};
	$ctrl.cancel = function(){
		$uibModalInstance.dismiss('cancel');
	}
	
});
app.controller('ModalOppAddInstanceController',function($uibModalInstance,oppo,status,accounts){
	var $ctrl = this;
	$ctrl.oppo = oppo;
	$ctrl.stas = status;
	$ctrl.accs = accounts;
	$ctrl.addObj = {
		    "oppId": "",
		    "oppShowId": "",
		    "oppName": "",
		    "oppProbability": "",
		    "drmsStatus": {
		      "statusId": "",
		      "statusName": ""
		    },
		    "drmsAccount": {
		      "accountId": "",
		      "accountName": ""
		    }
		  }
	$ctrl.ok = function(){

		$uibModalInstance.close($ctrl.addObj);
	};
	$ctrl.cancel = function(){
		$uibModalInstance.dismiss('cancel');
	}
	
})
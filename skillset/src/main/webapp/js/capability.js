/**
 *  @author Joy Wang
 *  Capability Managemnet 
 *  TBD-Demands match to available Resource.
 */ 

app.controller("CapabilityController",["$scope","capabilityService","$state","$stateParams","$uibModal","$log","$document",function($scope,capabilityService,$state,$stateParams,$uibModal,$log,document){
	//$state.current===capa.tbd;
	
	var $ctrl = this;
	$scope.oneAtTime=true;
	$ctrl.status = {
			isHeaderOpen:false,
			isFirstOpen:true,
			isFirstDisabled:false
			
	};

	$ctrl.isCollapsed =true;
	$ctrl.bool=false;
	$ctrl.nonavailble=false;
	$ctrl.matchedSuccess=[];
	$ctrl.resource={
			resourceId:''
	};

	console.log("resourceId"+$ctrl.resource.resourceId);
	//get TBD Demands
	capabilityService.getCapabilities().then(function(capabilitiesData){
		if(capabilitiesData&&capabilitiesData.length){
			$ctrl.tbdDemands = capabilitiesData;
			console.log("tbddemands"+$ctrl.tbdDemands);
		
		}
	})
//get matched resource
	$ctrl.availableResult = false;
	$ctrl.matchResources = function(dmdId){
		capabilityService.getMatchedResources(dmdId).then(function(matchedResourcesData){
			if(matchedResourcesData&&matchedResourcesData.length>=1){
				$ctrl.matchedResources =  matchedResourcesData;
				$ctrl.bool=true;
				$ctrl.nonavailble=false;
			}else if(matchedResourcesData.length==0){
				console.log("results");
				
				$ctrl.matchedResources=null;
				$ctrl.bool=false;
				$ctrl.nonavailble=true;
			}	
		})
	}
//get matched OK submit	
	$ctrl.successMatched = function(){
		$ctrl.bool=false;
		var href=window.location.href;
		var dmdId = href.split("demandId=")[1];
		var resourceId = $ctrl.resource.resourceId;
		capabilityService.matchedSuccess(dmdId,resourceId).then(function(mathcedSuccessData){
			console.log("dmdId"+dmdId);
			console.log("resourceId"+resourceId);
			if(mathcedSuccessData){
				$ctrl.successTag = mathcedSuccessData;
				console.log("success tag"+ $ctrl.successTag);
				if($ctrl.successTag==true){
					alert("SUCCESS");
					capabilityService.getCapabilities().then(function(capabilitiesData){
						if(capabilitiesData&&capabilitiesData.length){
							$ctrl.tbdDemands = capabilitiesData;
							console.log("tbddemands"+$ctrl.tbdDemands);
						
						}
					})
					
				}else{
					alert("FAILD");
				}
				
			}
		})
		
		
	}
	
	//open Email_modal
	$ctrl.animationsEnabled = false;
	$ctrl.openEmailModal = function(index,size,parentSelector){
		var parentParams = parentSelector?
				angular.element($document[0].querySelector('.modal-demand '+parentSelector)) : undefined;

		var modalInstance = $uibModal.open({
			animation:$ctrl.animationsEnabled,
			ariaLabelledBy:'modal-title',
			ariaDescribedBy:'modal-body',
			templateUrl:'views/email-to.html',
			controller:'ModalEmailInstanceController',
			controllerAs:'$ctrl',
			size:size,
			appendTo:parentParams,
			resolve:{
				tbdDemands:function(){
					return $ctrl.tbdDemands[index];
				}
			}
		});
		modalInstance.result.then(function(currentDmd){
			$ctrl.tbdDemands.push(currentDmd);
		})
	}
		
	
	
}]);

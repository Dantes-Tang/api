app.controller('ModalEmailInstanceController',function($uibModalInstance,tbdDemands, mailsendService){
	var $ctrl = this;
	$ctrl.animationsEnabled = true;
	$ctrl.tbds = tbdDemands;
	console.log("thid is modal eamil"+$ctrl.tbds);
	$ctrl.ok = function(){
		mailsendService.mailsend($ctrl.emailInformation.to, 'demand request form', JSON.stringify($ctrl.tbds));
		$uibModalInstance.close($ctrl.tbds);
	}
	$ctrl.cancel = function(){
		$uibModalInstance.dismiss('cancel');
	}
	$ctrl.emailInformation ={
			to: null,
			opnDate: null,
			capability: $ctrl.tbds.drmsCapability.capName,
			posTit: null,
			desDes: $ctrl.tbds.drmsDesigation.dsgName,
			hirRes: null,
			hcReq: null,
			billDate: $ctrl.tbds.startDate,
			wrkLoc: $ctrl.tbds.drmsSite.siteName,
			cusIntrReq: null,
			prjIntr: null,
			dutRes: null,
			others: null,
			techs: [
				     {
				    	 	techName:null,
				    	 	techMini:null,
							techIdeal:null,
							techComments:null
				     }  
			        ],
			langs: [
				     {
				    	 	langName:null,
							langWrite:null,
							langLevel:null,
							langComments:null
				     }  
			        ]
			
	}
//	$ctrl.techObj = {
//			techName:null,
//			techMini:null,
//			techIdeal:null,
//			techComments:null
//	}
//	$ctrl.langObj= {
//			langName:null,
//			langWrite:null,
//			langLevel:null,
//			langComments:null
//	}
//	$ctrl.emailInformation.techs.push($ctrl.techObj);
//	$ctrl.emailInformation.langs.push($ctrl.langObj);

	$ctrl.addTech = function(){
		var techObj = {
		techName:null,
		techMini:null,
		techIdeal:null,
		techComments:null
		}
		$ctrl.emailInformation.techs.push(techObj);
		
	}
	$ctrl.addLang = function(){
		var langObj= {
				langName:null,
				langWrite:null,
				langLevel:null,
				langComments:null
		}
		$ctrl.emailInformation.langs.push(langObj);
	}
})
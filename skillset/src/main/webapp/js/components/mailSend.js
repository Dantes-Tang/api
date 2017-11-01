/**
 *  @author Cornelius Huang
 *  mail sending modal
 */
app.component('mailSendComponent', {
	templateUrl: './views/mailsend.html',
	bindings: {
		resolve: '<?',
		close: '&?',
		dismiss: '&?'
	},
	controller: ['demandService', function(demandService) {
		var $ctrl = this;
		
		$ctrl.request = {
				to: null,
				opnDate: null,
				capability: null,
				posTit: null,
				desDes: null,
				hirRes: null,
				hcReq: null,
				billDate: null,
				wrkLoc: null,
				cusIntrReq: null,
				prjIntr: null,
				dutRes: null,
				others: null,
				techs: [],
				langs: [],
		}
		
		$ctrl.dmd = $ctrl.resolve.dmd;
		$ctrl.calOpen1 = false;
		$ctrl.calOpen2 = false;
		$ctrl.capabilitys = [];
		$ctrl.desgations = [];
		$ctrl.sites = [];
		
		$ctrl.calendarToggle1 = function() {
			$ctrl.calOpen1 = true;
		}
		
		$ctrl.calendarToggle2 = function() {
			$ctrl.calOpen2 = true;
		}
		
		$ctrl.ok = function() {
			$ctrl.close({$value: result});
		}
		
		$ctrl.cancel = function() {
			$ctrl.dismiss();
		}
		
		/**
		 *  lang componenet & tech component callback implements
		 */
		$ctrl.langsLoad = function(langs) {
			$ctrl.request.langs = [];
			$ctrl.request.langs = $ctrl.request.langs.concat(langs);
		}
		
		$ctrl.techLoad = function(techs) {
			$ctrl.request.techs = [];
			$ctrl.request.techs = $ctrl.request.techs.concat(techs);
		}
		
		/**
		 * mailSendComponent - life cycle
		 */
		$ctrl.$onInit = function() {
			demandService.getSelects().then(function(adac) {
				$ctrl.desgations = $ctrl.desgations.concat(adac.drmsDesigation);
				$ctrl.sites = $ctrl.sites.concat(adac.drmsSite);
				$ctrl.capabilitys = $ctrl.capabilitys.concat(adac.drmsAssCapability);
			});
			//$ctrl.dmd.
		}
		
		$ctrl.$doCheck = function() {
			console.log($ctrl.request);
		} 
		
	}],
});
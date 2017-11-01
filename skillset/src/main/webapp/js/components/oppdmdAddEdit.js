/**
 *  @author Cornelius Huang
 *  opportunity and demand Edit & Add Modal
 */
app.component('demandModalComponent', {
	templateUrl: './views/editdmdmodal.html',
	bindings: {
		resolve: '<?',
		opp: '<?',
		close: '&?',
		dismiss: '&?'
	},
	controller: ['demandService', '$q', 'slideCallbackService', function(demandService, $q, slideCallbackService) {
		var $ctrl = this;
		
		$ctrl.allocType = [];
		$ctrl.capabilitys = [];
		$ctrl.desgations = [];
		$ctrl.sites = [];
		
		$ctrl.dmd = null;
		
		/**
		 *  validate not null Promise
		 */
		$ctrl.vldtPromise = function(dmd) {
			return $q(function(resolve, reject) {
				//TODO: form validate method;
				if(true) {
					resolve($ctrl.dmd);
				}else {
					reject();
				}
			});
		}
		
		$ctrl.demandLoad = function() {
			if($ctrl.resolve != null) {
				$ctrl.dmd = $ctrl.resolve.selects.dmd;
			} else {
				$ctrl.dmd = new Object();
			}
		}
		
		/**
		 *  Component Life Cycle
		 */
		$ctrl.$onInit = function() {
			
			/**
			 *  ADAC load
			 */
			demandService.getSelects().then(function(adac) {
				$ctrl.allocType = $ctrl.allocType.concat(adac.drmsAllocationType);
				$ctrl.capabilitys = $ctrl.capabilitys.concat(adac.drmsAssCapability);
				$ctrl.desgations = $ctrl.desgations.concat(adac.drmsDesigation);
				$ctrl.sites = $ctrl.sites.concat(adac.drmsSite);
			})
			
			$ctrl.demandLoad();
		}
		
		$ctrl.ok = function() {
			//TODO:  validate promise
			$ctrl.vldtPromise($ctrl.dmd).then(function(result) {
				$ctrl.close({$value: result});
			}, function(result){
				
			});
		}
		
		$ctrl.cancel = function() {
			$ctrl.dismiss();
		}
		
		slideCallbackService.getPromise.then(function(result) {
			console.log('compinent resolve' + result);
		})
		
	}]
});
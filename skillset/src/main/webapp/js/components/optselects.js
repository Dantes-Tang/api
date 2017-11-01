/**
 *  @author Cornelius Huang
 *  selects components
 */
app.component('statusComponent', {
	templateUrl: './views/corstatus.html',
	bindings: {
		slModel: '=?'
	},
	controller: ['oppodmdService', 'validNotifyService', function(oppodmdService, validNotifyService) {
		var $ctrl = this;
		
		$ctrl.isInvalid;
		
		$ctrl.$onInit = function() {
			$ctrl.isInvalid = false;
			oppodmdService.staLoad().then(function(stat) {
				$ctrl.statuses = stat;
			}, function() {
				
			});
		}
		
		$ctrl.indicateValidate = function() {
			console.log('blur validate');
			if($ctrl.slModel == undefined || $ctrl.slModel == null || $ctrl.slModel == '')
				$ctrl.isInvalid = true;
			else {
				$ctrl.isInvalid = false;
			}
			console.log($ctrl.isInvalid);
		};

		validNotifyService.getPromise.then(null, null, function() {
			console.log('validateComponent recieved notify');
			$ctrl.indicateValidate();
		});
	}]
});

app.component('acctComponent', {
	template: '<select ng-options="acct.accountName for acct in $ctrl.accts track by acct.accountId" ng-model="$ctrl.slModel" ng-blur="$ctrl.indicateValidate()" ng-class="{invalid: $ctrl.isInvalid}" class="slt-fix"></select>',
	bindings: {
		slModel: '=?'
	},
	controller: ['oppodmdService', 'validNotifyService', function(oppodmdService, validNotifyService) {
		var $ctrl = this;
		
		$ctrl.isInvalid;
		
		$ctrl.$onInit = function() {
			$ctrl.isInvalid = false;
			oppodmdService.accLoad().then(function(accts) {
				$ctrl.accts = accts;
			}, function() {
				
			});
		};
		
		$ctrl.indicateValidate = function() {
			console.log('blur validate');
			if($ctrl.slModel == undefined || $ctrl.slModel == null || $ctrl.slModel == '')
				$ctrl.isInvalid = true;
			else {
				$ctrl.isInvalid = false;
			}
			console.log($ctrl.isInvalid);
		};
		
		validNotifyService.getPromise.then(null, null, function() {
			console.log('validateComponent recieved notify');
			$ctrl.indicateValidate();
		});
	}]
});

app.component('capaComponent', {
	template: '<select ng-options="capa.capName for capa in $ctrl.capaes track by capa.capId" ng-model="$ctrl.slModel" ng-blur="$ctrl.indicateValidate()" ng-class="{invalid: $ctrl.isInvalid}" class="slt-fix"></select>',
	bindings: {
		slModel: '=?'
	},
	controller: ['demandService', 'validNotifyService', function(demandService, validNotifyService) {
		var $ctrl = this;
		
		$ctrl.isInvalid;
		
		$ctrl.$onInit = function() {
			$ctrl.isInvalid = false;
			demandService.getSelects().then(function(sdac) {
				$ctrl.capaes = sdac.drmsCapability;
			});
		}
		
		$ctrl.indicateValidate = function() {
			console.log('blur validate');
			if($ctrl.slModel == undefined || $ctrl.slModel == null || $ctrl.slModel == '')
				$ctrl.isInvalid = true;
			else {
				$ctrl.isInvalid = false;
			}
			console.log($ctrl.isInvalid);
		};
		
		validNotifyService.getPromise.then(null, null, function() {
			console.log('validateComponent recieved notify');
			$ctrl.indicateValidate();
		});
	}]
});

app.component('allocComponent', {
	template: '<select ng-model="$ctrl.slModel" ng-options="alloc.atpName for alloc in $ctrl.alloces track by alloc.atpId" ng-blur="$ctrl.indicateValidate()" ng-class="{invalid: $ctrl.isInvalid}" class="slt-fix"></select>',
	bindings: {
		slModel: '=?'
	},
	controller: ['demandService', 'validNotifyService', function(demandService, validNotifyService) {
		var $ctrl = this;
		
		$ctrl.isInvalid;
		
		$ctrl.$onInit = function() {
			$ctrl.isInvalid = false;
			console.log($ctrl.slModel);
			demandService.getSelects().then(function(sdac) {
				$ctrl.alloces = sdac.drmsAllocationType;
			});
		};
		
		$ctrl.indicateValidate = function() {
			console.log('blur validate');
			if($ctrl.slModel == undefined || $ctrl.slModel == null || $ctrl.slModel == '')
				$ctrl.isInvalid = true;
			else {
				$ctrl.isInvalid = false;
			}
			console.log($ctrl.isInvalid);
		};
		
		validNotifyService.getPromise.then(null, null, function() {
			console.log('validateComponent recieved notify');
			$ctrl.indicateValidate();
		});
	}]
});

app.component('siteComponent', {
	template: '<select ng-options="site.siteName for site in $ctrl.sites track by site.siteId" ng-model="$ctrl.slModel" ng-blur="$ctrl.indicateValidate()" ng-class="{invalid: $ctrl.isInvalid}" class="slt-fix"></select>',
	bindings: {
		slModel: '=?'
	},
	controller: ['demandService', 'validNotifyService', function(demandService, validNotifyService) {
		var $ctrl = this;
		
		$ctrl.isInvalid;
		
		$ctrl.$onInit = function() {
			$ctrl.isInvalid = false;
			demandService.getSelects().then(function(sdac) {
				$ctrl.sites = sdac.drmsSite;
			});
		};
		
		$ctrl.indicateValidate = function() {
			console.log('blur validate');
			if($ctrl.slModel == undefined || $ctrl.slModel == null || $ctrl.slModel == '')
				$ctrl.isInvalid = true;
			else {
				$ctrl.isInvalid = false;
			}
			console.log($ctrl.isInvalid);
		};
		
		validNotifyService.getPromise.then(null, null, function() {
			console.log('validateComponent recieved notify');
			$ctrl.indicateValidate();
		});
	}]
});

app.component('desComponent', {
	template: '<select ng-options="des.dsgName for des in $ctrl.deses track by des.dsgId" ng-model="$ctrl.slModel" ng-blur="$ctrl.indicateValidate()" ng-class="{invalid: $ctrl.isInvalid}" class="slt-fix"></select>',
	bindings: {
		slModel: '=?'
	},
	controller: ['demandService', 'validNotifyService', function(demandService, validNotifyService) {
		var $ctrl = this;
		
		$ctrl.isInvalid;
		
		$ctrl.$onInit = function() {
			$ctrl.isInvalid = false;
			demandService.getSelects().then(function(sdac) {
				$ctrl.deses = sdac.drmsDesigation;
			});
		}
		
		$ctrl.indicateValidate = function() {
			console.log('blur validate');
			if($ctrl.slModel == undefined || $ctrl.slModel == null || $ctrl.slModel == '')
				$ctrl.isInvalid = true;
			else {
				$ctrl.isInvalid = false;
			}
			console.log($ctrl.isInvalid);
		};
		
		validNotifyService.getPromise.then(null, null, function() {
			console.log('validateComponent recieved notify');
			$ctrl.indicateValidate();
		});
	}]
});

app.component('dateComponent', {
	template: '<input readonly type="text" ng-blur="$ctrl.onblurMet()" ng-click="$ctrl.onfocusMet()" ng-class="{invalid: $ctrl.isInvalid}" class="form-control sld-can-fix" uib-datepicker-popup="yyyy-MM-dd" ng-model="$ctrl.slModel" is-open="$ctrl.isOpen" datepicker-options="dateOptions" ng-required="true" close-text="Close" alt-input-formats="altInputFormates" />',
	bindings: {
		slModel: '=?'
	},
	controller: ['validNotifyService', function(validNotifyService) {
		var $ctrl = this;
		
		$ctrl.isOpen = false;
		$ctrl.isInvalid = false;
		
		
		var calToggle = function() {
			if($ctrl.isOpen)
				$ctrl.isOpen = false;
			else
				$ctrl.isOpen = true;
		};
		
		var indicateValidate = function() {
			console.log('blur validate');
			if($ctrl.slModel == undefined || $ctrl.slModel == null || $ctrl.slModel == '')
				$ctrl.isInvalid = true;
			else {
				$ctrl.isInvalid = false;
			}
			console.log($ctrl.isInvalid);
		};
		
		$ctrl.onblurMet = function() {
			//calToggle();
			indicateValidate();
		};
		
		$ctrl.onfocusMet = function() {
			if($ctrl.isOpen)
				$ctrl.isOpen = false;
			else
				$ctrl.isOpen = true;
		};
		
		validNotifyService.getPromise.then(null, null, function() {
			console.log('validateComponent recieved notify');
			indicateValidate();
		});
	}]
}); 

app.component('codCapaComponent', {
	template: '<select ng-options="capa.capName for capa in $ctrl.capaes track by capa.capId" ng-model="$ctrl.slModel" class="slt-fix sel"></select>',
	bindings: {
		slModel: '=?'
	},
	controller: ['demandService', function(demandService) {
		var $ctrl = this;
		
		$ctrl.$onInit = function() {
			demandService.getSelects().then(function(sdac) {
				$ctrl.capaes = sdac.drmsCapability;
			});
		}
		
	}]
});

app.component('dmdstatusComponent', {
	template: '<select ng-options="dmdStatus.dmdStatusName for dmdStatus in $ctrl.dmdStatuses track by dmdStatus.dmdStatusId" ng-model="$ctrl.slModel" class="slt-fix sel"></select>',
	bindings: {
		slModel: '=?'
	},
	controller: ['DemandStatusService', function(DemandStatusService) {
		var $ctrl = this;
		$ctrl.$onInit = function() {
			DemandStatusService.then(function(result) {
				$ctrl.dmdStatuses = result;
			}, function(result) {
				console.log(result);
			})
		}
	}]
});
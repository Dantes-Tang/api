/**
 *  @author Cornelius Huang
 *  validate when on blur
 */
app.component('validateComponent', {
	template: '<input ng-model="$ctrl.slModel" ng-class="{invalid: $ctrl.isInvalid}" ng-blur="$ctrl.indicateValidate()" type="text" />',
	bindings: {
		slModel: '=?'
	},
	controller: ['validNotifyService', function(validNotifyService) {
		var $ctrl = this;
		
		$ctrl.isInvalid;
		
		$ctrl.$onInit = function() {
			console.log('validate component validate on init');
			$ctrl.isInvalid = false;
		}
		
		$ctrl.indicateValidate = function() {
			console.log('blur validate');
			if($ctrl.slModel == undefined || $ctrl.slModel == null || $ctrl.slModel == '')
				$ctrl.isInvalid = true;
			else {
				$ctrl.isInvalid = false;
			}
			console.log($ctrl.isInvalid);
		}
		
		validNotifyService.getPromise.then(null, null, function() {
			console.log('validateComponent recieved notify');
			$ctrl.indicateValidate();
		});
	}]
});
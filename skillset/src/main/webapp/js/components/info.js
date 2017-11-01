/**
 *  @author Cornelius Huang
 *  alert modal
 */
app.component('alertComponent', {
	templateUrl: './views/coralert.html',
	bindings: {
		resolve: '<?',
		close: '&?',
		dismiss: '&?'
	},
	controller: [function() {
		var $ctrl = this;
		
		$ctrl.ok = function() {
			$ctrl.close();
		}
		
		$ctrl.cancel = function() {
			$ctrl.dismiss();
		}
	}]
});
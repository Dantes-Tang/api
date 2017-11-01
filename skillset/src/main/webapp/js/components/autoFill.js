/**
 *  @author Cornelius Huang
 *  autoFill dropDown
 */
app.component('restypeComponent', {
	templateUrl: './views/corResType.html',
	bindings: {
		slModel: '=?'
	},
	controller: ['resourceTypeService', 'validNotifyService', 'filterFilter', function(resourceTypeService, validNotifyService, filterFilter) {
		var $ctrl = this;
		
		$ctrl.resTypes = [];
		$ctrl.filteredRes = [];
		
		$ctrl.$onInit = function() {
			resourceTypeService.then(function(result) {
				$ctrl.resTypes = result;
			}, function(result) {
				console.log(result);
			});
			
			$ctrl.isHidden = true;
			
			$ctrl.filteredRes = filterFilter($ctrl.resTypes, $ctrl.slModel);
		}
		
		$ctrl.keyInput = function() {
			$ctrl.isHidden = false;
			$ctrl.filteredRes = filterFilter($ctrl.resTypes, $ctrl.slModel);
		}
		
		$ctrl.clickFill = function(result) {
			$ctrl.slModel = result;
			$ctrl.isHidden = true;
			indicateValidate();
		}
		
		var indicateValidate = $ctrl.indicateValidate = function() {
			console.log('blur validate');
			if($ctrl.slModel == undefined || $ctrl.slModel == null || $ctrl.slModel == '')
				$ctrl.isInvalid = true;
			else {
				$ctrl.isInvalid = false;
			}
			console.log($ctrl.isInvalid);
		};
		
	}]
});
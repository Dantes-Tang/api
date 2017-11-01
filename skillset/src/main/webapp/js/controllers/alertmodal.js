/**
 *  @author Cornelius Huang
 */
app.controller('alertController', function($scope, $uibModalInstance, item) {
	var $ctrl = this;
	$scope.info = item;
	
	$scope.ok = function() {
		$uibModalInstance.close();
	}
});
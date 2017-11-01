/**
 *  @author Cornelius Huang
 *  
 */
app.directive('aDemand', [function() {
	return {
		restrict: 'AE',
		templateUrl: './views/alineDmd.html',
		scope: {
			dmd: '=?',
			oppId: '=?'
		},
		controller: ['$scope', 'demandService', 'slideCallbackService', function($scope, demandService, slideCallbackService) {
			
			slideCallbackService.getPromise.then(function(result) {
				console.log('compinent resolve' + result);
			}, function(result) {
				console.log('compinent reject' + result);
			}, function(result) {
				//console.log('compinent notify' + result);
				demandService.getOneDemand($scope.dmd.dmdId).then(function(result) {
					$scope.dmd = result;
				}, function(result) {
					console.log(result);
				});
			});
			
		}]
	}
}]);
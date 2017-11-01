/**
 *  @author Cornelius Huang
 *  
 */
app.directive('acmDemand', [function() {
	return {
		restrict: 'AE',
		templateUrl: './views/alineCmDmd.html',
		scope: {
			disDmd: '=?'
			//doTask: '&?'
		},
		controller: ['$scope', '$state', 'acmDemandService', 'cmSlideCacheService', 'slideCallbackService', function($scope, $state, acmDemandService, cmSlideCacheService, slideCallbackService) {
			//console.log('acmDemand');
			
			$scope.doTask = function(disDmd, $event) {
				cmSlideCacheService.cmCache = disDmd;
				$state.go('capa.tbd.twom');
				$event.stopPropagation();
				$event.preventDefault();
			}
			
			slideCallbackService.getPromise.then(function(result) {
				console.log('compinent resolve' + result);
			}, function(result) {
				console.log('compinent reject' + result);
			}, function(result) {
				acmDemandService.reloadADemand($scope.disDmd.dmdID).then(function(result) {
					//console.log(result);
					$scope.disDmd = result[0];
				}, function(result) {
					console.log(result);
				})
			});
			
			
		}]
	}
}]);
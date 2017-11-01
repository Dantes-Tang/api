/**
 * @author Cornelius Huang
 * opportunity demand condition filter 
 */
app.directive('condFilter', [function() {
	return {
		restrict: 'E',
		transclude: true,
		scope: {
			getResult: '&',
			oppdmd: '<',
			accts: '<'
		},
		templateUrl: 'views/condfilter.html',
		controller: ['$scope', '$timeout', '$q', 'oppShowIdFilter', 'oppAccountFilter', 'oppAccountFilter', function($scope, $timeout, $q, oppShowIdFilter, oppAccountFilter, oppAccountFilter) {
			$scope.cond = {oppId: '', oppName: '', acct: null};
			var result = null;
			
			this.test = function() {
				console.log('require test');
			};
			
			$scope.doFiltering = function() {
				var cond = $scope.cond;
				
				
//				cond.oppId = cond.oppId.tirm();
//				cond.oppName = cond.oppName.trim();
				
				console.log(cond);
				var result = oppShowIdFilter($scope.oppdmd, cond.oppId, 1);
				result = oppShowIdFilter(result, cond.oppName, 2);
				result = oppAccountFilter(result, $scope.cond.acct);
				$scope.getResult({result: result});
			}
			/**
			 * watch the oppdmd finish
			 */
			$scope.$watch('oppdmd.length', function(newValue, oldValue) {
				$scope.doFiltering();
			});
			
		}]
	};
	
}]);
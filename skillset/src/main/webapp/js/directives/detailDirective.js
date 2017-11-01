/**
 *  @author Cornelius Huang
 *  titles and detail tab
 */
app.directive('corTitle', [function() {
	return {
		restrict: 'AE',
		transclude: true,
		templateUrl: './views/corTitle.html',
		scope: {
			
		},
		controller: ['$scope', function($scope) {
			
			$scope.index = 0;
			$scope.details = [];
			
			this.detailLoader = function(detail) {
				if($scope.details.length == 0) {
					detail.selected = true;
				}
				$scope.details.push(detail);				
			};
			
			this.next = function() {
				$scope.index++;
				$scope.details.forEach(function(detail) {
					detail.selected = false;
				});
				$scope.details[$scope.index] = true;
			}
			
			this.prev = function() {
				$scope.index--;
				$scope.details.forEach(function(detail) {
					detail.selected = false;
				});
				$scope.details[$scope.index] = true;
			}
		}]
	}
}]);

app.directive('corDetail', [function() {
	return {
		restrict: 'AE',
		transclude: true,
		templateUrl: './views/corDetail.html',
		scope: {
			tag: '@'
		},
		require: '^^corTitle',
		controller: ['$scope', function($scope) {
			
		}],
		link: function(scope, element, attrs, titleCtrl) {
			titleCtrl.detailLoader(scope);
		}
	}
}])
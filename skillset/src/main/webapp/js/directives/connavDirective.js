/**
 *  @author Cornelius Huang
 *  for content nav tab
 */
app.directive('contentNav', [function() {
	return {
		restrict: 'E',
		transclude:true,
		templateUrl: './views/corConNav.html',
		scope: {
			
		},
		controller: ['$scope', function($scope) {
			$scope.panes = [];
			
			$scope.$on('readServ', function() {
				console.log('content nav - hi body hidden');
				
			});
			
			$scope.selected = function(pane) {
				$scope.panes.forEach(function(pane) {
					pane.selected = false;
				});
				pane.selected = true;
			}
			
			this.paneLoader = function(pane) {
				$scope.panes.push(pane);
			}
		}]
	}
}]);

app.directive('contentPane', [function() {
	return {
		restrict: 'AE',
		transclude: true,
		templateUrl: './views/corConPan.html',
		scope: {
			tag: '@',
		},
		require: '^^contentNav',
		controller: ['$scope', 'slidegetter', function($scope, slidegetter) {
			$scope.open = function($event) {
				$event.stopPropagation();
				$scope.$emit('readServ');
			};
			
			$scope.$on('readServ', function() {
				console.log('content panel - hi body hidden');
				$scope.$broadcast('dispatcher');
			});
		}],
		link: function(scope, element, attrs, contentCtrl) {
			contentCtrl.paneLoader(scope);
		}
	}
}]);
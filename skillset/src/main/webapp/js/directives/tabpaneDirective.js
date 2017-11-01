/**
 *  @author Cornelius Huang
 *  tab & panes for modal
 */
app.directive('dcorTab', [function() {
	return {
		restrict: 'E',
		transclude: true,
		templateUrl: './views/cortab.html',
		scope: {
			
		},
		controller: ['$scope', function($scope) {
			
			
			$scope.panes = [];
			
			$scope.selected = function(pane) {
				$scope.panes.forEach(function(pane) {
					pane.selected = false;
				});
				pane.selected = true;
			}
			
			this.addPane = function(pane) {
				$scope.panes.push(pane);
			}
			
			$scope.$watch('panes.length', function(newValue, oldvalue) {
				console.log('$watch - panes length is '+newValue);
				if(newValue != 0) {
					$scope.selected($scope.panes[0])
				}
			});
			
/*			this.$onInit = function() {
				console.log('do on init');
				console.log($scope.panes.length);
			}
			
			this.$postLink = function() {
				console.log('do post link');
				console.log($scope.panes.length);
				//$scope.selected($scope.panes[0]);
			}
			
			this.doCheck = function() {
				console.log('do check');
				console.log($scope.panes.length);
			}*/
		}]
	}
}]);

app.directive('dcorPane', [function() {
	return {
		restrict: 'AE',
		transclude: true,
		templateUrl: './views/corpane.html',
		scope: {
			title: '@'
		},
		require: '^^corTab',
		controller: ['$scope', function($scope) {
			
		}],
		link: function(scope, element, attrs, corTabCtrl) {
			corTabCtrl.addPane(scope);
		}
	}
}]);
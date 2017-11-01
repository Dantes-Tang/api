/**
 *  @author Cornelius Huang
 *  for refactor left nav tab 
 */
app.directive('corLeftnav', [function() {
	return {
		restrict: 'E',
		transclude: true,
		templateUrl: './views/corlftnav.html',
		scope: {
			
		},
		controller: ['$scope', function($scope) {
			$scope.tabs = [];
			
			$scope.selected = function(tab) {
				$scope.tabs.forEach(function(tab) {
					tab.selected = false;
				});
				tab.selected = true;
			};
			
			this.tabCollector = function(tab) {
				$scope.tabs.push(tab);
			};
			
		}]
	};
}]);

app.directive('corNvpane', [function() {
	return {
		restrict: 'AE',
		transclude: true,
		templateUrl: './views/corcontent.html',
		scope: {
			tag: '@',
			role: '@'
		},
		require: '^^corLeftnav',
		constroller: ['$scope', function($scope) {
			
		}],
		link: function(scope, element, attrs, corLftCtrl) {
			corLftCtrl.tabCollector(scope);
		}
	}
}]);
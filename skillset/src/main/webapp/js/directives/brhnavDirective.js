/**
 *  @author Cornelius Huang
 *  branch nav
 */
app.directive('brhNav', [function() {
	return {
		restrict: 'AE',
		transclude: true,
		templateUrl: './views/corbrhNav.html',
		scope: {
			
		},
		controller: ['$scope', function($scope) {
			$scope.items = [];
			
			$scope.select = function(item) {
				$scope.items.forEach(function(item) {
					item.selected = false;
				});
				item.selected = true;
			}
			
			this.itemGetter = function(scope) {
				$scope.items.push(scope);
			}
		}]
	}
}]);

app.directive('brhItem', [function() {
	return {
		restrict: 'AE',
		transclude: false,
		scope: {
			
		},
		require: '^^brhNav',
		controller: ['$scope', function($scope) {
			
		}],
		link: function(scope, element, attrs, brhCtrl) {
			scope.tag = element.text();
			scope.uisref = attrs.uiSref;
			console.log('tag is '+scope.tag+' uiserf is '+scope.uisref);
			brhCtrl.itemGetter(scope);
		}
	}
}])
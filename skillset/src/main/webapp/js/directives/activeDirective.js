/**
 *  @author Cornelius Huang
 *  header nav active directive
 */
app.directive('headTabnav', [function() {
	return {
		restrict: 'AE',
		transclude: true,
		templateUrl: './views/corHeadTab.html',
		scope: {
			
		},
		controller: ['$scope', 'userRoleService', 'tabFilter', function($scope, userRoleService, tabFilter) {
			
			$scope.items = [];
			
			$scope.filteredItems = [];
			
			var itemRemove = function(arys, index) {
				for(var i = index + 1; i < arys.length; i++) {
					arys[i - 1] = null;
					arys[i - 1] = ary[i];
				}
				arys.pop();
				return arys;
			}
			
			this.$postLink = function() {
				console.log("post link");
				
				userRoleService.getCurrRole.then(function(result) {
					console.log(result);
					var permission = result;
					
					$scope.filteredItems = tabFilter($scope.items, result);
					
				}, function(result) {
					console.log(result);
				});
			}
						
			this.itemGetter = function(scope) {
				$scope.items.push(scope);
				console.log('scope pushed');
			}
		}]
	}
}]);

app.directive('navItem', [function() {
	return {
		restrict: 'AE',
		transclude: false,
		scope: {
			
		},
		require: '^^headTabnav',
		controller: ['$scope', function($scope) {
			
		}],
		link: function(scope, element, attrs, headCtrl) {
			scope.tag = element.text();
			scope.level = attrs.level;
			scope.uisref = attrs.uiSref;
			headCtrl.itemGetter(scope);
		}
	}
}]);
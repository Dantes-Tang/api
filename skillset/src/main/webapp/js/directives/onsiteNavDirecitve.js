/**
 *  @author Cornelius Huang
 *  
 */
app.directive('onsiteNav', function() {
	return {
		restrict: 'E',
		transclude: true,
		scope: {
			
		},
		templateUrl: './views/onsiteNav.html',
		controller: ['$scope', function($scope) {
			var $ctrl = this;
			
		}],
		
	}
});

app.directive
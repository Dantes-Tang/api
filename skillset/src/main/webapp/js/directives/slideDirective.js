/**
 *  @author Cornelius Huang
 *  Detail slide list
 */
app.directive('slideList', ['$document', function($document) {
	return {
		restrict: 'AE',
		scope: {
			
		},
		controller: ['$scope', function($scope) {
			
		}],
		link: function(scope, element, attrs) {
			element.on('click', function(event) {
				event.stopPropagation();
			});
		}
	}
}]);

app.directive('bodyHidden', ['$document', function($document) {
	return {
		scope: {
			
		},
		controller: ['$scope', '$state', function($scope, $state) {
			$scope.oppEditHide = function() {
				if($state.includes('account.opportunity.edit'))
					$state.go('^');
				if($state.includes('account.opportunity.add'))
					$state.go('^');
				if($state.includes('account.demand.add'))
					$state.go('^');
				if($state.includes('account.demand.edit'))
					$state.go('^');
				if($state.includes('capa.tbd.twom'))
					$state.go('capa.tbd');
			}
			
		}],
		link: function(scope, element, attrs) {
			element.on('click', function() {
				scope.oppEditHide();
			})
		}
	}
}]);

app.directive('accordHeadbutton', [function() {
	return {
		scope: {
			
		},
		link: function(scope, element, attrs) {
			element.on('click', function(event) {
				//console.log('accordHeadbutton - stop propagation');
				event.stopPropagation();
				event.preventDefault();
			});
		}
	}
}]);
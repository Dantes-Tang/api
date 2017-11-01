/**
 *  @author Cornelius Huang
 *  DIY Accordion directive
 */
app.directive('corAccordionGroup', [function() {
	return {
		restrict: 'E',
		transclude: true,
		scope: {
			loadElements: '&?'
		},
		templateUrl: 'views/accordiongroup.html',
		controller: ['$scope', function accordionGroupController($scope) {
			
			$scope.elements = [];
			this.pushToElements = function(element) {
				$scope.elements.push(element);
				console.log('INFO - element push to elements');
			}
			
			$scope.collapseAll = function() {
				$scope.elements.forEach(function(element) {
					element.addClass('collapse');
				});
			}
			
			$scope.extendAll = function() {
				$scope.elements.forEach(function(element) {
					element.removeClass('collapse');
				});
			}
			
			$scope.$watch('elements.length', function(newValue, oldValue) {
				$scope.loadElements({elements: $scope.elements});
			});
			
		}]
	};
}]);

app.directive('corAccordion', [function() {
	return {
		restrict: 'E',
		transclude: true,
		scope:{
			heading: '=',     //opportunity
			isDisabled: '='   
		},
		controller: ['$scope', '$element', '$attrs', function($scope, $element, $attrs) {
			
			$scope.isOpen = false;
			$scope.element = null;
										
			$scope.toggle = function() {
				$scope.element.toggleClass('collapse');
			}
			
			this.addElement = function(element) {
				$scope.element = element;
			}
			
			console.log($scope.isOpen);
		}],
		templateUrl: 'views/corAccordion.html'
	}
}]);

app.directive('corAccordContent', [function() {
	return {
		restrict: 'E',
		transclude: true,
		require: ['^^corAccordionGroup', '^^corAccordion'],
		scope: {
			tables: '=?',   //demands under a opportunity
			aopp: '=?'      //opportunity
		},
		controller: ['$scope', function($scope) {
			console.log($scope.demands);
		}],
		templateUrl: 'views/corAccordContent.html',
		link: function(scope, element, attrs, ctrls) {
			console.log(ctrls);
			ctrls[0].pushToElements(element);
			ctrls[1].addElement(element);
		}
	};
}]);
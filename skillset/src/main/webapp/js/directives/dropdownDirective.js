/**
 *  @author Cornelius Huang
 *  DIY dropdown
 */
app.directive('corDropdown', ['$uibModal', 'demandService', function($uibModal, demandService) {
	return {
		restrict: 'E',
		transclude: true,
		scope: {
			dmd: '<?',
			opp: '<?'
		},
		templateUrl: 'views/cordropdown.html',
		controller: ['$scope', '$window', function($scope, $window) {
			console.log('INFO - Dropdown get demand: '+$scope.dmd);
			console.log('INFO - Dropdown get opportunity:  '+$scope.opp);

			
			$scope.element = null;
			$scope.itemElements = [];
			
			$scope.doToggle = function() {
				$scope.element.toggleClass('dpn-menu-inactive');
			}
			
			$scope.$watch('element', function(newValue, oldValue) {
				if(newValue != null) {
					var innerWidth = $window.innerWidth;
					
					console.log($scope.element);
					console.log('The windows width: '+$window.innerWidth);
					console.log('watch the span'+$scope.spanOffset);
					console.log('watch the menu Width'+$scope.menuWidth);
					
					var dvalue = $window.innerWidth - $scope.spanOffset;
					/*if(dvalue <= $scope.menuWidth) {
						$scope.element.addClass('dpn-menu-fix');
					}*/
					//TODO: need more think.
					if(true) {
						$scope.element.addClass('dpn-menu-fix');
					}
				}
				
			});
			
			this.setElement = function(element, menuWidth){
				$scope.element = element;
				$scope.menuWidth = menuWidth;
			}
			
			this.setEventElement = function(itemElement) {
				$scope.itemElements.push(itemElement);
			}
			
			/**
			 *  Business function - demand add & edit
			 */
			this.openCompModal = function(bstype) {
				var modalInstance = $uibModal.open({
					animation: true,
					component: 'demandModalComponent',
					resolve: {
						selects: function() {
							return {
								dmd: $scope.dmd,
								bsType: bstype
							};
						}
					}
				});
				modalInstance.result.then(function(result) {
					console.log(result);
					if(bstype == 'edit') {
						var results = new Array();
						results.push(result);
						demandService.addUpDemands(results).then(function(response) {
							console.log('INFO - edit demand');
						}, function(response) {
							
						})
					}else if(bstype == 'baseadd') {
						result.dmdId = 0;
						var results = new Array();
						results.push(result);
						demandService.addUpDemands(results).then(function(response) {
							console.log('INFO - base add');
						}, function(response) {
							
						})
					}
				}, function(result) {
					
				});
			}
			
			/**
			 * Business function - mail send modal
			 */
			this.mailSendModal = function() {
				var modalInstance = $uibModal.open({
					animation: true,
					component: 'mailSendComponent',
					resolve: {
						dmd: null
					}
				});
				modalInstance.result.then(function(result) {
					
				});
			}
			
			/**
			 *  dropdown menu items event binding
			 */
			$scope.$watch('itemElements.length', function(newValue, oldValue) {
				console.log('INFO - itemElements update');
				$scope.itemElements.forEach(function(itemElement) {
					itemElement.on('click', function() {
						$scope.doToggle();
						//$scope.openCompModal();
						//TODO: click EVENT add
					});
				});
			})
			
			$scope.$watch('spanOffset', function(newValue, oldValue) {
				console.log('get SPAN Offset:  '+newValue);
			});

		}],
		link: function(scope, element, attrs) {
			scope.spanOffset = angular.element(document.getElementById('dropdn')).prop('offsetLeft');
			scope.menuWidth = angular.element(document.getElementById('menu')).prop('offsetWidth');
			console.log('offsetleft'+scope.spanOffset);
			console.log(element);
		}
	}
}]);

app.directive('dropMenu', [function() {
	return {
		restrict: 'E',
		transclude: true,
		scope: {
			test: '=?'
		},
		templateUrl: 'views/cordropmenu.html',
		controller: ['$scope', function($scope) {
			
		}],
		require: '^^corDropdown',
		link: function(scope, element, attrs, dpdnCtrl) {
			var menuWidth = angular.element(document.getElementById('menu')).prop('offsetWidth');
			dpdnCtrl.setElement(element, menuWidth);
			console.log('offsetWidth'+scope.menuWidth);
		}
	}
}]);

app.directive('menuItem', [function() {
	return {
		restrict: 'A',
		transclude: true,
		scope: false,
		controller: ['$scope', function($scope) {
			$scope.openCompModal = function() {
				var midalInstance = $uibModal.open({
					animation: this.animationsEnabled,
					component: 'demandModalComponent',
					resolve: {
						selects: function() {
							return $scope.dmd;
						}
					}
				});
			}
		}],
		require: '^^corDropdown',
		link: function(scope, element, attrs, dpdnCtrl) {
			dpdnCtrl.setEventElement(element);
			
			element.on('click', function() {
				//dpdnCtrl.openCompModal(attrs.bsType);
				dpdnCtrl.mailSendModal();
			});
		}
	}
}]);
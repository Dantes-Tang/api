/**
 * 
 */
app.controller('BaseController', ['$scope', function($scope) {
	var navs = $scope.navs = [
	               {
	            	   id: 0,
	            	   title: 'Opportunitory Management'
	               },
	               {
	            	   id: 1,
	            	   title: 'Demonds Management'
	               }
	               ];
	var currentId = $scope.currentId = 0;
	
	var bsLoad = $scope.bsLoad = function(index) {
		$scope.currentId = index;
		
	}
}]);
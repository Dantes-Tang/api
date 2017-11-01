/**
 *
 */
app.controller('OppController', ['$scope', 'oppodmdService', function($scope, oppodmdService) {
	$scope.oppos = [];
	oppodmdService.oppoLoad().then(function(resultOppos) {
		//console.log('resolve');
		//console.log(resultOppos);
		for(var i = 0; i<resultOppos.length; i++) {
			$scope.oppos.push(resultOppos[i]);
		}
		$scope.$apply();
	});
	oppodmdService.selectedId = 8;	
}]);

app.controller('selectedTestController', ['$scope', 'oppodmdService', function($scope, oppodmdService) {
	console.log(oppodmdService.selectedId);
}]);
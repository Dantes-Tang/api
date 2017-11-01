/**
 * 
 */

app.controller('SourceController', ['$scope', 'filterFilter', function($scope, filterFilter) {
	$scope.test = 'testStr';
	var sources = $scope.sources = []; //from back-end
	var source = {};
	
	var searchCond = $scope.searchCond = '';
	
	source.id = 0;
	source.name = 'sourceA';
	source.url = 'http://www.baidu.com';
	
	var newSources = $scope.newSources = [];
	
	var filteredSources = $scope.filteredSources = [];
	
	var submitSources = $scope.submitSources = []; //to back-end
	
	var editSources = $scope.editSources = [];
	
	for(var i=0; i<10; i++){
		sources.push({name:'sourceA', url: 'http://www.baidu.com'});
	}
	
	this.filteredSources = filterFilter(this.sources, '');
	
	var addSource = $scope.addSource = function() {
		this.newSources.push({name:"", url:""});
	};
	
	var deleteSource = $scope.deleteSource = function($index) {
		this.newSources.splice($index, 1);
	};
	
	var confirmEdit = $scope.confirmEdit = function(source) {
		console.log(source);
		this.submitSources.push(source);
		this.source.$edit = false;
	};
	
	var confirmSource = $scope.confirmSource = function() {
		for(var j = 0; j < this.newSources.length; j++) {
			if(this.newSources[j].name=="" && this.newSources[j].url=="") {
				console.log('in if');
				this.newSources.splice(j, 1);
			}
		}
	};
	
	
}]);
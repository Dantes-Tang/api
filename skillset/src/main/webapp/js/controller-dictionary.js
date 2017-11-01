/**
 * 
 */
app.controller('DictController', ['$scope', 'dictService', function($scope, dictService) {
	
	var result = $scope.result= [];
	
	var dicts = $scope.dicts = [];
	var editCache = $scope.editCache = [];
	var inserts = $scope.inserts = [];
	var saves = $scope.saves = [];
	
	var dictLoad = function() {
		dicts.splice(0, dicts.length);
		dictService.search().then(function(data) {
			console.log(data.length); 
			for(var i = 0; i<data.length; i++) {
				dicts.push(data[i]);
			}
		});		
	};
			
	var editOpsOn = $scope.editOps = function(dict, $index) {
		dict.$edit = true;
		this.refreshOps($index);
		console.log(this.editCache);
		editOpsOff($index);
	};
	
	var editOpsOff = function ($index) {
		for(var i = 0; i<dicts.length; i++) {
			if(i == $index)
				continue;
			dicts[i].$edit = false;
		}
	};
	
	var saveOps = $scope.saveOps = function($index) {
		//TODO: Http request to submit editCache
		editOpsOff($index);
		dictService.update(this.editCache[0])
				   .then(function(data) {
					   console.log(data.result);
					   dictLoad();
				   });
	};
	
	var refreshOps = $scope.refreshOps = function($index) {
		this.editCache.pop();
		this.editCache.push(angular.copy(this.dicts[$index]));
	};
	
	var insertOps = $scope.insertOps = function(){
		this.inserts.push({
			dataModule: '',
        	dataCode: '',
        	dataName: '',
        	dataParent_Id: '',
        	priority: '',
        	description: '',
        	retired: '',
        	validate: true,
        	});
	};
	
	var deleteOps = $scope.deleteOps = function($index) {
		this.inserts.splice($index,1);
	};
	
	var saveInsertOps = $scope.saveInsertOps = function($index) {
		//TODO: data validation
		var saveCache = this.inserts[$index];
		if(isNotNull(saveCache)) {
			saveCache.validate = true;
			//TODO: http request and clear the saves cache;
			this.saves.push(saveCache);
			dictService.add(saveObjBulider(saves[$index])).then(function(data){
				dictLoad();
			});
			
			//this.deleteOps($index);
		}else {
			saveCache.validate = false;
			console.log('error');
		}
		
	};
	
	var saveObjBulider = function(save) {
		var saveObj = {
			    dataModule: save.dataModule,
			    dataCode: save.dataCode,
			    dataName: save.dataName,
			    dataParent_Id: save.dataParent_Id,
			    priority: save.priority,
			    description: save.description,
			    retired: save.retired
			  };
		return saveObj;
	};
	
	var isNotNull = function(checkObj) {
		if(checkObj.dataModule == '')
			return false;
		else if(checkObj.dataCode == '')
			return false;
		else if(checkObj.dataName == '')
			return false;
		else if(checkObj.dataParent_Id == '')
			return false;
		else if(checkObj.priority == '')
			return false;
		else if(checkObj.description == '')
			return false;
		else if(checkObj.retired == '')
			return false;
		else
			return true;	
	};
	
	dictLoad();
	
}]);
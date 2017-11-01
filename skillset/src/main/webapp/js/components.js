/**
 * 
 */

function DmdMngController($scope, oppodmdService) {
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
};

app.component('demondManagement', {
	templateUrl: 'views/dmd.html',
	controller: DmdMngController
});

function OppMngController($scope, oppodmdService) {
	var ctrl = this;
	
	ctrl.oppos = [];
	ctrl.accs = [];
	ctrl.stas = [];
	ctrl.selected = {
     	   id: 1,
    	   name: 'Proposal'
    };
	oppodmdService.oppoLoad().then(function(resultOppos) {
		//console.log('oppos resolve')
		for(var i = 0; i<resultOppos.length; i++) {
			ctrl.oppos.push(resultOppos[i]);
		}
		$scope.$apply();
	});
	
	oppodmdService.staLoad().then(function(resultStas) {
		for(var i = 0; i<resultStas.length; i++) {
			ctrl.stas.push(resultStas[i]);
		}
		$scope.$apply();
	})
}

app.component('oppManagement', {
	templateUrl: 'views/opp.html',
	controller: OppMngController
});

function EditableFieldController($scope, $element, $attrs) {
	var ctrl = this;
	
	ctrl.data = {
			availableOptions: ctrl.options,
			selectedOption: ctrl.selected
	}
	
	ctrl.selected = ctrl.data.selectedOption;
}

app.component('editableField', {
	templateUrl: 'views/editField.html',
	controller: EditableFieldController,
	bindings: {
		type: '@',
		selected: '=',
		options: '=',
		mode: '='
	}
});
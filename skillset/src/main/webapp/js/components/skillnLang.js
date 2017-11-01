/**
 *  @author Cornelius Huang
 *  language & skill table components
 */

/**
 *  language table components
 */
app.component('langComponent', {
	templateUrl: './views/langset.html',
	bindings: {
		langOut: '='
	},
	controller: ['$scope', function($scope) {
		var $ctrl = this;
		
		$ctrl.langs = [];
		$ctrl.langOut = [];
		$scope.lang = {
			langSkill: '',
			wriVer: '',
			level: '',
			comment: ''
		};
		
		$ctrl.add = function() {
			if($scope.lang.langSkill == '' && $scope.lang.wriVer == '' && $scope.lang.level == '' && $scope.lang.comment == '') {
				
			} else {
				$ctrl.langs.push($scope.lang);
				$scope.lang = {
					langSkill: '',
					wriVer: '',
					level: '',
					comment: ''
				};
				$ctrl.langOut = [];
				$ctrl.langOut = $ctrl.langs;
			}
		}
		
		$ctrl.doDel = function($index) {
			for(var i = $index + 1; i < $ctrl.langs.length; i++) {
				$ctrl.langs[i - 1] = null;
				$ctrl.langs[i - 1] = $ctrl.langs[i];
			}
			$ctrl.langs.pop();
			$ctrl.langOut = [];
			$ctrl.langOut = $ctrl.langs;
		}
		
		$ctrl.$onInit = function() {
			//console.log('COM - lang component on init');
		}
		
		$ctrl.$onChanges = function() {
			//console.log('COM - lang component on change');
		}
		
		$ctrl.$doCheck = function() {
			//console.log('COM - lang component do check');
		}
		
		$ctrl.$onDestroy = function() {
			//console.log('COM - lang component on destroy');
		}
		
	}]
});

app.component('techComponent', {
	templateUrl: './views/techset.html',
	bindings: {
		skillOut: '='
	},
	controller: ['$scope', function($scope) {
		var $ctrl = this;
		
		$ctrl.techs = [];
		$ctrl.skillOut = [];
		$ctrl.tech = {
			techSkil: '',
			miniYear: null,
			maxYear: null,
			comment: ''
		}
		
		$ctrl.add = function() {
			if($ctrl.tech.techSkil == '' && $ctrl.tech.miniExp == null && $ctrl.tech.ideaExp == null && $ctrl.tech.comment == '') {
				console.log('invalidate');
			} else {
				$ctrl.tech.miniYear = $ctrl.tech.miniYear.toString();
				$ctrl.tech.maxYear = $ctrl.tech.maxYear.toString();
				$ctrl.techs.push($ctrl.tech);
				$ctrl.tech = {
						techSkil: '',
						miniYear: null,
						maxYear: null,
						comment: ''
				}
				$ctrl.skillOut = [];
				$ctrl.skillOut = $ctrl.techs;
			}
		}
		
		$ctrl.doDel = function($index) {
			for(var i = $index + 1; i < $ctrl.techs.length; i++) {
				$ctrl.techs[i - 1] = null;
				$ctrl.techs[i - 1] = $ctrl.techs[i];
			}
			$ctrl.techs.pop();
			$ctrl.skillOut = [];
			$ctrl.skillOut = $ctrl.techs;
		}
		
		
		$ctrl.$onInit = function() {
			
		}
		
		$ctrl.$onChanges = function() {
			//console.log('COM - lang component on change');
		}
		
		$ctrl.$doCheck = function() {
			//console.log('COM - lang component do check');
			//console.log($ctrl.tech);
		}
		
		$ctrl.$onDestroy = function() {
			//console.log('COM - lang component on destroy');
		}
				
	}]
});
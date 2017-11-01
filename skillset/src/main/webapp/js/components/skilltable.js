/**
 *  @author Cornelius huang
 *  skill table component
 */
app.component('skillComponent', {
	templateUrl: './views/corSkillTable.html',
	bindings: {
		sites: '=?',
		skills: '=?'
	},
	controller: [function() {
		var $ctrl = this;
		
		$ctrl.perPage = 5;
		$ctrl.totalPage = null;
		$ctrl.totalItems = null;
		$ctrl.currPage = 1;
		
		$ctrl.pgskills = [];
		
		$ctrl.calTtPage = function() {
			$ctrl.totalItems = $ctrl.skills.length;
			
			var totalpage = $ctrl.totalItems/$ctrl.perPage;
			if($ctrl.totalItems % $ctrl.perPage != 0) {
				totalpage = Math.floor(totalpage);
				totalpage++;
			}
			$ctrl.totalPage = totalpage;
		};
		
		$ctrl.getCurrentPage = function(pgNumber) {
			var pgnumber = Math.floor(pgNumber);
			var pgskills = [];
			
			if(pgnumber > 0 && pgnumber <= $ctrl.totalPage) {
				var statInd = $ctrl.perPage * (pgnumber - 1);
				var endInd = statInd + $ctrl.perPage;
				
				for(var i = statInd; i < endInd; i++) {
					if($ctrl.skills[i] != undefined)
						pgskills.push($ctrl.skills[i]);
				}
			}
			return pgskills;
		};
		
		$ctrl.$onInit = function() {
			if($ctrl.skills != undefined) {
				$ctrl.calTtPage();
				console.log($ctrl.getCurrentPage($ctrl.currPage));
				$ctrl.pgskills = $ctrl.getCurrentPage($ctrl.currPage);
			}
		}
		
		$ctrl.pageChange = function() {
			$ctrl.calTtPage();
			console.log($ctrl.getCurrentPage($ctrl.currPage));
			$ctrl.pgskills = $ctrl.getCurrentPage($ctrl.currPage);
		}
		
	}]
});
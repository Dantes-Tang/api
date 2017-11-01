/**
 *  @author Cornelius Huang
 *  demand table in opportunity accordion
 */
app.component('dmdtableComponent', {
	templateUrl: './views/corDmdtable.html',
	bindings: {
		dmds: '<?',
		oppId: '<?',
		redmds: '=?'
	},
	controller: ['$scope', 'matrixService', 'slideCallbackService', 'demandService', 'filterFilter', function($scope, matrixService, slideCallbackService, demandService, filterFilter) {
		var $ctrl = this;
		
		this.unfilterDmds = [];
		this.pgdmds = null;
		
		this.perPage = 5;
		this.totalPage = null;
		this.totalItems = null;
		this.currPage = 1;
		
		this.calTtPage = function() {
			this.totalItems = this.dmds.length;
			
			var totalpage = this.totalItems/this.perPage;
			if(this.totalItems%this.perPage != 0) {
				totalpage = Math.floor(totalpage);
				totalpage++;
			}
			this.totalPage = totalpage;
		}
		
		 this.getCurrentPage = function(pgNumber) {
			var pgnumber = Math.floor(pgNumber);
			var pgdmds = [];
			
			if(pgnumber > 0 && pgnumber <= this.totalPage) {
				var statInd = this.perPage * (pgnumber - 1);
				var endInd = statInd + this.perPage;
				for(var i = statInd; i < endInd; i++) {
					if(this.dmds[i] != undefined)
						pgdmds.push(this.dmds[i]);
				}
			}
			return pgdmds;
		}
		
		 this.$onInit = function() {
			 $ctrl.calTtPage();
			 $ctrl.pgdmds = $ctrl.getCurrentPage($ctrl.currPage);
		 }
						
		this.$onChanges = function(changesObj) {
			//console.log('Opp Id is first change:  ' + changesObj.oppId.isFirstChange());
			//console.log('keyword is first change:  ' + changesObj.keyWord.isFirstChange());
			//console.log(changesObj.oppId);
			//console.log($ctrl.dmds);
					
			//if(changesObj.dmds != undefined) {
				//$ctrl.dmds = changesObj.dmds.currentvalue;
				$ctrl.calTtPage();
				$ctrl.pgdmds = $ctrl.getCurrentPage($ctrl.currPage);
			//}
		}
		
						
		this.pgOnChange = function() {
			this.pgdmds = null;
			this.pgdmds = this.getCurrentPage(this.currPage);
		}
		
		slideCallbackService.getPromise.then(function(result) {
			console.log('compinent resolve' + result);
		}, function(result) {
			console.log('compinent reject' + result);
		}, function(result) {
			console.log('compinent notify' + result);
			demandService.getDemands($ctrl.oppId).then(function(dmds) {
				$ctrl.dmds = dmds;
				$ctrl.redmds = dmds;
				$ctrl.calTtPage();
				$ctrl.pgdmds = $ctrl.getCurrentPage($ctrl.currPage);
			});
		});
		
	}]
});

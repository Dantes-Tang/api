/**
 *  @author Cornelius Huang
 *  paging filter
 */
app.filter('paging', [function() {
	var resAry = [];
	var perPage = null;
	var totalPage = null;
	
	var calTtPage = function(reslength, perpage) {
		var totalpage = reslength/perpage;
		if(reslength%perpage != 0) {
			totalpage = Math.floor(totalpage);
			totalpage++;
		}
		return totalpage;
	}
	
	return {
		/**
		 * Load the array that you want to make paging
		 * resary: the array that you want to paging,
		 * perpage: the number items on one page
		 */
		listLoad: function(resary, perpage) {
			resAry = [];
			resAry = resAry.concat(resary);
			perPage = perpage;
			totalPage = calTtPage(resary.length, perpage);			
		},
		/**
		 *  the array of current page items
		 *  pgNumber: current page number
		 */
		getCurrentPage: function(pgNumber) {
			var pgnumber = Math.floor(pgNumber);
			var perAry = [];
			if(pgnumber > 0 && pgnumber <= totalPage) {
				var statInd = perPage * (pgnumber - 1);
				var endInd = statInd + perPage;
				for(var i = statInd; i < endInd; i++) {
					if(resAry[i] != undefined)
						perAry.push(resAry[i]);
				}
			}
			return perAry;
		},
		/**
		 * return the paging infomation
		 */
		getPgInfo: function() {
			return {
				totalpage: totalPage,
				perpage: perPage,
				resArylength: resAry.length
			};
		},
		infoToConsole: function() {
			console.log(resAry);
			console.log('resource Array length: '+resAry.length);
			console.log('perPage: '+perPage);
			console.log('total page: '+totalPage);
		}
	}
}]);
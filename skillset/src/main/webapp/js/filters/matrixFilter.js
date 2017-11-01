/**
 *  @author Cornelius Huang
 *  matrix Filter
 */
app.filter('matrix', ['filterFilter', function(filterFilter) {
	
	return function(matrix, keyword) {
		var cmatrix = angular.copy(matrix);
		var filterResult = filterFilter(cmatrix, function(value, index, array) {
			var fDmds = filterFilter(value.dmds, keyword);
			if(fDmds.length != 0) {
				value.dmds = fDmds;
				return value;
			} else {
				var fOppdmds = [];
				fOppdmds.push(value);
				fOppdmds = filterFilter(fOppdmds, keyword);
				if(fOppdmds.length != 0) {
					return fOppdmds[0];
				}
			}
		});
		return filterResult;
	}
}])
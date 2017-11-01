/**
 *  @author Cornelius Huang
 *  Opportunity and demand Filter
 */

/**
 *  filter Opportunity by Opportunity show Id
 */
app.filter('oppShowId', [function() {
	var filterOut = [];

	var oppSidValidate = function(checkObj, checkStr, reg) {
		if(reg.test(checkStr)) {
			console.log('INFO - meet the opportunity Keyword condition');
			filterOut.push(checkObj);
		}
	}
	
	/**
	 * 	if type == 1 filter the oppShowId. if type==2 filter the oppName
	 */	
	var oppTraversal = function(oppdmds, reg, type) {
		for(var i = 0; i < oppdmds.length; i++) {
			if(type == 1) {
				oppSidValidate(oppdmds[i], oppdmds[i].oppo.oppShowId, reg);
			}else if(type == 2) {
				oppSidValidate(oppdmds[i], oppdmds[i].oppo.oppName, reg);
			}
		}
	}

	return function(oppdmds, sidkwd, type) {
		oppdmds = oppdmds || [];
		filterOut = [];
		if(sidkwd != '') {
			var reg = new RegExp(sidkwd, 'i');
			oppTraversal(oppdmds, reg, type);
			return filterOut;
		}else {
			return oppdmds;
		}
		
	}
}]);

/**
 *  filter Opportunity by account
 */
app.filter('oppAccount', [function() {
	var filterOut = [];
	
	return function(oppdmds, account) {
		oppdmds = oppdmds || [];
		filterOut = [];
		
		if(account != null) {
			oppdmds.forEach(function(oppdmd) {
				if(oppdmd.oppo.drmsAccount.accountId == account.accountId) {
					filterOut.push(oppdmd)
				}
			});
			return filterOut;
		} else {
			return oppdmds;
		}
		
	}
}]);
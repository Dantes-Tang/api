/**
 *  @author Cornelius huang
 *  permission tab filter
 */
app.filter('tab', [function() {
	var filtered = [];
	var hasLevelTwo = false;
	return function(tabs, roles) {
		roles.forEach(function(role) {
			if(role == 'ROLE_ADMIN') {
				tabs.forEach(function(tab) {
					if(tab.level == 3) {
						filtered.push(tab);
					}
				});
			} else if(role == 'ROLE_CM' || role == 'ROLE_AP' || role == 'ROLE_HR') {
				if( ! hasLevelTwo) {
					tabs.forEach(function(tab) {
						if(tab.level == 2) {
							filtered.push(tab);
						}
					});
					hasLevelTwo = true;
				}
			} else if(role == 'ROLE_USER') {
				tabs.forEach(function(tab) {
					if(tab.level == 1) {
						filtered.push(tab);
					}
				})
			}
		});
		return filtered;
	}
}]);
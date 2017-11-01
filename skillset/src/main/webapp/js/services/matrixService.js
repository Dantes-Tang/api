/**
 *  @author Cornelius Huang
 *  Opportunity demand matrix service
 */
app.factory('matrixService', ['$q', 'oppodmdService', 'demandService', function($q, oppodmdService, demandService) {
	var oppdmds = [];
	var j = 0;
		
	return $q(function (resolve, reject) {
		var getDemandsRecursion = function() {
			demandService.getDemands(oppdmds[j].oppo.oppId).then(function(demands) {
				oppdmds[j].dmds = demands;
				j++;
				if(j < oppdmds.length) {
					getDemandsRecursion();
				} else {
					console.log(oppdmds)
					resolve(oppdmds);
				}
					
			}, function() {
				reject('REJECT - get demand reject')
			});
		}
		
		if(oppdmds.length != 0 && true) {
			console('RESOLVE - soft load');
			resolve(oppdmds);
		} else {
			oppodmdService.oppoLoad().then(function(resultOppos) {
				for(var i = 0; i < resultOppos.length; i++) {
					var oppdmd = {
							oppo: null,
							dmds: null
						}
					oppdmd.oppo = resultOppos[i];
					oppdmds.push(oppdmd);
				}
				getDemandsRecursion();
				
			}, function() {
				console.log('REJECT - Oppportunity Load reject');
			});
		}
	});
}]);

app.factory('matrixdeferService', ['$q',  'oppodmdService', 'demandService', function($q, oppodmdService, demandService) {
	var oppdmds = [];
	var defer = $q.defer();
	
	var matrixLoad = function() {
		var j = 0;
		var getDemandsRecursion = function() {
			demandService.getDemands(oppdmds[j].oppo.oppId).then(function(demands) {
				oppdmds[j].dmds = null;
				oppdmds[j].dmds = demands;
				j++;
				if(j < oppdmds.length) {
					getDemandsRecursion();
				} else {
					console.log(oppdmds)
					defer.notify(oppdmds);
				}
			}, function() {
				reject('REJECT - get demand reject')
			});
		}
		
		oppodmdService.oppoLoad().then(function(resultOppos) {
			for(var i = 0; i < resultOppos.length; i++) {
				var oppdmd = {
					oppo: null,
					dmds: null
				}
				oppdmd.oppo = resultOppos[i];
				oppdmds.push(oppdmd);
				getDemandsRecursion();
			}
		});
		return defer.promise;
	}
	
	return matrixLoad();
}]);

app.factory('notifydeferService', ['$q', 'matrixService', function($q, matrixService) {
	var defer = $q.defer();
	
	return function() {
		matrixService.then(function(oppdmds) {
			defer.notify(oppdmds);
		});
		return defer.promise;
	};
}]);
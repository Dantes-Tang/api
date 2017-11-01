/**
 *  @author Cornelius Huang
 */
app.factory('slideCallbackService', ['$q', function($q) {
	var defered = $q.defer();
	return {
		promiseDeferd: defered,
		getPromise: defered.promise
	}
}]);

app.factory('validNotifyService', ['$q', function($q) {
	var defered = $q.defer();
	return {
		promiseDeferd: defered,
		getPromise: defered.promise
	}
}]);

app.factory('cmSlideCacheService', [function() {
	return {
		cmCache: null
	}
}]);
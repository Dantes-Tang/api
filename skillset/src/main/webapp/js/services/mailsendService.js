/**
 *  @author Cornelius Huang
 *  mailsend service
 */
app.factory('mailsendService', ['$http', '$q', function($http, $q) {
	var baseUrl = '/DRMS/api';
	return {
		mailsend: function(to, subject, content) {
			var http = $http({
				url: baseUrl + '/drmsEmail/send',
				method: 'POST',
				headers: {
					'Content-Type': 'application/x-www-form-urlencoded'
				},
				data: 'to='+to+'&subject='+subject+'&content='+content
			}).then(function(response) {
				console.log('Email send resolve');
				console.log(response);
				return response;
			}, function() {
				return response;
			});
			return http;
		}
	};
}]);

app.factory('mailTplMergeService', ['$http', '$q', 'mailsendService', function($http, $q, mailsendService) {
	var baseUrl = '/DRMS/views'
	return {
		sendWithTemp: function() {
			var http = $http({
				url: baseUrl + '/email-temp-main.html'
			}).then(function(response) {
				console.log(response.data);
			})
		}
	}
}]);
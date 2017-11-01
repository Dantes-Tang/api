/**
 * 
 */
app.config(function($stateProvider) {
	$stateProvider.state('resource', {
		url: '/resource',
		templateUrl: './views/re-resource.html'
	}).state('resource.ovrv', {
		url: '/overview',
		templateUrl: './views/matchingDmd.html',
	}).state('resource.usage', {
		url: '/usage',
		template: '<div>resource usage</div>'
	}).state('resource.report', {
		url: '/report',
		templateUrl: './views/report.html'
	});
	
	$stateProvider.state('recrut', {
		url: '/recrut',
		templateUrl: './views/re-recrut.html'
	}).state('recrut.recrut', {
		url: '/recrut',
		template: '<div>recrut recrut</div>'
	}).state('recrut.close', {
		url: '/close',
		template: '<div>recrut close</div>'
	});
	
/*	$stateProvider.state('report', {
		url: '/report',
		templateUrl: './views/report.html'
	}).state('recrut.recrut', {
		url: '/recrut',
		template: '<div>recrut recrut</div>'
	}).state('recrut.close', {
		url: '/close',
		template: '<div>recrut close</div>'
	});*/
})

/**
 *  refactor router configure
 */
app.config(function($stateProvider) {
	$stateProvider.state('account', {
		url: '/account',
		templateUrl: './views/re-oppdmd.html'
	}).state('account.demand', {
		url: '/demand',
		template: '<div>son</div>' +
				  '<div ui-view></div>'
	}).state('account.opportunity', {
		url: '/opptunt',
		template: '<div>grdson</div>' +
				  '<div ui-view></div>'
	});

	
//	$stateProvider.state('capa', {
//		url: '/capa',
//		templateUrl: './views/re-dmdmng.html'
//	}).state('capa.tbd', {
//		url: '/tbd',
//		template: '<div>capa tbd</div>'
//	}).state('capa.recrut', {
//		url: '/recrut',
//		template: '<div>capa recruting</div>'
//	}).state('capa.close', {
//		url: '/close',
//		template: '<div>capa close</div>'
//	});
	
	$stateProvider.state('resource', {
		url: '/resource',
		templateUrl: './views/re-resource.html'
	}).state('resource.ovrv', {
		url: '/overview',
		template: '<div>resource overview</div>'
	}).state('resource.usage', {
		url: '/usage',
		template: '<div>resource usage</div>'
	});
	
	$stateProvider.state('recrut', {
		url: '/recrut',
		templateUrl: './views/re-recrut.html'
	}).state('recrut.recrut', {
		url: '/recrut',
		template: '<div>recrut recrut</div>' +
				  ''
 	}).state('recrut.close', {
		url: '/close',
		template: '<div>recrut close</div>'
	});
	
	$stateProvider.state('report', {
		url: '/report',
		templateUrl: './views/report.html'
	}).state('recrut.recrut', {
		url: '/recrut',
		template: '<div>recrut recrut</div>' +
				  ''
 	}).state('recrut.close', {
		url: '/close',
		template: '<div>recrut close</div>'
	});
	
})
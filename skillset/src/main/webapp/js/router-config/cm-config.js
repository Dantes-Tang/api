/**
 * 
 */
app.config(function($stateProvider) {
	$stateProvider.state('capa', {
		url: '/capa',
		templateUrl: './views/re-dmdmng.html',
		controller: ['$state', function($state) {
			$state.go('capa.tbd');
		}]
	}).state('capa.tbd', {
		url: '/tbd',
		templateUrl: 'views/template_capability/capability.html',
		controller: 'CMController',
	}).state('capa.tbd.detail', {
		url: '/detail',
		templateUrl: 'views/slideDetail.html'
	}).state('capa.tbd.twom', {
		url: '/twom',
		templateUrl: 'views/cormatchmail.html',
		controller: ['$state', function($state) {
			$state.go('capa.tbd.twom.detail');
		}]
	}).state('capa.tbd.twom.mail', {
		url: '/mail',
		templateUrl: './views/slideMail.html',
		controller: 'mailTabController'
	}).state('capa.tbd.twom.match', {
		url: '/match',
		templateUrl: 'views/slideResFill.html',
		controller: 'resTabController'
	}).state('capa.tbd.twom.detail', {
		url: '/detail',
		templateUrl: 'views/slideDetail.html',
		controller: 'DetailTabController'
	}).state('capa.recrut', {
		url: '/recrut',
		template: '<div>capa recruting</div>'
	}).state('capa.close', {
		url: '/close',
		template: '<div>capa close</div>'
	}).state('capa.tbd.find-available',{
		views:{
			"available-results":{
				url:'/find-available/#demandId=:id',
				templateUrl:'views/template_capability/find_available.html',
				controller:'CapabilityController'
			},
			"unavailable-results":{
				url:'/find-available/#demandId=:id',
				templateUrl:'views/template_capability/find_unavailable.html',
				controller:'CapabilityController'
			}
		}
		
	}
			
	);
	
	//$stateProvider.transitionTo('capa.tbd.find-available');
});
//function CapabilityController($state){
//		$state.go('capa.tbd');
//	}

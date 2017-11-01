/**
 *  @author Cornelius Huang
 *  
 */
app.config(function($stateProvider) {
	$stateProvider.state('me', {
		url: '/me',
		templateUrl: './views/re-meinfo.html',
		controller: ['$state', function($state) {
			$state.go('me.me');
		}]
	}).state('me.me', {
		url: '/me',
		templateUrl: './views/user_infomation.html',
		controller: 'UserInfoController'
	}).state('me.skill', {
		url: '/skill',
		templateUrl: './views/skillset.html',
	}).state('me.onsite', {
		url: '/onsite',
		templateUrl: './views/on-site.html',
		controller: 'onsiteController'
	})
})
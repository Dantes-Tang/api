/**
 *  @author Cornelius Huang
 *  
 */
app.config(function($stateProvider) {
	$stateProvider.state('account', {
		url: '/account',
		templateUrl: './views/re-oppdmd.html',
		controller: ['$state', function($state) {
			$state.go('account.opportunity');
		}]
	}).state('account.demand', {
		url: '/demand',
		templateUrl: './views/re-dmdadd.html',
		controller: 'DmdAddEditController'
	}).state('account.demand.add', {
		url: '/:oppId',
		templateUrl: './views/corDmdAddSlide.html',
		controller: 'DmdAddController'
	}).state('account.demand.edit', {
		url: '/:oppId/:dmdId',
		templateUrl: './views/corDmdEditSlide.html',
		controller: 'DmdEditController'
	}).state('account.opportunity', {
		url: '/opptunt',
		templateUrl: './views/re-oppomng.html',
		controller: 'OppoEditController',
		resolve: {
			
		}
	}).state('account.opportunity.edit', {
		url: '/edit/:oppId',
		templateUrl: './views/corSlidebar.html',
		controller: 'EditOppController'
	}).state('account.opportunity.add', {
		url: '/add',
		templateUrl: './views/corOppAddSlide.html',
		controller: 'AddOppController'
	}).state('account.detail', {
		url: '/{detailId}',
		templateUrl: './views/re-dmdetail.html',
		controller: ['$scope', '$stateParams', '$uibModal', 'userFullInfoService', 'matrixService', 'matrixFilter', function($scope, $stateParams, $uibModal, userFullInfoService, matrixService, matrixFilter) {
			
		}]
	});
})

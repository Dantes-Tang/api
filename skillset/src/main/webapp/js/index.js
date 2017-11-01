var app= angular.module("indexApp",['ngAnimate','ngSanitize','ui.bootstrap','ui.router','ui.router.stateHelper','ui.bootstrap.datetimepicker', 'lr.upload']);
app.config(function($stateProvider){
		
	$stateProvider
	
	.state("demand",{
		
		 		url:'views/demands.html',
		 		templateUrl:'views/demands.html'
		
	})
	.state('opps',{
				
				url:"/opps",
			    templateUrl:'views/opps.html',
//			    controller:function($scope){
//					$scope.contacts=[{id:01,name:'HSBC'},{id:02,name:'Arial'}];
//					
//				}  
	  })
	
	.state('opps.list',{
		
			  url:"/list",
			  templateUrl:'views/opp.html',
			  controller: 'OppMngController as $ctrl',
			  controllerAs: '$ctrl'
			  
			  
	 })
	 
	 .state('opps.showDmd',{
		
			  url:"/showDmd",
			  templateUrl:'views/showDmd.html',
			  controller: 'DemandResourceController as $ctrl',
			  controllerAs: '$ctrl'
			  
			  
	 })
	 
//	.state('opps.mobile-detail',{
//		url:"/detail-xs",
//		templateUrl:'small-opp.html',
//		controller :''
//		
//			
//	})
	.state('opps.pc-detail',{
		url:"/:id/detail-pc",
		templateUrl:'views/lg-opp-demand.html',
		controller:"Controller"
		
	})
	.state('opps.mobile-detail',{
		
				url:'/:id/detail-xs',
				templateUrl:'views/xs-opp-demand.html',
				controller:'MobileDemandController'
				
	}).state('oppdmdreport',{
		
		url:'/oppdmdreport',
		templateUrl:'views/oppdmdreport.html',
		controller:'OdReportController'
		
	}).state('opps.oppdmdreport',{
		
		url:'/detail-pc',
		templateUrl:'views/oppdmdreport.html',
		controller:'OdReportController'
		
	}).state('accordion', {
		//This is just for DIY accordion test
		url: '/accord',
		templateUrl: 'views/accordtest.html',
		controller: 'accordtestController'
	}).state('report',{
		
		url:'/report',
		templateUrl:'views/report.html',
		controller:'reportController'
		
	});

})
app.controller("MainCtrl",["$scope","$state", '$window',function($scope,$state, $window){
	
	if($window.innerWidth<768){
		$state.transitionTo('opps.list');
	}else{
		$state.transitionTo('opps.oppdmdreport');
	}
	$scope.isXs = function(){
	if($window.innerWidth<768){
		
		return "detail-xs"
	}else {
		
		return "detail-pc"
	}
	}
}]);
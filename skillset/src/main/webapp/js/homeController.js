var myApp = angular.module("myApp",['ui.router']);
myApp.config(function($stateProvider) {
	  var oppState = {
	    name: 'views/opportunity',
	    url: 'views/opp',
	    template: 'js/views/opp.html'
	  }

	  var offerState = {
	    name: 'offer',
	    url: '/offer',
	    template: '<h3>Its the UI-Router hello world app!</h3>'
	  }

	  $stateProvider.state(oppState);
	  $stateProvider.state(offerState);
	});
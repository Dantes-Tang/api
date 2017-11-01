/*    angular.module('ui.bootstrap.demo', ['ngAnimate', 'ngSanitize', 'ui.bootstrap']);*/
app.controller('AccordionDemoCtrl',['$scope',"drmsSkillFlexibilityService", function ($scope,drmsSkillFlexibilityService) {
	$scope.oneAtATime = false;
  drmsSkillFlexibilityService.getInformation().then(function(informationData){
	  $scope.groups=informationData;
  })


  $scope.status = {
    isCustomHeaderOpen: false,
    isFirstOpen: true,
    isFirstDisabled: false
  };
  
  
}]);

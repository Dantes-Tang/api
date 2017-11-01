app.controller('reportController',['$scope',"weeklyReportService", function ($scope,weeklyReportService) {
	weeklyReportService.getInformation().then(function(informationData){
	  $scope.reports=informationData;
    }),
    weeklyReportService.getSummaryDesignation().then(function(informationData){
  	  $scope.demands=informationData;
      })
}]);

 //var app=angular.module('add-DemandApp',['ui.bootstrap.datetimepicker']);
 //moment.locale('zh-cn');  
// moment.locale('en');  
 app.controller("DemandResourceController",["showDemandService",function(showDemandService){
	 var $ctrl = this;
	 $ctrl.demands = [];
	 $ctrl.successDemands =[];
	 showDemandService.searchTBD().then(function(SearchTBDData){ 		 
		 $ctrl.demands=SearchTBDData;
	 })


	
	//matching   beginning
	$ctrl.matching = function(dmdId){
		showDemandService.matchedResource(dmdId).then(function(matchedResourceData){
			console.log('matchedResourceData',matchedResourceData);
			 $ctrl.successDemands=[];
			 for(var i=0;i<matchedResourceData.length;i++){
				 if(matchedResourceData[i]&&matchedResourceData[i].length){
//					 $ctrl.successDemands=matchedResourceData[i];
					 matchedResourceData[i].forEach(function(resource){
						 $ctrl.successDemands.push(resource);
					 });
					 console.log('$ctrl.successDemands',$ctrl.successDemands);
				 }
			 }
		 });		 
	 }
	 
	//remove  demand
	$ctrl.mismatching = function(index){
		$ctrl.successDemands.splice(index,1);
	}
	
	$ctrl.excel = function(){
		showDemandService.exportExcel().then(function(){
			console.log(5555);
		})
	}
	
	 	$ctrl.endDateBeforeRender = endDateBeforeRender
		$ctrl.endDateOnSetTime = endDateOnSetTime
		$ctrl.startDateBeforeRender = startDateBeforeRender
		$ctrl.startDateOnSetTime = startDateOnSetTime

		function startDateOnSetTime () {
		  $ctrl.$broadcast('start-date-changed');
		}

		function endDateOnSetTime () {
		  $ctrl.$broadcast('end-date-changed');
		}

		function startDateBeforeRender ($dates) {
		  if ($ctrl.endDate) {
		    var activeDate = moment($ctrl.endDate);

		    $dates.filter(function (date) {
		      return date.localDateValue() >= activeDate.valueOf()
		    }).forEach(function (date) {
		      date.selectable = false;
		    })
		  }
		}

		function endDateBeforeRender ($view, $dates) {
		  if ($ctrl.startDate) {
		    var activeDate = moment($ctrl.startDate).subtract(1, $view).add(1, 'minute');

		    $dates.filter(function (date) {
		      return date.localDateValue() <= activeDate.valueOf()
		    }).forEach(function (date) {
		      date.selectable = false;
		    })
		  }
		}
}]);

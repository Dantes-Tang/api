/**
 *  @author Cornelius Huang
 *  user acccout name
 */
app.component('userinfoComponent', {
	templateUrl: './views/coruserInfo.html',
	controller: ['userFullInfoService', function(userFullInfoService) {
		var $ctrl = this;
		$ctrl.username = '';
		$ctrl.imgSrc = 'http://10.61.213.114:8083/DrmsStaticResource/images/'
		
		$ctrl.$onInit = function() {
			userFullInfoService.then(function(result) {
				$ctrl.username = result.fullName;
				$ctrl.imgSrc = $ctrl.imgSrc + result.facePic;
			}, function(result) {
				console.log(result);
			});
		}
	}]
})
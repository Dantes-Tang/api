
app.controller('SkillsetController', ['$scope', '$rootScope', 'userService', 'skillsetService',
function($scope, $rootScope, userService, skillsetService) {
	console.log(200);
	$scope.$emit('pathChange');
	skillsetService.getCategories().then(function(data) {
		if (data && data.length) {
			$scope.categories = data;
			$scope.setCurrentCategory($scope.categories[0]);
			skillsetService.getUserSkills($scope.currentUserInfo.userName).then(function(data) {
				initUserSkills(data);
				initUI();

			});
		}
	});

	$scope.setCurrentCategory = function(category) {
		$scope.currentCategory = category;
		console.log(category);
	};
	$scope.setHasActiveData = function(category, skill) {
		var hasActiveData = false;
		for (var i = 0; i < category.children.length; i++) {
			if (category.children[i].experience) {
				hasActiveData = true;
				break;
			}
		}
		category.hasActiveData = hasActiveData;
		console.log('setHasActiveData', category, skill);
	};
	$scope.save = function() {
		console.log(123)
		var filledSkills = [];
		for (var i = 0; i < $scope.categories.length; i++) {
			if ($scope.categories[i].hasActiveData) {
				var skills = $scope.categories[i].children;
				for (var j = 0; j < skills.length; j++) {
					if (skills[j].experience) {
						filledSkills.push({
							username : $scope.currentUserInfo.userName,
							fullName : $scope.currentUserInfo.fullName,
							skill : skills[j].name,
							level : skills[j].level,
							experience : skills[j].experience
						});
					}
				}
			}
		}
		console.log(filledSkills);
		if (!filledSkills.length) {
			alert('No data for save.');
			return;
		}
		skillsetService.save(filledSkills).then(function(data) {
			if (data && data.length) {
				alert('Save succeeded.');
				console.log(123);
			}
		});
	};
	// $scope.validateExpMonth = function(skill) {
	// try {
	// console.log('skill',skill);
	// if(!skill.month){
	// return false;
	// }
	// skill.month = parseInt(skill.month);
	// if (skill.month > EXP_MONTH.max) {
	// skill.month = EXP_MONTH.max;
	// } else if (skill.month < EXP_MONTH.min) {
	// skill.month = EXP_MONTH.min;
	// }
	// } catch(e) {
	// skill.month = EXP_MONTH.min;
	// }
	// console.log('validateExpMonth',skill);
	// };
	function initUI() {
		$(document).ready(function() {
			$('table').on('keydown', 'input[type="number"]', function(e) {
				var keycode = e.which;
				switch (keycode) {
				case 8:
				//backspace
				case 9:
				//tab
				case 46:
				//delete
				case 37:
				//left
				case 38:
				//up
				case 39:
				//right
				case 40:
					//down
					return true;
				default:
					if ((keycode >= 96 && keycode <= 105) || (keycode >= 48 && keycode <= 57)) {
						return true;
					} else {
						return false;
					}
				}
			});
			$scope.resetNavigationMaxHeight();
//			var contentOffsetLeft = $('.nav-content').offset().left;
//			var contentWidth = $('.nav-content').outerWidth();
//			$(window).on('scroll', function() {
//				if ($('.nav-content').offset().top - $(document).scrollTop() <= 0 && $(document).scrollTop()) {
//					$('.nav-content').css({
//						position : 'fixed',
//						top : 0,
//						left : contentOffsetLeft,
//						width : contentWidth
//					});
//				} else {
//					$('.nav-content').removeAttr('style');
//				}
//			});
		});
	}

	function initUserSkills(data) {
		if (data && data.length) {
			for (var i = 0; i < data.length; i++) {
				for (var j = 0; j < $scope.categories.length; j++) {
					var skills = $scope.categories[j].children;
					for (var k = 0; k < skills.length; k++) {
						if (data[i].skill == skills[k].name) {
							skills[k].experience = parseInt(data[i].experience);
							skills[k].level = data[i].level;
							if (skills[k].experience) {
								$scope.categories[j].hasActiveData = true;
							}
						}
					}
				}
			}
		}
	}
}]);

/**
 * @author Cornelius Huang
 */

/**
 *  this directive is use for define height depend on explore innerHeight
 */
app.directive('autoHeight', ['$document', '$window', function($document, $window) {
	console.log('INFO - autoHeight execute.');
	return {
		link: function(scope, element, attr) {
			console.log('INFO - autoHeight execute.');
			var height = $window.innerHeight - 250;
			element.css({
				maxHeight:height+ 'px'
			});
		}
	};
}]);


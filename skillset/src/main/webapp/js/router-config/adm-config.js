
app.config(function($stateProvider) {
	$stateProvider.state('admin', {
		url: '/admin',
		templateUrl: './views/perAdmins.html',
		controller: ['$state', function($state) {
			$state.go('admin.permission');
		}]
	}).state('admin.permission', {
		url: '/permission',
		templateUrl: './views/admin.html',
		controller: ['$window', function($window) {
			jQuery(function($) {			
				capgUsers = [];
				$(document).ready(
					function ajaxRequest() {
						$.ajax({
							url : "./api/flexibility/getfindCapgUserRoles",
						    type : "POST",
						    dataType : "json",
						    async : true,
						    success : function(data) {
							if (data != 0) {
								capgUsers = data;
								for(var i = 0; i < capgUsers.length; i++) {
									$('#tbd').append('<tr><td class="tdh">'+ capgUsers[i].employeeId+ '</td>'+
											 '<td class="tdh">'+ capgUsers[i].fullName+ '</td>'+
											 '<td class="tdh" style="white-space:nowrap;overflow:hidden;text-overflow:ellipsis;cursor:pointer;" title="\''+ capgUsers[i].roleName+ '\'">'+ capgUsers[i].roleName + '</td>'+
											 '<td class="tdh"><img src="images/34.gif" onclick="updateClick(\''+i+ '\')" style="border: 0; cursor:pointer;" /></td>'+
											 '<td class="tdh"><img src="images/35.gif" onclick="deleteClick(\''+ capgUsers[i].fullName+ '\')" style="border: 0; cursor:pointer;" /></td>'+
											 '</tr>');
								}
								} else if (data == 0) {
									$('#tbd').append('<tr><td colspan="5" style="text-align:center;font-size:20px;color:red">....System exception.Please contact administrator....</td></tr>');
								}
							},
						    error : function() {
							    window.location.href = "error.jsp";
						    }
				    });
		        });

			});			
		}]
	})
})

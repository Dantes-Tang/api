/**
 * SEARCH USER INFORMATION
 */
/*function searchClick() {
	if (event.keyCode==13){*/
capgUsers = [];  
$('input').keyup(function(){
		var fullName = document.getElementById("name").value;
		$.ajax({
			url : "./api/flexibility/getCapgUserRole?fullName=" + fullName,
			type : "GET",
			async : true,
			success : function(data) {
				$('#tbd').empty();
				$('#tbd').append('<tr style="color:#FFF;background-color:#A8B8C2;font-size: 20px;text-transform:uppercase;padding:5px;">'
						       + '<th class="tdh" scope="col" width="25%" id="employeeId">KIN_ID</th>'
							   + '<th class="tdh" scope="col" width="25%" id="fullName">FullName</th>'
							   + '<th class="tdh" scope="col" width="30%" id="roleName">Permission</th>'
							   + '<th class="tdh" scope="col" width="20%" colspan="2">Operation</th>'
							   + '</tr>');
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
						
						/*data.forEach(function(element) {
							$('#tbd').append('<tr><td>'+ element.employeeId+ '</td>'+
										     '<td>'+ element.fullName+ '</td>'+
										     '<td style="white-space:nowrap;overflow:hidden;text-overflow:ellipsis;cursor:pointer;" title="\''+ element.roleName+ '\'">'+ element.roleName + '</td>'+
										     '<td><img src="images/34.gif" onclick="updateClick(\''+ element+ '\')" style="border: 0; cursor:pointer;" /></td>'+
										     '<td><img src="images/35.gif" onclick="deleteClick(\''+ element.fullName+ '\')" style="border: 0; cursor:pointer;" /></td>'+
									         '</tr>');
						});*/
					} else if (data == 0) {
						$('#tbd').append('<tr><td colspan="5" style="text-align:center;font-size:20px;color:red">....No data for this user.Please make sure....</td></tr>');
					}
			},
			error : function() {
				window.location.href = "error.jsp";
			}
		});
  });
/*	}	
}*/

/**
 * UPDATEVIEW USER INFORMATION
 */
function updateClick(index) {
	console.log(capgUsers[index]);
	var capgUser = capgUsers[index];
	$.ajax({
		url: './views/permissionSet.html',
		type: 'GET',
		async : true,
		success: function(data) {
			$('#slide').append(data);
			$('#sFullname').val(capgUser.fullName);
			$('#roleNameVal').val(capgUser.roleName);
		}
	})
}

$(document).ready(function() {
	$('#hidden').click(function() {
		$('#slide').empty();
	});
});

/**
 * DELETE USER INFORMATION
 */
function deleteClick(fullName) {
	confirm_ = confirm('This action will delete current user information! Are you sure?');
	if (confirm_) {
		$.ajax({
			url : "./api/user/delete?fullName=" + fullName,
			type : "GET",
			success : function() {
				window.location.reload();
			},
			error : function() {
				window.location.href = "error.jsp";
			}
		});
	}
}
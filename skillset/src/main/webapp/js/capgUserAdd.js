/**
 * Dynamic loading
 */
$(document).ready(
	function() {
		$.ajax({
			url : "./api/AppRole/selectAppRole",
			type : "GET",
			dataType : "json",
			async : true,
			success : function(data) {
				data.forEach(function(element) {
					$('#chkItm').append(
						"<ul style='list-style:none'><li style='font-size:18px;'><input type='checkbox' value='"
							+ element.roleName + "'/>"
							+ element.roleName + "</li></ul>");
				});
			}
	    });
});

/**
 * Find FullName with email
 */
function getName() {
	var email = document.getElementById("ht_pwd").value;
	$.ajax({
		url : "./api/AppUser/findFullName?email=" + email,
		type : "GET",
		async : true,
		success : function(data) {
			if (data != 0) {
				$('#name').empty();
				$('#name').append('<img src="images/capgUser.png"/><span id="fullName" style="font-size:42px;color:#87CEFA;vertical-align:middle;">'
								  + data + '</span>');
				} else {
					$('#name').empty();
					$('#name').append('<input type="text" class="alertInputText" id="ht_pwd" placeholder="INCORRECT CAPGE EMAIL"/><input type="button" class="alertName" value="OK" onclick="getName()"/>');
				}
			},
		error : function() {
			window.location.href = "error.jsp";
		}
	});
}

/*
 * SUBMIT
 */
function subRole() {
	var fullname = $('#fullName').text();
	var roleName = new Array();
	var i = 0;
	$('input:checked').each(function(index, data) {
		roleName[i] = $(data).attr('value');
		i++;
	});
	console.log(roleName);
	var obj = {
		userId : null,
		employeeId : null,
		fullName : fullname,
		roleId : null,
		roleName : roleName,
		roleNo : null,
		role : null
	};
	var data = JSON.stringify(obj);

	$.ajax({
		url : "./api/flexibility/addCapgUserRoles",
		type : "POST",
		data : data,
		contentType : "application/json",
		async : true,
		success : function() {
			window.location.reload();
		},
		error : function() {
			window.location.href = "error.jsp";
		}
	});
}
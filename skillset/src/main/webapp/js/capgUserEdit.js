/*
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
						$('#chkItm').append("<li style='font-size:18px;'><input type='checkbox' id='chkBox' value='"+ element.roleName + "'/>"+ element.roleName + "</li>");
					});

					var str = $('#roleNameVal').attr('value');
					var strAry = str.split(",");
					var strRes = new Array();
					strAry.forEach(function(e) {
						e = e.replace('[', '');
						e = e.replace(']', '');
						e = e.trim();
						strRes.push(e);
					});

					$(strRes).each(
						function(i, dom) {
							$(":checkbox[value='" + dom + "']").attr(
								"checked", 'checked');
					});
				}
			});
		});

/*
 * SUBMIT
 */
function ajaxRequest() {
	var roleName = new Array();
	var i = 0;
	$('#chkBox:checked').each(function(index, data) {
		roleName[i] = $(data).attr('value');
		i++;
		
	});
	console.log(roleName);
	var obj = {
		userId : null,
		employeeId : null,
		fullName : $("#sFullname").val(),
		roleId : null,
		roleName : roleName,
		roleNo : null,
		role : null
	};
	var data = JSON.stringify(obj);

	$.ajax({
		url : "./api/flexibility/updateCapgUserRoles",
		type : "POST",
		dataType : "json",
		data : data,
		contentType : "application/json",
		async : true,
		success : function(data) {
			window.location.reload();
		},
		error : function() {
			window.location.href = "error.jsp";
		}
	});
}
app
		.controller(
				'skillset2Controller',
				function() {
					jQuery(function($) {
						$(document).ready(function() {
							ajaxRequest();

							saveEven();
							$(".edit").click(function() {
								edit();
							});

						});
						var ajaxRequest = function() {
							$
									
									.ajax({
										url : "/DRMS/api/skillmatrix/getSkillMatrix",
										type : "get",
										dataType : "json",
										data : {
											username : "healiu"
										},
										async : true,
										success : function(data) {
											
											if (data != null&& data !="") {
												data
														.forEach(function(
																element) {
															$('.tbd')
																	.append(
																			'<tr>'
																					+ '<td align = "center"  ><input readOnly = "true"  name ="skill"  type="text"  value = '
																					+ element.skill
																					+ '></td>'
																					+ '<td align = "center" ><input readOnly = "true"  name ="experience"  type="text" value = '
																					+ element.experience
																					+ '></td>'
																					+ '<td align = "center" ><input readOnly = "true"   name ="level"  type="text" value = '
																					+ element.level
																					+ '></td>'
																					+ '<td align = "center"  class="tdEdit"><section><div class="checkboxThree"><input id= checkboxThreeInput'+element.id+'  class=\"check\" type= "checkbox" id = '
																					+ element.id
																					+ ' ><label for=checkboxThreeInput'+element.id+'  ></label></div></section></td> </tr>');

														});
											} else {
												
												$('.tbd')
														.append(
																'<tr><td colspan="4" style="text-align:center;font-size:20px;color:red">....System exception.Please contact administrator....</td></tr>');
														$(".edit").css('display','none'); 
											}
										},
										error : function() {
											window.location.href = "error.jsp";
										}
									});

						}

						var edit = function() {

							if ($(".edit").attr("src") == "images/edit.jpg") {
								$(".check:checked").each(

										function() {
											$(this).parent().parent().parent().parent().find(
													":text").attr("readOnly",
													false);
											$(this).parent().parent().parent().parent().find(
											":text").css("border","inset"
											);
										});
							} else {
								saveEven();
							}

							var str = $(".edit").attr("src") == "images/edit.jpg" ? "images/save.jpg"
									: "images/edit.jpg";
							$(".edit").attr("src", str);

						}

						var saveEven = function() {

							
							$(".check:checked").each(

									function() {
										$(this).parent().parent().parent().parent().find(
												":text").attr("readOnly",
												true);
										$(this).parent().parent().parent().parent().find(
										":text").css("border","none"
										);
									});
							
							
							// $(".save").click(function(){
							var flag = false;
							var inputStatus = $("input:text");

							/*
							 * inputStatus.each(function() {
							 * 
							 * if ($(this).attr("readOnly") == false) { flag =
							 * true; } }); if (flag == false) { alert("you are
							 * not change the form, so you can't save"); }else {
							 */

							$(":checkbox")
									.each(
											function() {
												if ($(this).prop('checked') == true) {
													$
															.ajax({
																url : "/DRMS/api/skillmatrix/update",
																type : "POST",
																dataType : "json",
																data : {
																	id : $(this)
																			.attr(
																					"id"),
																	skill : $(
																			this)
																			.parent()
																			.parent()
																			.parent().parent().find(
																					"input[name='skill']")
																			.val(),
																	experience : $(
																			this)
																			.parent()
																			.parent()
																			.parent().parent().find(
																					"input[name='experience']")
																			.val(),
																	level : $(
																			this)
																			.parent()
																			.parent()
																			.parent().parent().find(
																					"input[name='level']")
																			.val()
																},
																async : true,
																success : function() {
																	alert("ok!");
																},
																error : function() {

																}
															});
												}
											});

							//}
							//});	
						}

					});
				});
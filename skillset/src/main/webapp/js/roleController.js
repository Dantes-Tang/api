app.controller('RoleManagementController',['$scope', '$rootScope', 'userService',  'roleManagementService',
                                           function($scope,$rootScope,userService,roleManagementService){
	
	$scope.order="description";
	$scope.roles=[];
	
	roleManagementService.getRoles({}).then(function(rolesData){
		if(rolesData){
			$scope.roles.push(rolesData);
			console.log($scope.roles[0]);
			
		}	
	});

	$scope.deleteRole=function($index){

		roleManagementService.getRoles({}).then(function(rolesData){
			if(rolesData&&rolesData.length){
				$scope.roles=[];
				console.log($scope.roles);
				$scope.roles.push(rolesData);	
				console.log($scope.roles[0]);
				
				
				var roleId=$scope.roles[0][$index].id;
				console.log(roleId);
				$scope.roles[0].splice($index,1);
				
				
				roleManagementService.deleteRoles(roleId).then(function(){
					alert("delete Success")});
				
			}	
			
		});
		
		
		
		}
	
	$scope.editRole=function($index){
		
	}
	
	
	
	$scope.saveRole = function(role){
		//获取当前role key值
		
		
		//console.log($scope.roles.indexOf(role));
			//判断编辑和增加的role，与roles数组是否有重复。
		
			//从后台获取的role-key数组,判断当前role-key，是否在其中。
	
		roleManagementService.getRoles({}).then(function(rolesData){
			if(rolesData&&rolesData.length){
				//$scope.roles=[];
				console.log($scope.roles);
				$scope.roles.push(rolesData);	
				console.log($scope.roles[0]);
				var newId=$scope.roles[0][$scope.roles[0].indexOf(role)].id;
				console.log(newId);
		
				if(newId!==""){
					if($scope.roles[0][$scope.roles[0].indexOf(role)].roleName=="" || $scope.roles[0][$scope.roles[0].indexOf(role)].description=="" || $scope.roles[0][$scope.roles[0].indexOf(role)].roleName==null||$scope.roles[0][$scope.roles[0].indexOf(role)].description==null){
							alert("empty ");
							$scope.roles[0][$scope.roles.indexOf(role)].$edit=true;
						
						}else{
							alert("edit save");
							//发送edit-save请求
							var editedRoles={
								id:$scope.roles[0][$scope.roles[0].indexOf(role)].id,	
								roleName:$scope.roles[0][$scope.roles[0].indexOf(role)].roleName,
								description:$scope.roles[0][$scope.roles[0].indexOf(role)].description
							};
							console.log(editedRoles);
							roleManagementService.editRoles(editedRoles).then(function(data){
								if(data&&data.length){
									alert('edited-save successed');
									
								}
							})
							
						}				
					}
				else{
						
						
						if($scope.roles[0][$scope.roles[0].indexOf(role)].roleName=="" || $scope.roles[0][$scope.roles[0].indexOf(role)].description=="" || $scope.roles[0][$scope.roles[0].indexOf(role)].roleName==null||$scope.roles[0][$scope.roles[0].indexOf(role)].description==null){
							alert("empty ")
							$scope.roles[0][$scope.roles[0].indexOf(role)].$edit=true;
							//$scope.roles.splice($scope.roles.indexOf(role),1);		
							
						}else {
							var savedRoles={
								roleName:$scope.roles[0][$scope.roles[0].indexOf(role)].roleName,
								description:$scope.roles[0][$scope.roles[0].indexOf(role)].description
							};
							
							//console.log(savedRoles[0].name);
							//console.log(keyArray);	
							//roleManagementService.addRoles
							//获取add数据和id
							
							roleManagementService.addRoles(savedRoles).then(function(data){
								if(data&&data.length){
									alert('Save succeed');
//									roleManagementService.getRoles({}).then(function(rolesData){
//										if(rolesData){
//											$scope.roles.push(rolesData);	
//										}	
//										
//									});
									
									
								}
							})
						}						
					}		
				
			}	
			
		});
		
//		var idArray=[];
//		
//		for(var i = 0,len=$scope.roles[0].length;i<len;i++){
//			idArray.push($scope.roles[0][i].id);
//			console.log("id"+idArray); 
//					
//		}
		
	}

	$scope.addRole=function(role){
		//if($scope.roles[$scope.roles.indexOf(role)].name!=="" || $scope.roles[$scope.roles.indexOf(role)].desc!=="")
		var obj = {roleName:"",description:"",key:new Date().getTime(),id:""};
		obj.$edit= true;
		$scope.roles[0].push(obj);
		
//		if(obj.name==""&&obj.value==""&&obj.desc==""){
//			alert("this is empty");
//		}else{
//			
//			$scope.roles.push(obj);
//		}
//		
		
	}
		
}])
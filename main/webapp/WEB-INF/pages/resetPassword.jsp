<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<header>
<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				
					<span class="name"><h3>Reset Password</h3></span>
				
			</div>
		</div>
	</div>
</header>
<br />

<div class="container">
	<form id="resetForm">
					<div class="row">
							<div class="form-top-left">	
							<div class="col-lg-12 form-group">						   
							 <div class="form-group">
							 <label for="users" class="col-sm-4 col-sm-offset-2 control-label"> User </label>
							 <div class="col-sm-4">
								<select id="users" class="form-control">
								<option selected="selected" disabled="disabled" value="">Select User</option>
								<c:forEach var="i" items="${userList}">
								<option>${i.name}</option>
								</c:forEach>
								</select>
								</div>
   						    </div> 
   						    </div>
   						</div>
   					</div>
   					
   					<div class="row">
							<div class="form-top-left">	
							<div class="col-lg-12 form-group">						   
							 <div class="form-group">
							 <label for="password" class="col-sm-4 col-sm-offset-2 control-label"> Old Password </label>
							 <div class="col-sm-4">
								<input id="oldPassword" type ="password" class="form-control">
								</div>
   						    </div> 
   						    </div>
   						</div>
   					</div>
   					
   					<div class="row">
							<div class="form-top-left">	
							<div class="col-lg-12 form-group">						   
							 <div class="form-group">
							 <label for="password" class="col-sm-4 col-sm-offset-2 control-label"> New Password </label>
							 <div class="col-sm-4">
								<input id="newPassword" type ="password" class="form-control">
								</div>
   						    </div> 
   						    </div>
   						</div>
   					</div>
   					
   					<div class="row">
   					<div class="form-group">
   					 <div class = "col-lg-12 col-sm-offset-4">
   					 <button id="save" type="reset" class="btn btn-default" align="center">Save</button> 
					 <button id="cancel" type="button" class="btn btn-default" align="center" onClick="history.go(0)">Cancel</button> 
					 </div>
					 </div>
					 </div>
					 </form>
   	</div>	
   	
   	<div id="wait" style="display: none" class="ajax-loader">
		<img src="resources/vendor/img/ajax-loader.gif" width="75" height="75" 
		class="ajax-loader">
	</div>
		<iframe id="downloadFrame" style="display: none"></iframe>				
   		

<script type="text/javascript">

$(document)
.ready(
		function() {
			$("#wait").hide();
			$(document).ajaxStart(function() {
				$("#wait").show();
			});
			$(document).ajaxComplete(function() {
				$("#wait").hide();
			});
			
			
		$("#save").click(function(){
			
			var username = document.getElementById("users");
			var oldPassword = document.getElementById("oldPassword");
			var newPassword = document.getElementById("newPassword");
			
			if (newPassword.value.length == 0) {
	        	 sweetAlert ('Tracker',
	        			 'The New password field cannot be empty!',
	        			 'warning');
	            return false;
	         }
	         if( /^[a-zA-Z]+$/.test(newPassword) ) {
	        	 sweetAlert('Tracker',
	        			 'The password must contain alphabets,numbers and special character',
	        			 'warning');                 
	             return false;
		 }
	         if (newPassword.value.length < 5) {
	        	 sweetAlert ('Tracker',
	        			 'The password must be at least 5 characters long!',
	        			 'warning');
	             return false;
	         }
	         if(newPassword.value == oldPassword.value){
	        	 sweetAlert('Tracker',
	        			 	'The new password is same as the old password!',
	        			 	'warning');
	        	 return false;
	         }
			
			
		$.ajax({
			url: "resetPassword",
			type: "POST",
			data: {
				name : $("#users").val(),
				oldPassword : $("#oldPassword").val(),
				newPassword : $("#newPassword").val(),
			},
			dataType : 'json', 
		    success: function(data) {

				 if(data){
					 $("#resetForm")[0].reset();
				    		sweetAlert(
									'Tracker',
									'Password changed successfully!',
									'success');
				    	 }
				 else
				    	{
				    		sweetAlert(
									'Tracker',
									'The Password change is unsuccessful! Check the Old password enetered',
									'error');
				    	}
		                } 
			
			
		});
		});
		});

</script>	
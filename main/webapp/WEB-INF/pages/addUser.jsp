<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!-- Header -->
<header>
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="intro-text">
					<span class="name">Creating New User</span>
				</div>
			</div>
		</div>
	</div>
</header>
<br />
 

 <div class="container">
						
				<form class="form-horizontal">
							<div class="form-top-left">
							<div class="form-group">
								<label for="username" class="col-sm-4 control-label"> Username(ZID) </label>
								<div class="col-sm-5">
      						    <input class="form-control" id="username"  type="text" >
   						        </div>
   						    </div> 
							
							<div class="form-group">
								<label for="username" class="col-sm-4 control-label"> Name </label>
								<div class="col-sm-5">
      						    <input class="form-control" id="name"  type="text" >
   						        </div>
   						    </div> 
   						    		
							<div class="form-group">							
								<label for="password" class="col-sm-4 control-label"> Password </label>
								<div class="col-sm-5">
							    <input id= "password" type="password" class="form-control">
							    </div>
							</div>
							  	
							<div class="form-group">				
							    <label for="confirmPassword" class="col-sm-4 control-label"> Confirm Password </label>
								<div class="col-sm-5">
								<input id= "confirmPassword" type="password" class="form-control">
								</div>
						    </div>
						
							<div class="form-group">
								<label for="privileges" class="col-sm-4 control-label"> Privileges </label>
								<div class="col-sm-5">
								<select id="role" name="role" class="form-control">
								
								<!-- <option>SELECT</option> -->
								<option disabled="disabled" selected="selected">Select a privilege</option> 
								<option value="ROLE_ADMIN">ROLE_ADMIN</option>
								<option value="ROLE_USER">ROLE_USER</option>
   	 							</select>
    							</div>
							</div>
							 							 											
						     <div class="col-lg-12 col-sm-6 col-sm-offset-4"> 
							 <button id="addUser" type="reset" class="btn btn-default" align="center">Add User</button> 
						     <button id="cancel" type="button" class="btn btn-default" align="center" onClick="history.go(0)">Cancel</button> 
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
	
	$("#addUser").click(function(){
		
		 var username = document.getElementById ("username");
		 var name = document.getElementById("name");
		 var password = document.getElementById ("password");
         var confirmPassword = document.getElementById ("confirmPassword");
        
          if(username.value.length == 0 && password.value.length == 0){
        	  sweetAlert ('Tracker',
        			  'The username and password fields cannot be empty!',
        			  'warning');
	         return false;
         } 		
	     if( /^[a-zA-Z0-9]+$/.test(username) ) {
	    	 sweetAlert('Tracker',
	    			 'The username must contain only alphabets and numbers!',
	    			 'warning');              /*      /^[a-zA-Z]+$/ */
	                return false;
	   	 }
         if (username.value.length == 0) {
        	 sweetAlert ('Tracker',
        			 'The username field cannot be empty!',
        			 'warning');
            return false;
         }
         if (username.value.length < 5) {
        	 sweetAlert ('Tracker',
        			 'The username must be at least 5 characters long!',
        			 'warning');
            return false;
         }  
         if (password.value.length == 0) {
        	 sweetAlert ('Tracker',
        			 'The password field cannot be empty!',
        			 'warning');
            return false;
         }
         if( /^[a-zA-Z]+$/.test(password) ) {
        	 sweetAlert('Tracker',
        			 'The password must contain alphabets,numbers and special character',
        			 'warning');                  /*    /[^a-zA-Z0-9]/ */
             return false;
	 }
         if (password.value.length < 5) {
        	 sweetAlert ('Tracker',
        			 'The password must be at least 5 characters long!',
        			 'warning');
             return false;
         }
         if (confirmPassword.value != password.value) {
        	 sweetAlert ('Tracker',
        			 'The two passwords are different!',
        			 'warning');
             return false;
         } 
		$.ajax({
			url : "addUser",
			type : 'POST',
			data: { username : $("#username").val(),
					name     : $("#name").val(),
					password : $("#password").val(),
					role 	 : $("#role").val()
				  }, 
		    dataType : 'json', 
		    success: function(data) {

				 if(data){
				    		sweetAlert(
									'Tracker',
									'User added successfully!',
									'success');
				    	 }
				 else
				    	{
				    		sweetAlert(
									'Tracker',
									'User already exists!',
									'error');
				    	}
		                } 
		           
		});
		});
		});
	</script>




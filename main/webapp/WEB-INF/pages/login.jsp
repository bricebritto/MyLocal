<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> 
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<header>
<div class="container">
		<div class="row">
			<div class="col-lg-12">
				
					<span class="name" align="center"><h3>Tracker Application Login</h3></span>
				
			</div>
		</div>
	</div>
</header>
<br />


<!-- <div class="top-content">

   <div class="container"> -->
   <div class="panel-container" style= "height : 500px;">
			<div class="row">
				<div class="col-sm-6 col-sm-offset-3 form-box">
					<div class="form-top">
						<div class="form-top-left">
							 
							 <div class="form-bottom">  
							 
							 <form action="<c:url value='j_spring_security_check' />" 
							 method='POST' accept-charset="UTF-8" class="form-signin" role="form">	
							 <div class="row">
							 <div class="col-lg-12 form-group">
								<label class="col-sm-4 control-label" for="form-username"> Username </label>
								<div class="col-sm-6">
      						    <input class="form-username form-control" type="text" name="j_username" id="form-username">
   						        </div>
   						    </div>
   						    </div> 
							
							<div class="row">		
							<div class="col-lg-12 form-group">							
								<label class="col-sm-4 control-label" for="form-password"> Password </label>
								<div class="col-sm-6">
							    <input class="form-password form-control" type="password" name="j_password" id="form-password">
							    </div>
							</div>
							</div>
					
					<div class="row">
					<div class="col-lg-12 form-group">
					<div class="col-lg-12 col-sm-6 col-sm-offset-4">
      				<button id="sign-in" type="submit" class="btn btn-default" align="center">Sign in</button>
      				</div>
      				</div>
      				</div>
      				
      				<div class="row">
      				<div class="col-lg-12 form-group">
      				<div class="col-lg-12 col-sm-6">
      				<a href = "resetPassword">Reset Password?</a>
      				</div>
      				</div>
      				</div>	
 	</form>
 	</div>
 	</div>
 	</div>	
	</div>
	</div>
	</div>
	<!-- </div>
	</div>	 -->
	
	
	<div class="row" style="margin-top: 10px;">
			<div class="col-md-offset-4 col-md-4">
				<c:if test="${logout}">
					<div class="alert alert-success" role="alert">Successfully
						Logged out.</div>
				</c:if>
				<c:if test="${error}">
					<div class="alert alert-danger" role="alert">
						Incorrect username or password.<br> Please retry using
						correct username and password.
					</div>
				</c:if>
			</div>
			<!--/row-->
		</div>
	</div>

	
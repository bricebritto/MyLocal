<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<header>
<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
					<span class="name"><h3>BCO File Upload</h3></span>
			</div>
		</div>
	</div>
</header>
<br />

 <div class="row">
   				<div class="col-lg-12 form-group">
   				<div class="form-group">
   				<form method="POST" action="${pageContext.request.contextPath}/BCOupload" enctype="multipart/form-data">
   				<label for="uploadBco" class="col-sm-2 col-sm-offset-4"> Choose the BCO File to upload </label>
								
      						  	<div class="col-sm-2">
   								<!-- <button id="browse" type="button" class="btn btn-default" align="center">Browse..</button> -->
   								<input type="file" name="file" value="Browse..." /><br/>
								</div>
								<div class="col-sm-2">
   								<!-- <button id="upload" type="button" class="btn btn-default" align="center">Upload</button> -->
   								<input type="submit" value="Submit" />
								</div> 
								<%-- <form method="POST" action="${pageContext.request.contextPath}/BCOupload" enctype="multipart/form-data"> 
    							 <input type="file" name="file" >Browse...</input<br/>
    							<input type="submit" value="Submit" />--%>
								</form>
   						        </div>
   						        </div>	
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
  			
  		
  			

  
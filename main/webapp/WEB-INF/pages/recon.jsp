<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
 <script>  
 $(function() {  
	    $( "#reviewDate" ).datepicker({   
	       dateFormat:"yy-mm-dd"            
	    });  
	 });   

	$(function() {  
	    $( "#sharingDate" ).datepicker({  
	       dateFormat:"yy-mm-dd"            
	    });  
	 });   
</script>     
<header>

<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
					<span class="name"><h3>Recon Ticket Details</h3></span>
			</div>
		</div>
	</div>
</header>
<br />

<div class="container">
<form id="reconForm">
<div class="row">
<div class="form-top-left">
							 <div class="col-lg-12 form-group"> 
							 <div class="form-group">
								<label for="sugarTicket" class="col-sm-3 control-label" > Sugar Ticket <label for="*" class="required-field"></label> </label>
								<div class="col-sm-3">
      						    <input class="form-control" id="sugarTicket"  type="text" required-field />
   						     </div>
   						     <label for="accountNumber" class="col-sm-3 control-label"> Account Number <label for="*" class="required-field" ></label> </label>
								<div class="col-sm-3">
      						    <input class="form-control" id="accountNumber" onchange="findTariff(this.value)" type="text" required-field/ >
   						        </div>
   						    </div> 
   						   </div> 
   						</div>
   					</div>   				
   						        
   		<div class="row">
   				<div class="col-lg-12 form-group">
   				<div class="form-group">
   				<label for="reconType" class="col-sm-3 control-label"> Recon Type <label for="*" class="required-field" ></label></label>
							<div class="col-sm-3">
      						<!-- <input class="form-control" id="reconType"  type="text" > -->
      						<select id="reconType" class="form-control">
							<option selected="selected" disabled="disabled" value="">Select Recon Type</option>
							<option value="Estimation">Estimation</option>
							<option value="MissingReadRecon">Missing Read Recon</option>
							<option value="CTPT">CTPT</option>
							<option value="SpikeCorrection">Spike Correction</option>
							<option value="TariffCorrection">Tariff Correction</option>
							<option value="Demand">Demand</option>
							<%-- <c:forEach var="i" items="${reconTypesList}">
							<option>${i.reconType}</option>
							</c:forEach> --%>
							</select>
							<%-- 
							 <input class="form-control" id="reconType"  type="text" form:select path="ReconTypesList">
    						<option value="Select" label="Select a recon type"></option>
   						    <form:options items="${reconTypesList}" />
							</form:select>  --%>
   						        </div>
   				<label for="tariffCategory" class="col-sm-3 control-label"> Tariff Category </label>
								<div class="col-sm-3">
      						   <input class="form-control" id="tariffCategory"  type="text" >
   						        </div>		        
   						        </div>
   						        </div>
   						        </div>
   						       
   	  <div class="row">
   				<div class="col-lg-12 form-group">
   				<div class="form-group">
   				<label for="reconPreparedBy" class="col-sm-3 control-label"> Recon Prepared By <label for="*" class="required-field" ></label></label>
								<div class="col-sm-3">
      						  <!--  <input class="form-control" id="reconPreparedBy"  type="text" > -->
      						  	<select id="reconPreparedBy" class="form-control">
								<option selected="selected" disabled="disabled" value="">Select User</option>
								<c:forEach var="i" items="${userList}">
								<option>${i.name}</option>
								</c:forEach>
								</select> 
   						        </div>
   				<label for="reconReviewedBy" class="col-sm-3 control-label"> Recon Reviewed By <label for="*" class="required-field"></label></label>
								<div class="col-sm-3">
      						 <!--   <input class="form-control" id="reconReviewedBy"  type="text" > -->
      						    <select id="reconReviewedBy" class="form-control">
								<option selected="selected" disabled="disabled" value="">Select User</option>
								<c:forEach var="i" items="${userList}">
								<option>${i.name}</option>
								</c:forEach>
								</select>
   						        </div>
   						        </div>
   						        </div>
   						        </div>
   						        		
   	<div class="row">
   				<div class="col-lg-12 form-group">
   				<div class="form-group">
   				<label for="criticality" class="col-sm-3 control-label"> Criticality </label>
								<div class="col-sm-3">
      						    <input type="radio" name="criticality" value="Simple" checked>Simple
      						    <input type="radio" name="criticality" value="Medium">Medium
      						    <input type="radio" name="criticality" value="Complex">Complex
   						        </div>
   				<label for="timeTaken" class="col-sm-3 control-label"> Time Taken for Recon Creation (in hours) <label for="*" class="required-field"></label></label>
								 <div class="col-xs-3">
      						 <select id="timeTaken" class="form-control" >
							<option selected="selected" disabled="disabled" value="">Select Time Taken</option>
							<option value="0.5">0.5</option>
							<option value="1">1</option>
							<option value="1.5">1.5</option>
							<option value="2">2</option>
							<option value="2.5">2.5</option>
							<option value="3">3</option>
							<option value="3.5">3.5</option>
							<option value="4">4</option>
							<option value="4.5">4.5</option>
							<option value="5">5</option>
							<option value="5.5">5.5</option>
							<option value="6">> 6</option> 
							</select>
   						        </div>		        
   						        </div>
   						        </div>
   						        </div>
   					        
   		<div class="row">
   				<div class="col-lg-12 form-group">
   				<div class="form-group">
   				<label for="reviewDate" class="col-sm-3 control-label"> Review Date (YYYY-MM-DD) <label for="*" class="required-field"></label></label>
								<div class="col-sm-3">
      						    <input class="form-control" id="reviewDate"  type="text" >
   						        </div>
   				<label for="sharingDate" class="col-sm-3 control-label"> Sharing Date With TUMS (YYYY-MM-DD) <label for="*" class="required-field"></label></label>
								<div class="col-sm-3">
      						    <input class="form-control" id="sharingDate"  type="text" >
   						        </div>
   						        </div>
   						        </div>
   						        </div>
   						           						        
   	<div class="row">
   				<div class="col-lg-12 form-group">
   				<div class="form-group">
   				<label for="reviewComments" class="col-sm-3 control-label"> Review Comments </label>
								<div class="col-sm-9">
      						    <textarea class="form-control" id="reviewComments"></textarea>
   						        </div>
   						        </div>
   						        </div>
   						        </div>
   						        
   	<div class="row">
   				<div class="col-lg-12 form-group">
   				<div class="form-group">
   				<label for="commentsType" class="col-sm-3 control-label"> Comments Type </label>
								<div id="commentsType" class="col-sm-9">
      						    <input name="commentsType" type="radio" value="Major">Major
      						    <input name="commentsType" type="radio" value="Minor">Minor
   						        </div>
   						        </div>
   						        </div>
   						        </div>
   						        
   
   						        
   		<!-- <div class="row">
   				<div class="col-lg-12 form-group">
   				<div class="form-group">
   				<label for="tariffCategory" class="col-sm-3 control-label"> Tariff Category </label>
								<div class="col-sm-9">
      						    <input class="form-control" id="tariffCategory"  type="text" >
   						        </div>
   						        </div>
   						        </div>
   						        </div>    -->					 	        					        					        
   			
   			 <div class="row">			        
      		 <div class="col-lg-12 col-sm-offset-3"> 
						 <button id="submit" type="button" class="btn btn-default" align="center">Submit</button> 
						 <button id="clear" type="reset" class="btn btn-default" align="center">Reset</button> 
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


function findTariff(accNum){
		
	if(accNum.length > 12){
	$.ajax({
		url : "tariff",
		type : 'POST',
		data: { 
			accountNumber : $("#accountNumber").val()
			}, 
	    dataType : 'json', 
	    success: function(data){
	    			    	
	    	if(data){  
	    		   document.getElementById("tariffCategory").value = data;		 
			    	 }
			 else
			    	{
				 console.log("Account Number not received");
			    	}
	                }
	           
	});
}
}



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
	
		
	$("#submit").click(function(){
		
		 var sugarTicket = document.getElementById ("sugarTicket").value;
		 console.log("sugarTicket :" +sugarTicket);
		 var accountNumber = document.getElementById ("accountNumber").value;
		 console.log("accountNumber :" +accountNumber);
		 var reconType = document.getElementById ("reconType").value;
		 console.log("reconType :" +reconType);
		 var reconPreparedBy = document.getElementById ("reconPreparedBy").value;
		 console.log("reconPreparedBy :" +reconPreparedBy);
		 var reconReviewedBy = document.getElementById ("reconReviewedBy").value;	 
		 console.log("reconReviewedBy :" +reconReviewedBy);
		  var timeTaken = document.getElementById ("timeTaken").value;
		  /*if(timeTaken > 24){
			 sweetAlert('Tracker',
					 	'Invalid Input for Time Taken',
					 	'warning');
		 } */
		 console.log("timeTaken :" +timeTaken);
		 var reviewDate = document.getElementById ("reviewDate").value;
		 console.log("reviewDate :" +reviewDate);
		 var sharingDate =document.getElementById ("sharingDate").value;
		 console.log("sharingDate :" +sharingDate);
		 
		 if(sugarTicket && accountNumber && reconType && reconPreparedBy 
				 && reconReviewedBy && timeTaken && reviewDate && sharingDate){	
			
			 if(timeTaken < 24){
          
		$.ajax({
			url : "recon",
			type : 'POST',
			data: { sugarTicket : $("#sugarTicket").val(),
					accountNumber : $("#accountNumber").val(),
					reconType :  $("#reconType").val(),
					reconPreparedBy : $("#reconPreparedBy").val(),
					reconReviewedBy : $("#reconReviewedBy").val(),
					criticality : $("input[name='criticality']:checked").val(),
					timeTaken : $("#timeTaken").val(),
					reviewComments : $("#reviewComments").val(),
				/* 	commentsType : $("input[name='commentsType']:checked").val(), */
				 	commentsType : $("#commentsType").val(),
					reviewDate : $("#reviewDate").val(),
					sharingDate : $("#sharingDate").val(),
					tariffCategory : $("#tariffCategory").val()
				  }, 
		    dataType : 'json', 
		    success: function(data){
		    			    	
		    	if(data){  
		    		$("#reconForm")[0].reset();
		    		 sweetAlert(
							'Tracker',
							'Inserted data successfully',
							'success');
				    		 
				    	 }
				 else
				    	{
					 sweetAlert(
								'Tracker',
								'Error in submitting data',
								'error');
				    	}
		                }
		           
		});
		}else{
			 sweetAlert('Tracker',
					 	'Invalid Input for Time Taken',
					 	'warning');
		}
		 } else{
			  sweetAlert(
						'Tracker',
						'Please fill all required fields',
						'error');
			  }
		  
		});
		});
	</script>			
   						   
   						   
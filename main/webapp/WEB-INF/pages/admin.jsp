<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

      <!-- Javascript -->  
      <script>  
       $(function() {   
          $("#datepickerFrom").datepicker({   
             dateFormat:"yy-mm-dd"            
          });  
        });    
      
       $(function() { 
          $("#datepickerTo").datepicker({   
             dateFormat:"yy-mm-dd"            
          });  
        });   
      </script>  
<header>

<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				
					<span class="name"><h3>Master Log</h3></span>
				
			</div>
		</div>
	</div>
</header>
<br />

<div class="container">
					<div class="row">
							<div class="form-top-left">	
							<div class="col-lg-12 form-group">						   
							 <div class="form-group">
							 <label for="users" class="col-sm-4 col-sm-offset-2 control-label"> Users </label>
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
   					<div class="col-lg-12 form-group">
  						<div class="form-group">
   						<label for="fromDate" class="col-sm-4 col-sm-offset-2 control-label"> From Date </label>
								<div class="col-sm-4">
								<input id="datepickerFrom" class="form-control" type="text" >
   						        </div>
   						        </div>
   						        </div>
   						        </div>
   						        
   						        
   						<div class="row">
   						<div class="col-lg-12 form-group">
  						<div class="form-group">
   						<label for="toDate" class="col-sm-4 col-sm-offset-2 control-label"> To Date </label>
								<div class="col-sm-4">
      						    <input id="datepickerTo" class="form-control" type="text" >
   						        </div>
   						        </div>
   						        </div>
   						        </div>
   						
   						<div class="row">
  						<div class="form-group">        
   						<div class="col-lg-12 col-sm-6 col-sm-offset-4"> 
							 <button id="submit" type="button" class="btn btn-default" align="center">Submit</button> 
						    <button id="reset" type="button" class="btn btn-default" align="center" onClick="history.go(0)">Reset</button>  
						    <!--  <button id="clear" type="reset" class="btn btn-default" align="center" >Reset</button>  -->
						     </div>
						     </div>
						     </div>        
   		   
 </div>
   						        				
   		<div id="wait" style="display: none" class="ajax-loader">
		<img src="resources/vendor/img/ajax-loader.gif" width="75" height="75" 
		class="ajax-loader">
		</div>
   		
		<iframe id="downloadFrame" style="display: none"></iframe>		
   		<div id="reconPreparedTable" class="col-lg-12 achievements-wrapper" style="display: none">
   		<table id="reconDataTable" class="td">
   		<thead>
   		<tr>
   		<th>Sugar Ticket</th>
   		<th>Account Number</th>
   		<th>Recon Type</th>
   		<th>Recon Prepared By</th>
   		<th>Recon Reviewed By</th>
   		<th>Criticality</th>
   		<th>Time Taken</th>
   		<th>Review Comments</th>
   		<th>Comments Type</th>
   		<th>Date of Review</th>
   		<th>Date of Sharing</th>
   		<th>Tariff</th>
   		</tr>
   		</thead> 
   		</table>
   		</div>		
   				
<script type="text/javascript">

 /* function filterColumns(data,type,row){ */
	/*  function(data,type,row){
		if(type == 'display')
		
	 console.log("Filtering on criticality");
	/*console.log("---------");
	console.log(type);
	console.log("----------");
	 /* console.log(row); */
	/*  console.log(data);
	 console.log("---------"); */ 
	/*  return data; */
	/*  return data; 
}  */

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
		
		var users = document.getElementById("users").value;
		var datepickerFrom = document.getElementById("datepickerFrom").value;
		var datepickerTo = document.getElementById("datepickerTo").value;
		
if(users && datepickerFrom && datepickerTo){
			
	 var i=1;
  $("#reconPreparedTable").empty();
	 $("#reconPreparedTable").append("<table id=\"reconDataTable\" class=\"display\"></table>"); 
	 $('#reconDataTable').DataTable(
	 		{
	 			ajax :{
	 			url : "admin",
	 			type: "POST",
	 			data: function(d){
	 				$("#reconPreparedTable").show();
	 				/* console.log("Result" + JSON.stringify(d)); */
	 				d.columns[3].search.value = $("#users").val();
	 				d.columns[9].search.value = $("#datepickerFrom").val();
	 				d.columns[10].search.value = $("#datepickerTo").val();
	 				d.draw=i++;
	 				return JSON.stringify(d);
	 				
	 			},
	 			dataType: "json",
	            processing : true,
	            contentType: 'application/json;charset=UTF-8'
	 			},
	 			/* language: {
			        searchPlaceholder: "Reviewed By / Criticality"
			    }, */
	 			serverSide: true,
	 			order : [[9,'asc']],  
	 			/*order: [[ 0, "asc" ]], */
				/* searching : false, */
	 			  /*  columnDefs: [ {
									render : function(data,type,row){
										console.log(data);
										console.log(type);
										console.log(row);
										return data; 
									}		      
											      
								 }] , */
				/* columnDefs : [
					{
					targets : 0,
					data : "Sugar Ticket"
					},
					{
					targets : 1,
					data : "Account Number"
					},
					{
					targets : 2,
					data : "Recon Type"
					},
					{
					targets : 5,
					data : "Criticality",
					render : function(data,type,row){
						if(data != null && data !=""){
							return data;
						}
					}
					},
					/* {
					targets : 7,
					data: "ReviewComments",
					render : "filterColumns"
					}, 
				],
					 */											    
	 			 columns : [
 				{	
 					targets : 0,
 					title : "Sugar Ticket",
					data : "sugarTicket"
				},
				{
					targets : 1,
					title : "Account Number",
					data : "accountNumber"
				},
				{
					targets : 2,
					title : "Recon Type",
					data : "reconType"
				},
				{
					targets : 3,
					title : "Recon Prepared By",
					data : "reconPreparedBy"
				},
				{
					targets : 4,
					title : "Recon Reviewed By",
					data : "reconReviewedBy"
				},
				{
					targets : 5,
					title : "Criticality",
					data : "criticality"

/* render : filterColumns */
				},
				{
					targets : 6,
					title : "Time Taken",
					data : "timeTaken"
				},
				{
					targets : 7,
					title : "Review Comments",
					data : "reviewComments"
				},
				{
					targets : 8,
					title : "Comments Type",
					data : "commentsType"
				},
				{
					targets : 9,
					title : "Date of Review",
					data : "reviewDate"
				},
				{
					targets : 10,
					title : "Date of Sharing",
					data : "sharingDate"
				},
				{
					targets : 11,
					title : "Tariff",
					data : "tariffCategory"
				}]	
	 	  	
}); 
}else{
	sweetAlert('Tracker',
			'Please select user and date',
			'warning');
}
});	
});	

  </script>
 
  
  
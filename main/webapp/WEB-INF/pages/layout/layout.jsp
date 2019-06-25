<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" charset="utf8" src="/js/jquery.dataTables.js"></script> -->


<link rel="stylesheet" href="resources/vendor/sweetalert2/dist/sweetalert2.css">	
<script src="resources/vendor/sweetalert2/dist/sweetalert2.min.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> 
<link href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel="stylesheet">  
      <script src="http://code.jquery.com/jquery-1.10.2.js"></script>  
      <script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script> 
      
 <!-- <link href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css" />   -->   

 <!-- <link href="https://nightly.datatables.net/css/jquery.dataTables.css"
	rel="stylesheet" type="text/css" />       
     
      <script src="https://nightly.datatables.net/js/jquery.dataTables.js"></script> 
     
      <script type="text/javascript" 	th:src="@{../js/datatables.min.js}"></script>  -->
      
    
  <!--   //cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js -->  
  
   <link href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css" /> 
	
	 <script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.js "></script>     
	 
	  <script type="text/javascript" 	th:src="@{../js/datatables.min.js}"></script>   
	 
	 <script	src="resources/js/moment.min.js"></script>
	<script	src="resources/js/moment-with-locales.min.js"></script>

      <!-- Theme CSS -->
<link href="resources/css/freelancer.css" rel="stylesheet">

<!-- <link href="resources/css/login-style.css" rel="stylesheet"> -->
<link href="resources/css/style.css" rel="stylesheet">

</head>
<body id="page-top" class="index">

	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="body" />
	<tiles:insertAttribute name="footer" />
</body>
</html>	

 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="true"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page isELIgnored="false"%>
<%--<!-- Navigation -->
	<div class="container">
	
	</div> --%>
	<!-- /.container-fluid -->

<!-- <h2>Header</h2>
<hr/> -->

<!-- Navigation -->
<nav id="mainNav"
	class="navbar navbar-default navbar-fixed-top navbar-custom">
<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<!-- <div class="navbar-header page-scroll">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> Menu <i
					class="fa fa-bars"></i>
			</button>
			
		</div>
 -->
		<!-- Collect the nav links, forms, and other content for toggling -->
		<!-- <div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right"> -->
			<div class="nav navbar-nav navbar-right">
			<ul class="nav navbar-nav navbar-right">
						<!-- <li><a id="add-user-link" href="addUser">
						<i class="fa fa-sign-out fa-fw"></i> Add User</a></li>										
						<li><a id="drop-down-link" href="login"><i
								class="fa fa-sign-out fa-fw"></i> Logout</a></li> -->
						<li><a href="BCOupload"> Upload BCO</a></li>		
						<li><a href="addUser"> Add User</a></li>
						<li><a href="login"> Logout</a></li>	
			</ul>
		</div>
		<!-- /.navbar-collapse -->
</div>	
</nav>	
		
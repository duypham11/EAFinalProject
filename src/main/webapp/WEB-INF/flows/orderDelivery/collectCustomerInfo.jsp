<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Restaurant</title>

<!-- Bootstrap Core CSS -->
<link href="<spring:url value='/bootstrap/vendor/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet">
<!-- MetisMenu CSS -->
<link href="<spring:url value='/bootstrap/vendor/metisMenu/metisMenu.min.css'/>" rel="stylesheet">
<!-- Custom CSS -->
<link href="<spring:url value='/bootstrap/dist/css/sb-admin-2.css'/>" rel="stylesheet">
<!-- Custom Fonts -->
<link href="<spring:url value='/bootstrap/front/vendor/font-awesome/css/font-awesome.min.css'/>" rel="stylesheet" type="text/css">
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>

<!-- jQuery -->
<script src="<spring:url value='/bootstrap/vendor/jquery/jquery.min.js'/>"></script>
<!-- Bootstrap Core JavaScript -->
<script src="<spring:url value='/bootstrap/vendor/bootstrap/js/bootstrap.min.js'/>"></script>
<!-- Metis Menu Plugin JavaScript -->
<script src="<spring:url value='/bootstrap/vendor/metisMenu/metisMenu.min.js'/>"></script>
<!-- Custom Theme JavaScript -->
<script src="<spring:url value='/bootstrap/dist/js/sb-admin-2.js'/>"></script>
<script type="text/javascript" src="<spring:url value="/resources/js/ajax.js"/>"></script>
</head>
<body>
	<div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="<spring:url value='/restaurant'/>">Restaurant</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">

                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a id="profile"><i class="fa fa-user fa-fw"></i> User Profile</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                        		<spring:url value="/dologout" var="logout_url" />
							<a href="${logout_url}"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->
            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                            </div>
                            <!-- /input-group -->
                        </li>
                        <li>
                            <a href="<spring:url value='/restaurantOrderDelivery' />"><i class="fa fa-plus-circle fa-fw"></i> New Request</a>
                        </li>
                        <li>
                            <a href="<spring:url value='/restaurant' />"><i class="fa fa-list-ul fa-fw"></i> Request List </a>
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Order Web Flow</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            Order Delivery
                        </div>
                        <div class="panel-body">
                        		<div class="stepwizard">
                                  <div class="stepwizard-row setup-panel">
                                  	<div class="stepwizard-step col-xs-3">
                                          <a href="#s" type="button" class="btn btn-default btn-circle" disabled="disabled">0</a>
                                          <p><small>Start</small></p>
                                      </div>
                                      <div class="stepwizard-step col-xs-3">
                                          <a href="#" type="button" class="btn btn-primary btn-circle" disabled="disabled">1</a>
                                          <p><small>Customer Detail</small></p>
                                      </div>
                                      <div class="stepwizard-step col-xs-3">
                                          <a href="#" type="button" class="btn btn-default btn-circle" disabled="disabled">2</a>
                                          <p><small>Choose a Rider</small></p>
                                      </div>
                                      <div class="stepwizard-step col-xs-3">
                                          <a href="#" type="button" class="btn btn-default btn-circle" disabled="disabled">3</a>
                                          <p><small>Thank You</small></p>
                                      </div>
                                  </div>
                              </div>
                              <form:form modelAttribute="orderDelivery" class="form-horizontal">
								<fieldset>
									<legend>Customer Detail</legend>
							  		<p>
							  		     <form:errors path="*" cssStyle="color : red;" /> 
							        </p>
									<div class="form-group">
										<label class="control-label col-lg-2 col-lg-2" for="customerName" >Customer Name</label>
										<div class="col-lg-10">
											<form:input id="customerName" path="customerName" type="text" class="form:input-large" />
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-lg-2" for="address">Address</label>
										<div class="col-lg-10">
											<form:input id="address" path="address" type="text" class="form:input-large" />
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-lg-2" for="email">Email</label>
										<div class="col-lg-10">
											<form:input id="email" path="email" type="text" class="form:input-large" />
										</div>
									</div>
									<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
									<div class="form-group">
										<div class="col-lg-offset-2 col-lg-10">
											<button id="btnCancel" class="btn btn-default" name="_eventId_cancel">Cancel</button>
											<input type="submit" id="btnAdd" class="btn btn-primary" value="Next" name="_eventId_customerInfoCollected" />
										</div>
									</div>
								</fieldset>
							</form:form>
                        </div>    
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->]

    </div>
    <!-- /#wrapper -->
    
    <!-- Modal -->
      <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
          <div class="modal-dialog">
              <div class="modal-content">
                  <div class="modal-header">
                      <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                      <h4 class="modal-title" id="myModalLabel">Profile Detail</h4>
                  </div>
                  <div class="modal-body" id="modalBody">
                      <form role="form">
                          <fieldset disabled>
                          	<div class="form-group">
                                  <label>ID :</label>
                                  <input class="form-control" type="text" id="id">
                              </div>
                         	<div class="form-group">
                                  <label>Restaurant Name :</label>
                                  <input class="form-control" type="text" id="restaurantName">
                              </div>
                              <div class="form-group">
                                  <label>Owner First Name :</label>
                                  <input class="form-control" type="text" id="firstName">
                              </div>
                              <div class="form-group">
                                  <label>Owner Last Name :</label>
                                  <input class="form-control" type="text" id="lastName">
                              </div>
                              <div class="form-group">
                                  <label>Address :</label>
                                  <input class="form-control" type="text" id="address">
                              </div>
                              <div class="form-group">
                                  <label>Email :</label>
                                  <input class="form-control" type="text" id="email">
                              </div>
                              <div class="form-group">
                                  <label>Note :</label>
                                  <textarea class="form-control" id="note"></textarea>
                              </div>
                          </fieldset>
                      </form>
                  </div>
                  <div class="modal-footer">
                      <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                      <button type="button" class="btn btn-primary" disabled>Save</button>
                  </div>
              </div>
              <!-- /.modal-content -->
          </div>
          <!-- /.modal-dialog -->
      </div>
     <!-- /.modal -->

</body>
</html>

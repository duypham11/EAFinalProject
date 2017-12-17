<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title><tiles:insertAttribute name="title" /></title>

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
                <a class="navbar-brand" href="<spring:url value='/rider'/>">Rider</a>
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
                    <h1 class="page-header"><tiles:insertAttribute name="title" /></h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
         		<tiles:insertAttribute name="body"/>
            </div>
        </div>
        <!-- /#page-wrapper -->
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

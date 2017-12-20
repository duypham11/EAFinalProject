<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="<spring:url value='/bootstrap/vendor/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet">
	<link href="<spring:url value='/bootstrap/vendor/metisMenu/metisMenu.min.css'/>" rel="stylesheet">
	<link href="<spring:url value='/bootstrap/dist/css/sb-admin-2.css'/>" rel="stylesheet">
	<link href="<spring:url value='/bootstrap/front/vendor/font-awesome/css/font-awesome.min.css'/>" rel="stylesheet" type="text/css">
	<script src="<spring:url value='/bootstrap/vendor/jquery/jquery.min.js'/>"></script>
	<script src="<spring:url value='/bootstrap/vendor/bootstrap/js/bootstrap.min.js'/>"></script>
	<script src="<spring:url value='/bootstrap/vendor/metisMenu/metisMenu.min.js'/>"></script>
	<script src="<spring:url value='/bootstrap/dist/js/sb-admin-2.js'/>"></script>
	<script type="text/javascript" src="<spring:url value="/resources/js/riderAjax.js"/>"></script>
	<title>Rider home</title>
</head>
<body>

 <var="rider_Id" items="${RiderID}">
 </var>
  <var="riderName" items="${RiderName}">
 </var>
  <var="rider_rate" items="${RiderRate}">
 </var>
  <var="number_Rate" items="${NumberRate}">
 </var>
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
                <a class="navbar-brand" href="<spring:url value='/rider'/>">Flash Delivery Rider</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">

                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
<!--                         <li><a id="btnRiderProfile"><i class="fa fa-user fa-fw"></i> User Profile</a> -->
<!--                         </li> -->
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
        </nav>
	<div id="page-wrapper">
		<div class="row">
	    		<div class="col-lg-12">
	    			<h1 class="page-header">${RiderName}               ${NumberRate} - ${RiderRate} <p class="fa fa-cab"> </p></h1>
	    		</div>
	    </div>
	    <div class="row">
        		<div class="col-lg-12">
            		<div class="panel panel-primary">
                		<div class="panel-heading">
                     	On Going Delivery orders
                 	</div>
                 	<div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Tracking Number</th>
                                            <th>Store</th>
                                            <th>Customer</th>
                                            <th>Address</th>
                                            <th>ZipCode</th>
                                            <th>Phone</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	   <c:forEach var="parcel" items="${notDoneParcelList}">
                                    	   		<tr>
	                                            <td>${parcel.id}</td>
	                                            <td>${parcel.trackNumber}</td>
	                                            <td>${parcel.store.name}</td>
	                                            <td>${parcel.customerName}</td>
	                                            <td>${parcel.address.address}</td>
	                                            <td>${parcel.address.zipCode}</td>
	                                            <td>${parcel.address.phone}</td>
	                                            <td>
	                                            		<button type="button" class="btn btn-outline btn-primary" onclick="completedParcel('${parcel.id}')">Complete</button>
	                                            </td>
                                        		</tr>		
                                    	   </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
            		</div>
        		</div>
        </div>
        
        <div class="row">
        		<div class="col-lg-12">
            		<div class="panel panel-green">
                		<div class="panel-heading">
                     	Completed deliveries
                 	</div>
                 	<div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Store</th>
                                            <th>Customer</th>
                                            <th>Address</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	   <c:forEach var="cParcel" items="${completedParcelList}">
                                    	   		<tr>
	                                            <td>${cParcel.id}</td>
	                                            <td>${cParcel.store.name}</td>
	                                            <td>${cParcel.customerName}</td>
	                                            <td>${cParcel.address.address}</td>
                                        		</tr>		
                                    	   </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
            		</div>
        		</div>
        </div>
        
	    <div class="row">
        		<div class="col-lg-12">
            		<div class="panel panel-primary">
                		<div class="panel-heading">
                     	All Available Parcels
                 	</div>
                 	<div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Store</th>
                                            <th>Customer</th>
                                            <th>Address</th>
                                            <th>ZipCode</th>
                                            <th>Phone</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    		
                                    	   <c:forEach var="allParcels" items="${allParcelAvailable}">
                                    	   		<tr>
	                                            <td>${allParcels.id}</td>
	                                            <td>${allParcels.store.name}</td>
	                                            <td>${allParcels.customerName}</td>
	                                            <td>${allParcels.address.address}</td>
	                                            <td>${allParcels.address.zipCode}</td>
	                                            <td>${allParcels.address.phone}</td>
	                                            <td>
	                                            		<button type="button" class="btn btn-outline btn-primary" 
	                                            		onclick="selectParcel('${RiderID}', '${allParcels.id}');">Select</button>
	                                            </td>
                                        		</tr>		
                                    	   </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
            		</div>
        		</div>
        </div>        
	</div>
	</div>
	<!-- Modal -->
      <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
          <div class="modal-dialog">
              <div class="modal-content">
                  <div class="modal-header">
                      <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                      <h4 class="modal-title" id="myModalLabel">Delivery completion</h4>
                  </div>
                  <div class="modal-body" id="modalBody">
                  	<p>Confirm the delivery order #<span id="parcelDeliverNumber"></span> is complete.</p>
                  	<form action="">
                  		<div class="form-group">
                         	<label>Customer's order track number</label>
                             <input class="form-control" type="text" id="parcelId">
                         </div>
                  	</form>
                  	<div class='alert alert-success alert-dismissable' id="emptyError" hidden> Enter a valid delivery order ID </div>
                  </div>
                  <div class="modal-footer">
                      <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                      <button type="button" class="btn btn-primary" onclick="confirmParcel()">Finish</button>
                  </div>
              </div>
              <!-- /.modal-content -->
          </div>
          <!-- /.modal-dialog -->
      </div>
     <!-- /.modal -->
     
      <div class="modal fade" id="myProfileModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
                                  <label>ID:</label>
                                  <input class="form-control" type="text" id="id">
                              </div>
                              <div class="form-group">
                                  <label>First Name:</label>
                                  <input class="form-control" type="text" id="firstName">
                              </div>
                              <div class="form-group">
                                  <label>Last Name:</label>
                                  <input class="form-control" type="text" id="lastName">
                              </div>
                              <div class="form-group">
                                  <label>Address:</label>
                                  <input class="form-control" type="text" id="address">
                              </div>
                              <div class="form-group">
                                  <label>Email:</label>
                                  <input class="form-control" type="text" id="email">
                              </div>
                              <div class="form-group">
                                  <label>Rate:</label>
                                  <textarea class="form-control" id="rate"></textarea>
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
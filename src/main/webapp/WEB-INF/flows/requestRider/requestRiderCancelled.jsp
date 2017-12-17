<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<html>
<tiles:insertDefinition name="storeLayout">
	<tiles:putAttribute name="title">Request List</tiles:putAttribute>
	<tiles:putAttribute name="body">
		<div class="col-lg-12">
			<div class="panel panel-primary">
				<div class="panel-heading">Order Delivery</div>
				<div class="panel-body">
					<form class="form-horizontal">
						<fieldset>
							<legend>Order Cancelled</legend>
							<p>Your order has been cancelled</p>
						</fieldset>
					</form>
					<div class="col-lg-12 text-center">
						<a href="<spring:url value='/storeRequestRider' />"
							class="btn btn-primary"> Start Another Order </a> 
						<a href="<spring:url value='/store' />" class="btn btn-primary">Go to Order List </a>
					</div>
				</div>
			</div>
			<!-- /.panel -->
		</div>
		<!-- /.col-lg-12 -->
	</tiles:putAttribute>
</tiles:insertDefinition>
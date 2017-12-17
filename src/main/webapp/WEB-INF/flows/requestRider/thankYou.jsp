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
					<div class="stepwizard">
						<div class="stepwizard-row setup-panel">
							<div class="stepwizard-step col-xs-3">
								<a href="#s" type="button" class="btn btn-default btn-circle"
									disabled="disabled">0</a>
								<p>
									<small>Start</small>
								</p>
							</div>
							<div class="stepwizard-step col-xs-3">
								<a href="#" type="button" class="btn btn-default btn-circle"
									disabled="disabled">1</a>
								<p>
									<small>Customer Detail</small>
								</p>
							</div>
							<div class="stepwizard-step col-xs-3">
								<a href="#" type="button" class="btn btn-default btn-circle"
									disabled="disabled">2</a>
								<p>
									<small>Choose a Rider</small>
								</p>
							</div>
							<div class="stepwizard-step col-xs-3">
								<a href="#" type="button" class="btn btn-primary btn-circle"
									disabled="disabled">3</a>
								<p>
									<small>Thank You</small>
								</p>
							</div>
						</div>
					</div>
					<form class="form-horizontal">
						<fieldset>
							<legend>Thank You</legend>
							<h4 class="alert alert-success">
								Thanks for the order - ${orderDelivery.id}. The tracking number
								is ${orderDelivery.trackNumber} and our rider detail is as
								following :
								</h3>
								<div class="form-group">
									<label class="control-label col-lg-2" for="firstName">First
										Name</label>
									<div class="col-lg-10">
										<input value="${rider.firstName}" type="text"
											class="form:input-large" disabled />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-lg-2" for="lastName">Last
										Name</label>
									<div class="col-lg-10">
										<input value="${rider.lastName}" type="text"
											class="form:input-large" disabled />
									</div>
								</div>
						</fieldset>
					</form>
					<div class="col-lg-12 text-center">
						<a href="<spring:url value='/restaurantOrderDelivery' />"
							class="btn btn-primary"> Start Another Order </a> <a
							href="<spring:url value='/restaurant' />" class="btn btn-primary">
							Go to Order List </a>
					</div>
				</div>
			</div>
			<!-- /.panel -->
		</div>
		<!-- /.col-lg-12 -->
	</tiles:putAttribute>
</tiles:insertDefinition>
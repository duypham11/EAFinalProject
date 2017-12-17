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
								<a href="#" type="button" class="btn btn-primary btn-circle"
									disabled="disabled">2</a>
								<p>
									<small>Choose a Rider</small>
								</p>
							</div>
							<div class="stepwizard-step col-xs-3">
								<a href="#" type="button" class="btn btn-default btn-circle"
									disabled="disabled">3</a>
								<p>
									<small>Thank You</small>
								</p>
							</div>
						</div>
					</div>
					<form:form modelAttribute="orderDelivery" class="form-horizontal">
						<fieldset>
							<legend>Rider List</legend>
							<div class="table-responsive">
								<table class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th>ID</th>
											<th>First Name</th>
											<th>Last Name</th>
											<!-- <th></th> -->
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>${rider.id}</td>
											<td>${rider.firstName}</td>
											<td>${rider.lastName}</td>
											<%-- <td class="text-center">
		                                            		<button class="btn btn-primary" onclick="sendRequest('${rider.id}')">Send Request</button>
		                                            </td> --%>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="form-group">
								<label class="control-label col-lg-2" for="customerName">Customer
									Name</label>
								<div class="col-lg-10">
									<form:input path="customerName" type="text"
										class="form:input-large" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-lg-2" for="address">Customer
									Address</label>
								<div class="col-lg-10">
									<form:input path="address" type="text" class="form:input-large" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-lg-2" for="email">Customer
									Email</label>
								<div class="col-lg-10">
									<form:input path="email" type="text" class="form:input-large" />
								</div>
							</div>
							<input type="hidden" name="_flowExecutionKey"
								value="${flowExecutionKey}" />
							<div class="form-group">
								<div class="col-lg-offset-2 col-lg-10">
									<button id="btnCancel" class="btn btn-default"
										name="_eventId_cancel">Cancel</button>
									<button id="back" class="btn btn-success"
										name="_eventId_backToCollectCustomerInfo">Back</button>
									<button type="submit" id="btnAdd" class="btn btn-danger"
										name="_eventId_riderDetailCollected">Confirm</button>
								</div>
							</div>
						</fieldset>
					</form:form>
				</div>
			</div>
			<!-- /.panel -->
		</div>
		<!-- /.col-lg-12 -->
	</tiles:putAttribute>
</tiles:insertDefinition>
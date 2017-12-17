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
								<a href="#" type="button" class="btn btn-primary btn-circle"
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
								<a href="#" type="button" class="btn btn-default btn-circle"
									disabled="disabled">3</a>
								<p>
									<small>Thank You</small>
								</p>
							</div>
						</div>
					</div>
					<form:form modelAttribute="parcel" class="form-horizontal">
						<fieldset>
							<legend>Customer Detail</legend>
							<p>
								<form:errors path="*" cssStyle="color : red;" />
							</p>
							<div class="form-group">
								<label class="control-label col-lg-2 col-lg-2"
									for="customerName">Customer Name</label>
								<div class="col-lg-10">
									<form:input id="customerName" path="customerName" type="text"
										class="form:input-large" />
								</div>
							</div>
							<%-- <div class="form-group">
								<label class="control-label col-lg-2" for="address">Address</label>
								<div class="col-lg-10">
									<form:input id="address" path="address" type="text" class="form:input-large" />
								</div>
							</div> --%>
							<div class="form-group">
								<label class="control-label col-lg-2" for="email">Email</label>
								<div class="col-lg-10">
									<form:input id="email" path="email" type="text"
										class="form:input-large" />
								</div>
							</div>
							<input type="hidden" name="_flowExecutionKey"
								value="${flowExecutionKey}" />
							<div class="form-group">
								<div class="col-lg-offset-2 col-lg-10">
									<button id="btnCancel" class="btn btn-default"
										name="_eventId_cancel">Cancel</button>
									<input type="submit" id="btnAdd" class="btn btn-primary"
										value="Next" name="_eventId_customerInfoCollected" />
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
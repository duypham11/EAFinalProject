<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<html>
<tiles:insertDefinition name="customerLayout">
<tiles:putAttribute name="title">Become a Flash Delivery Rider</tiles:putAttribute>
<tiles:putAttribute name="body"> 
	    <div class="row">
		    <div class="col-lg-12">
				<div class="panel panel-primary">
					<div class="panel-heading">
						Rider registration
					</div>
					<div class="panel-body">
						<form:form modelAttribute="newRider" action="processRider" method="post" enctype="multipart/form-data">
							<div class="form-group">
								<label>First name</label>
								<form:input path="firstName" class="form-control" />
								<div>
									<form:errors path="firstName" cssStyle="color : red;" />
								</div>
							</div>
							<div class="form-group">
								<label>Last name</label>
								<form:input path="lastName" class="form-control" />
								<div>
									<form:errors path="lastName" cssStyle="color : red;" />
								</div>
							</div>
							<div class="form-group">
								<label>Email</label>
								<form:input path="email" class="form-control" />
								<div>
									<form:errors path="email" cssStyle="color : red;" />
								</div>
							</div>
							
							<div class="form-group">
								<label>Address</label>
								<form:input path="address.address" class="form-control" />
								<div>
									<form:errors path="address.address" cssStyle="color : red;" />
								</div>
								<label>ZipCode</label>
								<form:input path="address.zipCode" class="form-control" />
								<div>
									<form:errors path="address.zipCode" cssStyle="color : red;" />
								</div>
								<label>State</label>
								<form:input path="address.state" class="form-control" />
								<div>
									<form:errors path="address.state" cssStyle="color : red;" />
								</div>
								<label>Phone</label>
								<form:input path="address.phone" class="form-control" />
								<div>
									<form:errors path="address.phone" cssStyle="color : red;" />
								</div>
							</div>
							<div class="form-group">
								<label>Password</label>
								<form:input path="userCredentials.password" class="form-control"
									type="password" />
								<div>
									<form:errors path="userCredentials.password" cssStyle="color : red;" />
								</div>
							</div>
							<div class="form-group">
								<label>Verify password</label>
								<form:input path="userCredentials.verifyPassword"
									class="form-control" type="password" />
								<div>
									<form:errors path="userCredentials.verifyPassword" cssStyle="color : red;" />
								</div>
							</div>
<%-- 							<form:input id="employeePhoto" path="photo" type="file"/><br> --%>
							<input class="btn btn-default" id="submit" type="submit" tabindex="5" value="Continue" />
						</form:form>
					</div>
				</div>
			</div>
</tiles:putAttribute>
</tiles:insertDefinition>

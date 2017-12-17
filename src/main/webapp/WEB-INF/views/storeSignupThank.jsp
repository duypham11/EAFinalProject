<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<html>
<tiles:insertDefinition name="customerLayout">
	<tiles:putAttribute name="title">Welcome to our team</tiles:putAttribute>
	<tiles:putAttribute name="body">
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-primary">
					<div class="panel-heading">Restaurant Detail</div>
					<div class="panel-body">
						<div class="alert alert-success alert-dismissable">
							<button type="button" class="close" data-dismiss="alert"
								aria-hidden="true">&times;</button>
							Your request has been processed. Please check your email. To
							login, Please click <a href="<spring:url value='/login' />"
								class="alert-link">here</a>.
						</div>
					</div>
					<!-- /.panel-body -->
				</div>
				<!-- /.panel -->
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
	</tiles:putAttribute>
</tiles:insertDefinition>
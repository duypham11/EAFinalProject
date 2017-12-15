<!-- implement tile -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<html>
<tiles:insertDefinition name="loginLayout">

 <tiles:putAttribute name="title">Taobao Login</tiles:putAttribute> 
	<tiles:putAttribute name="body"> 
		<div class="container">
			<div class="row">
				<div class="col-md-4 col-md-offset-4">
					<div class="login-panel panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title"><spring:message code="login.title"/></h3>
						</div>
						<div class="panel-body">
							<c:if test="${not empty error}">
								<div class="alert alert-danger">
									<spring:message code="AbstractUserDetailsAuthenticationProvider.badCredentials" />
								</div>
							</c:if>
							<form action="<spring:url value="/postLogin"></spring:url>" method="post">
								<fieldset>
									<div class="form-group">
										<input class="form-control" placeholder="<spring:message code="login.label.username"/>"
											name="username" type="text" autofocus />
									</div>
									<div class="form-group">
										<input class="form-control" placeholder="<spring:message code="login.label.password"/>"
											name="password" type="password" value="" />
									</div>
									<div class="checkbox">
										<label> <input name="keepMe" type="checkbox" value="Remember Me"/><spring:message code="login.label.rememberMe"/>
										</label>
									</div>
									<!-- Change this to a button or input when using this as a form -->
									<input class="btn btn-lg btn-success btn-block" type="submit" value="<spring:message code="login.label.login"/>" />
								</fieldset>
								<security:csrfInput />
							</form>
						</div>
						<div class="text-right panel-footer">
							<a class="btn btn-outline btn-primary btn-sm" href="?language=ms_MY">Malayu (MY)</a>
							<a class="btn btn-outline btn-primary btn-sm" href="?language=en_US">English (US)</a>
							<a class="btn btn-outline btn-primary btn-sm" href="?language=zh_CN">Chinese (CH)</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<html>
<tiles:insertDefinition name="customerLayout">
<tiles:putAttribute name="title">Rider signup</tiles:putAttribute>
<tiles:putAttribute name="body"> 

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
                <a class="navbar-brand" href="<spring:url value='/' />">Welcome to Taobao Tracking System</a>
            </div>
            <!-- /.navbar-header -->
            <!-- /.navbar-top-links -->
            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="Track No i.e 123 xxx xxx">
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                            </div>
                            <!-- /input-group -->
                        </li>
                        <li>
                            <a href="<spring:url value='/login' />"><i class="fa fa-sign-in fa-fw"></i> Login</a>
                        </li>
                        <li>
                            <a href="<spring:url value='/storeSignup' />"><i class="fa fa-users fa-fw"></i> Become our Partner</a>
                        </li>
                        <li>
                            <a href="<spring:url value='/rider/riderSignup' />"><i class="fa fa-car  fa-fw" ></i> Become our Rider</a>
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>
	</div>
	<div id="page-wrapper">
		<div class="row">
	    		<div class="col-lg-12">
	    			<h1 class="page-header">Become a Flash Delivery Rider</h1>
	    		</div>
	    </div>
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
	    </div>
	</div>
</tiles:putAttribute>
</tiles:insertDefinition>

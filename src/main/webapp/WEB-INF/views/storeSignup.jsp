<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<html>
<tiles:insertDefinition name="customerLayout">
	<tiles:putAttribute name="title">New Store Signup</tiles:putAttribute>
	<tiles:putAttribute name="body">
		<div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            Store Detail
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-12">
                                    <form:form modelAttribute="store" action="storeSignup" method="post">
                                    		<fieldset>
	                                        <div class="form-group col-lg-4">
	                                            <label>Store Name</label>
	                                            <form:input class="form-control" placeholder="i.e Panda Chinese Food" path="name" type="text"/>
	                                            <form:errors path="name" cssStyle="color : red;" />
	                                        </div>
	                                        <div class="form-group col-lg-4">
	                                            <label>Store Owner First Name</label>
	                                            <form:input class="form-control" placeholder="i.e A Ey" path="firstName"/>
	                                            <form:errors path="firstName" cssStyle="color : red;" />
	                                        </div>
	                                        <div class="form-group col-lg-4">
	                                            <label>Store Owner Last Name</label>
	                                            <form:input class="form-control" placeholder="i.e Sun" path="lastName"/>
	                                            <form:errors path="lastName" cssStyle="color : red;" />
	                                        </div>
	                                        <div class="form-group col-lg-4">
	                                            <label>Store Address</label>
	                                            <form:input class="form-control" placeholder="i.e 1000th 4th North Street, Fairfield, 52557, IA " path="address"/>
	                                            <form:errors path="address" cssStyle="color : red;" />
	                                        </div>
	                                        <div class="form-group col-lg-4">
	                                            <label>Email</label>
	                                            <form:input class="form-control" placeholder="i.e panda@gmail.com" path="email"/>
	                                            <form:errors path="email" cssStyle="color : red;" />
	                                        </div>
	                                        <div class="form-group col-lg-4">
												<label>Password</label>
												<form:input path="userCredentials.password" class="form-control" type="password" />
												<form:errors path="userCredentials.password" cssStyle="color : red;" />
											</div>
											<div class="form-group col-lg-4">
												<label>Verify password</label>
												<form:input path="userCredentials.verifyPassword" class="form-control" type="password" />
												<form:errors path="userCredentials.verifyPassword" cssStyle="color : red;" />
											</div>
											<div class="form-group col-lg-8">
	                                            <label>Note</label>
	                                            <form:textarea class="form-control" rows="3" path="note"/>
	                                            <form:errors path="note" cssStyle="color : red;" />
	                                        </div>
	                                        <div class="form-group col-lg-12">
	                                            <input type="reset" class="btn btn-default" value="Reset"/>
	                                            <input type="submit" class="btn btn-default" value="Submit"/>
	                                        </div>
	                                    </fieldset>
                                        <security:csrfInput/>
                                    </form:form>
                                </div>
                                <!-- /.col-lg-6 (nested) -->
                            </div>
                            <!-- /.row (nested) -->
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
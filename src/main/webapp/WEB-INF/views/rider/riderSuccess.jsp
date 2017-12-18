<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<html>
<tiles:insertDefinition name="riderLayout">
<tiles:putAttribute name="title">Flash Delivery Rider signup</tiles:putAttribute>
<tiles:putAttribute name="body"> 
	Success!
	
	<input type="button"  onclick="location.href='/FlashDelivery/login'" value="Submit" >
	<div class="panel panel-primary">
                        <div class="panel-heading">
                            Flash Delivery Rider Registration
                        </div>
                        <div class="panel-body">
                            <div class="alert alert-success alert-dismissable">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                Your request has been processed. Please check your email. To login, Please click <a href="<spring:url value='/login' />" class="alert-link">here</a>.
                            </div>
                        </div>
                        <!-- /.panel-body -->
                    </div>
</tiles:putAttribute>
</tiles:insertDefinition>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<html>
<tiles:insertDefinition name="customerLayout">
	<tiles:putAttribute name="title">Parcel Tracking</tiles:putAttribute>
	<tiles:putAttribute name="body">
	<c:choose>
	<c:when test="${empty trackedParcel}">
        Not Valid Tracking Number.
    </c:when>
    <c:otherwise>
		<div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            Parcel Detail
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-12">
                                    		<fieldset>
	                                        <div class="form-group col-lg-4">
	                                            <label>Tracking Number</label>
	                                            <label class="form-control">${trackedParcel.trackingNumber}</label>
	                                        </div>
	                                        <div class="form-group col-lg-4">
	                                            <label>Customer Name</label>
	                                            <label class="form-control">${trackedParcel.customerName}</label>
	                                        </div>
	                                        <div class="form-group col-lg-4">
	                                            <label>Delivery Address:</label>
	                                            <label class="form-control">${trackedParcel.delieveryAddress}</label>
	                                        </div>
	                                        <div class="form-group col-lg-4">
	                                            <label>Delivery Status:</label>
	                                            <label class="form-control">${trackedParcel.delieveryStatus}</label>
	                                        </div>
	                                    </fieldset>
                                        <security:csrfInput/>
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
             <div class="table-responsive">
             <table class="table table-striped table-bordered table-hover">
                <tbody>
               	<c:forEach var="history" items="${trackedParcel.historyLog}">
              	   		<tr>
              	   		<td>${history}</td>
              	   		</tr>                        
                  	</c:forEach>
               </tbody>
           </table>
             </div>
            </c:otherwise>
                </c:choose>
            <!-- /.row -->
	</tiles:putAttribute>
</tiles:insertDefinition>
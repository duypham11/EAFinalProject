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
		<div class="table-responsive">
			<table class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th>Track No</th>
						<th>Customer Name</th>
						<th>Address</th>
                         <th>ZipCode</th>
                         <th>Phone</th>
						<th>Status</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="parcel" items="${parcels}">
						<tr>
							<td>${parcel.trackNumber}</td>
							<td>${parcel.customerName}</td>
							<td>${parcel.address.address}</td>
							<td>${parcel.address.zipCode}</td>
	                         <td>${parcel.address.phone}</td>
							<td>${parcel.status.status}</td>
							<td class="text-center">
								<c:if test="${parcel.status.status == 'NEW'}">
									<button class="btn btn-primary btn-outline"
									onclick="cancelRiderRequest('${parcel.getId()}')">Cancel</button>
								</c:if>
								<c:if test="${parcel.status.status == 'DONE'}">
									<select class="form-control" id="btnRate" onchange="rateRider(this,'${parcel.getRider().getRider_Id()}')" value="${parcel.getRider().getRate()}">
										<option value="0">Rate</option>
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="5">5</option>
										<option value="6">6</option>
										<option value="7">7</option>
										<option value="8">8</option>
										<option value="9">9</option>
										<option value="10">10</option>
									</select>
								</c:if>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
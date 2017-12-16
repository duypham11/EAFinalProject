<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<html>
<tiles:insertDefinition name="storeLayout">
	<tiles:putAttribute name="title">Store Page</tiles:putAttribute>
	<tiles:putAttribute name="body">
		<div class="table-responsive">
			<table class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th>Track No</th>
						<th>Customer Name</th>
						<th>Address</th>
						<th>Status</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="order" items="${orders}">
						<tr>
							<td>${order.trackNumber}</td>
							<td>${order.customerName}</td>
							<td>${order.address}</td>
							<td>${order.status.status}</td>
							<td class="text-center">
								<button class="btn btn-primary"
									onclick="sendRequest('${order.id}')" disabled>Cancel
									Request</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
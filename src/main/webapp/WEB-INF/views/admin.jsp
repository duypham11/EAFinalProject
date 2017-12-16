<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<tiles:insertDefinition name="baseLayout">
 <tiles:putAttribute name="title">Admin Page</tiles:putAttribute> 
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
                        		<button class="btn btn-primary" onclick="sendRequest('${order.id}')" disabled>Cancel Request</button>
                        </td>
                  		</tr>
                  	</c:forEach>
               </tbody>
           </table>
       </div> 
	</tiles:putAttribute>
</tiles:insertDefinition>
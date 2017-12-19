<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<tiles:insertDefinition name="baseLayout">
 <tiles:putAttribute name="title">Riders</tiles:putAttribute> 
	<tiles:putAttribute name="body">  
	    <div class="table-responsive">
           <table class="table table-striped table-bordered table-hover">
               <thead>
                   <tr>
                   	<!-- <th>Track No</th> -->
                       <th>Rider Name</th>
                       <th>Username</th>
                       <th>Phone</th>
                       <th>Email</th>
                       <th>Address</th>
                       <th>State</th>
                       <th>Status</th>
                   </tr>
               </thead>
               <tbody>
               	<c:forEach var="riderDTO" items="${listOfriders}">
              	   		<tr>
              	   		<td>${riderDTO.riderName}</td>
                        <td>${riderDTO.userName}</td>
                        <td>${riderDTO.phone}</td>
                        <td>${riderDTO.email}</td>
                        <td>${riderDTO.address}</td>
                        <td>${riderDTO.state}</td>
                        <td>${riderDTO.status}</td>
                      <c:choose>
    					<c:when test="${riderDTO.status == 'true'}">
    					 <td>Approved</td>
    					</c:when>    
    					<c:otherwise>    
    					 <td class="text-center">
                        		<button class="btn btn-primary" onclick="location.href='/FlashDelivery/approverider/${riderDTO.userName}'">Approve Signup</button>
                        </td>
    					</c:otherwise>
					  </c:choose>
                  		</tr>
                  	</c:forEach>
               </tbody>
           </table>
       </div> 
	</tiles:putAttribute>
</tiles:insertDefinition>
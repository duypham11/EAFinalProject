<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<tiles:insertDefinition name="baseLayout">
 <tiles:putAttribute name="title">Stores</tiles:putAttribute> 
	<tiles:putAttribute name="body">  
	    <div class="table-responsive">
           <table class="table table-striped table-bordered table-hover">
               <thead>
                   <tr>
                   	<!-- <th>Track No</th> -->
                       <th>Store Name</th>
                       <th>Username</th>
                       <th>Email</th>
                       <th>Address</th>
                       <th>State</th>
                       <th>ZipCode</th>
                       <th>Status</th>
                   </tr>
               </thead>
               <tbody>
               	<c:forEach var="storeDTO" items="${listOfstores}">
              	   		<tr>
              	   		<td>${storeDTO.storeName}</td>
                        <td>${storeDTO.userName}</td>
                        <td>${storeDTO.email}</td>
                        <td>${storeDTO.address}</td>
                        <td>${storeDTO.state}</td>
                        <td>${storeDTO.zipcode}</td>
                      <c:choose>
    					<c:when test="${storeDTO.status == 'true'}">
    					 <td>Approved</td>
    					</c:when>    
    					<c:otherwise>    
    					 <td class="text-center">
                        		<button class="btn btn-primary" onclick="location.href='/FlashDelivery/approvestore/${storeDTO.userName}'">Approve Signup</button>
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
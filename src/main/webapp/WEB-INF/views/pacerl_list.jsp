<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Rider Home Page</title>
</head>
<body>
<h1>
	1st draft!  
</h1>
<table width = 100% border="1">
	<tr>
		<td>Track Number: </td>
		<td>Store: </td>
		<td>Customer: </td>
		<td>Email: </td>
		<td>Status: </td>

	</tr>
	<c:forEach items="${pacerl_list}" var="entry">
	<tr>
		<td>${entry.trackNumber} </td>
		<td>${entry.store.name} </td>
		<td>${entry.customerName} </td>
		<td>${entry.email} </td>
		<td>${entry.status} </td>
	</tr>
	</c:forEach>
	
</table>
</body>
</html>

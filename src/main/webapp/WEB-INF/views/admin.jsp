<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<tiles:insertDefinition name="baseLayout">
 <tiles:putAttribute name="title">Admin Page</tiles:putAttribute> 
	<tiles:putAttribute name="body">  
	 <h2>Welcome Admin</h2>
	</tiles:putAttribute>
</tiles:insertDefinition>
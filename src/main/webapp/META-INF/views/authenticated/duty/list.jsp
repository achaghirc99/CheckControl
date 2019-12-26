  <%--
	-list.jsp
	
	Copyrigth (c) 2019 Desing and Testing
	
 --%>

<%@ page language="java" %>

<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags"%>

 <acme:list>
 	<acme:list-column code="employer.job.duty.list.label.dutyTitle" path="dutyTitle" width="10%"/>
 	<acme:list-column code="employer.job.duty.list.label.description" path="description" width="50%"/>
 	
</acme:list>
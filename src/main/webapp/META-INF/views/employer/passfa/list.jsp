  
<%--
	-list.jsp
	
	Copyrigth (c) 2019 Desing and Testing
	
 --%>

<%@ page language="java" %>

<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags"%>

 <acme:list>
 	<acme:list-column code="employer.job.list.label.text" path="text" width="50%"/>
</acme:list>
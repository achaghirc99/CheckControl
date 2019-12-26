<%--
	-list.jsp
	
	Copyrigth (c) 2019 Desing and Testing
	
 --%>

<%@ page language="java" %>

<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list readonly="true">
	<acme:list-column code="anonymous.chaghir-bulletin.list.label.moment" path="moment" width="20%"/>
	<acme:list-column code="anonymous.chaghir-bulletin.list.label.name" path="name" width="20%"/>
	<acme:list-column code="anonymous.chaghir-bulletin.list.label.languages" path="languages" width="60%"/>
	<acme:list-column code="anonymous.chaghir-bulletin.list.label.phone" path="phone" width="20%"/>	
</acme:list>
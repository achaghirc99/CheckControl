  
<%--
	-list.jsp
	
	Copyrigth (c) 2019 Desing and Testing
	
 --%>

<%@ page language="java" %>

<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="consumer.offer.list.label.ticker" path="ticker" width="20%"/>
	<acme:list-column code="consumer.offer.list.label.title" path="title" width="20%"/>
	<acme:list-column code="consumer.offer.list.label.moment" path="moment" width="10%"/>
</acme:list>
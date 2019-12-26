<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list >
	<acme:list-column code="authenticated.register.list.label.name" path="name" width="20%"/>
	<acme:list-column code="authenticated.register.list.label.sector" path="sector" width="30%"/>
	<acme:list-column code="authenticated.register.list.label.investmentStatement" path="investmentStatement" width="25%"/>
	<acme:list-column code="authenticated.register.list.label.assessment" path="assessment" width="25%"/>
	
</acme:list>

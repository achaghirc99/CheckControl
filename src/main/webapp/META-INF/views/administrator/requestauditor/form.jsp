<?xml version="1.0" encoding="utf-8" ?>
<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
    <acme:form-checkbox code="administrator.requestauditor.form.label.accepted" path="accepted" />
 	<acme:form-textbox code="administrator.requestauditor.form.label.reference" path="reference" readonly="true"/>
	<jstl:if  test="${command == 'show'}">
	<acme:form-textbox code="administrator.requestauditor.form.label.status" path="status" readonly="true"/>
	<acme:form-submit code="administrator.requestauditor.form.button.update" action="/administrator/requestauditor/update"/>
	</jstl:if>
		<acme:form-submit test="${command == 'update'}" 
		code="administrator.requestauditor.form.button.update" 
		action="/administrator/requestauditor/update"/>

    <acme:form-return code="administrator.requestauditor.form.button.return" />
</acme:form>

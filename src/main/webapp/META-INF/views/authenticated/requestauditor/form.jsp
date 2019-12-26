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
    <acme:message code="authenticated.requestauditor.form.label.request" />
 	<acme:form-textbox code="authenticated.requestauditor.form.label.reference" path="reference" />
 	<acme:form-hidden path="accept"/>
	<acme:form-submit test="${command == 'create'}" code="authenticated.requestauditor.form.button.create" action="/authenticated/requestauditor/create"/>
    <acme:form-return code="authenticated.requestauditor.form.button.return" />
</acme:form>

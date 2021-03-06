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
	<acme:form-textbox code="auditor.audit-record.form.label.title" path="title" placeholder="Titulo" />
	<acme:form-textbox code="auditor.audit-record.form.label.body" path="body" placeholder="----" />

	<jstl:if test="${command != 'create'}">
		<acme:form-textbox code="auditor.audit-record.form.label.status" path="status" />
		<acme:form-textbox code="auditor.audit-record.form.label.moment" path="moment" />
	</jstl:if>

	<acme:form-submit test="${command == 'create'}" code="auditor.audit-record.form.button.create" action="/auditor/auditrecord/create" />


	<acme:form-return code="auditor.audit-record.form.button.return" />
</acme:form>

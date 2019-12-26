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

<acme:form readonly="false">
    <acme:form-textbox code="auditor.job.form.label.reference" path="reference" />
    <acme:form-textbox code="auditor.job.form.label.title" path="title" />
    <acme:form-moment code="auditor.job.form.label.deadline" path="deadline"/>
    <acme:form-money code="auditor.job.form.label.salary" path="salary"/>
    <acme:form-url code="auditor.job.form.label.moreInfo" path="moreInfo"/>
    <acme:form-textarea code="auditor.job.form.label.description" path="description"/>

	<acme:form-submit method="get"
    code="auditor.job.form.button.auditRecord"
    action="/auditor/auditrecord/list?id=${id}"/>
    
    <acme:form-submit test="${!isAudited}" method="get"
    code="auditor.auditRecord.form.button.create"
    action="/auditor/auditrecord/create?id=${jobId}"/>
    
    
    <acme:form-return code="auditor.job.form.button.return" />
</acme:form>

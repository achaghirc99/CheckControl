<%--
- form.jsp
-
- Copyright (c) 2019 Desing And Testing
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">

	<acme:form-textbox code="authenticated.job.form.label.reference" path="reference" placeholder="EEEE-JJJJ"/>
	<acme:form-textbox code="authenticated.job.form.label.title" path="title" placeholder="Titulo"/>
	<acme:form-moment code="authenticated.job.form.label.deadline" path="deadline" placeholder="YYYY/MM/DD HH:MM"/>
	<acme:form-money code="authenticated.job.form.label.salary" path="salary" placeholder="Moneda(EUR, USD..) Valor"/>
	<acme:form-url code="authenticated.job.form.label.moreInfo" path="moreInfo" placeholder="http://www.example.com"/>
	<acme:form-textbox code="authenticated.job.form.label.descriptor.description" path="descriptor.description"/>
	
	<acme:form-submit code="authenticated.job.form.button.duty" method="get" action="/employer/duty/list_duty?idDescriptor=${idDescriptor}"/>	
	<acme:form-submit code="authenticated.job.form.button.auditRecord" method="get" action="/authenticated/auditrecord/list?id=${jobId}"/>
	<acme:form-submit test="${isWorker}" code="worker.job.form.button" method="get" action="/worker/application/create?jobId=${jobId}"/>
	
	<acme:form-return code="authenticated.job.form.button.return"/>
</acme:form>
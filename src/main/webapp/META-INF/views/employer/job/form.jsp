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

<%@page import="acme.entities.jobs.Job"%>
<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<jstl:if test="${command == 'show' }">
<acme:form readonly = "true">
		<acme:form-textbox code="employer.job.form.label.reference" path="reference" placeholder="EEEE-JJJJ"/>
		<acme:form-textbox code="employer.job.form.label.title" path="title" placeholder="Titulo" />
		<acme:form-textbox code="employer.job.form.label.status" path="status" placeholder="PUBLISHED or DRAFT" />
		<acme:form-textbox code="employer.job.form.label.description" path="description" placeholder="Description" />
		<acme:form-moment code="employer.job.form.label.deadline" path="deadline" placeholder="YYYY/MM/DD HH:MM" />
		<acme:form-money code="employer.job.form.label.salary" path="salary" placeholder="Moneda(EUR, USD..) Valor" />
		<acme:form-url code="employer.job.form.label.moreInfo" path="moreInfo" placeholder="http://www.example.com" />
		<acme:form-textbox code="employer.job.form.label.descriptor.description" path="descriptor.description" />
		<jstl:if test="${haveChallenge == true }">
		<jstl:if test="${textChallenge == true}">
			<acme:form-textarea code="employer.job.form.label.challenge.text" path="challenge.text" placeholder="Text of Challenge" />	
		</jstl:if>
		<jstl:if test="${moreInfoChallenge == true}">
		<acme:form-url code="employer.job.form.label.challenge.moreInfo" path="challenge.moreInfo" placeholder="http://www.example.com" />	
		</jstl:if>
		</jstl:if>
		<acme:form-hidden path="${idDescriptor }"/>
	
		<acme:form-submit code="employer.job.form.button.duty" method="get" action="/employer/duty/list_duty?idDescriptor=${idDescriptor}"/>
		<acme:form-submit code="employer.job.form.button.crear-duty" test="${finalMode == false}" method="get" action="/employer/duty/create?idDescriptor=${idDescriptor}"/>
		<acme:form-submit code="employer.job.form.button.auditRecord" method="get" action="/employer/auditrecord/list?id=${jobId}"/>	
		<acme:form-submit code="employer.job.form.button.update" test="${finalMode == false}"  method="get" action="/employer/job/update?id=${jobId}"/>
		<acme:form-submit code="employer.job.form.button.job.createChallenge" method="get" action="/employer/jobchallenge/create?id=${jobId}"/>
		<acme:form-submit code="employer.job.form.button.delete" action="/employer/job/delete"/>
</acme:form>
</jstl:if>

<jstl:if test="${command == 'create' or command == 'update' }">
	<acme:form>
		<acme:form-textbox code="employer.job.form.label.reference" path="reference" placeholder="EEEE-JJJJ"/>
		<acme:form-textbox code="employer.job.form.label.title" path="title" placeholder="Titulo" />
		<acme:form-textbox code="employer.job.form.label.description" path="description" placeholder="Description" />
		<acme:form-moment code="employer.job.form.label.deadline" path="deadline" placeholder="YYYY/MM/DD HH:MM" />
		<acme:form-money code="employer.job.form.label.salary" path="salary" placeholder="Moneda(EUR, USD..) Valor" />
		<acme:form-url code="employer.job.form.label.moreInfo" path="moreInfo" placeholder="http://www.example.com" />
		<acme:form-textbox code="employer.job.form.label.descriptor.description" path="descriptor.description" placeholder="Description" />	
		<acme:form-checkbox code="employer.job.form.label.finalMode" path="finalMode"/>
		<jstl:if test="${command == 'update' and haveChallenge==true}">
		<acme:form-textarea code="employer.job.form.label.challenge.text" path="challenge.text" placeholder="Text of Challenge" />	
		<acme:form-url code="employer.job.form.label.challenge.moreInfo" path="challenge.moreInfo" placeholder="http://www.example.com" />	
		</jstl:if>
		<acme:form-submit  code="employer.job.form.button.update" test="${command == 'update' }" action="/employer/job/update"/>
		<acme:form-submit code="employer.job.form.button.create" test="${command == 'create' }" action="/employer/job/create" />	
		<acme:form-return code="employer.job.form.button.return"/>
	</acme:form>	
</jstl:if>
<jstl:if test="${command == 'delete' }">
<acme:form>
	<h2>
		<p> El trabajo no puede ser eliminado porque tiene solicitudes </p>
	</h2>	
	<acme:form-return code="employer.job.form.button.return"/>
</acme:form>	
</jstl:if>


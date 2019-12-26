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
	<acme:form-textbox code="worker.applications.form.label.referenceNumber" path="referenceNumber" placeholder="EEEE-JJJJ:WWWW"/>
	<jstl:if test="${command != 'create'}">
	<acme:form-textbox code="worker.applications.form.label.moment" path="moment" placeholder="YYYYY/MM/dd hh:mm"/>
	<acme:form-textbox code="worker.applications.form.label.status" path="status" placeholder="Status" readonly="true"/>
	</jstl:if>
	<acme:form-textbox code="worker.applications.form.label.statement" path="statement" placeholder="Statement"/>
	<acme:form-textbox code="worker.applications.form.label.skills" path="skills" placeholder="Skills"/>
	<acme:form-textbox code="worker.applications.form.label.qualifications" path="qualifications" placeholder="Qualifications"/>
	
	<jstl:if test="${status == 'REJECTED' }">
	<acme:form-textarea code="employer.applications.form.label.justification" path="justification"/>
	</jstl:if>
	<acme:form-hidden path="jobId"/>
	
	<acme:form-submit test="${command=='create'}" code="worker.applications.form.button.create" action="/worker/application/create" />
	
	<acme:form-return code="worker.applications.form.button.return" />
</acme:form>
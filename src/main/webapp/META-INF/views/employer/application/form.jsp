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
	
	<acme:form-textbox code="employer.applications.form.label.referenceNumber" path="referenceNumber" placeholder="EEEE-JJJJ:WWWW"/>
	<acme:form-textbox code="employer.applications.form.label.moment" path="moment" placeholder="YYYYY/MM/dd hh:mm"/>
	<acme:form-textbox code="employer.applications.form.label.statement" path="statement" placeholder="Statement"/>
	<acme:form-textbox code="employer.applications.form.label.skills" path="skills" placeholder="Skills"/>
	<acme:form-textbox code="employer.applications.form.label.qualifications" path="qualifications" placeholder="Qualifications"/>
	<jstl:if test="${command == 'show' }">
	<acme:form-textbox code="employer.applications.form.label.status" path="status" placeholder="Status"/>
		<jstl:if test="${status == 'REJECTED' }">
			<acme:form-textarea code="employer.applications.form.label.justification" path="justification"/>
		</jstl:if>
	<acme:form-submit code="employer.applications.form.button.update" method="get" action="/employer/application/update?id=${idApp}"/>
	</jstl:if>
	<jstl:if test="${command == 'update'}">
	<acme:form-select code="employer.applications.form.label.status" path="status" readonly="false">
		<jstl:forEach items="status" var="status">
			<acme:form-option code="employer.applications.form.label.status.pending" value="PENDING"/>
			<acme:form-option code="employer.applications.form.label.status.accepted" value="ACCEPTED" />
			<acme:form-option code="employer.applications.form.label.status.rejected" value="REJECTED" />
		</jstl:forEach>
	</acme:form-select>
	<acme:form-textarea code="employer.applications.form.label.justification" path="justification" readonly="false"/>
	<acme:form-submit code="employer.applications.form.button.update" action="/employer/application/update"/>
	</jstl:if>
	<acme:form-return code="employer.applications.form.button.return" />
</acme:form>
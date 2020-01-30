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


<acme:form>
		
		<acme:form-textarea code="employer.job.form.label.passfa.text" path="text" placeholder="Text of passfa"/>	
		<acme:form-url code="employer.job.form.label.passfa.trackNumber" path="trackNumber" placeholder="http://www.example.com" />	
		<acme:form-submit code="employer.job.form.button.passfa.create" test="${command == 'create'}" method="post" action="/employer/passfa/create?id=${idJob}"/>
		<input type="hidden" name="idJob" value="${jobId}"/>
		<acme:form-hidden path="idJob"/>
		<acme:form-return code="employer.job.form.button.passfa.return"/>
</acme:form>
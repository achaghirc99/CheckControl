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
		
		<acme:form-textarea code="employer.job.form.label.challenge.text" path="text" placeholder="Text of Challenge" />	
		<acme:form-url code="employer.job.form.label.challenge.moreInfo" path="moreInfo" placeholder="http://www.example.com" />	
		
		<acme:form-submit code="employer.job.form.button.challenge.create" action="/employer/jobchallenge/create?id=${jobId}"/>
		<acme:form-return code="employer.job.form.button.challenge.return"/>
</acme:form>
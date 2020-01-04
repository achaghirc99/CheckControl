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
	<acme:form-textbox code="worker.applications.form.label.answer.answer" path="answer" placeholder="Write your answer"/>
	<acme:form-textbox code="worker.applications.form.label.answer.optional" path="optional" placeholder="This is optional"/>

		<acme:form-submit test="${command=='create'}" 
				code="worker.applications.form.button.createAnswer" 
				action="/worker/answer/create?id=${applicationId}" />	
		<acme:form-return code="worker.applications.form.button.return"/>
</acme:form>
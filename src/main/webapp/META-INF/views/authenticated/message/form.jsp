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

<%@page language="java" %>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<acme:form readonly="false">
	<acme:form-textbox code="authenticated.messages.form.label.title" path="title" />
	<acme:check-access test="${command != 'create'}">
	<acme:form-textbox code="authenticated.messages.form.label.moment" path="moment"/>
	</acme:check-access>
	<acme:form-checkbox code="authenticated.messages.form.label.accepted" path="accepted"/>
	<acme:form-textbox code="authenticated.messages.form.label.tags" path="tags"/>
	<acme:form-textarea code="authenticated.messages.form.label.body" path="body"/>
	
	
	<acme:form-submit test="${command == 'create'}" 	
	code="authenticated.message-thread.form.button.create"  	
	action="/authenticated/message/create?id=${id}"/>
	
	<acme:form-return code="authenticated.messages.form.button.return" />
</acme:form>
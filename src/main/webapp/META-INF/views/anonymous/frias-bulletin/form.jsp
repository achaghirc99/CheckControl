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
	<acme:form-textbox code="anonymous.frias-bulletin.form.label.author" path="author" placeholder="Bulletin"/>
	<acme:form-textbox code="anonymous.frias-bulletin.form.label.email" path="email" placeholder="ejemplo@gmail.com"/>
	<acme:form-textbox code="anonymous.frias-bulletin.form.label.location" path="location" placeholder="----"/>
	<acme:form-textarea code="anonymous.frias-bulletin.form.label.text" path="text" placeholder="----"/>

	<acme:form-submit code="anonymous.frias-bulletin.form.button.create" action="/anonymous/friasbulletin/create" />
	<acme:form-return code="anonymous.frias-bulletin.form.button.return" />


</acme:form>
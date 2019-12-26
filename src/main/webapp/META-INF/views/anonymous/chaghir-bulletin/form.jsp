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
	<acme:form-textbox code="anonymous.chaghir-bulletin.form.label.name" path="name" placeholder="Bulletin" />
	<acme:form-textarea code="anonymous.chaghir-bulletin.form.label.languages" path="lenguages" placeholder="C1 English" />
	<acme:form-textbox code="anonymous.chaghir-bulletin.form.label.phone" path="Phone" placeholder="631102599" />

	<acme:form-submit code="anonymous.chaghir-bulletin.form.button.create" action="/anonymous/chaghirbulletin/create" />
	<acme:form-return code="anonymous.chaghir-bulletin.form.button.return" />


</acme:form>
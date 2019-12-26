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
	<acme:form-textbox code="authenticated.sponsor.form.label.organisationName" path="organisationName" />
	
	<acme:form-submit test="${command=='update'}" code="authenticated.sponsor.form.button.update"
		action="/authenticated/sponsor/update" />
	<acme:form-submit test="${command=='create'}" code="authenticated.sponsor.form.button.create"
		action="/authenticated/sponsor/create" />

	<jstl:if test="${creditCard}">
		<acme:form-submit test="${command=='update'}" code="authenticated.sponsor.form.button.update-creditcard" method="get"
			action="/sponsor/credit-card/update?sponsorId=${sponsorId}" />
	</jstl:if>
	<jstl:if test="${!creditCard}">
		<acme:form-submit test="${command=='update'}" code="authenticated.sponsor.form.button.create-creditcard" method="get"
			action="/sponsor/credit-card/create?sponsorId=${sponsorId}" />
	</jstl:if>

	<acme:form-return code="authenticated.sponsor.form.button.return" />

</acme:form>
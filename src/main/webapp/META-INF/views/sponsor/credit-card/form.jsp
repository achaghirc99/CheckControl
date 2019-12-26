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
		<acme:form-textbox code="sponsor.creditcard.form.label.name" path="name"/>
		<acme:form-textbox code="sponsor.creditcard.form.label.creditnumber" path="creditCardNumber"/>
		<acme:form-textbox code="sponsor.creditcard.form.label.cvc" path="cvc"/>
		<acme:form-textbox code="sponsor.creditcard.form.label.month" path="month"/>
		<acme:form-textbox code="sponsor.creditcard.form.label.year" path="year"/>
		
		<acme:form-hidden path="sponsorId"/>
	
		<acme:form-submit test="${command=='create'}" code="sponsor.form.button.create-creditcard" action="/sponsor/credit-card/create"/>
		<acme:form-submit test="${command=='update'}" code="sponsor.form.button.update-creditcard" action="/sponsor/credit-card/update"/>
		<acme:form-return code="authenticated.sponsor.form.button.return"/>
</acme:form>
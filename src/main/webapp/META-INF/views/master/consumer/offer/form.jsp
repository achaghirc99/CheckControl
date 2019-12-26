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

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="consumer.offer.form.label.ticker" path="ticker" placeholder="OAAAA-12345"/>
	<acme:form-moment code="consumer.offer.form.label.deadline" path="deadline" placeholder="YYYY/MM/dd hh:mm"/>
	<acme:form-textbox code="consumer.offer.form.label.title" path="title" placeholder="title"/>
	<acme:form-textarea code="consumer.offer.form.label.text" path="text" placeholder="Text"/>
	<acme:form-money code="consumer.offer.form.label.reward" path="reward" placeholder="EUR 2000,00   Pon una , Español or put a . English"/>
		<jstl:if test="${command == 'create' }">
		<acme:form-checkbox code="consumer.offer.form.label.checkbox" path="beCareful"/>
		<acme:form-submit code="consumer.offer.form.button.create" action="/consumer/offer/create"/>
		</jstl:if>
	<acme:form-return code="consumer.offer.form.button.return"/>
</acme:form>
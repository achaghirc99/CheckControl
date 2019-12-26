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
	<acme:form-url code="sponsor.commercialbanner.form.label.picture" path="picture" placeholder="http://www.imagen.com"/>
	<acme:form-textbox code="sponsor.commercialbanner.form.label.slogan" path="slogan" placeholder="slogan" />
	<acme:form-url code="sponsor.commercialbanner.form.label.targetUrl" path="targetUrl" placeholder="http://www.url.com" />
	<acme:form-textbox code="sponsor.commercialbanner.form.label.creditCard" path="creditCard" placeholder="1234567890123456" />
<%-- 	<acme:form-hidden path="sponsor.id"/> --%>
	<jstl:if test="${command == 'show' }">
	<acme:form-hidden path="${id}"/>
	<acme:form-submit code="sponsor.commercialbanner.form.button.update" method="get" action="/sponsor/commercialbanner/update?id=${idCommercialBanner}"/>
	<acme:form-submit code="sponsor.commercialbanner.form.button.delete"  action="/sponsor/commercialbanner/delete"/>
	</jstl:if>
	

	<acme:form-submit code="sponsor.commercialbanner.form.button.update" test="${command == 'update' }" action="/sponsor/commercialbanner/update"/>

	<acme:form-submit code="sponsor.commercialbanner.form.button.create" test="${command == 'create' }" action="/sponsor/commercialbanner/create"/>

	
	<acme:form-return code="sponsor.commercialbanner.form.button.return" />
</acme:form>
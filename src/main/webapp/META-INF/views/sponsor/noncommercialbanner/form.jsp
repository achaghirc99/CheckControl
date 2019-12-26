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
	<acme:form-url code="sponsor.noncommercialbanner.form.label.picture" path="picture" placeholder="http://www.picture.com" />
	<acme:form-textbox code="sponsor.noncommercialbanner.form.label.slogan" path="slogan" placeholder="slogan"/>
	<acme:form-url code="sponsor.noncommercialbanner.form.label.targetUrl" path="targetUrl" placeholder="http://www.url.com"/>	
	<acme:form-url code="sponsor.noncommercialbanner.form.label.optionalJingle" path="optionalJingle" placeholder="http://www.optionaljingle.com"/>	
		
  	
	<jstl:if test="${command == 'show' }">
	<acme:form-hidden path="${id}"/>
	<acme:form-submit code="sponsor.noncommercialbanner.form.button.update" method="get" action="/sponsor/non-commercialbanner/update?id=${id}"/>
	<acme:form-submit code="sponsor.noncommercialbanner.form.button.delete" action="/sponsor/non-commercialbanner/delete"/>
	</jstl:if>
	
	<acme:form-submit code="sponsor.noncommercialbanner.form.button.update" test="${command == 'update' }" action="/sponsor/non-commercialbanner/update"/>

	<acme:form-submit code="sponsor.noncommercialbanner.form.button.create" test="${command == 'create' }" action="/sponsor/non-commercialbanner/create"/>

	
	<acme:form-return code="sponsor.commercialbanner.form.button.return" />
</acme:form>
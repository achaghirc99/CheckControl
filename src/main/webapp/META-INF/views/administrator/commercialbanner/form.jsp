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
	<acme:form-url code="administrator.commercialbanner.form.label.picture" path="picture" placeholder="http://www.imagen.com"/>
	<acme:form-textbox code="administrator.commercialbanner.form.label.slogan" path="slogan" placeholder="slogan" />
	<acme:form-url code="administrator.commercialbanner.form.label.targetUrl" path="targetUrl" placeholder="http://www.url.com" />
	<acme:form-textbox code="administrator.commercialbanner.form.label.creditCard" path="creditCard" placeholder="1234567890123456" />

	<acme:form-submit test="${command == 'show'}" code="administrator.commercialbanner.form.button.update"
		action="/administrator/commercialbanner/update" />
	<acme:form-submit test="${command == 'show'}" code="administrator.commercialbanner.form.button.delete"
		action="/administrator/commercialbanner/delete" />
	<acme:form-submit test="${command == 'create'}" code="administrator.commercialbanner.form.button.create"
		action="/administrator/commercialbanner/create" />
	<acme:form-submit test="${command == 'update'}" code="administrator.commercialbanner.form.button.update"
		action="/administrator/commercialbanner/update" />
	<acme:form-submit test="${command == 'delete'}" code="administrator.commercialbanner.form.button.delete"
		action="/administrator/commercialbanner/delete" />
	<acme:form-return code="administrator.commercialbanner.form.button.return" />

</acme:form>
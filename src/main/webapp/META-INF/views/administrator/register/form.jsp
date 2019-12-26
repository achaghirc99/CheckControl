<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="administrator.register.form.label.name" path="name" placeholder="Name"/>
	<acme:form-textbox code="administrator.register.form.label.sector" path="sector" placeholder="Sector"/>
	<acme:form-textbox code="administrator.register.form.label.investmentStatement" path="investmentStatement" />
	<acme:form-textbox code="administrator.register.form.label.assessment" path="assessment" placeholder="1-5"/>


	<acme:form-submit test="${command == 'show'}" code="administrator.register.form.button.update"
		action="/administrator/register/update" />

	<acme:form-submit test="${command == 'show'}" code="administrator.register.form.button.delete"
		action="/administrator/register/delete" />

	<acme:form-submit test="${command == 'create'}" code="administrator.register.form.button.create"
		action="/administrator/register/create" />

	<acme:form-submit test="${command == 'update'}" code="administrator.register.form.button.update"
		action="/administrator/register/update" />

	<acme:form-submit test="${command == 'delete'}" code="administrator.register.form.button.delete"
		action="/administrator/register/delete" />

	<acme:form-return code="administrator.register.form.button.return" />
</acme:form>
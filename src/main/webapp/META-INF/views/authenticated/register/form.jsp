<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="authenticated.register.form.label.name" path="name" placeholder="Name"/>
	<acme:form-textbox code="authenticated.register.form.label.sector" path="sector" placeholder="Sector"/>
	<acme:form-textbox code="authenticated.register.form.label.investmentStatement" path="investmentStatement"/>
	<acme:form-textbox code="authenticated.register.form.label.assessment" path="assessment" placeholder="1-5"/>
	
	<acme:form-return code="authenticated.register.form.button.return"/>
</acme:form>
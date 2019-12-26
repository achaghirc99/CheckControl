<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="anonymous.register.form.label.name" path="name" placeholder="Name"/>
	<acme:form-textbox code="anonymous.register.form.label.sector" path="sector" placeholder="Sector"/>
	<acme:form-textbox code="anonymous.register.form.label.investmentStatement" path="investmentStatement" />
	<acme:form-textbox code="anonymous.register.form.label.assessment" path="assessment" placeholder="1-5"/>
	
	<acme:form-return code="anonymous.register.form.button.return"/>
</acme:form>
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

<%@page language="java" %>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<acme:form readonly="true">
	<acme:form-textbox code="authenticated.companyrecord.form.label.name" path="name" placeholder="Company1"/>
	<acme:form-textbox code="authenticated.companyrecord.form.label.sector" path="sector" placeholder="Sector1"/>
	<acme:form-textbox code="authenticated.companyrecord.form.label.ceo" path="ceo" placeholder="CEO"/>
	<acme:form-textarea code="authenticated.companyrecord.form.label.description" path="description" placeholder="Write a description of your company"/>
	<acme:form-url code="authenticated.companyrecord.form.label.url" path="url" placeholder="http://www.urlcompany.com"/>
	<acme:form-textbox code="authenticated.companyrecord.form.label.phone" path="phone" placeholder="612345678"/>
	<acme:form-textbox code="authenticated.companyrecord.form.label.email" path="email" placeholder="company@gmail.com"/>
	<acme:form-checkbox code="authenticated.companyrecord.form.label.incorporated" path="incorporated" />
	<acme:form-integer code="authenticated.companyrecord.form.label.evaluation" path="evaluation" placeholder="1-5"/>
	
	
	<acme:form-return code="authenticated.companyrecord.form.button.return" />	
</acme:form>
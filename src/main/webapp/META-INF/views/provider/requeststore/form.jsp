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
	<acme:form-textbox code="provider.requeststore.form.label.title" path="title" placeholder="Titulo"/>
	<jstl:if test="$(command != 'create')">
		<acme:form-moment code="provider.requeststore.form.label.moment" path="moment" placeholder="YYYYY/MM/dd hh:mm"/>
	</jstl:if>
	<acme:form-textbox code="provider.requeststore.form.label.deadline" path="deadline" placeholder="YYYYY/MM/dd hh:mm"/>
	<acme:form-textarea code="provider.requeststore.form.label.text" path="text" placeholder="text"/>
	<acme:form-textbox code="provider.requeststore.form.label.reward" path="reward" placeholder="EUR 2000,00  Pon una , Español or put a . English"/>
	<acme:form-textbox code="provider.requeststore.form.label.ticker" path="ticker" placeholder="RAAAA-12345"/>

	<acme:form-submit code="provider.requeststore.form.button.create" action="/provider/requeststore/create" />

	<acme:form-return code="provider.requeststore.form.button.return" />
</acme:form>








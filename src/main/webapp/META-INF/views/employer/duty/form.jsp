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

<jstl:if test="${command == 'show'}">
	<acme:form readonly="true" >
	<acme:form-textbox code="employer.duty.form.label.dutyTitle" path="dutyTitle" placeholder="Titulo" readonly="false" />
	<acme:form-textbox code="employer.duty.form.label.description" path="description" placeholder="Descripción" readonly="false" />
	<acme:form-textbox code="employer.duty.form.label.percentage" path="percentage" placeholder="Porcentaje" readonly="false" />
	
	<acme:form-submit code="employer.job.form.button.update" method="get" action="/employer/duty/update?id=${idDuty}"/>
	<acme:form-submit code="employer.job.form.button.delete" action="/employer/duty/delete"/>
	<acme:form-return code="employer.job.form.button.return"/>
	</acme:form>
</jstl:if>
<jstl:if test="${command == 'update' or command== 'create'}" >
	<acme:form >
	<acme:form-textbox code="employer.duty.form.label.dutyTitle" path="dutyTitle" placeholder="Titulo"  />
	<acme:form-textbox code="employer.duty.form.label.description" path="description" placeholder="Descripción"  />
	<acme:form-textbox code="employer.duty.form.label.percentage" path="percentage" placeholder="Porcentaje" />
	
	<acme:form-submit code="employer.job.form.button.create" test="${command == 'create'}" method="post" action="/employer/duty/create?idDescriptor=${idDescriptor}"/>
	<acme:form-submit code="employer.job.form.button.update" test="${command == 'update'}" action="/employer/duty/update" />
	<acme:form-return code="employer.job.form.button.return"/>
</acme:form>
</jstl:if>
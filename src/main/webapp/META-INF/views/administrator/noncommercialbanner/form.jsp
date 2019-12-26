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
	<acme:form-url code="administrator.noncommercialbanner.form.label.picture" path="picture" placeholder="http://www.picture.com" />
	<acme:form-textbox code="administrator.noncommercialbanner.form.label.slogan" path="slogan" placeholder="slogan"/>
	<acme:form-url code="administrator.noncommercialbanner.form.label.targetUrl" path="targetUrl" placeholder="http://www.url.com"/>	
	<acme:form-url code="administrator.noncommercialbanner.form.label.optionalJingle" path="optionalJingle" placeholder="http://www.optionaljingle.com"/>	
		
  	<acme:form-submit test="${command == 'show'}" 
		code="administrator.noncommercialbanner.form.button.update" 
		action="/administrator/noncommercialbanner/update"/>
	<acme:form-submit test="${command == 'show'}" 
		code="administrator.noncommercialbanner.form.button.delete" 
		action="/administrator/noncommercialbanner/delete"/>
	<acme:form-submit test="${command == 'create'}" 
		code="administrator.noncommercialbanner.form.button.create" 
		action="/administrator/noncommercialbanner/create"/>
	<acme:form-submit test="${command == 'update'}" 
		code="administrator.noncommercialbanner.form.button.update" 
		action="/administrator/noncommercialbanner/update"/>
	<acme:form-submit test="${command == 'delete'}" 
		code="administrator.noncommercialbanner.form.button.delete" 
		action="/administrator/noncommercialbanner/delete"/>
		
	<acme:form-return code="administrator.noncommercialbanner.form.button.return" />
</acme:form>
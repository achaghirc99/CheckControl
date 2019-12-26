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
	<acme:form-textbox code="anonymous.maciasportillobulletin.form.label.name" path="name" placeholder="Emily"/>
	<acme:form-textarea code="anonymous.maciasportillobulletin.form.label.hobbies" path="hobbies" placeholder="Photography"/>
	<acme:form-textbox code="anonymous.maciasportillobulletin.form.label.city" path="city" placeholder="Seville"/>
	
	
	<acme:form-submit code="anonymous.maciasportillobulletin.form.button.create" action="/anonymous/maciasportillobulletin/create"/>
  	<acme:form-return code="anonymous.maciasportillobulletin.form.button.return"/>
</acme:form>

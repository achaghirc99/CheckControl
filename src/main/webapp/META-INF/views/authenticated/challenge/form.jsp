<?xml version="1.0" encoding="utf-8" ?>
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
	<acme:form-textbox code="authenticated.challenge.form.label.title" path="title" placeholder="This is a first title"/>
	<acme:form-textbox code="authenticated.challenge.form.label.deadline" path="deadline"/>
	<acme:form-textbox code="authenticated.challenge.form.label.description" path="description" placeholder="This is a description"/>
	<acme:form-textbox code="authenticated.challenge.form.label.goldGoal" path="goldGoal" placeholder="Do Task A"/>
	<acme:form-textbox code="authenticated.challenge.form.label.goldReward" path="goldReward" placeholder="EUR 2000 "/>
	<acme:form-textbox code="authenticated.challenge.form.label.silverGoal" path="silverGoal" placeholder="Do Task B"/>
	<acme:form-textbox code="authenticated.challenge.form.label.silverReward" path="silverReward" placeholder="EUR 1000"/>
	<acme:form-textbox code="authenticated.challenge.form.label.bronzeGoal" path="bronzeGoal" placeholder="Do Task C"/>
	<acme:form-textbox code="authenticated.challenge.form.label.bronzeReward" path="bronzeReward" placeholder="EUR 500"/>

  	<acme:form-return code="authenticated.challenge.form.button.return"/>
</acme:form>

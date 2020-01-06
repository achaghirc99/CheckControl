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

<acme:form readonly = "true">
	<acme:form-textbox code="administrator.dashboard-list.form.totalNumberAnnouncement" path="totalNumberAnnouncement" />
	<acme:form-textbox code="administrator.dashboard-list.form.totalNumberInvestor" path="totalNumberInvestor"/>
	<acme:form-textbox code="administrator.dashboard-list.form.totalNumberCompany" path="totalNumberCompany"/>	
	<acme:form-textbox code="administrator.dashboard-list.form.minimumRequest" path="minimumRequest"/>
	<acme:form-textbox code="administrator.dashboard-list.form.maximumRequest" path="maximumRequest"/>
	<acme:form-textbox code="administrator.dashboard-list.form.averageRequest" path="averageRequest"/>
	<acme:form-textbox code="administrator.dashboard-list.form.desviationRequest" path="desviationRequest"/>
	<acme:form-textbox code="administrator.dashboard-list.form.minimumOffers" path="minimumOffers"/>
	<acme:form-textbox code="administrator.dashboard-list.form.maximumOffers" path="maximumOffers"/>
	<acme:form-textbox code="administrator.dashboard-list.form.averageOffers" path="averageOffers"/>
	<acme:form-textbox code="administrator.dashboard-list.form.desviationOffers" path="desviationOffers"/>
	<acme:form-textbox code="administrator.dashboard-list.form.averageNumberOfJobsPerEmployer" path="averageNumberOfJobsPerEmployer"/>
	<acme:form-textbox code="administrator.dashboard-list.form.averageNumberOfApplicationsPerWorker" path="averageNumberOfApplicationsPerWorker"/>
	<acme:form-textbox code="administrator.dashboard-list.form.averageNumberOfApplicationsPerEmployer" path="averageNumberOfApplicationsPerEmployer"/>
	<acme:form-textbox code="administrator.dashboard-list.form.ratioOfJobsWithChallenge" path="ratioOfJobsWithChallenge"/>
	<acme:form-textbox code="administrator.dashboard-list.form.ratioChallengeWithMoreInfo" path="ratioChallengeWithXxx4"/>
	<acme:form-textbox code="administrator.dashboard-list.form.ratioOfApplicationsWithPasworedJob" path="ratioOfApplicationsWithPasworedXxx4"/>
		
</acme:form>

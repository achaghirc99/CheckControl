<%--
- menu.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java" import="acme.framework.helpers.PrincipalHelper,acme.entities.roles.Provider,acme.entities.roles.Consumer"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:menu-bar code="master.menu.home">
	<acme:menu-left>
		<acme:menu-option code="master.menu.anonymous" access="isAnonymous()">
			<acme:menu-suboption code="master.menu.anonymous.register" action="/anonymous/register/list" />
			<acme:menu-suboption code="master.menu.anonymous.register-top" action="/anonymous/register/list_top" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.anonymous.announcement" action="/anonymous/announcement/list" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.anonymous.companyrecord-list" action="/anonymous/companyrecord/list" />
			<acme:menu-suboption code="master.menu.anonymous.companyrecord-list-top" action="/anonymous/companyrecord/list_top" />
		</acme:menu-option>

		<acme:menu-option code="master.menu.administrator" access="hasRole('Administrator')">


		<acme:menu-suboption code="master.menu.administrator.user-accounts" action="/administrator/user-account/list"/>
		<acme:menu-separator/>
		<acme:menu-suboption code="master.menu.authenticated.register" action="/administrator/register/list"/>
		<acme:menu-suboption code="master.menu.administrator.register.create" action="/administrator/register/create"/>
      	<acme:menu-separator/>
		<acme:menu-suboption code="master.menu.administrator.announcement" action="/administrator/announcement/list"/>
		<acme:menu-suboption code="master.menu.administrator.announcement.create" action="/administrator/announcement/create" />
     	<acme:menu-separator/>
     	<acme:menu-suboption code="master.menu.administrator.companyrecord-list" action="/administrator/companyrecord/list"/>	
		<acme:menu-suboption code="master.menu.administrator.companyrecord-create" action="/administrator/companyrecord/create"/>	
		<acme:menu-separator/>
		<acme:menu-suboption code="master.menu.authenticated.offer.list" action="/authenticated/offer/list"/>
      	<acme:menu-separator/>
      	<acme:menu-suboption code="master.menu.authenticated.requeststore-list" action="/authenticated/requeststore/list"/>
      	<acme:menu-separator/>
      	<acme:menu-suboption code="master.menu.authenticated.challenges-list" action="/administrator/challenge/list"/>
      	<acme:menu-suboption code="master.menu.administrator.challenge.create" action="/administrator/challenge/create"/>
      	<acme:menu-separator/>
	  	<acme:menu-suboption code="master.menu.administrator.shutdown" action="/master/shutdown"/>
	  	<acme:menu-separator/>
	  	<acme:menu-suboption code="master.menu.spam.spams-list" action="/administrator/spam/list"/>
	  	<acme:menu-separator/>
	  	<acme:menu-suboption code="master.menu.administrator.requestauditor-list" action="/administrator/requestauditor/list"/>
		</acme:menu-option>

		<acme:menu-option code="master.menu.authenticated-messagethread" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.authenticated.messagethread" action="/authenticated/message-thread/list_mine" />
			<acme:menu-suboption code="master.menu.authenticated.messagethread-Create" action="/authenticated/message-thread/create" />
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.authenticated-requestauditor" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.authenticated.requestauditor-list" action="/authenticated/requestauditor/list" />
			<acme:menu-suboption code="master.menu.authenticated.requestauditor-Create" action="/authenticated/requestauditor/create" />
		</acme:menu-option>

		<acme:menu-option code="master.menu.administrator-banner" access="hasRole('Administrator')">
			<acme:menu-suboption code="master.menu.administrator.commercialbanner.list" action="/administrator/commercialbanner/list" />
			<acme:menu-suboption code="master.menu.administrator.commercialbanner.create" action="/administrator/commercialbanner/create" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.administrator.noncommercialbanner.list" action="/administrator/noncommercialbanner/list" />
			<acme:menu-suboption code="master.menu.administrator.noncommercialbanner.create" action="/administrator/noncommercialbanner/create" />
		</acme:menu-option>
		<acme:menu-option code="master.menu.administrator-dashboard" access="hasRole('Administrator')">
			<acme:menu-suboption code="master.menu.administrator.dashboard-list" action="/administrator/dashboard-list/show"/>
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.administrator.dashboard-chars" action="/administrator/dashboard/show" />
		</acme:menu-option>
		

		<acme:menu-option code="master.menu.authenticated" access="isAuthenticated() and !hasRole('Administrator')">
			<acme:menu-suboption code="master.menu.authenticated.register" action="/authenticated/register/list" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.authenticated.announcement" action="/authenticated/announcement/list" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.authenticated.companyrecord-list" action="/authenticated/companyrecord/list" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.authenticated.offer.list" action="/authenticated/offer/list" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.authenticated.requeststore-list" action="/authenticated/requeststore/list" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.authenticated.challenges-list" action="/authenticated/challenge/list" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.authenticated.lis-all-jobs" action="/authenticated/job/list_all" />
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.worker" access="hasRole('Worker')">
		<acme:menu-suboption code="master.menu.worker.workerapplications.listMine" action="/worker/application/list_mine" />
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.sponsor" access="isAuthenticated() and hasRole('Sponsor')">
		<acme:menu-suboption code="master.menu.sponsor.commercialbanner.listMine" action="/sponsor/commercialbanner/list_mine" />
		<acme:menu-suboption code="master.menu.sponsor.commercialbanner.create" action="/sponsor/commercialbanner/create" />
		<acme:menu-separator />
		<acme:menu-suboption code="master.menu.sponsor.noncommercialbanner.listMine" action="/sponsor/non-commercialbanner/list_mine" />
		<acme:menu-suboption code="master.menu.sponsor.noncommercialbanner.create" action="/sponsor/non-commercialbanner/create" />
		
		</acme:menu-option>

		<acme:menu-option code="master.menu.provider" access="hasRole('Provider')">
			<acme:menu-suboption code="master.menu.provider.favourite-link" action="http://www.example.com/" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.provider.create" action="/provider/requeststore/create" />
		</acme:menu-option>

		<acme:menu-option code="master.menu.consumer" access="hasRole('Consumer')">
			<acme:menu-suboption code="master.menu.consumer.favourite-link" action="http://www.example.com/" />
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.consumer.create-offer" action="/consumer/offer/create" />
		</acme:menu-option>
		

		<acme:menu-option code="master.menu.employer" access="hasRole('Employer')">
			<acme:menu-suboption code="master.menu.employer.favourite-link" action="http://www.example.com/" />
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.employer.list-mine-jobs" action="/employer/job/list_mine" />
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.employer.create-mine-jobs" action="/employer/job/create"	/>			
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.employer.list-job-applications" action="/employer/application/list_mine" />
		</acme:menu-option>

		
		

		<acme:menu-option code="master.menu.links" access="isAnonymous()">
			<acme:menu-suboption code="master.menu.links.favourite-link" action="https://github.com/Pabloreneses98" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.links.favourite-link1" action="https://github.com/AlvarofbUS" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.links.favourite-link2" action="https://github.com/JosanFCS" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.links.favourite-link3" action="https://github.com/achaghirc99/" />
		</acme:menu-option>


		<acme:menu-option code="master.menu.bulletins" access="isAnonymous()">
			<acme:menu-suboption code="master.menu.bulletins.list-Chaghirbulletins" action="/anonymous/chaghirbulletin/list" />
			<acme:menu-suboption code="master.menu.bulletins.create-Chaghirbulletin" action="/anonymous/chaghirbulletin/create" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.bulletins.list-Renesesbulletin" action="/anonymous/renesesBulletin/list" />
			<acme:menu-suboption code="master.menu.bulletins.create-Renesesbulletin" action="/anonymous/renesesBulletin/create" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.bulletins.friaslist" action="/anonymous/friasbulletin/list" />
			<acme:menu-suboption code="master.menu.bulletins.friasform" action="/anonymous/friasbulletin/create" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.bulletins.maciasportillo-list-bulletins" action="/anonymous/maciasportillobulletin/list" />
			<acme:menu-suboption code="master.menu.bulletins.maciasportillo-create-bulletin"
				action="/anonymous/maciasportillobulletin/create" />
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.auditor" access="hasRole('Auditor')">
			<acme:menu-suboption code="master.menu.auditor.Jobwhitrecords-list" action="/auditor/job/list_rec" />
			<acme:menu-suboption code="master.menu.auditor.Jobwhitoutrecords-list" action="/auditor/job/list_nonrec" />
		</acme:menu-option>
	

	</acme:menu-left>

	<acme:menu-right>


		<acme:menu-option code="master.menu.sign-up" action="/anonymous/user-account/create" access="isAnonymous()" />
		<acme:menu-option code="master.menu.sign-in" action="/master/sign-in" access="isAnonymous()" />

		<acme:menu-option code="master.menu.user-account" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.user-account.general-data" action="/authenticated/user-account/update" />
			<acme:menu-suboption code="master.menu.user-account.become-provider" action="/authenticated/provider/create"
				access="!hasRole('Provider')" />
			<acme:menu-suboption code="master.menu.user-account.provider" action="/authenticated/provider/update"
				access="hasRole('Provider')" />
			<acme:menu-suboption code="master.menu.user-account.become-consumer" action="/authenticated/consumer/create"
				access="!hasRole('Consumer')" />
			<acme:menu-suboption code="master.menu.user-account.consumer" action="/authenticated/consumer/update"
				access="hasRole('Consumer')" />
				<acme:menu-suboption code="master.menu.user-account.become-auditor" action="/authenticated/auditor/create"
				access="!hasRole('Auditor')" />
			<acme:menu-suboption code="master.menu.user-account.auditor" action="/authenticated/auditor/update"
				access="hasRole('Auditor')" />
			<acme:menu-suboption code="master.menu.user-account.sponsor"  action="/authenticated/sponsor/update"
				access="hasRole('Sponsor')" />
			<acme:menu-suboption code="master.menu.user-account.become-sponsor" action="/authenticated/sponsor/create"
				access="!hasRole('Sponsor')" />
				<acme:menu-suboption code="master.menu.user-account.become-employer" action="/authenticated/employer/create"
				access="!hasRole('Employer')" />
			<acme:menu-suboption code="master.menu.user-account.employer" action="/authenticated/employer/update"
				access="hasRole('Employer')" />
				<acme:menu-suboption code="master.menu.user-account.become-worker" action="/authenticated/worker/create"
				access="!hasRole('Worker')" />
			<acme:menu-suboption code="master.menu.user-account.worker" action="/authenticated/worker/update"
				access="hasRole('Worker')" />
		</acme:menu-option>

		<acme:menu-option code="master.menu.sign-out" action="/master/sign-out" access="isAuthenticated()" />
	</acme:menu-right>
</acme:menu-bar>


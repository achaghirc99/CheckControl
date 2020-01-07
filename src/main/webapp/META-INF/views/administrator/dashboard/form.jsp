<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


	<div class="form-group">
		<h3 align="center">
			<acme:message code="administrator.dashboard.title.ratiosCheckControl"/>
		</h3>
	</div>
	<br>
	<div>
		<canvas id="canvas0"></canvas>
	</div>
	<br>
	<script type="text/javascript" >
		$(document).ready(function(){
			var data = {
					labels : [
						"Jobs With Passfa","Passfa with Track Number","Applications with password-protected TrackNumber"
					],
					datasets : [
						{
						
							data : [
								<jstl:out value="${ratiosOfCheckControl[0]}"/>,
								<jstl:out value="${ratiosOfCheckControl[1]}"/>,
								<jstl:out value="${ratiosOfCheckControl[2]}"/>
							],backgroundColor: [
								<jstl:forEach var="ratiosOfCheckControl[0]" items="${ratiosOfCheckControl[0]}">
								<jstl:out value="'#63FFFB'" escapeXml="false"/>,
								</jstl:forEach>
								<jstl:forEach var="ratiosOfCheckControl[1]" items="${ratiosOfCheckControl[1]}">
								<jstl:out value="'#7AE44C'" escapeXml="false"/>,
								</jstl:forEach>
								<jstl:forEach var="ratiosOfCheckControl[2]" items="${ratiosOfCheckControl[2]}">
								<jstl:out value="'#FB0101'" escapeXml="false"/>,
								</jstl:forEach>
								
							]
						}
					]
			
				};
				var options = {
					scales : {
						yAxes : [
							{
								ticks : {
									suggestedMin : 0.0,
									suggestedMax : 1.0
								}
							}
						]
					},
					legend : {
						display : false
					}
				};
	
		var canvas, context;
	
			canvas = document.getElementById("canvas0");
			context = canvas.getContext("2d");
		new Chart(context, {
		
			type : "bar",
			data : data,
			options : options
		});
	});
	</script>
	


<h2 align="center">
	<acme:message code="administrator.dashboard.title.application-statuses"/>
</h2>

<div>
	<canvas id="canvas1"></canvas>
</div>

<script type="text/javascript">
	$(document).ready(function(){
		var data = {
				labels: [
					<jstl:forEach var="items" items="${labels}">
					<jstl:out value="\"${items}\"" escapeXml="false"/>,
					</jstl:forEach>
				],
				datasets : [
					{
						label: "Company Records",
						data: [
							<jstl:forEach var="numberCompanies" items="${numberCompanies}">
							<jstl:out value="\"${numberCompanies}\"" escapeXml="false"/>,
							</jstl:forEach>
						],backgroundColor: [
							<jstl:forEach var="numberCompanies" items="${numberCompanies}">
							<jstl:out value="'#FF6384'" escapeXml="false"/>,
							</jstl:forEach>
						]
					},{
						label: "Register",
						data: [
							<jstl:forEach var="numberRegisters" items="${numberRegisters}">
							<jstl:out value="\"${numberRegisters}\"" escapeXml="false"/>,
							</jstl:forEach>
						],backgroundColor: [
							<jstl:forEach var="numberRegisters" items="${numberRegisters}">
							<jstl:out value="'#8463FF'" escapeXml="false"/>,
							</jstl:forEach>
						]
					}
				]
		
		};
		
		var options = {
				scales : {
					yAxes : [
						{
							ticks : {
								suggestedMin : 0.0,
								suggestedMax : 10.0
							}
						}
					]
				},
				legend : {
					display : true
				}
		};
		
		var canvas,context;
		
		canvas = document.getElementById('canvas1');
		context = canvas.getContext('2d');
		new Chart(context, {
			type : 'bar',
			data : data,
			options : options
		});
	});

</script>

		<!--  Canvas for the lesson L-04 TO JOBS BY STATUS-->
	<div class="form-group">
		<h3 align="center">
			<acme:message code="administrator.dashboard.title.jobsByStatus"/>
		</h3>
	</div>
	<br>
	<div>
		<canvas id="canvas2"></canvas>
	</div>
	<br>
	
	<script type="text/javascript" >
		$(document).ready(function(){
			var data = {
					labels : [
						"PUBLISHED","DRAFTED"
					],
					datasets : [
						{
						
							data : [
								<jstl:out value="${ratioJobsByStatus[0]}"/>,
								<jstl:out value="${ratioJobsByStatus[1]}"/>
							],backgroundColor: [
								<jstl:forEach var="ratioJobsByStatus[0]" items="${ratioJobsByStatus[0]}">
								<jstl:out value="'#63FFFB'" escapeXml="false"/>,
								</jstl:forEach>
								<jstl:forEach var="ratioJobsByStatus[1]" items="${ratioJobsByStatus[1]}">
								<jstl:out value="'#7AE44C'" escapeXml="false"/>,
								</jstl:forEach>
								
							]
						}
					]
			
				};
				var options = {
					scales : {
						yAxes : [
							{
								ticks : {
									suggestedMin : 0.0,
									suggestedMax : 1.0
								}
							}
						]
					},
					legend : {
						display : false
					}
				};
	
		var canvas, context;
	
			canvas = document.getElementById("canvas2");
			context = canvas.getContext("2d");
		new Chart(context, {
		
			type : "pie",
			data : data,
			options : options
		});
	});
	</script>
	<!--  Canvas for the lesson L-05 TO JOBS BY STATUS-->
	<div class="form-group">
		<h3 align="center">
			<acme:message code="administrator.dashboard.title.applicationsByStatus"/>
		</h3>
	</div>
	<br>
	<div>
		<canvas id="canvas3"></canvas>
	</div>
	<br>
	<script type="text/javascript" >
		$(document).ready(function(){
			var data = {
					labels : [
						"ACCEPTED","PENDING","REJECTED"
					],
					datasets : [
						{
						
							data : [
								<jstl:out value="${ratioApplicationsByStatus[0]}"/>,
								<jstl:out value="${ratioApplicationsByStatus[1]}"/>,
								<jstl:out value="${ratioApplicationsByStatus[2]}"/>
							],backgroundColor: [
								<jstl:forEach var="ratioApplicationsByStatus[0]" items="${ratioApplicationsByStatus[0]}">
								<jstl:out value="'#63FFFB'" escapeXml="false"/>,
								</jstl:forEach>
								<jstl:forEach var="ratioApplicationsByStatus[1]" items="${ratioApplicationsByStatus[1]}">
								<jstl:out value="'#7AE44C'" escapeXml="false"/>,
								</jstl:forEach>
								<jstl:forEach var="ratioApplicationsByStatus[2]" items="${ratioApplicationsByStatus[2]}">
								<jstl:out value="'#FB0101'" escapeXml="false"/>,
								</jstl:forEach>
								
							]
						}
					]
			
				};
				var options = {
					scales : {
						yAxes : [
							{
								ticks : {
									suggestedMin : 0.0,
									suggestedMax : 1.0
								}
							}
						]
					},
					legend : {
						display : false
					}
				};
	
		var canvas, context;
	
			canvas = document.getElementById("canvas3");
			context = canvas.getContext("2d");
		new Chart(context, {
		
			type : "pie",
			data : data,
			options : options
		});
	});
	</script>
	
	<!-- L-05 TO APPLICATIONS PENDING ACCEPTED REJECTED PER DAY FOR LAST FOUR WEEKS -->
	<div>
	<canvas id="canvas4"></canvas>
</div>

<script type="text/javascript">
	$(document).ready(function(){
		var data = {
				labels: [
					<jstl:forEach var="status" items="${days}">
					<jstl:out value="\"${status}\"" escapeXml="false"/>,
					</jstl:forEach>
				],
				datasets : [
					{
						label: "PENDING",
						data: [
							<jstl:forEach var="pendingApp" items="${numberPendingApplications}">
							<jstl:out value="\"${pendingApp}\"" escapeXml="false"/>,
							</jstl:forEach>
						],backgroundColor: [
							<jstl:out value="'#FF6384'" escapeXml="false"/>,
						]
					},{
						label: "ACCEPTED",
						data: [
							<jstl:forEach var="acceptedApp" items="${numberAcceptedApplications}">
							<jstl:out value="\"${acceptedApp}\"" escapeXml="false"/>,
							</jstl:forEach>
						],backgroundColor: [
							<jstl:out value="'#7AE44C'" escapeXml="false"/>,
						]
					},{
						label: "REJECTED",
						data: [
							<jstl:forEach var="rejectedApp" items="${numberRejectedApplications}">
							<jstl:out value="\"${rejectedApp}\"" escapeXml="false"/>,
							</jstl:forEach>
						],backgroundColor: [
							<jstl:out value="'#8463FF'" escapeXml="false"/>,
						]
					}
				]
		
		};
		
		var options = {
				scales : {
					yAxes : [
						{
							ticks : {
								suggestedMin : 0.0,
								suggestedMax : 10.0
							}
						}
					]
				},
				legend : {
					display : true
				}
		};
		
		var canvas,context;
		
		canvas = document.getElementById('canvas4');
		context = canvas.getContext('2d');
		new Chart(context, {
			type : 'line',
			data : data,
			options : options
		});
	});
</script>
	
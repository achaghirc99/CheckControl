
package acme.features.administrator.dashboard;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.dashboards.Dashboard;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorDashboardShowService implements AbstractShowService<Administrator, Dashboard> {

	// Internal State -------------------------------------------------------------------------
	@Autowired
	private AdministratorDashboardRepository repository;


	@Override
	public boolean authorise(final Request<Dashboard> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Dashboard> request, final Dashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		Calendar calendar = new GregorianCalendar();
		Long fourWeeksAgo = calendar.getTimeInMillis() - 2419000000L;
		Date minimumdate = new Date(fourWeeksAgo);
		List<LocalDate> dates = this.getDates(minimumdate);
		List<String> stringDates = dates.stream().map(x -> x.toString()).collect(Collectors.toList());

		model.setAttribute("days", stringDates);

		request.unbind(entity, model, "labels", "numberCompanies", "numberRegisters", "ratioJobsByStatus", "ratioApplicationsByStatus");
		request.unbind(entity, model, "numberPendingApplications", "numberAcceptedApplications", "numberRejectedApplications", "ratiosOfCheckControl");

	}

	@Override
	public Dashboard findOne(final Request<Dashboard> request) {
		assert request != null;

		Dashboard dashboard = new Dashboard();

		Collection<Object[]> companylist = this.repository.findAllCompanies();
		Collection<Object[]> registerlist = this.repository.findAllRegisters();
		int i = 0;
		String res;

		String[] numberCompanies;
		String[] numberRegisters;

		for (Object[] obj : companylist) {
			if (ArrayUtils.contains(dashboard.getLabels(), obj[0].toString())) {
				i = ArrayUtils.lastIndexOf(dashboard.getLabels(), obj[0].toString());
				numberCompanies = dashboard.getNumberCompanies();
				res = Integer.toString(Integer.parseInt(numberCompanies[i]) + Integer.parseInt(obj[1].toString()));
				dashboard.setNumberRegisters(ArrayUtils.remove(dashboard.getNumberCompanies(), i));
				dashboard.setNumberCompanies(ArrayUtils.insert(i, dashboard.getNumberCompanies(), res));
			}

			if (!ArrayUtils.contains(dashboard.getLabels(), obj[0].toString())) {
				dashboard.setLabels(ArrayUtils.add(dashboard.getLabels(), obj[0].toString()));
				dashboard.setNumberCompanies(ArrayUtils.add(dashboard.getNumberCompanies(), obj[1].toString()));
				dashboard.setNumberRegisters(ArrayUtils.add(dashboard.getNumberRegisters(), "0"));
			}
		}

		for (Object[] obj : registerlist) {
			if (ArrayUtils.contains(dashboard.getLabels(), obj[0].toString())) {
				i = ArrayUtils.lastIndexOf(dashboard.getLabels(), obj[0].toString());
				numberRegisters = dashboard.getNumberRegisters();
				res = Integer.toString(Integer.parseInt(numberRegisters[i]) + Integer.parseInt(obj[1].toString()));
				dashboard.setNumberRegisters(ArrayUtils.remove(dashboard.getNumberRegisters(), i));
				dashboard.setNumberRegisters(ArrayUtils.insert(i, dashboard.getNumberRegisters(), res));
			}

			if (!ArrayUtils.contains(dashboard.getLabels(), obj[0].toString())) {
				dashboard.setLabels(ArrayUtils.add(dashboard.getLabels(), obj[0].toString()));
				dashboard.setNumberRegisters(ArrayUtils.add(dashboard.getNumberRegisters(), obj[1].toString()));
				dashboard.setNumberCompanies(ArrayUtils.add(dashboard.getNumberCompanies(), "0"));
			}
		}
		//---------------------		//L-04 Chars applications ratio per status  -----------------------------------------------
		Double ratiojobsPublished = this.repository.getJobsPublished();
		Double ratioJobsDrafted = this.repository.getJobsDraft();
		String[] ratiosJobs = new String[2];
		ratiosJobs[0] = ratiojobsPublished.toString();
		ratiosJobs[1] = ratioJobsDrafted.toString();
		dashboard.setRatioJobsByStatus(ratiosJobs);

		Double pendigApplications = this.repository.getApplicationsPending();
		Double acceptingApplications = this.repository.getApplicationsAccepted();
		Double rejectedApplications = this.repository.getApplicationsRejected();
		String[] ratiosApplications = new String[3];
		ratiosApplications[0] = acceptingApplications.toString();
		ratiosApplications[1] = rejectedApplications.toString();
		ratiosApplications[2] = pendigApplications.toString();
		dashboard.setRatioApplicationsByStatus(ratiosApplications);

		//---------------------		//L-05 Chars applications status per day the last four weeks -----------------------------------------------
		Calendar calendar = new GregorianCalendar();
		Long fourWeeksAgo = calendar.getTimeInMillis() - 2419000000L;
		Date minimumdate = new Date(fourWeeksAgo);
		List<String[]> pendingApplicationsList = this.repository.getPendingApplicationsPerDayLastFourWeeks(minimumdate);
		List<String[]> acceptedApplicationsList = this.repository.getAcceptedApplicationsPerDayLastFourWeeks(minimumdate);
		List<String[]> rejectedApplicationsList = this.repository.getRejectedApplicationsPerDayLastFourWeeks(minimumdate);

		List<LocalDate> dates = this.getDates(minimumdate);

		dashboard.setNumberPendingApplications(this.getDataByDate(pendingApplicationsList, dates));
		dashboard.setNumberAcceptedApplications(this.getDataByDate(acceptedApplicationsList, dates));
		dashboard.setNumberRejectedApplications(this.getDataByDate(rejectedApplicationsList, dates));
		//---------------------------------------END------------------------------------------------------------------------------------------

		//--------------------------------CHECK CONTROL---------------------------------------------------------------------------------------
		Double ratioOfJobsWithChallenge = this.repository.getRatioJobsWithChallenge();
		Double ratioChallengeWithMoreInfo = this.repository.getRatioChallengeWithMoreInfo();
		Double ratioOfApplicationsWithPasworedXXX = this.repository.getRatioOfApplicationsWithPasworedXXX();
		String[] ratios = new String[3];
		ratios[0] = ratioOfJobsWithChallenge.toString();
		ratios[1] = ratioChallengeWithMoreInfo.toString();
		ratios[2] = ratioOfApplicationsWithPasworedXXX.toString();
		dashboard.setRatiosOfCheckControl(ratios);

		return dashboard;

	}

	private List<Integer> getDataByDate(final List<String[]> numberApp, final List<LocalDate> dates) {
		Map<LocalDate, Integer> map = new HashMap<>();
		List<String[]> ls = numberApp;
		for (LocalDate fecha1 : dates) {
			map.put(fecha1, 0);
		}

		for (int i = 0; i < numberApp.size(); i++) {
			LocalDate fechaConNumberApp = LocalDate.parse(numberApp.get(i)[0].substring(0, 10));
			if (map.containsKey(fechaConNumberApp)) {
				map.replace(fechaConNumberApp, 0, Integer.parseInt(ls.get(i)[1]));
			}
		}

		TreeMap<LocalDate, Integer> fechas = new TreeMap<>(map);
		List<Integer> res = fechas.values().stream().collect(Collectors.toList());
		return res;
	}

	private List<LocalDate> getDates(final Date minimumDate) {
		Date now = Date.valueOf(LocalDate.now());
		long totalDays = (now.getTime() - minimumDate.getTime()) / (1000 * 60 * 60 * 24);
		List<LocalDate> dates = IntStream.iterate(0, x -> x + 1).limit(totalDays).mapToObj(x -> minimumDate.toLocalDate().plusDays(x)).collect(Collectors.toList());
		return dates;
	}
}


package acme.features.administrator.dashboardsList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.dashboardsList.DashboardList;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorDashboardListShowService implements AbstractShowService<Administrator, DashboardList> {

	@Autowired
	private AdministratorDashboardListRepository repository;


	@Override
	public boolean authorise(final Request<DashboardList> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<DashboardList> request, final DashboardList entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		Integer totalNumberAnnouncement = this.repository.getTotalNumberAnnouncement();
		Integer totalNumberInvestor = this.repository.getTotalNumberInvestor();
		Integer totalNumberCompany = this.repository.getTotalNumberCompany();
		Double minimumRequest = this.repository.getMinimumRequest();
		Double maximumRequest = this.repository.getMaximumRequest();
		Double averageRequest = this.repository.getAverageRequest();
		Double desviationRequest = this.repository.getDesviationRequest();
		Double minimumOffer = this.repository.getMinimumOffers();
		Double maximumOffer = this.repository.getMaximumOffers();
		Double averageOffer = this.repository.getAverageOffers();
		Double desviationOffer = this.repository.getDesviationOffers();
		Double averageNumberOfJobsPerEmployer = this.repository.averageNumberOfJobsPerEmployer();
		Double averageNumberOfApplicationsPerWorker = this.repository.averageNumberOfApplicationsPerWorker();
		Double averageNumberOfApplicationsPerEmployer = this.repository.averageNumberOfApplicationsPerEmployer();
		Double ratioOfJobsWithChallenge = this.repository.getRatioJobsWithChallenge();
		Double ratioChallengeWithXxx4 = this.repository.getRatioChallengeWithXxx4();
		Double ratioOfApplicationsWithPasworedXxx4 = this.repository.getRatioOfApplicationsWithPasworedXXX4();
		request.unbind(entity, model);

		model.setAttribute("totalNumberAnnouncement", totalNumberAnnouncement);
		model.setAttribute("totalNumberInvestor", totalNumberInvestor);
		model.setAttribute("totalNumberCompany", totalNumberCompany);
		model.setAttribute("minimumRequest", minimumRequest);
		model.setAttribute("maximumRequest", maximumRequest);
		model.setAttribute("averageRequest", averageRequest);
		model.setAttribute("desviationRequest", desviationRequest);
		model.setAttribute("minimumOffers", minimumOffer);
		model.setAttribute("maximumOffers", maximumOffer);
		model.setAttribute("averageOffers", averageOffer);
		model.setAttribute("desviationOffers", desviationOffer);
		model.setAttribute("averageNumberOfJobsPerEmployer", averageNumberOfJobsPerEmployer);
		model.setAttribute("averageNumberOfApplicationsPerWorker", averageNumberOfApplicationsPerWorker);
		model.setAttribute("averageNumberOfApplicationsPerEmployer", averageNumberOfApplicationsPerEmployer);
		model.setAttribute("ratioOfJobsWithChallenge", ratioOfJobsWithChallenge);
		model.setAttribute("ratioChallengeWithXxx4", ratioChallengeWithXxx4);
		model.setAttribute("ratioOfApplicationsWithPasworedXxx4", ratioOfApplicationsWithPasworedXxx4);
	}

	@Override
	public DashboardList findOne(final Request<DashboardList> request) {
		assert request != null;

		DashboardList result = new DashboardList();

		return result;
	}

}

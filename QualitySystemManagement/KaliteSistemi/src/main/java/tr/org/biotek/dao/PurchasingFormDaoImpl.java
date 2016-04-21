package tr.org.biotek.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tr.org.biotek.model.PurchasingForm;

@Repository
public class PurchasingFormDaoImpl implements PurchasingFormDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addPurchasingForm(PurchasingForm purchasingForm) {

		getCurrentSession().save(purchasingForm);

	}

	public void updatePurchasingForm(PurchasingForm purchasingForm) {
		
		PurchasingForm purchasingFormToUpdate = getPurchasingForm(purchasingForm.getId());
		
		purchasingFormToUpdate.setAmountOfOrder(purchasingForm.getAmountOfOrder());
		purchasingFormToUpdate.setDate(purchasingForm.getDate());
		purchasingFormToUpdate.setDateRequested(purchasingForm.getDateRequested());
		purchasingFormToUpdate.setExplanationOfRequestedReason(purchasingForm.getExplanationOfRequestedReason());
		purchasingFormToUpdate.setGeneralExplanation(purchasingForm.getGeneralExplanation());
		purchasingFormToUpdate.setQuantityRequested(purchasingForm.getQuantityRequested());
		purchasingFormToUpdate.setRequestedProductDefinition(purchasingForm.getRequestedProductDefinition());
		purchasingFormToUpdate.setRequestor(purchasingForm.getRequestor());
		purchasingFormToUpdate.setTenderCode(purchasingForm.getTenderCode());
		purchasingFormToUpdate.setDepartmentHeadApproval(purchasingForm.getDepartmentHeadApproval());
		purchasingFormToUpdate.setDepartmentName(purchasingForm.getDepartmentName());
		purchasingFormToUpdate.setAmountOfStock(purchasingForm.getAmountOfStock());
		
		getCurrentSession().update(purchasingFormToUpdate);

	}

	public PurchasingForm getPurchasingForm(int id) {
				
		PurchasingForm purchasingForm = (PurchasingForm) getCurrentSession().get(PurchasingForm.class, id);
		return purchasingForm;
		
	}

	public void deletePurchasingForm(int id) {
		
		PurchasingForm purchasingForm = getPurchasingForm(id);
		if (purchasingForm != null)
			getCurrentSession().delete(purchasingForm);
		

	}

	public List<PurchasingForm> getPurchasingForms() {
	
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(PurchasingForm.class);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.setFetchMode("*", FetchMode.JOIN);
		
		return criteria.list();
	}

}

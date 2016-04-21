/**
 * 
 */
package tr.org.biotek.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tr.org.biotek.dao.PurchasingFormDao;
import tr.org.biotek.model.PurchasingForm;

/**
 * @author haticesigirci
 *
 */

@Service
@Transactional
public class PurchasingFormServiceImpl implements PurchasingFormService {

	@Autowired
	PurchasingFormDao purchasingFormDao;
	
	public void addPurchasingForm(PurchasingForm purchasingForm) {
		
		purchasingFormDao.addPurchasingForm(purchasingForm);
	}

	
	public void updatePurchasingForm(PurchasingForm purchasingForm) {
		
		purchasingFormDao.updatePurchasingForm(purchasingForm);
	}

	
	public PurchasingForm getPurchasingForm(int id) {
		
		return purchasingFormDao.getPurchasingForm(id);
		
	}

	
	public void deletePurchasingForm(int id) {
		
		purchasingFormDao.deletePurchasingForm(id);
		
	}

	
	public List<PurchasingForm> getPurchasingForms() {
		
		return purchasingFormDao.getPurchasingForms();
	}

}

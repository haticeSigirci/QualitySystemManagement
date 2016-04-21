package tr.org.biotek.dao;

import java.util.List;

import tr.org.biotek.model.PurchasingForm;

public interface PurchasingFormDao {

	public void addPurchasingForm(PurchasingForm purchasingForm);

	public void updatePurchasingForm(PurchasingForm purchasingForm);

	public PurchasingForm getPurchasingForm(int id);

	public void deletePurchasingForm(int id);

	public List<PurchasingForm> getPurchasingForms();

}

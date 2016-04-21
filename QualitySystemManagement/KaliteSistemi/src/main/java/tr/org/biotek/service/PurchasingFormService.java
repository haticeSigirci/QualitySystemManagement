package tr.org.biotek.service;

import java.util.List;

import tr.org.biotek.model.PurchasingForm;

public interface PurchasingFormService {

	public void addPurchasingForm(PurchasingForm purchasingForm);

	public void updatePurchasingForm(PurchasingForm purchasingForm);

	public PurchasingForm getPurchasingForm(int id);

	public void deletePurchasingForm(int id);

	public List<PurchasingForm> getPurchasingForms();

}

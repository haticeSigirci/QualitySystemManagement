package tr.org.biotek.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tr.org.biotek.model.PurchasingForm;
import tr.org.biotek.service.PurchasingFormService;

@Controller
@RequestMapping(value="/purchasingForm", produces = "text/plain;charset=UTF-8")
public class PurchasingFormController {
	
	@Autowired
	PurchasingFormService purchasingFormService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) 
	{
		 CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false);
	        binder.registerCustomEditor(Date.class, editor);
	        
	        
	}

	@RequestMapping(value="")
	public String list(Model model) { 
		
		List<PurchasingForm> purchasingForms = purchasingFormService.getPurchasingForms();

		model.addAttribute("purchasingFormList", purchasingForms);
		
		return "purchasingFormList";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createForm(@ModelAttribute PurchasingForm purchasingForm) {
		
		System.out.println("hatice");
		
		System.out.println(purchasingForm.getDate());
		
		return "purchasingFormForm";
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String create(@ModelAttribute PurchasingForm purchasingForm) {	
		
		purchasingFormService.addPurchasingForm(purchasingForm);
		
		System.out.println("hiiiPOST");
		
		System.out.println(purchasingForm.getGeneralExplanation());
		System.out.println(purchasingForm.getDate());
		System.out.println(purchasingForm.getExplanationOfRequestedReason());
		
		return "redirect:/purchasingForm"; // ?? recursive
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET )
	public String edit(@ModelAttribute PurchasingForm purchasingForm, Model model, @PathVariable(value="id") Integer id){

		
		PurchasingForm purchasingFormNew = purchasingFormService.getPurchasingForm(id);

		model.addAttribute("purchasingForm", purchasingFormNew);

		return "purchasingFormEdit";
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(@PathVariable(value = "id") Long id, @ModelAttribute PurchasingForm purchasingForm, Model model) {
	
		purchasingFormService.updatePurchasingForm(purchasingForm);

		return "redirect:/purchasingForm";  // aynı formu iki kere gondermesin 
	}
	
}

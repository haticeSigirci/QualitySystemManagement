package tr.org.biotek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tr.org.biotek.model.Person;
import tr.org.biotek.service.PersonService;

@Controller
@RequestMapping(value="/person", produces = "text/plain;charset=UTF-8")
public class PersonController {

	@Autowired
	PersonService personService;
	
	@RequestMapping(value="")
	public String list(Model model) { 
		
		List<Person> people = personService.getPeople();

		model.addAttribute("peopleList", people);
		
		return "personList";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createForm(@ModelAttribute Person person) {
		
		System.out.println("hatice");
		
		System.out.println(person.getName());
		System.out.println(person.getSurname());
		
		return "personForm";
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String create(@ModelAttribute Person person) {	
		
		personService.addPerson(person);
		
		System.out.println("hiiiPOST");
		
		System.out.println(person.getName());
		System.out.println(person.getSurname());

		return "redirect:/person"; // ?? recursive
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET )
	public String edit(@ModelAttribute Person person, Model model, @PathVariable(value="id") Integer id){

		
		Person personNew = personService.getPerson(id);

		model.addAttribute("admin", personNew);

		return "personEdit";
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(@PathVariable(value = "id") Long id, @ModelAttribute Person person, Model model) {
	
		personService.updatePerson(person);

		return "redirect:/person";  // aynı formu iki kere gondermesin 
	}
}

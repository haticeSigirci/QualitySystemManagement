package tr.org.biotek.service;

import java.util.List;
import tr.org.biotek.model.Person;


public interface PersonService {

	public void addPerson(Person person);

	public void updatePerson(Person person);

	public Person getPerson(int id);

	public void deletePerson(int id);

	public List<Person> getPeople();
	
}

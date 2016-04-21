package tr.org.biotek.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tr.org.biotek.dao.PersonDao;
import tr.org.biotek.model.Person;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonDao personDao;
	
	public void addPerson(Person person) {
		
		personDao.addPerson(person);
	}

	public void updatePerson(Person person) {
		
		personDao.updatePerson(person);
		
	}

	public Person getPerson(int id) {
		
		return personDao.getPerson(id);
	}

	public void deletePerson(int id) {
	
		personDao.deletePerson(id);
	}

	public List<Person> getPeople() {
		
		return personDao.getPeople();
	}

}

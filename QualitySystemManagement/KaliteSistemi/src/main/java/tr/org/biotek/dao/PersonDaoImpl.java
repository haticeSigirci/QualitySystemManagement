package tr.org.biotek.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tr.org.biotek.model.Person;

@Repository
public class PersonDaoImpl implements PersonDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addPerson(Person person) {
		getCurrentSession().save(person);
		
	}

	public void updatePerson(Person person) {
		Person personToUpdate = getPerson(person.getId());
		personToUpdate.setName(person.getName());
		personToUpdate.setSurname(person.getSurname());
		personToUpdate.setAge(person.getAge());
		getCurrentSession().update(personToUpdate);
		
	}

	public Person getPerson(int id) {
		Person person = (Person) getCurrentSession().get(Person.class, id);
		return person;
	}

	public void deletePerson(int id) {
		Person person = getPerson(id);
		if (person != null)
			getCurrentSession().delete(person);
		
	}

	@SuppressWarnings("unchecked")
	public List<Person> getPeople() {
		
		System.out.println("hi there");
		
		//Query query = entityManager. createQuery("Select UserName from UserDetails ");
		
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(Person.class);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.setFetchMode("*", FetchMode.JOIN);
		
	 //can be wrong 
		
		
		
		return criteria.list();
	}

}

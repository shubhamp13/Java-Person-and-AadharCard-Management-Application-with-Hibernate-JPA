package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import dto.Aadhaar;
import dto.Person;

public class PersonDao 
{
	public EntityManager getEntityManager()
	{
		return Persistence.createEntityManagerFactory("shubham").createEntityManager();
	}
	public void savePerson(Person person)
	{
		EntityManager entityManager=getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(person);
		entityManager.getTransaction().commit();
	}
	public void updatePerson(int id,Person person)
	{
		EntityManager entityManager=getEntityManager();
		Person dbPerson=entityManager.find(Person.class, id);
		if(dbPerson!=null)
		{
			entityManager.getTransaction().begin();
			person.setId(id);
			person.setAadhaar(dbPerson.getAadhaar());
			entityManager.merge(person);
			entityManager.getTransaction().commit();
		}
		else
		{
			System.out.println("Person not Present");
		}
	}
	public void deletePerson(int id)
	{
		
		EntityManager entityManager=getEntityManager();
		Person dbPerson=entityManager.find(Person.class, id);
		Aadhaar aadhaar=dbPerson.getAadhaar();
		AadharDao aadharDao=new AadharDao();
		aadharDao.deleteAadhar(aadhaar.getId());
		entityManager.getTransaction().begin();
		entityManager.remove(dbPerson);
		entityManager.getTransaction().commit();
		
	}
	public void fetchById(int id)
	{
		EntityManager entityManager=getEntityManager();
		Person dbPerson=entityManager.find(Person.class, id);
		if(dbPerson!=null)
		{
			System.out.println(dbPerson);
		}
		else
		{
			System.out.println("Person Is  not Present");
		}
	}
	public void fetchByName(String name)
	{
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("SELECT p from Person p where p.name=?1");
		query.setParameter(1, name);
		List<Person> list=query.getResultList();
		if(!list.isEmpty())
		{
			for(Person person:list)
			{
				System.out.println(person);
				System.out.println("*******************************************************");
			}
		}
		else
		{
			System.out.println("None record Found");
		}
	}
	public void fetchByAadhharNo(long aadharNo)
	{
		EntityManager entityManager=getEntityManager();
		Aadhaar dbAadhaar=entityManager.find(Aadhaar.class, aadharNo);
		if(dbAadhaar!=null)
		{
			Person dbPerson=dbAadhaar.getPerson();
			System.out.println(dbPerson);
		}
		else
		{
			System.out.println("Invalid Aadhaar Number ");
		}
	}
	public void fetchAllPerson()
	{
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select p from Person p");
		List<Person> list=query.getResultList();
		if(!list.isEmpty())
		{
			for(Person person:list)
			{
				System.out.println(person);
				System.out.println("***********************************************************\n");
			}
		}
		else
		{
			System.out.println("Database is empty");
		}
	}
	public void fetchPersonAadhar(int pId)
	{
		EntityManager entityManager=getEntityManager();
		Person dbPerson=entityManager.find(Person.class, pId);
		Aadhaar dbAadhaar=dbPerson.getAadhaar();
		if(dbPerson!=null)
		{
			System.out.println(dbPerson);
			System.out.println("\n**********************************************************");
			System.out.println(dbAadhaar);
		}
		else
		{
			System.out.println("Person Is  not Present");
		}
	}
	public void fetchAllPersonAadhhar()
	{
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select p from Person p");
		List<Person> list=query.getResultList();
		if(!list.isEmpty())
		{
			for(Person person:list)
			{
				Aadhaar dbAadhaar=person.getAadhaar();
				System.out.println(person);
				System.out.println("***********************************************************\n");
				if(dbAadhaar!=null)
				{
					System.out.println(dbAadhaar);
				}
				else
				{
					System.out.println("Person is Not Registerdd  With Aadhar card Details");
				}
			}
		}
		else
		{
			System.out.println("Database is empty");
		}
	}
}

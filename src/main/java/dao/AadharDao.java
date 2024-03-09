package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.Aadhaar;
import dto.Person;

public class AadharDao 
{
	public EntityManager getEntityManager()
	{
		return Persistence.createEntityManagerFactory("shubham").createEntityManager();
	}
	public void saveAadhar(int id,Aadhaar aadhaar)
	{
		
		EntityManager entityManager=getEntityManager();
		Person person=entityManager.find(Person.class,id);
		if(person!=null)
		{
			entityManager.getTransaction().begin();
			aadhaar.setPerson(person);
			entityManager.persist(aadhaar);
			person.setAadhaar(aadhaar);
			entityManager.merge(person);
			entityManager.getTransaction().commit();
		}
		else
		{
			System.out.println("Invalid Person id");
		}
	}
	public void updateAadhar(long id,Aadhaar aadhaar)
	{
		EntityManager entityManager=getEntityManager();
		Aadhaar dbAadhaar=entityManager.find(Aadhaar.class,id);
		if(dbAadhaar!=null)
		{
			entityManager.getTransaction().begin();
			aadhaar.setId(id);
			aadhaar.setPerson(dbAadhaar.getPerson());
			entityManager.merge(aadhaar);
			entityManager.getTransaction().commit();
		}
		else
		{
			System.out.println("Invalid Aadhar Number");
		}
	}
	public void deleteAadhar(long aadharNo)
	{
		EntityManager entityManager=getEntityManager();
		Aadhaar aadhaar=entityManager.find(Aadhaar.class, aadharNo);
		if(aadhaar!=null)
		{
			entityManager.getTransaction().begin();
			Person person=aadhaar.getPerson();
			person.setAadhaar(null);
			entityManager.remove(aadhaar);
			entityManager.getTransaction().commit();
		}
		else
		{
			System.out.println("Invalid Aadhar No");
		}
	}
	public void fetchAadharId(long id)
	{
		EntityManager entityManager=getEntityManager();
		Aadhaar aadhaar=entityManager.find(Aadhaar.class,id);
		if(aadhaar!=null)
		{
			System.out.println(aadhaar);
		}
		else
		{
			System.out.println("Aadhar Details Not Present");
		}			
	}
	public void fetchByName(String name)
	{
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("SELECT a from Aadhaar a where a.name=?1");
		query.setParameter(1, name);
		List<Aadhaar> list=query.getResultList();
		if(!list.isEmpty())
		{
			for(Aadhaar dbAadhaar:list)
			{
				System.out.println(dbAadhaar);
				System.out.println("*******************************************************");
			}
		}
		else
		{
			System.out.println("None record Found");
		}
	}
	public void fetchByPersonId(int pId)
	{
		EntityManager entityManager=getEntityManager();
		Person dbPerson=entityManager.find(Person.class, pId);
		if(dbPerson!=null)
		{
			Aadhaar dbAadhaar=dbPerson.getAadhaar();
			if(dbAadhaar!=null)
			{
				System.out.println(dbAadhaar);
			}
			else
			{
				System.out.println("Person does not have aadhaar Card");
			}
		}
		else
		{
			System.out.println("Person id incorrect");
		}
	}
	public void fetchAllAadhaar()
	{
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select a from Aadhaar a");
		List<Aadhaar> list=query.getResultList();
		if(!list.isEmpty())
		{
			for(Aadhaar aadhaar:list)
			{
				System.out.println(aadhaar);
				System.out.println("***********************************************************\n");
			}
		}
		else
		{
			System.out.println("Database is empty");
		}
	}
	public void fetchAadhharPerson(long adhaarNo)
	{
		EntityManager entityManager=getEntityManager();
		Aadhaar aadhaar=entityManager.find(Aadhaar.class,adhaarNo);
		Person dbPerson=aadhaar.getPerson();
		if(aadhaar!=null)
		{
			System.out.println("*************************************************************************");
			System.out.println(aadhaar);
			System.out.println("*************************************************************************\n");
			System.out.println(dbPerson);
			System.out.println("*************************************************************************\n");
		}
		else
		{
			System.out.println("Aadhar Details Not Present");
		}
	}
	
}


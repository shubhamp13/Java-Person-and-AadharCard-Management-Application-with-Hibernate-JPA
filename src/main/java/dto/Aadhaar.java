package dto;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import org.hibernate.annotations.GenericGenerator;
@Entity
public class Aadhaar 
{
	
	@Id
	@GeneratedValue(generator = "tweleveDigit",strategy = GenerationType.SEQUENCE)
	@GenericGenerator(strategy ="generator.TweleveDigitId", name = "tweleveDigit")
	private long id;
	private String name;
	private int age;
	@OneToOne (fetch = FetchType.LAZY)
	private Person person;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	@Override
	public String toString() {
		return "Aadhaa Id = " + id + "\n Aadhhar Name = " + name + "\n Aadhhar age = " + age;
	}
	
	
}

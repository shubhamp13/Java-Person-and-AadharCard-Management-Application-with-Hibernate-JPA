package dto;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class Person 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String name;
	private String address;
	@OneToOne(fetch = FetchType.LAZY)
	private Aadhaar aadhaar;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Aadhaar getAadhaar() {
		return aadhaar;
	}
	public void setAadhaar(Aadhaar aadhaar) {
		this.aadhaar = aadhaar;
	}
	@Override
	public String toString() {
		return "Person Id = " + id + "\nPerson Name=" + name + "\nPerson address=" + address;
	}
	
	
}

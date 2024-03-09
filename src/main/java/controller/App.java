package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.persistence.criteria.CriteriaBuilder.In;

import dao.AadharDao;
import dao.PersonDao;
import dto.Aadhaar;
import dto.Person;

public class App {
	public static void main(String[] args) {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Your Choice");
		System.out.println("1.Save The Person Details");
		System.out.println("2.Save The Aadhar Card");
		System.out.println("3.Update The Person Details");
		System.out.println("4.Update The Aadhar Card Details");
		System.out.println("5.Delete The Person Details");
		System.out.println("6.Delete The Aadhar Card Details");
		System.out.println("7.Feth The Records");

		try {
			Person person = new Person();
			PersonDao personDao = new PersonDao();
			Aadhaar aadhaar = new Aadhaar();
			AadharDao aadharDao = new AadharDao();
			int choice = Integer.parseInt(bufferedReader.readLine());
			switch (choice) {
			case 1: {
				System.out.println("Enter Your Name");
				String name = bufferedReader.readLine();
				System.out.println("Enter Your Address");
				String address = bufferedReader.readLine();
				person.setAddress(address.toLowerCase());
				person.setName(name.toLowerCase());
				personDao.savePerson(person);
			}
				break;
			case 2: {
				System.out.println("Enter Person Id");
				int pId = Integer.parseInt(bufferedReader.readLine());
				System.out.println("Enter name for Aadhar card");
				String aadharName = bufferedReader.readLine();
				System.out.println("Enter your Age");
				int age = Integer.parseInt(bufferedReader.readLine());
				aadhaar.setAge(age);
				aadhaar.setName(aadharName.toLowerCase());
				aadharDao.saveAadhar(pId, aadhaar);
			}
				break;
			case 3: {
				System.out.println("Enter Person Id");
				int id = Integer.parseInt(bufferedReader.readLine());
				System.out.println("Enter Name");
				String name = bufferedReader.readLine();
				System.out.println("Enter Address");
				String address = bufferedReader.readLine();
				person.setAddress(address.toLowerCase());
				person.setName(name.toLowerCase());
				personDao.updatePerson(id, person);
			}
				break;
			case 4: {
				System.out.println("Enter Aadhar No");
				long aadharNo = Long.parseLong(bufferedReader.readLine());
				System.out.println("Enter name for Aadhar card");
				String aadharName = bufferedReader.readLine();
				System.out.println("Enter your Age");
				int age = Integer.parseInt(bufferedReader.readLine());
				aadhaar.setAge(age);
				aadhaar.setName(aadharName);
				aadharDao.updateAadhar(aadharNo, aadhaar);

			}
				break;
			case 5: {
				System.out.println("Enter Person id");
				int pId = Integer.parseInt(bufferedReader.readLine());
				personDao.deletePerson(pId);
			}
				break;
			case 6: {
				System.out.println("Enter Aadhar No");
				long aadharNo = Long.parseLong(bufferedReader.readLine());
				aadharDao.deleteAadhar(aadharNo);
			}
				break;
			case 7: {
				System.out.println("Enter your choice");
				System.out.println("1.Fetch Person With Person Id");
				System.out.println("2.Fetch Person details with Aadhar Card details with Person Id");
				System.out.println("3.Fetch Person With Name");
				System.out.println("4.Fetch Person Details With Aadhar Number");
				System.out.println("5.Fetch Aadhaar details with Aadhar No");
				System.out.println("6.Fetch Aadhhar Details and Person Details with Aadhhar No");
				System.out.println("7.Fetch Aadhaar details with Aadhar  Name");
				System.out.println("8.Fecth Aadhaar Details with personId");
				System.out.println("9.Fetch All Person Details");
				System.out.println("10.Fetch all aadhar card details");
				System.out.println("11.Fetch All Person Aadhar Records");
				int ch = Integer.parseInt(bufferedReader.readLine());
				switch (ch) {
				case 1: {
					System.out.println("Enter Person Id");
					int pId = Integer.parseInt(bufferedReader.readLine());
					personDao.fetchById(pId);
				}
					break;
				case 2:
					{
						System.out.println("Enter Person Id");
						int pId=Integer.parseInt(bufferedReader.readLine());
						personDao.fetchPersonAadhar(pId);
					}
					break;
				case 3: {
					System.out.println("Enter Name of The Personn Want To Fetch");
					String name = bufferedReader.readLine();
					personDao.fetchByName(name.toLowerCase());
				}
					break;
				case 4: {
					System.out.println("Enter Person Aadhar Number To display Its Details");
					long aadhaarNo = Long.parseLong(bufferedReader.readLine());
					personDao.fetchByAadhharNo(aadhaarNo);
				}
					break;
				case 5: {
					System.out.println("Enter aadhar Id Details");
					long aadharNo = Long.parseLong(bufferedReader.readLine());
					aadharDao.fetchAadharId(aadharNo);
				}
				break;
				case 6:
					{
						System.out.println("Enter Aadhhar No");
						long aadhharNo=Long.parseLong(bufferedReader.readLine());
						aadharDao.fetchAadhharPerson(aadhharNo);
					}
					break;

				case 7: {
					System.out.println("Enter Name");
					String name = bufferedReader.readLine();
					aadharDao.fetchByName(name.toLowerCase());
				}
					break;
				case 8: {
					System.out.println("Enter Person id to fetch Aadhhar Details");
					int pId = Integer.parseInt(bufferedReader.readLine());
					aadharDao.fetchByPersonId(pId);
				}
					break;
				case 9: {
					personDao.fetchAllPerson();
				}
					break;
				case 10: {
					aadharDao.fetchAllAadhaar();
				}
				break;
				case 11:
				{
					personDao.fetchAllPersonAadhhar();
				}
			 
				default:
					System.out.println("Enter correct choice between 1 to 8");
					break;
				}
			}
				break;
			default:
				System.out.println("Enter Correct Choice 1 to 7");
				break;

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

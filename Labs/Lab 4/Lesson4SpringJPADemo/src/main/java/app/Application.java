package app;

import java.util.List;

import domain.Address;
import domain.CreditCard;
import domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import repositories.CustomerRepository;
import domain.Customer;
import repositories.StudentRepository;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain") 
public class Application implements CommandLineRunner{
	
	@Autowired
	CustomerRepository customerrepository;

	@Autowired
	StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// create customer
		Customer customer = new Customer(101,"John doe", "johnd@acme.com", "0622341678");
		CreditCard creditCard = new CreditCard("12324564321", "Visa", "11/23");
		customer.setCreditCard(creditCard);
		customerrepository.save(customer);
		customer = new Customer(109,"John Jones", "jones@acme.com", "0624321234");
		creditCard = new CreditCard("657483342", "Visa", "09/23");
		customer.setCreditCard(creditCard);
		customerrepository.save(customer);
		customer = new Customer(66,"James Johnson", "jj123@acme.com", "068633452");
		creditCard = new CreditCard("99876549876", "MasterCard", "01/24");
		customer.setCreditCard(creditCard);
		customerrepository.save(customer);

		//get customers
		System.out.println(customerrepository.findById(66).get());
		System.out.println(customerrepository.findById(101).get());
		System.out.println("-----------All customers ----------------");
		System.out.println(customerrepository.findAll());
		//update customer
		customer = customerrepository.findById(101).get();
		customer.setEmail("jd@gmail.com");
		customerrepository.save(customer);
		System.out.println("-----------find by phone ----------------");
		System.out.println(customerrepository.findByPhone("0622341678"));
		System.out.println("-----------find by email ----------------");
		System.out.println(customerrepository.findCustomerWithEmail("jj123@acme.com"));
		System.out.println("-----------find customers with a certain type of creditcard ----------------");
		List<Customer> customers = customerrepository.findCustomerWithCreditCardType("Visa");
		for (Customer cust : customers){
			System.out.println(cust);
		}

		System.out.println("-----------find by name ----------------");
		System.out.println(customerrepository.findByName("John doe"));


		//add 5 students
		Student student = new Student(1,"Phuc Hua", "a@miu.edu", "(702)-111-1111");
		Address address = new Address("1000 Preston", "Dallas", 71237);
		student.setAddress(address);
		studentRepository.save(student);

		student = new Student(2,"Hoang Dinh", "b@miu.edu", "(702)-222-2222");
		address = new Address("2000 Preston", "Plano", 72434);
		student.setAddress(address);
		studentRepository.save(student);

		student = new Student(3,"Nha Doan", "c@miu.edu", "(702)-333-3333");
		address = new Address("3000 Preston", "Plano", 73266);
		student.setAddress(address);
		studentRepository.save(student);

		student = new Student(4,"Mike Ngo", "d@miu.edu", "(702)-444-4444");
		address = new Address("4000 Preston", "Allen", 74233);
		student.setAddress(address);
		studentRepository.save(student);

		student = new Student(5,"Phuc Hua", "e@miu.edu", "(702)-555-5555");
		address = new Address("5000 Preston", "Frisco", 75257);
		student.setAddress(address);
		studentRepository.save(student);

		//get all students
		System.out.println("-----------All students ----------------");
		System.out.println(studentRepository.findAll());

		//get all students with a certain name
		System.out.println("-----------All students with a certain name----------------");
		List<Student> students = studentRepository.findByName("Phuc Hua");
		for (Student stu : students) {
			System.out.println(stu);
		}

		//get a student with a certain phoneNumber
		System.out.println("-----------find by phone----------------");
		System.out.println(studentRepository.findByPhone("(702)-222-2222"));

		//get all students from a certain city
		System.out.println("-----------All students from a certain city----------------");
		students = studentRepository.findStudentFromCity("Plano");
		for (Student stu : students) {
			System.out.println(stu);
		}
	}

}

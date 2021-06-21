package com.sirt.boot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sirt.boot.hibernate.associationmapping.Account;
import com.sirt.boot.hibernate.associationmapping.Author;
import com.sirt.boot.hibernate.associationmapping.Book;
import com.sirt.boot.hibernate.associationmapping.Employee;
import com.sirt.boot.hibernate.associationmapping.MyBook;
import com.sirt.boot.hibernate.associationmapping.Review;
import com.sirt.boot.hibernate.inheritancemapping.CurrentStudent;
import com.sirt.boot.hibernate.inheritancemapping.Student;
import com.sirt.boot.hibernate.inheritancemapping.WeekDaysStudent;
import com.sirt.boot.repository.AuthorRepo;
import com.sirt.boot.repository.BookRepo;
import com.sirt.boot.repository.ReviewRepo;
import com.sirt.boot.repository.TablePerSubClassRepo;

@RestController
@RequestMapping("/hibernate")
public class HibernateController {
	@Autowired
	private TablePerSubClassRepo tpscRepo;
	@Autowired
	private EntityManager em;
	@Autowired
	private BookRepo bookRepo;
	@Autowired
	private ReviewRepo reviewRepo;
	@Autowired
	private AuthorRepo authRepo;

	@GetMapping(path = "/tpsc")
	public String tpscMapping() {
//		WeekDaysStudent wds = new WeekDaysStudent(1, "Anjali", "Sagar", "weekdaysstudent", 7000, 2000, "7am to 9am", "CS", "BE", 75, 2021);
//		tpscRepo.save(wds);
		Session session = em.unwrap(Session.class);
		Transaction transaction = session.beginTransaction();
		Student stu = new Student();
		stu.setSid(101);
		stu.setName("Anu");
		stu.setCity("Bhopal");
		stu.setStatus("current");
		stu.setTotalFee(7000);
		session.save(stu);
		CurrentStudent cStu = new CurrentStudent("Ambe", 2000, "8am to 10am", "CSE");
		cStu.setSid(102);
		session.save(cStu);
		WeekDaysStudent wds = new WeekDaysStudent("Anu", 1000, "2pm to 4pm", "CSE", "Btech", 80, 2021);
		wds.setSid(103);
		session.save(wds);

		transaction.commit();
		session.close();
		return "tpscMapping";
	}

	@GetMapping(path = "/one2one")
	public String oneToOne() {
		Employee employee = new Employee();
		employee.setName("Shail");
		employee.setEmail("shail@gmail.com");

		Account account = new Account();
		account.setAccountNo(7456);
		account.setEmp(employee);
		employee.setAccount(account);
		Session session = em.unwrap(Session.class);
		Transaction transaction = session.beginTransaction();
		session.save(account);
		session.save(employee);
		transaction.commit();
		session.close();
		return "success";
	}

	@GetMapping(path = "/employee")
	public Employee getEmployee() {
		Session session = em.unwrap(Session.class);
		Employee emp = session.find(Employee.class, 2);
		System.out.println(emp.getEmpId() + " " + emp.getName() + " " + emp.getAccount().getAccountNo());
		return emp;
	}

	@GetMapping(path = "/one2many")
	public String oneToMany() {
		Book book = new Book("Modern Java", 550);
		Review review1 = new Review();
		review1.setComment("It is a nice Book");
//		review1.setBook(book);
		Review review2 = new Review();
		review2.setComment("It is a good book, but overpriced");
//		review2.setBook(book);
		List<Review> reviews = book.getReviews();
		reviews.add(review1);
		reviews.add(review2);
		book.setReviews(reviews);
		bookRepo.save(book);
//		reviewRepo.saveAll(reviews);
		return "success";
	}

	@GetMapping(path = "many2many")
	public String manyToMany() {
		Author author1 = new Author();
		author1.setAuthorName("Ambe");
		Author author2 = new Author();
		author2.setAuthorName("Anu");
		MyBook book1 = new MyBook();
		book1.setBookName("Java8");
		List<Author> authors = book1.getAuthors();
		authors.add(author2);
		book1.setAuthors(authors);
		MyBook book2 = new MyBook();
		book2.setBookName("Java11");
		List<Author> authors2 = book2.getAuthors();
		authors2.add(author1);
		authors2.add(author2);
		book2.setAuthors(authors2);
		List<MyBook> books = author2.getBooks();
		books.add(book1);
		books.add(book2);
		author2.setBooks(books);
		List<MyBook> books2 = author1.getBooks();
		books2.add(book1);
		author1.setBooks(books2);
		authRepo.save(author1);
		authRepo.save(author2);
		return "success";
	}

}

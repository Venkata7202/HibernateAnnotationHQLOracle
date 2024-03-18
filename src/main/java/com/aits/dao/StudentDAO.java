package com.aits.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.aits.bean.Student;

import java.util.*;
public class StudentDAO {

	SessionFactory sessionFactory;
	public StudentDAO() {
		// TODO Auto-generated constructor stub
		Configuration cfg=new Configuration().configure("myconfig.cfg.xml");
		sessionFactory=cfg.buildSessionFactory();		
	}
	public String insertStudent(Student student){
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.save(student);
		transaction.commit();
		session.close();
		return "successful";
	}
	public Student updateStudent(String roll){
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Student student=(Student)session.get(Student.class,roll);
		if(student.getBranch().equals("CSE")){
			student.setFname(student.getFname()+" Garu");
			session.update(student);
			transaction.commit();
		}	
		session.close();
		return student;
	}
	public String deleteStudent(String roll){
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Student student=new Student();
		student.setRoll(roll);
		session.delete(student);
		transaction.commit();
		session.close();
		return "successful";
	}
	public Student getStudent(String roll){
		Session session=sessionFactory.openSession();
		Student student=new Student();
		student=session.get(Student.class,roll);
		session.close();
		return student;
    }
	public Student loadStudent(String roll){
		Session session=sessionFactory.openSession();
		Student student=new Student();
		student=session.load(Student.class,roll);
		session.close();
		return student;
    }
	public List<Student> getStudents(){
		Session session=sessionFactory.openSession();
		Query<Student> query=session.createQuery("From STUDENTAITS_TBL");
		return query.list();
	}
	public List<Student> getStudentsByCompany(String company){
		Session session=sessionFactory.openSession();
		Query<Student> query=session.createQuery("From STUDENTAITS_TBL std where std.dcompany=?0");
		query.setParameter(0, company);
		return query.list();
	}
	public List<Student> getStudentsByBranch(String branch){
		Session session=sessionFactory.openSession();
		Query<Student> query=session.createQuery("From STUDENTAITS_TBL std where std.branch=?0");
		query.setParameter(0,branch);
		return query.list();
	}
	public List<Student> getStudentsByAddress(String address){
		Session session=sessionFactory.openSession();
		Query<Student> query=session.createQuery("From STUDENTAITS_TBL std where std.address=?0");
		query.setParameter(0,address);
		return query.list();
	}
	public List<Student> getStudentsTop3(){
		Session session=sessionFactory.openSession();
		Query<Student> query=session.createQuery("From STUDENTAITS_TBL std order by std.fname");
		query.setMaxResults(3);
		return query.list();
	}

}

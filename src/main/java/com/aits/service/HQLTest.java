package com.aits.service;

import java.util.List;
import java.util.Scanner;

import com.aits.bean.Student;
import com.aits.dao.StudentDAO;

public class HQLTest {

	public HQLTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		char ch;
		StudentDAO dao=new StudentDAO();
		Student student;
		List<Student> result=null;
		do{
			System.out.println("Enter Choice for Student HQL operations");
			System.out.println("1-Get all students 2-Get Student by Dcompany 3-Get Student by Branch 4-Get Student by Address 5-Get Top 3 Students by Name");
			int choice=input.nextInt();
			input.nextLine();
			switch(choice){
				case 1:result=dao.getStudents();
					   System.out.println("Student records...");
					   for(Student ob:result)
						   System.out.println(ob);
					   break;
				case 2:System.out.println("Enter Student search by dream company");
					   String company=input.nextLine();
					   result=dao.getStudentsByCompany(company);
				       System.out.println("Student records by dream company...");
				       for(Student ob:result)
				    	   System.out.println(ob);
			       	   break; 
				case 3:System.out.println("Enter Student search by branch");
					   String branch=input.nextLine();
					   result=dao.getStudentsByBranch(branch);
					   System.out.println("Student records by branch...");
					   for(Student ob:result)
						   System.out.println(ob);
					   break;   		   
				case 4:System.out.println("Enter Student search by address");
				   	   String address=input.nextLine();
				       result=dao.getStudentsByAddress(address);
				       System.out.println("Student records by branch...");
				       for(Student ob:result)
				    	   System.out.println(ob);
				       break;	
				case 5:System.out.println("Top 3 students by first name");
			   	   	   result=dao.getStudentsTop3();
			   	   	   System.out.println("Top 3 Students records by first name...");
			   	   	   for(Student ob:result)
			   	   		   System.out.println(ob);
			   	   	   break;	       
		    }
		  System.out.println("Do want to continue press Y or y");
		  ch=input.next().charAt(0);
		}while(ch=='Y'||ch=='y');
	}

}



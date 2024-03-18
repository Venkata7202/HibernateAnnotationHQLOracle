/**
 * 
 */
package com.aits.service;

import java.util.Scanner;

import com.aits.bean.Student;
import com.aits.dao.StudentDAO;

/**
 * @author Administrator
 *
 */
public class StudentTest {

	/**
	 * 
	 */
	public StudentTest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		char ch;
		StudentDAO dao=new StudentDAO();
		Student student;
		do{
			System.out.println("Enter Choice for Student CRUD Operations");
			System.out.println("1-Create(Insert) \t 2-Read(Select)\t 3-Update \t 4-Delete");
			int choice=input.nextInt();
			input.nextLine();
			switch(choice){
				case 1:System.out.println("Enter Student details to Create Record");
				   	   System.out.println("Enter Roll Number...");
				       String roll=input.nextLine();
				       System.out.println("Enter First Name...");
				       String fname=input.nextLine();
				       System.out.println("Enter Last Name...");
				       String lname=input.nextLine();
				       System.out.println("Enter Branch...");
				       String branch=input.nextLine();
				       System.out.println("Enter Address...");
				       String address=input.nextLine();
				       System.out.println("Enter Dream Company...");
				       String dream=input.next();
				       student=new Student(roll,fname,lname,branch,address,dream);				   
				       String result=dao.insertStudent(student);
				       if(result=="successful")
				    	   System.out.println(student);
				       else
						   System.out.println("Record Not inserted");
					   break;
				case 2:System.out.println("Enter Student Roll number  to display student record");
				       System.out.println("Enter Roll Number..");
			           roll=input.nextLine();
			           student=dao.getStudent(roll);
			           if(student!=null)
			        	   System.out.println(student);
			           else
			        	   System.out.println("Record not found");
			       	   break; 
				case 3:System.out.println("Enter Student Roll  to update student record");
			       	   roll=input.nextLine();
			       	   student=dao.updateStudent(roll);
			       	   if(student!=null)
			       		   System.out.println(student);
			       	   else
		        	   System.out.println("Record not found");
			       	   break;   		   
				case 4:System.out.println("Enter Roll Number to delete record...");
			       	    // input.nextLine();
				       roll=input.nextLine();
			       	   String delres=dao.deleteStudent(roll);
			       	   if(delres=="successful")
			       		   System.out.println("Deletion Successful");
			       	   else
			       		   System.out.println("Deletion Un Successful");
			       	   break; 
		  }
		  System.out.println("Do want to continue press Y or y");
		  ch=input.next().charAt(0);
		}while(ch=='Y'||ch=='y');
	}


}



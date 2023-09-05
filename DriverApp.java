package com.greatlearning.app;

import java.util.Scanner;

import com.greatlearning.model.Employee;
import com.greatlearning.service.EmpCredentialsImpl;

public class DriverApp {

	public static void main(String[] args) {

		Scanner sc =new Scanner(System.in);
		System.out.println("Please Enter Employee First Name :");
		String f=sc.next();
		System.out.println("Please Enter Employee Last Name :");
		String l=sc.next();

		Employee emp1=new Employee(f,l);
		//		Employee emp2=new Employee();
		//		emp2.setFname("Shruti");
		//		emp2.setLname("Sharma");

		EmpCredentialsImpl cred=new EmpCredentialsImpl();

		System.out.println("1. Technical");
		System.out.println("2. Admin");
		System.out.println("3. HR");
		System.out.println("4. Legal");

		System.out.println("Please Choose Your Department :");
		int choice=sc.nextInt();
		String genEmail="";
		String genPassword="";
		switch(choice)
		{
		case 1:
			genEmail=cred.generateEmailId(emp1.getFname().toLowerCase(), emp1.getLname().toLowerCase(), "tech");
			break;
		case 2:
			genEmail=cred.generateEmailId(emp1.getFname().toLowerCase(), emp1.getLname().toLowerCase(), "admin");
			break;
		case 3:
			genEmail=cred.generateEmailId(emp1.getFname().toLowerCase(), emp1.getLname().toLowerCase(), "hr");
			break;
		case 4:
			genEmail=cred.generateEmailId(emp1.getFname().toLowerCase(), emp1.getLname().toLowerCase(), "legal");
			break;
		default : 	System.out.println("Please Enter Valid Input :");
		}

		genPassword=cred.generatePassword();
		emp1.setEmailid(genEmail); 
		emp1.setPassword(genPassword);

		cred.showDetails(emp1);
	}
}


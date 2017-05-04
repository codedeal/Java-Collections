package com.sunbeam.collection;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
class Employee implements Comparable<Employee>
{
	private String name;
	private int empid;
	private float salary;
	public Employee()
	{
		this("",0,0);
	}
	public Employee( int empid )
	{
		this("",0,0);
		this.empid = empid;
	}
	public Employee(String name, int empid, float salary)
	{
		this.name = name;
		this.empid = empid;
		this.salary = salary;
	}
	public int getEmpid()
	{
		return empid;
	}
	public void setEmpid(int empid)
	{
		this.empid = empid;
	}
	@Override
	public boolean equals(Object obj)
	{
		if( obj != null )
		{
			Employee other = (Employee)obj;
			if( this.empid == other.empid )
				return true;
		}
		return false;
	}
	@Override
	public int compareTo(Employee other)
	{
		if( this.empid > other.empid )
			return 1;
		else if( this.empid < other.empid )
			return -1;
		else
			return 0;
	}
	@Override
	public String toString()
	{
		return String.format("%-15s%-5d%-7.2f", this.name, this.empid, this.salary );
	}
}
public class Program
{
	static Scanner sc = new Scanner(System.in);
	public static void createArray(Employee[] arr)
	{
		arr[ 0 ] = new Employee("Sandeep", 50, 10000);
		arr[ 1 ] = new Employee("Nitin", 10, 20000);
		arr[ 2 ] = new Employee("Prashant", 40, 30000);
		arr[ 3 ] = new Employee("Mukesh", 20, 40000);
		arr[ 4 ] = new Employee("Yogesh", 30, 50000);
	}
	public static void addEmployee( List<Employee> empList, Employee[] arr )
	{
		for (Employee emp : arr)		
			empList.add(emp);		
	}
	public static  void acceptRecord(int[] arr )
	{
		System.out.print("Enter empid	:	");
		arr[ 0 ] = sc.nextInt();
	}
	public static Employee findEmployee( List<Employee> empList, int empid )
	{
		Employee key = new Employee(empid);
		int index = empList.indexOf(key);
		if( index != -1 )
			return empList.get(index);
		return null;
	}
	public static boolean removeEmployee( List<Employee> empList, int empid )
	{				
		Employee key = new Employee(empid);
		if( empList.contains(key))
		{
			empList.remove(key);
			return true;
		}
		return false;
	}
	public static void printRecord(Employee emp )
	{
		if( emp != null )
			System.out.println(emp.toString());
		else
			System.out.println("Employee not found");
	}
	public static void printEmployee( List<Employee> empList)
	{
		for (Employee emp : empList)
			System.out.println(emp.toString());
	}
	public static void printEmployee_Sorted( List<Employee> empList)
	{
		Collections.sort(empList);
		Program.printEmployee(empList);
	}
	public static int menuList()
	{
		System.out.println("0.Exit");
		System.out.println("1. Add Employee");
		System.out.println("2. Find Employee");
		System.out.println("3. Remove Employee");
		System.out.println("4. Print Employee");
		System.out.println("5. Print Employee(Sorted)");
		System.out.print("Enter choice	:	");
		return  sc.nextInt();
	}
	public static void main(String[] args)
	{	
		int choice;
		int[] empid = new int[ 1 ];
		List<Employee> empList = new LinkedList<Employee>();
		while(( choice = Program.menuList( ) ) != 0 )
		{
			switch( choice )
			{
				case 1:
					Employee[] arr = new Employee[ 5 ];
					Program.createArray(arr);
					Program.addEmployee( empList, arr );
					break;
				case 2:					 
					Program.acceptRecord(empid);
					Employee emp = Program.findEmployee( empList, empid[ 0 ]);
					Program.printRecord(emp);
					break;
				case 3:					 
					Program.acceptRecord(empid);
					System.out.println( Program.removeEmployee( empList, empid[ 0 ] )?"Removed":"Not Removed");
					break;
				case 4:
					Program.printEmployee( empList );
					break;
				case 5:
					Program.printEmployee_Sorted(empList);
					break;
			}
		}
		
	}
}

package com.sunbeam.collection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
class Vehicle
{
	private String companyName;
	private String modelName;
	private String plateNumber;
	public Vehicle()
	{
		this("","","");
	}
	public Vehicle(String companyName, String modelName, String plateNumber)
	{
		this.companyName = companyName;
		this.modelName = modelName;
		this.plateNumber = plateNumber;
	}
	public String getPlateNumber()
	{
		return plateNumber;
	}
	public void setPlateNumber(String plateNumber)
	{
		this.plateNumber = plateNumber;
	}
	@Override
	public boolean equals(Object obj)
	{
		if( obj != null )
		{
			Vehicle other = ( Vehicle )obj;
			if( this.plateNumber.equals(other.plateNumber))
				return true;
		}
		return false;
	}
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result	+ ((plateNumber == null) ? 0 : plateNumber.hashCode());
		return result;
	}
	@Override
	public String toString()
	{
		return String.format("%-15s%-15s%-15s", this.companyName, this.modelName, this.plateNumber);
	}
}
class Customer
{
	private String name;
	private String address;
	private String mobileNumber;
	public Customer()
	{
		this("","","");
	}
	public Customer(String name, String address, String mobileNumber)
	{
		this.name = name;
		this.address = address;
		this.mobileNumber = mobileNumber;
	}	
	public String getName()
	{
		return name;
	}
	@Override
	public String toString()
	{
		return String.format("%-15s%-15s%-15s", this.name, this.address, this.mobileNumber);
	}
}
public class Program
{
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	public static void createVehicleArray(Vehicle[]arr)
	{
		arr[ 0 ] = new Vehicle("Honda", "Shine", "MH-12,2042");
		arr[ 1 ] = new Vehicle("Hero", "Spelnder", "MH-14,3015");
		arr[ 2 ] = new Vehicle("Suzuki", "Samurai", "MH-15,1122");
		arr[ 3 ] = new Vehicle("Yamaha", "RX-100", "MH-16,7142");
		arr[ 4 ] = new Vehicle("Bajaj", "Pulsar", "MH-17,1234");
	}
	public static void createCustomerArray(Customer[]arr)
	{
		arr[ 0 ] = new  Customer("Sandeep", "A.Nagar", "12345");
		arr[ 1 ] = new  Customer("Mukesh", "Satara", "12346");
		arr[ 2 ] = new  Customer("Amit", "Pune", "12347");
		arr[ 3 ] = new  Customer("Umesh", "Sangali", "12348");
		arr[ 4 ] = new  Customer("Sachin", "Kolhapur", "12349");
	}
	public static void addVehicle( Map<Vehicle, Customer> vehicleList, Vehicle[] keys,  Customer[] values )
	{
		for( int index = 0; index < keys.length; ++ index )
		{
			vehicleList.put(keys[ index ], values[ index ] );
		}
	}
	public static Customer findCustomer(Map<Vehicle, Customer> vehicleList, String plateNumber )
	{
		Vehicle key = new Vehicle();
		key.setPlateNumber(plateNumber);
		
		if( vehicleList.containsKey(key))
		{
			Customer value = vehicleList.get(key);
			return value;
		}
		return null;
	}
	public static boolean removeVehicle( Map<Vehicle, Customer> vehicleList, String plateNumber )
	{
		Vehicle key = new Vehicle();
		key.setPlateNumber(plateNumber);
		
		if( vehicleList.containsKey(key))
		{
			vehicleList.remove(key);
			return true;
		}
		return false;
	}
	public static void printCustomer( Customer customer )
	{
		if( customer != null )
			System.out.println(customer.toString());
		else
			System.out.println("Customer not found");
	}
	public static void printRecord( Map<Vehicle, Customer> vehicleList )
	{
		Set<Map.Entry<Vehicle, Customer>> entries = vehicleList.entrySet();
		for (Map.Entry<Vehicle, Customer> entry : entries)
		{
			Vehicle key = entry.getKey();
			Customer value = entry.getValue();
			System.out.println(value.getName()+"	"+key.toString());
		}
	}	
	public static int menuList()throws IOException
	{
		System.out.println("0.Exit");
		System.out.println("1.Add Vehicle");
		System.out.println("2.Find customer");
		System.out.println("3.Remove vehicle");
		System.out.println("4.Print record");
		System.out.print("Enter choice	:	");
		return Integer.parseInt(reader.readLine());
	}
	public static void main(String[] args)
	{	
		try
		{
			int choice;
			String plateNumber = "";
			Map<Vehicle, Customer> vehicleList = new HashMap<Vehicle, Customer>();
			while( ( choice = Program.menuList( ) ) != 0 )
			{
				switch( choice )
				{
					case 1:
						Vehicle[]vehicles = new Vehicle[ 5 ];
						Program.createVehicleArray(vehicles);
						Customer[] customers = new Customer[ 5 ];
						Program.createCustomerArray(customers);
						Program.addVehicle(vehicleList, vehicles, customers);
						break;
					case 2:
						System.out.print("Enter plate number");
						plateNumber = reader.readLine();
						Customer customer = Program.findCustomer(vehicleList, plateNumber);
						Program.printCustomer(customer);
						break;
					case 3:
						System.out.print("Enter plate number");
						plateNumber = reader.readLine();
						System.out.println(Program.removeVehicle(vehicleList, plateNumber)?"Vehicle Removed" : "Vehicle not removed");
						break;
					case 4:
						Program.printRecord(vehicleList);
						break;
				}
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}			
	}
}

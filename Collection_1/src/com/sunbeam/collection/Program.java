	package com.sunbeam.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Program
{
	public static void main(String[] args)
	{
		Collection<Integer> collection = new LinkedList<Integer>();
		collection.add(10);
		collection.add(20);
		collection.add(30);
		
		List<Integer> list = new ArrayList<Integer>( collection );
		list.add(40);
		list.add(50);
		
		for( int index = 0; index < list.size(); ++ index )
		{
			int element = list.get(index);
			System.out.print(element+"	");
		}
		System.out.println();
	}
}

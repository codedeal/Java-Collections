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
		collection.add(30);
		collection.add(40);
		collection.add(50);
		
		List<Integer> list = new ArrayList<Integer>( );
		list.add(10);
		list.add(20);
		list.add(60);
		list.add(70);
		
		list.addAll(2, collection);
		
		for( int value : list )
		{
			System.out.println(value);
		}
	}
}

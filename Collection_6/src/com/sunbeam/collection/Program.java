package com.sunbeam.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Program
{
	public static void main(String[] args)
	{
		List<Integer> list = new ArrayList<Integer>( );
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		
		Collection<Integer> collection = new ArrayList<Integer>();
		collection.add(20);
		collection.add(40);
		
		if( list.containsAll(collection))
		{
			list.retainAll(collection);
		}
		for( int value : list )
			System.out.println(value);
	}
}

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
		Collection<Integer> collection = new LinkedList<Integer>();
		collection.add(30);
		collection.add(40);
		collection.add(50);
		
		List<Integer> list = new ArrayList<Integer>( );
		list.add(10);
		list.add(20);		
		list.addAll(collection);
		
		ListIterator<Integer> itr = list.listIterator();
		while( itr.hasNext())
		{
			System.out.print(itr.next()+"	");
		}
		System.out.println();
		while( itr.hasPrevious())
		{
			System.out.print(itr.previous()+"	");
		}
	}
}

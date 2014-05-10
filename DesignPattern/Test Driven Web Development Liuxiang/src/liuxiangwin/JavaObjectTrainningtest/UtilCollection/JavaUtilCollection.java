package liuxiangwin.JavaObjectTrainningtest.UtilCollection;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class JavaUtilCollection {
   public static void main(String args[])
   {
	  List list1=new ArrayList();
	  
	  
	  List list2=new LinkedList();
	  
	  
	  List list3=new Vector();
	   
      String[] array=new String[]{"Alan","Mike","Jack","Eric"};
      //Put something into collection
      for(int i=0;i<array.length;i++)
      	{
    	    list1.add(array[i]);
      	}
      //Push out something out of collection
	  for(Iterator iterator=list1.iterator();iterator.hasNext();)
	  	{
		 System.out.println(iterator.next()); 
	  	}
   }

   private static void HashTable()
   {
	   Hashtable hashTable=new Hashtable();
	   
	   hashTable.put("Alan", "IGT");
	   
	   hashTable.put("Jackie", "Google");
	   
	   hashTable.put("Erica", "Zara");
	   
	   
	   for(Enumeration en=hashTable.keys();en.hasMoreElements();)
	   {
		 /*String company= (String)hashTable.get(en);
		 System.out.println(company);
		 */
		 
//		 String company2= (String)hashTable.get(en.nextElement());
//		 System.out.println(company2);
		   
	   }
	   
	   for(Enumeration en=hashTable.elements();en.hasMoreElements();)
	   {		
		   
		 //String company2= (String)en.nextElement();
		 //System.out.println(company2);
		   
	   }
	   
	   for(Iterator en=hashTable.entrySet().iterator();en.hasNext();)
	   {		
		   
		 String company2= (String)en.next();
		 System.out.println("==="+company2);
		   
	   }
   }


}

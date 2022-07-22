import java.util.*;

public class collectionAssisted {

	public static void main(String[] args) {
	    ArrayList<String> city=new ArrayList<String>();
		Vector<Integer> vec = new Vector();
		LinkedList<String> names=new LinkedList<String>();  
		 Iterator<String> itr=names.iterator(); 
		 HashSet<Integer> set=new HashSet<Integer>(); 
		 LinkedHashSet<Integer> set2=new LinkedHashSet<Integer>(); 
	   
	      city.add("Mangalore");
	      city.add("Pune"); 
	      city.add("Mysore")
	      System.out.println("ArrayList");
	      System.out.println(city+"\n"); 
	      
	      
		  vec.addElement(15); 
	      vec.addElement(30); 
	      vec.addElement(45);
	      System.out.println("Vector");
	      System.out.println(vec);
	      
	   
	      names.add("Alex");  
	      names.add("John");  
	      names.("Adam")
	      System.out.println("LinkedList");
	      while(itr.hasNext()){  
	       System.out.println(itr.next()); 
	       System.out.println("\n");
	       
	       
	       set.add(101);  
	       set.add(103);  
	       set.add(102);
	       set.add(104);
	       System.out.println("HashSet");
	       System.out.println(set +"\n");
	        
	       set2.add(11);  
	       set2.add(13);  
	       set2.add(12);
	       set2.add(14);
	       System.out.println("LinkedHashSet");
	       System.out.println(set2);
	      	} 
	      }  
	}

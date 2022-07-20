class EmpInfo{
	int id=10;
	String name="raj";

       //default constructor
        EmpInfo(){
        System.out.println("Default constructor");
       }

       //parametarized constructor
        EmpInfo(int id){
           this.id=id;
        System.out.println("Parametarized  constructor");
       }
        EmpInfo(int id,String name){
           this.id=id;
           this.name=name;
        System.out.println("Parametarized  constructor");
       }

public void display() {
	System.out.println(id+" "+name);
	}
}

public class Main {

public static void main(String[] args) {
          EmpInfo emp3=new EmpInfo();
          emp3.display();
     
           EmpInfo emp2=new EmpInfo(112);
          emp2.display();
          
           EmpInfo emp=new EmpInfo(223,"mahesh");
          emp.display();
	
	}
}

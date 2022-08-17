import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class searchEmailID{
    ArrayList <String> list = new ArrayList<String>();
     public searchEmailID(String arr[]){
           for(int i=0;i<arr.length;i++){
                list.add(arr[i]);  
               }
            }
 
    public boolean getEmail(String email){
            for (String s : list){
             if (s.contains(email)){
               return true;
         }
         
      }
      return false;
    }
    
   public static void main(String[] args){
           String arr[]={"abc@gmail.com","def@gmail.com","ijk@gmail.com","lmn@gmail.com","opq@gmail.com","rst@gmail.com","uvw@gmail.com","xyz@gmail.com"};
           searchEmailID fe=new searchEmailID(arr);
           
           Scanner sc= new Scanner(System.in);
           System.out.print("Enter a email: ");
           String str= sc.nextLine();
           boolean b=fe.getEmail(str);
           if(b==true){
               System.out.println(str+" is present in this array");
           }else{
               System.out.println(str+" is not present in this array");
           }
           
   }
}
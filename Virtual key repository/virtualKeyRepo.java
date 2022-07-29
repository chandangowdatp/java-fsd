import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class virtualKeyRepo {
	

	public static void main(String[] args) {
		//Welocome screen
        System.out.println("\n****************************************************************************\n");
        System.out.println("\t      Welcome to Repository Management\n");
        System.out.println("****************************************************************************");
        System.out.println("\t  It is a virtual key for your repository");
        System.out.println("\n\nDeveloped by,\n\tChandangowda T P");
        optionsSelection();
	}
	
	private static void optionsSelection() {
		//Main directory
        System.out.println("\n\n--------- Main Directory -----------\n");
		File f = new File("C:\\Users\\chandan\\Desktop");
        String[] arr = {"1. I wish to list current File",
                "2. I wish to perform actions",
                "3. I wish to close application"
        };
        
        int[] arr1 = {1,2,3};
        int  slen = arr1.length;
        for(int i=0; i<slen;i++){
            System.out.println(arr[i]);
        }
        System.out.println("\nEnter your choice:\t");
        Scanner sc = new Scanner(System.in);
        int  options =  sc.nextInt();
                switch (options){
                    case 1:
                    	System.out.println("These are the list of files present in the current directory");
                    	String[] pathnames;
                        pathnames = f.list();
                        String[]  sortedPaths=sortFiles(pathnames);
                        for (String pathname : sortedPaths) {
                            System.out.println(pathname);
                        }
                        optionsSelection();
                        break;
                    case 2:
                    	selectedAction(f); 
                        break;
                    case 3:
                    	closeApp();
                        break;

                    default:
                        System.out.println("You have made an invalid choice!");
                        optionsSelection();
                        break;
                    
                }
                sc.close();
	}
	
	private static void selectedAction(File f) {
        String[] arr = {"\n\n1.I wish to Add File ",
                "2.I wish to Delete File",
                "3.I wish to Search File",
                "4.I wish to Main context"
        };
        
        int[] arr1 = {1,2,3,4};
        int  slen = arr1.length;
        for(int i=0; i<slen;i++){
            System.out.println(arr[i]);
        }
        System.out.println("\nEnter your choice:\t");
        Scanner in = new Scanner(System.in);
        int  options =  in.nextInt();
                switch (options){
                    case 1:
                    	try {
                    	System.out.println("\nEnter file name that you want to add:\t");
                    	String name = in.next();
                    	addFiles(name); 
                    	}catch(Exception e){
                            e.printStackTrace();
                        }
                        selectedAction(f);
                        break;
                    case 2:
                    	System.out.println("\nEnter file name that you want to delete:\t");
                    	String fname2=in.next();
                    	deleteFiles(fname2);
                    	selectedAction(f);
                        break;
                    case 3:
                    	System.out.println("\nEnter file name that you want to search:\t");
                    	String fname3=in.next();
                    	int index=searchFile(f,fname3);
                        String res=index > -1 ?  fname3+" is present in the sorted list at position : " + (index+1) : fname3+" is is not found in the the list.";
                        System.out.println(res);
                    	selectedAction(f);
                        break;
                    case 4:
                    	optionsSelection();
                        break;
                    default:
                        System.out.println("You have made an invalid choice!");
                        selectedAction(f);
                        break;
                }
                in.close();
	}
    private static void addFiles(String fname) {
    	File fnew= new File("C:\\Users\\chandan\\Desktop\\"+fname);
        try {
        boolean result; 
        result = fnew.createNewFile();  
         if(result)  
         {  
          System.out.println("file created "); 
          }  
          else  
         {  
           System.out.println("File already exist at location: "+fnew.getCanonicalPath());  
         }  

       }
       catch(IOException e){
        e.printStackTrace();
         }
    }
	
    private static void deleteFiles(String fname) {
    	
    	File fnew= new File("C:\\Users\\chandan\\Desktop\\"+fname);
    	try {
        	boolean res=fnew.delete();
         if(res)  
         {  
          System.out.println("file deleted "); 
          }  
          else  
         {  
           System.out.println("File not found!!");  
         }  
	}catch(Exception e){
        e.printStackTrace();
    }
    }
    
    private static int searchFile(File f,String fname) {
    	String[] filenames;
    	filenames = f.list();
        String[]  sortedPaths=sortFiles(filenames);
        for (int i = 0; i < sortedPaths.length; i++) {
            if (sortedPaths[i].equals(fname)) {
                return i;
            }
        }

        return -1;
    }
    
    private static void closeApp() {
        System.out.println("Closing your application... \nThank you!");
            }

    private static String[] sortFiles(String[] pathnames) {
        int len =  pathnames.length;
       //Complete the method. The expenses should be sorted in ascending order.
          for (int i = 0; i < len; i++) {

          for (int j = len - 1; j > i; j--) {
              if (pathnames[i].compareTo(pathnames[j])>0) {

                  String tmp = pathnames[i];
                  pathnames[i]= pathnames[j];
                  pathnames[j]=tmp;

              }

          }

      }
          return pathnames;
    }

}
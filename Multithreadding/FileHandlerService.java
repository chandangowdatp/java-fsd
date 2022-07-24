import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
public class FileHandlerService {


    public void readData(File file) {
    try {
          FileReader rfile=new FileReader(file);    
          int i;    
          while((i=rfile.read())!=-1) {   
          System.out.print((char)i);    
          }
          rfile.close(); 
    }
    catch(IOException e){
     e.printStackTrace();
      }
    }

    public void Write(File file) {  
    try {
           FileWriter filew=new FileWriter(file);    
           filew.write("This is an example for write the file.");    
           filew.close();   
    }
    catch(IOException e){
     e.printStackTrace();
      } 
}

    public void Append(File file) {
    try {
         String data = " This is an example for append data";
         FileWriter fileWritter = new FileWriter("C:\\Users\\chandan\\Desktop\\"+file.getName(),true);
         BufferedWriter bw = new BufferedWriter(fileWritter);
         bw.write(data);
         bw.close();
         System.out.println("\nFile append is done.");
    }
    catch(IOException e){
     e.printStackTrace();
      }
    }

  public File FileCreate(){

     File file = new File("C:\\Users\\chandan\\Desktop\\DemoFile.txt");
    try {
     boolean result; 
     result = file.createNewFile();  
      if(result)  
      {  
       System.out.println("file created "+file.getCanonicalPath()); 
       }  
       else  
      {  
        System.out.println("File already exist at location: "+file.getCanonicalPath());  
      }  

    }
    catch(IOException e){
     e.printStackTrace();
      }
return file;
}
    
   public static void main(String[] args)   
  {    
     FileHandlerService fhs =new FileHandlerService();
   File file= fhs.FileCreate();
   fhs.readData(file);
   fhs.Write(file);
   fhs.Append(file);
}  
}
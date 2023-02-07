
package final_restaurant;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class File_Basic {
    
    private static Scanner scanner;
    public static String[] Item=new String[50];
    public static String[] price=new String[50];
    
    public static void main(String[] args) {
        
    }
    
   public static void saveRecord(String name,String amount,String filepath){
        try {
            FileWriter fw=new FileWriter(filepath,true);
            BufferedWriter bw=new BufferedWriter(fw);
            PrintWriter pw=new PrintWriter(bw);
            
            pw.println(name+","+amount);
            pw.flush();
            pw.close();
            
            JOptionPane.showMessageDialog(null, "Record saved");
        } catch (IOException ex) {
           JOptionPane.showMessageDialog(null, "Record not saved");
        }
       
   }
   
   public static int ReadRecord(String filepath){
       int i=0;
        try {
            scanner=new Scanner(new File(filepath));
            scanner.useDelimiter("[,\n]");
            while(scanner.hasNext()){
                Item[i]=scanner.next();
                price[i]=scanner.next();
                i++;
            }
            scanner.close();
            System.out.println(i);
        } catch (FileNotFoundException ex) {
            
        }
        return i;
       
   }
      public static Boolean SearchRecord(String filepath,String item){
    int i=0;
        try {
            scanner=new Scanner(new File(filepath));
            scanner.useDelimiter("[,\n]");
            while(scanner.hasNext()){
                if(scanner.next().equalsIgnoreCase(item)){
                    i++;
                }
            }
            scanner.close();
            System.out.println(i);
            
        } catch (FileNotFoundException ex) {
            
        }
        if(i==0){
                return false;
            }
            else{
                return true;
            }
}

        public  static void removeRecord(String filepath, String removeTerm, int positionOfTrem, String delimeter) {
       
      int  position = positionOfTrem - 1;
            String tempfile = "temp.txt";
            File oldfile = new File (filepath);
            File newfile = new File (tempfile);
            
            String currentline;
            String data[];
            try{
                FileWriter fw = new FileWriter (tempfile,true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter (bw);
                
                FileReader fr = new FileReader (filepath);
                BufferedReader br =new BufferedReader (fr);
                
                while((currentline = br.readLine())!=null){
                data = currentline.split(",");
                if(!(data[position].equalsIgnoreCase(removeTerm))){
                    pw.println(currentline);
                }
                if((data[position].equalsIgnoreCase(removeTerm))){
                    JOptionPane.showMessageDialog(null, "Item successfully Deleted");
                }
            }
                pw.flush();
                pw.close();
                fr.close();
                br.close();
                bw.close();
                fw.close();
                oldfile.delete();
                if(oldfile.exists()){
                    JOptionPane.showMessageDialog(null, "File not deleted");
                }
                else{
                File dump = new File(filepath);
                newfile.renameTo(dump);
                }
            }
            catch(Exception e){
                
            }
            
    }
}

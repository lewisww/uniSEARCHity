import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class Database {
 private static ArrayList <University> universities = new ArrayList <University>();
 public static void main(String[] args) throws IOException {
  File test = new File("test.csv");
  int check = upload(test);
  if(check == 1)
   System.out.println("Not enough input");
  
  
 }
 /**
  * private String name;
    private float averageGpa;
    private int numStudents;
    private double admissionRate;
    private ArrayList<String> majors;
  * @param csv
  * @return
  * @throws IOException
  */
 
 public static int upload(File csv) throws IOException {
  
  BufferedReader reader = new BufferedReader(new FileReader(csv));
  String line;
  String name = "";
  float averageGpa = 0;
  int numStudents = 0;
  double admissionRate = 0;
  ArrayList<String> majors = new ArrayList<String>();
  while((line = reader.readLine()) != null) {
   String[] values = line.split(",");
   if(values.length < 5)
    return 0; //not enough data to create a university object
   for(int i = 0; i < values.length; i++) {
    switch(i) {
    case 0:
     name = values[i];
     break;
    case 1:
     averageGpa = Float.parseFloat(values[i]);
     break;
    case 2:
     numStudents = Integer.parseInt(values[i]);
     break;
    case 3:
     admissionRate = Double.parseDouble(values[i]);
     break;
    default:
     majors.add(values[i]);
      break;
    }
    University uni = new University(name, averageGpa, numStudents, admissionRate, majors);
    universities.add(uni);
    
    return 0;
   }
   
   
  }
  
  
  
  
  return 0;
 }
 
 

}

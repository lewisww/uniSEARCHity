import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * This is a class that creates a database object, which stores university array lists,
 * and adds universities through csv values
 * 
 * @author Charles Harders
 *
 */
public class Database {
	private static ArrayList <University> universities = new ArrayList <University>();
	private String name = "";
	
	public Database() {
        
    }
	public Database(String name) {
        this.name = name;
    }
	public ArrayList <University> getUniversities(){
		return universities;
	}
	
	public static void main(String[] args) throws IOException {
		File test = new File("/Users/hardersc/Desktop/Miami/CSE 201/src/test.csv");
		int check = addUniversity(test);
		if(check == 1)
			System.out.println("Not enough input");
		
		System.out.println(universities.get(0).getName());
		System.out.println(universities.get(1).getName());
		System.out.println(universities.get(0).getMajors().get(2));
		System.out.println(universities.get(1).getMajors().get(1));
		System.out.println(universities.size());
		Scanner input = new Scanner(System.in);
		account.createAccount(input);
		
	}
	/**
	 * This method returns the University at a given index of an University array list
	 * 
	 * @param index The index of the university that you are getting
	 *                 userProgress class - logIn method.
	 * @return The university at the index of index 
	 */
	public University getUniversity(int index) {
		return universities.get(index);
	}
	/**
	 * This method adds a university to the Universities array list, given the university
	 * 
	 * @param uni The university object being added to the array list
	 */
	public static void addUniversity(University uni) {
		universities.add(uni);
	}
	/**
	 * This method takes in a csv value, and goes through the file and takes each piece of data to use it 
	 * to create a new university object.  It adds each University object to the Universities ArrayList.
	 * If there are not enough values to fill a University object, then the method returns 1.
	 * 
	 * @param csv A file object linking to a csv that will be parsed through for its contents
	 * @return 0 if no errors, 1 if there is not enough values to create a new object
	 * @throws FileNotFoundException
	 */
	public static int addUniversity(File csv) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(csv));
		String line;
		String name = "";
		float averageGpa = 0;
		int numStudents = 0;
		double admissionRate = 0;
		
		while((line = reader.readLine()) != null) {
			ArrayList<String> majors = new ArrayList<String>();
			String[] values = line.split(",");
			if(values.length < 5)
				return 1; //not enough data to create a university object
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
				
			}	
			University uni = new University(name, averageGpa, numStudents, admissionRate, majors);
			universities.add(universities.size(), uni);
		}
		return 0;
	}
}

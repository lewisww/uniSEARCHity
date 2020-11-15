import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Search {
	
	public Search() {

	}
	
	public static void main(String[] args) throws IOException {
		Scanner read = null;
		try {
			// File test = new File("/Users/francieoneil/eclipse-workspace/201GUI/src/collegeList.csv");
			// System.out.println(test.exists());
			System.out.print("Search for university: ");
			read = new Scanner(System.in);
			String a = read.nextLine();
			searchCsvLine(0, a);

		
			} catch (Exception e) {
				System.out.print(e);
			}
		    
		finally {
			read.close();
		}
	}
	public static void searchCsvLine(int col, String str) throws IOException {
	   // String resultRow = null;
	    File fil = new File("/Users/francieoneil/eclipse-workspace/201GUI/src/collegeList.csv");
	    BufferedReader br = new BufferedReader(new FileReader(fil));
	    String line;
	    int count = 0;
	    while ((line = br.readLine()) != null ) {
	        String[] val = line.split(",");
	        if(val[col].equals(str)) {
	            System.out.println(line);
	            count++;
	        }
	    }
	    if (count == 0) {
	    	System.out.println("University Not Found");
	    }
	    br.close();
	}

	public static ArrayList<University> searchName(ArrayList<University> list, String name) {
		ArrayList<University> result = new ArrayList<>();
		for (University u : list) {
			if (u.getName().equals(name)) {
				result.add(u);
			}
		}
		return result;
	}

	public static ArrayList<University> searchGPA(ArrayList<University> list, double min, double max) {
		ArrayList<University> result = new ArrayList<>();
		for (University u : list) {
			if (u.getAverageGPA() >= min && u.getAverageGPA() <= max) {
				result.add(u);
			}
		}
		return result;
	}
	
	public static ArrayList<University> searchNum(ArrayList<University> list, int min, int max) {
		ArrayList<University> result = new ArrayList<>();
		for (University u : list) {
			if (u.getNumStudents() >= min && u.getNumStudents() <= max) {
				result.add(u);
			}
		}
		return result;
	}
	
	public static ArrayList<University> searchRate(ArrayList<University> list, double min, double max) {
		ArrayList<University> result = new ArrayList<>();
		for (University u : list) {
			if (u.getAdmissionRate() >= min && u.getAdmissionRate() <= max) {
				result.add(u);
			}
		}
		return result;
	}
	
	public static ArrayList<University> searchMajor(ArrayList<University> list, String major) {
		ArrayList<University> result = new ArrayList<>();
		for (University u : list) {
			if (u.getMajors().contains(major)) {
				result.add(u);
			}
		}
		return result;
	}
}
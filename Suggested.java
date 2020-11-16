import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Suggested class takes a student's GPA, intended major in college, and intended size for the university and gives them a suggestion for universities to look into
 * @author francieoneil
 *
 */
public class Suggested {
	private static double givenGPA;
	private static String givenMajor;
	private static String givenSize;
    public Suggested(double g, String m, String s) {
    	givenGPA = g;
    	givenMajor = m;
    	givenSize = s;
    }  
    public ArrayList<University> finalSchools() {
    	ArrayList<University> ret = new ArrayList<University>();
    	try {

//        	ArrayList<String> major = new ArrayList<String>();
//        	major.add("English");
//        	major.add("Physics");
//        	ArrayList<String> major2 = new ArrayList<String>();
//        	major2.add("English");
//        	major2.add("Biology");
//        	University u = new University("Miami", (float)3.2, 17000, 70.9, major);
//        	University u2 = new University("OSU", (float)3.0, 66000, 70.9, major2);
//        	University u3 = new University("Dayton", (float)3.7, 3000, 70.9, major2);
//        	University u4 = new University("Boston", (float)4.0, 9000, 70.9, major);
//        	// System.out.println(u.toString());
        	Database db = new Database();
//        	Database.addUniversity(u);
//        	Database.addUniversity(u2);
//        	Database.addUniversity(u3);
//        	Database.addUniversity(u4);
        	File f = new File("collegeList-2.csv");
        	Database.addUniversity(f);
            ArrayList<University> one = getSuggGPA(db);
            ArrayList<University> two = getSuggMajor(db);
            ArrayList<University> three = getSuggSize(db, givenSize);
           // int count = 0;
            ret = new ArrayList<University>();
          //  while (count < 4) {
            	for (int i = 0; i < one.size();i++) {
            		if (two.contains(one.get(i)) && three.contains(one.get(i)))  {
            			ret.add(one.get(i));
            		//	count++;
            		// }
            	}
            }
       		}
            catch (Exception e) {
            	System.out.println(e);
            }

        return ret;

    }
/**
 * The getSuggGPA method takes the student's GPA and gives them universities that are within a range of .3
 * @param d is the given GPA by the user
 * @param db the database the universities are stored in
 * @return a list of universities within the GPA range
 */
    public static ArrayList<University> getSuggGPA(Database db) {
        ArrayList<University> use = db.getUniversities();
        ArrayList<University> ret = new ArrayList<University>();
        double max = givenGPA + .30;
    	double min = givenGPA - .30;
        for (int i = 0; i < use.size(); i++) {
            if (use.get(i).getAverageGPA() > min && use.get(i).getAverageGPA() < max)
                ret.add(use.get(i));
        }
        return ret;
    }
/**
 * The getSuggMajor method takes the major the user gives and returns a list of universities with that major
 * @param s intended major given by user
 * @param db the database the universities are stored in
 * @return a list of universities with the major
 */
    public static ArrayList<University> getSuggMajor(Database db) {
        ArrayList<University> use = db.getUniversities();
        ArrayList<University> ret = new ArrayList<University>();
        for (int i = 0; i < use.size(); i++) {
            for (int j = 0; j < use.get(i).getMajors().size(); j++) {
                if (use.get(i).getMajors().get(j).equals(givenMajor))
                    ret.add(use.get(i));
            }
        }
        return ret;
    }

/**
 * The getSuggSize method takes the intended size of universities the user wants (either S M or L) and returns a list of universities within that size range
 * @param db the database the universities are stored in
 * @param let The input S M or L from user to indicate small medium or large range
 * @return a list of universities within that size
 */
    public static ArrayList<University> getSuggSize(Database db, String let) {
        ArrayList<University> use = db.getUniversities();
        ArrayList<University> ret = new ArrayList<University>();
        if (let.equals("S")) {
            for (int i = 0; i < use.size(); i++) {
                if (use.get(i).getNumStudents() <= 5000)
                    ret.add(use.get(i));
            }
        } else if (let.equals("M")) {
            for (int i = 0; i < use.size(); i++) {
                if (use.get(i).getNumStudents() > 5000 && use.get(i).getNumStudents() <= 15000)
                    ret.add(use.get(i));
            }
        } else if (let.equals("L")) {
            for (int i = 0; i < use.size(); i++) {
                if (use.get(i).getNumStudents() > 15000)
                    ret.add(use.get(i));
            }
        }
        return ret;

    }

   
    public static void main(String[] args) {
    }
}
import java.util.ArrayList;

public class University {
    private String name;
    private float averageGpa;
    private int numStudents;
    private double admissionRate;
    private ArrayList<String> majors;

    public University(String nam, float gpa, int ns, double a, ArrayList<String> m) {
        name = nam;
        averageGpa = gpa;
        numStudents = ns;
        admissionRate = a;
        majors = m;
    }
    
    public makeUniversity() {
        
    }

    public String getName() {
        return name;
    }

    public double getAverageGPA() {
        return averageGpa;
    }

    public int getNumStudents() {
        return numStudents;
    }

    public double getAdmissionRate() {
        return admissionRate;
    }

    public ArrayList<String> getMajors() {
        return majors;
    }
}

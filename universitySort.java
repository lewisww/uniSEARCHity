
public class universitySort {


	public static Database sort(Database list, int choice, String term) {
		switch (choice) {
		case 0:
			return sortName(list, term.toUpperCase());
		case 1:
			return sortGpa(list, term.toUpperCase());
		case 2:
			return sortNum(list, term.toUpperCase());
		case 3:
			return sortRate(list, term.toUpperCase());
		default:
			return sortMajor(list, term.toUpperCase());
		}

	}
	public static Database sortName(Database list, String term) {
		
		for(int i = 0; i < list.getUniversities().size(); i++) {
			for(int j = 0; j < list.getUniversities().size() - i - 1; j++) {
				//System.out.println(list.getUniversity(j).getName()+ " " + list.getUniversity(j).getName().toUpperCase().compareTo(term));
				//System.out.println(list.getUniversity(j+1).getName()+ " " + list.getUniversity(j+1).getName().toUpperCase().compareTo(term));
				
				if(Math.abs(list.getUniversity(j).getName().toUpperCase().compareTo(term)) > Math.abs(list.getUniversity(j+1).getName().toUpperCase().compareTo(term))) {
					University temp = list.getUniversity(j);
					list.getUniversities().set(j, list.getUniversity(j+1));
					list.getUniversities().set(j+1, temp);
				}
			}
		}
		return list;
	}
	public static Database sortGpa(Database list, String term) {

		for(int i = 0; i < list.getUniversities().size() - 1; i++) {
			for(int j = 0; j < list.getUniversities().size() - i - 1 ; j++) {
				if(term.equals("L")) {  //sort by lowest average GPA
					if(list.getUniversity(j).getAverageGPA() > list.getUniversity(j+1).getAverageGPA()) {
						University temp = list.getUniversity(j);
						list.getUniversities().set(j, list.getUniversity(j+1));
						list.getUniversities().set(j+1, temp);
					}
				}	else { //By default you sort by highest average GPA
					if(list.getUniversity(j).getAverageGPA() < list.getUniversity(j+1).getAverageGPA()) {
						University temp = list.getUniversity(j);
						list.getUniversities().set(j, list.getUniversity(j+1));
						list.getUniversities().set(j+1, temp);
					}
				}
			}
		}
		return list;
	}
	public static Database sortNum(Database list, String term) {
		for(int i = 0; i < list.getUniversities().size() - 1; i++) {
			for(int j = 0; j < list.getUniversities().size() - i - 1 ; j++) {
				if(term.equals("L")) { //sort by lowest number students
					if(list.getUniversity(j).getNumStudents() > list.getUniversity(j+1).getNumStudents()) {
						University temp = list.getUniversity(j);
						list.getUniversities().set(j, list.getUniversity(j+1));
						list.getUniversities().set(j+1, temp);
					}
				}	else { //by default sort by highest number students
					if(list.getUniversity(j).getNumStudents() < list.getUniversity(j+1).getNumStudents()) {
						University temp = list.getUniversity(j);
						list.getUniversities().set(j, list.getUniversity(j+1));
						list.getUniversities().set(j+1, temp);
					}
				}
			}
		}
		return list;
	}
	public static Database sortRate(Database list, String term) {
		for(int i = 0; i < list.getUniversities().size() - 1; i++) {
			for(int j = 0; j < list.getUniversities().size() - i - 1 ; j++) {
				if(term.equals("L")) { //sort by lowest admission rate
					if(list.getUniversity(j).getAdmissionRate() > list.getUniversity(j+1).getAdmissionRate()) {
						University temp = list.getUniversity(j);
						list.getUniversities().set(j, list.getUniversity(j+1));
						list.getUniversities().set(j+1, temp);
					}
				}	else { //by default sort by highest admission rate
					if(list.getUniversity(j).getAdmissionRate() < list.getUniversity(j+1).getAdmissionRate()) {
						University temp = list.getUniversity(j);
						list.getUniversities().set(j, list.getUniversity(j+1));
						list.getUniversities().set(j+1, temp);
					}
				}
			}
		}
		return list;
	}
	public static Database sortMajor(Database list, String term) {
		
		for(int i = 0; i < list.getUniversities().size(); i++) {
			for(int j = 0; j < list.getUniversities().size() - i - 1; j++) {
				if(Math.abs(closestMajor(list.getUniversity(j), term)) > Math.abs(closestMajor(list.getUniversity(j+1), term))) {
					University temp = list.getUniversity(j);
					list.getUniversities().set(j, list.getUniversity(j+1));
					list.getUniversities().set(j+1, temp);
				}
			}
		}
		return list;
	}
	public static int closestMajor(University uni, String term) {
		String closest = uni.getMajors().get(0).toUpperCase();
		for(int i = 1; i < uni.getMajors().size(); i++) {
			if(Math.abs(uni.getMajors().get(i).toUpperCase().compareTo(term)) < Math.abs(closest.compareTo(term))){
				closest = uni.getMajors().get(i).toUpperCase();
			}
		}
		//System.out.println(closest + " " + closest.compareTo(term));
		
		return closest.compareTo(term);
	}


}
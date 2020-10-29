import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * The User class creates an object upon successful login or account 
 * creation. It stores all of the user's account information and writes 
 * to the user's file when they save changes in the GUI.
 * 
 * Author: Logan Marks
 */
public class User {

	private String name;
	private String email;
	private String age;
	private String password;
	private ArrayList<University> wishlist;
	private File accountInfo;
	
	/*
	 * In practice this should never throw a FileNotFound Exception.
	 */
	public User(File userFile) throws FileNotFoundException {
		Scanner scan = new Scanner(userFile);
		name = scan.nextLine();
		email = scan.nextLine();
		age = scan.nextLine();
		password = scan.nextLine();
		wishlist = new ArrayList<>();
		while (scan.hasNextLine()) {
			// Get university from database based on university name
			// Add it to wishlist
		}
		scan.close();
		accountInfo = userFile;
	}

	/*
	 * The set methods are used when the user makes changes to their
	 * account information in the landing page.
	 */
	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 * This is the method to call if we just want to display the user's
	 * wishlist instead of our entire database. 
	 */
	public ArrayList<University> getWishlist() {
		return wishlist;
	}
	
	/*
	 * Used when the user clicks an "add" button in the GUI.
	 * Doesn't add if the University is present.
	 */
	public boolean addToWishlist(University u) {
		if (wishlist.contains(u))
			return false;
		wishlist.add(u);
		writeToFile();
		return true;
	}
	
	/*
	 * Used when the user clicks a "remove" button in the GUI.
	 * True if the object is removed and false if the object was 
	 * not present.
	 */
	public boolean removeFromWishlist(University u) {
		if (wishlist.remove(u)) {
			writeToFile();
			return true;
		}
		return false;
	}
	
	/*
	 * Writes all of the updated account information to the user's 
	 * file.
	 */
	public void writeToFile() {
		try {
			PrintWriter writer = new PrintWriter(accountInfo);
			writer.println(name + "\n" + email + "\n" +
					age + "\n" + password);
			wishlist.forEach(u -> writer.println(u.getName()));
			writer.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}

}

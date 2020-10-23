import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is a tool class, that contain a lot of tools function that used in
 * userProgress class.
 * 
 * @author Zachary Pang
 *
 */
public class account {
	/**
	 * This is the method for creating a new account. It will check user's entry. If
	 * entry's name is already taken, it will return false. If entry's name is
	 * available, it will ask user to enter a valid password for new account. That
	 * password will be passed to the invalidPassword method to check feasibility.
	 * 
	 * @param A pre-opened scanner value.
	 * @return It will return true if a new account is successfully created. It will
	 *         return no if an account is already existed.
	 * @throws FileNotFoundException
	 */
	public static boolean createAccount(Scanner input) throws FileNotFoundException {
		System.out.println("Please enter your new user name.");
		String userName = input.next();
		File userFile = new File(userName + ".txt");
		if (userFile.exists()) {
			System.out.println("The account already exist, please log in or use another name for registration!");
			return false;
		}
		PrintWriter output = new PrintWriter(userFile);
		System.out.println(
				"Create a password with at least 8 characters with one uppercase letter, and one lowercase letter.");
		String password = input.next().trim();
		while (invalidPassword(password)) {
			System.out.println(
					"Invalid password. Try again with at least 8 characters, one uppercase letter, and one lowercase letter.");
			password = input.next().trim();
		}
		output.println(password);
		output.close();
		return true;
	}
	
	/**
	 * This is the method for creating a new account, using the GUI.  It takes the logic of the above class and
	 * applies it using the GUI text boxes instead of a Scanner. It will check username. If
	 * username is already taken, it will return false. It will print to a file the name, email, and age.
	 * Then it will check if the password and confirm password are the same.  If they are,
	 * password will be passed to the invalidPassword method to check its validity.
	 * If everything passes, it is written to the file.
	 * 
	 * Charlie Harders
	 * 
	 * @param A pre-opened scanner value.
	 * @return It will return true if a new account is successfully created. It will
	 *         return no if an account is already existed.
	 * @throws FileNotFoundException
	 */
	/*
	 * One bug here that I didn't fix: a file is still created if the password is invalid,
	 * this could mess up future login/account creation attempts.
	 */
	public static boolean createAccount(String name, String username, String email, String pass, String cpass, int age) throws FileNotFoundException {
		//creates a new file with the name "username".txt
		File userFile = new File(username + ".txt");
		if (userFile.exists()) {
			System.out.println("The account already exist, please log in or use another name for registration!");
			return false;
		}
		PrintWriter output = new PrintWriter(userFile);
		/*
		 * writes name email and age to the 
		 */
		
		output.println(name + "\n" + email + "\n" + age);
		/*
		 * checks if the password given and the confirm password text box are the same
		 * then checks if the password is a valid password
		 */
		if(pass.equals(cpass))
			if(!invalidPassword(pass))
				output.println(pass);
			else {
				output.close();
				return false;
			}
		else {
			output.close();
			return false;
		}
		
		output.close();
		return true;
	}

	/**
	 * This is the method to check feasibility of the password.
	 * 
	 * @param password The password that ready to be checked.
	 * @return The method will return true if the password is valid. False
	 *         otherwise.
	 */
	private static boolean invalidPassword(String password) {
		boolean number = false;
		boolean lowerCase = false;
		boolean upperCase = false;
		if (password.length() >= 8) {
			for (int i = 0; i < password.length(); i++) {
				if (48 <= password.charAt(i) && password.charAt(i) <= 57)
					number = true;
				if (65 <= password.charAt(i) && password.charAt(i) <= 90)
					lowerCase = true;
				if (97 <= password.charAt(i) && password.charAt(i) <= 122)
					upperCase = true;
			}
			if (number && lowerCase && upperCase)
				return false;
			else {
				number = false;
				lowerCase = false;
				upperCase = false;
			}
		}
		return true;
	}

	/**
	 * This method checks whether the user entered name exist in the system or not.
	 * 
	 * @param userName The string value which user entered and stored in
	 *                 userProgress class - logIn method.
	 * @param input A pre-opened scanner value.
	 * @return The method returns a string value which includes "0" for not exist or a word which
	 *         is a existed user name. 
	 * @throws FileNotFoundException
	 */
	public static String isExist(String userName, Scanner input) throws FileNotFoundException {
		File userFile = new File(userName + ".txt");
		if (!userFile.exists()) {
			System.out.println("We do not find your information in the system, please sign up first.");
			return "0";
		}

		if (correctPassword(userFile, input)) {
			return userName;
		}
		return "0";
	}
	/**
	 * This method checks whether the user entered name exist in the system or not.
	 * Built around the GUI instead of the Scanner
	 * 
	 * Charlie Harders
	 * 
	 * @param userName The string value which user entered and stored in
	 *                 userProgress class - logIn method.
	 * @param password The String sent to the correctPassword method to check
	 * @return The method returns a string value which includes "0" for not exist or a word which
	 *         is a existed user name. 
	 * @throws FileNotFoundException
	 */
	public static String isExist(String userName, String password) throws FileNotFoundException {
		File userFile = new File(userName + ".txt");
		if (!userFile.exists()) {
			System.out.println("We do not find your information in the system, please sign up first.");
			return "0";
		}

		if (correctPassword(userFile, password)) {
			return userName;
		}
		return "0";
	}

	public static boolean correctPassword(File file, Scanner input) throws FileNotFoundException {
		Scanner inFile = new Scanner(file);
		String correctPassword = inFile.nextLine();
		inFile.close();
		System.out.println("Please enter your password.");
		input.nextLine();
		for (int i = 0; i < 3; i++) {
			String inputPassword = input.nextLine().trim();
			if (inputPassword.equals(correctPassword)) {
				return true;
			}
			System.out.println("Invalid password, you have " + (2 - i) + " times to try again!");
		}
		return false;
	}
	/**
	 * This method checks whether the password matches the password in the file or not
	 * but it is using the GUI text boxes so it takes in a password string as a parameter
	 * 
	 * Charlie Harders
	 * 
	 * @param file The file that is going to be searched for the password
	 * @param  password The String that will be searched for
	 * @return True if the password matches, False if it does not 
	 * @throws FileNotFoundException
	 */
	public static boolean correctPassword(File file, String password) throws FileNotFoundException {
		Scanner inFile = new Scanner(file);
		//This is because, due to the order of where the password is located, you need to go a couple lines down
		//Will look for a more efficient way to do this
		inFile.nextLine();
		inFile.nextLine();
		inFile.nextLine();
		String correctPassword = inFile.nextLine();
		inFile.close();
		for (int i = 0; i < 3; i++) {
			if (password.equals(correctPassword)) {
				return true;
			}
			System.out.println("Invalid password, you have " + (2 - i) + " times to try again!");
		}
		return false;
	}

}
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * 
 * @author Zachary Pang Kiwi Software Development Oct.15th
 * 
 *         Topic: User Interface 1.0
 * 
 *         This is a basic user interface class without GUI. Main functionality
 *         includes create account, access account password detection...
 *
 */
public class userProgress {

	/**
	 * This is the "main" method. Calling run method in main will start the whole
	 * program.
	 * 
	 * @throws FileNotFoundException
	 */
	public static void run() throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
		String result = "-1";
		do {
			greeting(input);
			result = logIn(input);
		} while (result.equals("0"));
		accessAccount(result, input);

	}

	/**
	 * This is the welcome method. It asks whether user already registered to the
	 * system. If yes, then proceed next. If no, then it will jump to the create
	 * account method.
	 * 
	 * @param input For the convenience of scanner, it asks you to input a
	 *              pre-opened scanner value called input.
	 * 
	 * @throws FileNotFoundException
	 */
	public static void greeting(Scanner input) throws FileNotFoundException {
		while (true) {
			System.out.println("Greetings! Are you a registered customer? (Please type in YES or NO.)");
			String userInput = input.next().trim();
			if (userInput.equals("YES") || userInput.equals("yes") || userInput.equals("Yes")) {
				break;
			} else if (userInput.equals("NO") || userInput.equals("no") || userInput.equals("No")) {
				if (!account.createAccount(input)) {
					System.out.println("Account create failure!");
					break;
				}
				System.out.println("Account create success.");
				break;
			} else
				System.out.println("Please type in the assigned words!");
		}
	}

	/**
	 * This is the method for log in. It will pass the user entered value into the
	 * isExist method.
	 * 
	 * @param input A pre-opened scanner value.
	 * @return This method return a string value which includes "0" for log in failure or a word which
	 *         is a existed user name.
	 * 
	 * @throws FileNotFoundException
	 */
	public static String logIn(Scanner input) throws FileNotFoundException {
		System.out.println("Please enter your user name to log in.");
		String inputName = input.next();
		return account.isExist(inputName, input);
	}
	/**
	 * This is the method for logging in through the GUI instead of the console.
	 * It is the above method translated to use GUI textboxes instead of the Scanner
	 * 
	 * Charlie Harders
	 * 
	 * @param inputName The username that you are looking for
	 * @param password The password you are using
	 * @return This method return a string value which includes "0" for log in failure or a word which
	 *         is a existed user name.
	 * 
	 * @throws FileNotFoundException
	 */
	public static String logIn(String inputName, String password) throws FileNotFoundException {
		return account.isExist(inputName, password);
		
		
	}

	/**
	 * This method will access the user account. More functionality to add in this
	 * method.
	 * 
	 * @param userName A already existed user name.
	 * @param input    A pre-opened scanner value.
	 */
	public static void accessAccount(String userName, Scanner input) {
		System.out.println("accessAccount... " + userName);
	}

}
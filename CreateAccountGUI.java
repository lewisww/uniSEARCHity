import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
/**
 * This is a class that is the GUI to the Create Account page, and will be used to generate
 * an account file for the user
 * 
 * @author Charles Harders
 *
 */

public class CreateAccountGUI extends JFrame{

	private final int FRAME_WIDTH = 700;
	private final int FRAME_HEIGHT = 310;
	JLabel label0;
	JLabel label1;
	JLabel label2;
	JLabel label3;
	JLabel label4;
	JLabel label5;
	JTextField name;
	JTextField username;
	JTextField email;
	JTextField passwd;
	JTextField confpasswd;
	JTextField age;
	JButton create;
	JPanel cards;

	public static void main(String[] args) {
		
		JFrame frame = new CreateAccountGUI();
		//frame.setTitle("uniSEARCHity");
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setVisible(true);
	}
	
	public CreateAccountGUI() {
		createComponents();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	public void createComponents() {
		cards = new JPanel();
		cards.setLayout(new GridLayout(7,0));
		cards.setPreferredSize(new Dimension(500, 200));
        cards.setMaximumSize(new Dimension(10000, 600));
        label0 = new JLabel("Full Name: ");
		label1 = new JLabel("Username: ");
		label2 = new JLabel("Email: ");
		label3 = new JLabel("Password: ");
		label4 = new JLabel("Confirm Password: ");
		label5 = new JLabel("Age: ");
		name = new JTextField(25);
		username = new JTextField(25);
		email = new JTextField(25);
		passwd = new JTextField(25);
		confpasswd = new JTextField(25);
		age = new JTextField(25);
		create = new JButton("Create Account");
		create.addActionListener(e -> {
				try {
					createAccount(name.getText(),username.getText(), email.getText(), passwd.getText(),
							confpasswd.getText(),Integer.parseInt(age.getText()));
				} catch (NumberFormatException | FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		});
		cards.add(label0);
		cards.add(name);
		cards.add(label1);
		cards.add(username);
		cards.add(label2);
		cards.add(email);
		cards.add(label3);
		cards.add(passwd);
		cards.add(label4);
		cards.add(confpasswd);
		cards.add(label5);
		cards.add(age);
		cards.add(create);
		
		cards.setBackground(Color.WHITE);
		
		JFrame frame = new JFrame();
		frame.setTitle("uniSEARCHity");
		frame.add(cards,BorderLayout.NORTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	/**
	 * This takes the information from the text boxes and goes to create the account through the other files
	 * 
	 * Charlie Harders
	 * 
	 * @param name Full name to be stored
	 * @param user Username to create the file
	 * @param email Email to be stored
	 * @param pass Password to be stored
	 * @param pass2 Password confirmation to be checked against pass
	 * @param age Age to be stored
	 * @throws FileNotFoundException
	 */
	public void createAccount(String name, String user, String email, String pass, String pass2, int age) throws FileNotFoundException {
		account.createAccount(name, user, email, pass, pass2, age);
	}
	
	
}

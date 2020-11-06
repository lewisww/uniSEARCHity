import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class AccountGUI extends JFrame {
	
	public static Database collegeList;
	public static User currentUser;
	
	private final int FRAME_WIDTH = 700;
	private final int FRAME_HEIGHT = 310;
	JLabel label1;
	JLabel label2;
	JLabel label3;
	JLabel label4;
	JLabel label5;
	JTextField name;
	JTextField username;
	JTextField email;
	JTextField age;
	JTextField password;
	//JTextField addPreferredSchool;
	//JTextField removePreferredSchool;
	JButton save;
	JButton display;
	JPanel cards;
	JPanel cards2;
	JPanel im;
	ImageIcon imag;

	/*
	 * Initializes the database and user upon successful login.
	 */
	public static void main(String[] args) throws IOException {
		
		collegeList = new Database("College List");
		if(Database.universities.size() == 0)
			Database.addUniversity(new File("collegeList.csv"));
		
		File userFile = new File(args[0] + ".txt");
		currentUser = new User(userFile, args[0]);
		JFrame frame = new AccountGUI(currentUser, userFile);
		//frame.setTitle("uniSEARCHity");
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setVisible(true);
	}
	
	public AccountGUI(User u, File userFile) {
		createComponents(u, userFile);
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	public void createComponents(User u, File userFile) {
		cards = new JPanel();
		
		
		cards.setLayout(new GridLayout(7,0));
		cards.setPreferredSize(new Dimension(500, 200));
        cards.setMaximumSize(new Dimension(10000, 200));
		label1 = new JLabel("Name: ");
		label2 = new JLabel("Username: ");
		label3 = new JLabel("Email: ");
		label4 = new JLabel("Age: ");
		label5 = new JLabel("Password: ");
		
		name = new JTextField(25);
		name.setText(u.getName());
		name.setEditable(false);
		
		username = new JTextField(25);
		username.setText(u.getUsername());
		username.setEditable(false);
		
		email = new JTextField(25);
		email.setText(u.getEmail());
		
		age = new JTextField(25);
		age.setText(u.getAge());
		
		password = new JTextField(25);
		password.setText(u.getPassword());
		//addPreferredSchool = new JTextField(25);
		//removePreferredSchool = new JTextField(25);
		save = new JButton("Save Changes");
		save.addActionListener(e -> {
			u.setName(name.getText());
			u.setEmail(email.getText());
			u.setAge(age.getText());
			u.setPassword(password.getText());
			u.writeToFile();
		});
		display = new JButton("Display Schools");
		display.addActionListener(e -> {
			new DatabaseGUI();
		});
		
		cards.add(label1);
		cards.add(name);
		cards.add(label2);
		cards.add(username);
		cards.add(label3);
		cards.add(email);
		cards.add(label4);
		cards.add(age);
		cards.add(label5);
		cards.add(password);
		cards.add(save);
		cards.add(display);
		
		cards.setBackground(Color.WHITE);
		
		JFrame frame = new JFrame();
		frame.setSize(500,400);
		frame.setTitle("uniSEARCHity");
		frame.add(cards,BorderLayout.NORTH);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	
	
}
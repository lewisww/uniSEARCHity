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
	JLabel label6;
	JTextField name;
	JTextField username;
	JTextField email;
	JTextField age;
	JTextField password;
	JTextField filepath;
	//JTextField addPreferredSchool;
	//JTextField removePreferredSchool;
	JButton save;
	JButton display;
	JButton upload;
	JButton wishlist;
	JButton suggest;
	JPanel cards;
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
		
		
		cards.setLayout(new GridLayout(0, 2, 0, 10));
		cards.setPreferredSize(new Dimension(500, 200));
        cards.setMaximumSize(new Dimension(1000, 500));
		label1 = new JLabel("Name: ");
		label2 = new JLabel("Username: ");
		label3 = new JLabel("Email: ");
		label4 = new JLabel("Age: ");
		label5 = new JLabel("Password: ");
		label6 = new JLabel("");
		
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
		
		filepath = new JTextField(25);
		filepath.setText("File Path");
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
		upload = new JButton("Upload File");
		upload.addActionListener(e -> {
			try {
				uploadFile(filepath.getText());
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		wishlist = new JButton("View Wishlist");
		wishlist.addActionListener(e -> {
			new DatabaseGUI();
		});
		suggest = new JButton("Suggest Schools");
		suggest.addActionListener(e -> {
			new SuggestGUI();
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
		cards.add(upload);
		cards.add(filepath);
		cards.add(wishlist);
		cards.add(suggest);
		
		
		
		cards.setBackground(Color.WHITE);
		
		JFrame frame = new JFrame();
		frame.setSize(500,400);
		frame.setTitle("uniSEARCHity");
		frame.add(cards,BorderLayout.NORTH);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public  void uploadFile(String filePath) throws FileNotFoundException {
		String newFile = "";
		for(int i = filePath.length() - 1; i >=0; i--) {
			if(filePath.charAt(i) == '/')
				break;
			else
				newFile = filePath.charAt(i) + newFile;
		}
		File input = new File(filePath);
		File added = new File(newFile);
		PrintWriter output = new PrintWriter(added);
		Scanner reader = new Scanner(input);
		while(reader.hasNext()) {
			output.write(reader.nextLine());
		}
		output.close();
		reader.close();
	}
	
	
}
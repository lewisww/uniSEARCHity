import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class LoginGUI extends JFrame implements ActionListener {
	
	JLabel label1;
	JLabel label2;
	JLabel label3;
	JLabel status = new JLabel("");
	JTextField username;
	JTextField password;
	JButton login;
	JButton create;
	JButton lists;
	JPanel cards;
	JPanel cards2;
	JPanel im;
	ImageIcon imag;

	public static void main(String[] args) {
		LoginGUI log = new LoginGUI();
		
//		JFrame frame = new LoginGUI();
//		frame.setTitle("uniSEARCHity");
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
	}
	
	public LoginGUI() {
		createComponents();
	}
	
	public void createComponents() {
		cards = new JPanel();
		cards2 = new JPanel();
		im = new JPanel();
		cards.setLayout(new GridLayout(7,0));
		cards.setPreferredSize(new Dimension(500, 200));
        cards.setMaximumSize(new Dimension(10000, 200));
        imag = new ImageIcon("logo_size.jpg");
		label3 = new JLabel(imag);
		label1 = new JLabel("Username: ");
		label2 = new JLabel("Password: ");
		username = new JTextField(30);
		password = new JTextField(30);
		login = new JButton("Login");
		login.setBackground(Color.darkGray);
		login.setOpaque(true);
		login.addActionListener(e -> {
			try {
				if (userLogin(username.getText(),password.getText()))
					AccountGUI.main(new String[] {username.getText()});
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		});
		create = new JButton("Create New User");
		create.setBackground(Color.darkGray);
		create.setOpaque(true);
		create.addActionListener(e -> {
			CreateAccountGUI.main(null);
		});
		lists = new JButton("List Colleges");
		lists.setBackground(Color.darkGray);
		lists.setOpaque(true);
		lists.addActionListener(this);
		cards.add(label1);
		cards.add(username);
		cards.add(label2);
		cards.add(password);
		cards.add(login);
		im.add(label3);
		cards2.add(create);
		cards2.add(lists);
		
		cards.setBackground(Color.WHITE);
		cards2.setBackground(Color.WHITE);
		im.setBackground(Color.WHITE);
		JFrame frame = new JFrame();
		frame.setSize(500,400);
		frame.setTitle("uniSEARCHity");
		frame.add(cards,BorderLayout.NORTH);
		frame.add(im, BorderLayout.CENTER);
		frame.add(cards2,BorderLayout.SOUTH);

		
//		Container c = frame.getContentPane();
//		c.setBackground(Color.BLACK);
		//frame.add(panel2,BorderLayout.CENTER);
		//frame.add(panel3,BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
	/**
	 * This method takes the information from the GUI Textboxes and uses the to login to through the other files
	 * If logged in correctly, it will eventually take you to the homescreen
	 * 
	 * Charlie Harders
	 * 
	 * @param username  Username of the user
	 * @param password  Password of the user
	 * @throws FileNotFoundException
	 * @throws InterruptedException 
	 */
	public boolean userLogin(String username, String password) throws FileNotFoundException, InterruptedException {
		
		if (username.equals(userProgress.logIn(username, password))){
			System.out.println("success");
			status.setText("Success");
			this.add(status);
			// TimeUnit.SECONDS.sleep(1);
			return true;
		} else {
			System.out.println("failure");
			status.setText("Failed Login!");
			this.add(status);
			return false;
		}
	}

	public void actionPerformed(ActionEvent e) {
		if(Database.universities.size() == 0) {
			File test = new File("collegeList.csv");
			int check = 0;
			try {
				check = Database.addUniversity(test);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			if (check == 1)
				System.out.println("Not enough input");
		}
		new DatabaseGUI();
	}
}

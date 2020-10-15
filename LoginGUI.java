import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame {
	
	private final int FRAME_WIDTH = 700;
	private final int FRAME_HEIGHT = 310;
	JLabel label1;
	JLabel label2;
	JTextField username;
	JTextField password;
	JButton login;

	public static void main(String[] args) {
		
		JFrame frame = new LoginGUI();
		frame.setTitle("uniSEARCHity");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public LoginGUI() {
		createComponents();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	public void createComponents() {
		this.setLayout(new FlowLayout());
		label1 = new JLabel("Username: ");
		label2 = new JLabel("Password: ");
		username = new JTextField(25);
		password = new JTextField(25);
		login = new JButton("Login");
		
		this.add(label1);
		this.add(username);
		this.add(label2);
		this.add(password);
		this.add(login);
	}
}

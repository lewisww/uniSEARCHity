import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountGUI extends JFrame {
	
	private final int FRAME_WIDTH = 700;
	private final int FRAME_HEIGHT = 310;
	JLabel label1;
	JLabel label2;
	JLabel label3;
	JLabel label4;
	JTextField username;
	JTextField gpa;
	JTextField addPreferredSchool;
	JTextField removePreferredSchool;
	JButton save;
	JButton display;

	public static void main(String[] args) {
		
		JFrame frame = new AccountGUI();
		frame.setTitle("uniSEARCHity");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public AccountGUI() {
		createComponents();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	public void createComponents() {
		this.setLayout(new FlowLayout());
		label1 = new JLabel("Username: ");
		label2 = new JLabel("GPA: ");
		label3 = new JLabel("Add Preferred School: ");
		label4 = new JLabel("Remove Preferred School: ");
		username = new JTextField(25);
		gpa = new JTextField(25);
		addPreferredSchool = new JTextField(25);
		removePreferredSchool = new JTextField(25);
		save = new JButton("Save Changes");
		display = new JButton("Display Schools");
		
		this.add(label1);
		this.add(username);
		this.add(label2);
		this.add(gpa);
		this.add(label3);
		this.add(addPreferredSchool);
		this.add(label4);
		this.add(removePreferredSchool);
		this.add(save);
		this.add(display);
	}
}

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

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
	JPanel cards;
	JPanel cards2;
	JPanel im;
	ImageIcon imag;

	public static void main(String[] args) {
		
		JFrame frame = new AccountGUI();
		//frame.setTitle("uniSEARCHity");
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setVisible(true);
	}
	
	public AccountGUI() {
		createComponents();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	public void createComponents() {
		cards = new JPanel();
		
		
		cards.setLayout(new GridLayout(7,0));
		cards.setPreferredSize(new Dimension(500, 200));
        cards.setMaximumSize(new Dimension(10000, 200));
		label1 = new JLabel("Username: ");
		label2 = new JLabel("GPA: ");
		label3 = new JLabel("Add Preferred School: ");
		label4 = new JLabel("Remove Preferred School: ");
		username = new JTextField(25);
		gpa = new JTextField(25);
		addPreferredSchool = new JTextField(25);
		removePreferredSchool = new JTextField(25);
		save = new JButton("Save Changes");
		save.addActionListener(e -> {
			//try {
				//createAccount();//(username.getText(),password.getText(), input);
			/*} /*catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/
		});
		display = new JButton("Display Schools");
		
		cards.add(label1);
		cards.add(username);
		cards.add(label2);
		cards.add(gpa);
		cards.add(label3);
		cards.add(addPreferredSchool);
		cards.add(label4);
		cards.add(removePreferredSchool);
		cards.add(save);
		cards.add(display);
		
		cards.setBackground(Color.WHITE);
		
		JFrame frame = new JFrame();
		frame.setTitle("uniSEARCHity");
		frame.add(cards,BorderLayout.NORTH);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	
	
}
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

public class SuggestGUI extends JFrame {
	
	public static Database collegeList;
	public static User currentUser;
	
	private final int FRAME_WIDTH = 700;
	private final int FRAME_HEIGHT = 310;
	JLabel label1;
	JLabel label2;
	JLabel label3;
	JTextField gpa;
	JTextField major;
	private String[] sizes = {"S","M","L"};
	JComboBox size = new JComboBox(sizes);
	//JTextField addPreferredSchool;
	//JTextField removePreferredSchool;
	JButton search;
	JPanel cards;
	JPanel im;
	ImageIcon imag;
	

	/*
	 * Initializes the database and user upon successful login.
	 */
	public static void main(String[] args) throws IOException {
		
		
		JFrame frame = new SuggestGUI();
		//frame.setTitle("uniSEARCHity");
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setVisible(true);
	}
	
	public SuggestGUI() {
		createComponents();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	public void createComponents() {
		cards = new JPanel();
		
		
		cards.setLayout(new GridLayout(7,0));
		cards.setPreferredSize(new Dimension(500, 200));
        cards.setMaximumSize(new Dimension(10000, 200));
		label1 = new JLabel("GPA: ");
		label2 = new JLabel("Major: ");
		label3 = new JLabel("Size: ");
		
		gpa = new JTextField(25);
		
		major = new JTextField(25);
		
		
		
		//addPreferredSchool = new JTextField(25);
		//removePreferredSchool = new JTextField(25);
		search = new JButton("Suggest Schools");
		search.addActionListener(e -> {
		});
		
		cards.add(label1);
		cards.add(gpa);
		cards.add(label2);
		cards.add(major);
		cards.add(label3);
		cards.add(size);
		cards.add(search);
		
		cards.setBackground(Color.WHITE);
		
		JFrame frame = new JFrame();
		frame.setSize(500,400);
		frame.setTitle("uniSEARCHity");
		frame.add(cards,BorderLayout.NORTH);
		//frame.add(fileUp, BorderLayout.NORTH);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
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
import java.util.ArrayList;
import java.util.Scanner;

public class SuggestGUI extends JFrame {
	
	public static Database collegeList;
	public static User currentUser;
	
	private final int FRAME_WIDTH = 700;
	private final int FRAME_HEIGHT = 310;
	JLabel label1;
	JLabel label2;
	JLabel label3;
	JLabel below1;
	JLabel below2;
	JLabel below3;
	JLabel below4;
	// JLabel suggSchools;
	JTextField gpa;
	JTextField major;
	private String[] sizes = {"S","M","L"};
	JComboBox size = new JComboBox(sizes);
	//JTextField addPreferredSchool;
	//JTextField removePreferredSchool;
	JButton search;
	JButton one;
	JButton two;
	JButton three;
	//JButton back;
	//JToolBar cardb;
	JPanel cards;
	JPanel card2;
	JPanel card3;
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
		//cardb = new JToolBar();
		cards = new JPanel();
		card2 = new JPanel();
		card3 = new JPanel();
//		cardb.setLayout(new BorderLayout());
//		cardb.setPreferredSize(new Dimension(500,50));
//		cardb.setMaximumSize(new Dimension(10000, 50));
		cards.setLayout(new GridLayout(0, 2, 0, 10));
		cards.setPreferredSize(new Dimension(500, 200));
        cards.setMaximumSize(new Dimension(10000, 200));
        card3.setLayout(new GridLayout(3, 3, 20, 10));
		card3.setPreferredSize(new Dimension(200, 100));
        card3.setMaximumSize(new Dimension(5000, 200));
		label1 = new JLabel("GPA: ");
		label2 = new JLabel("Major: ");
		label3 = new JLabel("Size: ");
		below1 = new JLabel("");
		below2 = new JLabel("");
		below3 = new JLabel("");
		
		one = new JButton("");
		one.setVisible(false);
		two = new JButton("");
		two.setVisible(false);
		three = new JButton("");
		three.setVisible(false);
		gpa = new JTextField(25);
		
		major = new JTextField(25);
		
		JFrame frame = new JFrame();

		
		//addPreferredSchool = new JTextField(25);
		//removePreferredSchool = new JTextField(25);
		search = new JButton("Suggest Schools");
		search.addActionListener(e -> { 
		 	User name = currentUser;
			double d = Double.parseDouble(gpa.getText());
			String s = (String)size.getSelectedItem();
			Suggested sugg = new Suggested(d,major.getText(),s);
			ArrayList<University> use = sugg.finalSchools();
			for (int i = 0; i < use.size(); i++) {
				if (below1.getText().isEmpty()) {
					below1.setText(use.get(i).getName());
					one.setVisible(true);
					one.setText("Add To Wishlist");
					if(e.getSource().equals(one)){
			        	name.addToWishlist(use.get(0));
			        }
				}
				else if (below2.getText().isEmpty()) {
					below2.setText(use.get(i).getName());
					two.setVisible(true);
					two.setText("Add To Wishlist");
					if(e.getSource().equals(two)){
			        	name.addToWishlist(use.get(1));
			        }
					//});
			
				}
				else if (below3.getText().isEmpty()){
					below3.setText(use.get(i).getName());
					three.setVisible(true);
					three.setText("Add To Wishlist");
					if(e.getSource().equals(three)){
			        	name.addToWishlist(use.get(2));
			        }
				}
			}
			
		});

		
		//cardb.add(back);
		cards.add(label1);
		cards.add(gpa);
		cards.add(label2);
		cards.add(major);
		cards.add(label3);
		cards.add(size);
		card2.add(search);
		card3.add(below1);
		card3.add(one);
		card3.add(below2);
		card3.add(two);
		card3.add(below3);
		card3.add(three);
		
		//cardb.setBackground(Color.WHITE);
		cards.setBackground(Color.WHITE);
		card2.setBackground(Color.WHITE);
		card3.setBackground(Color.WHITE);
		
		frame.setSize(500,400);
		frame.setTitle("uniSEARCHity");
		//frame.add(cardb, BorderLayout.NORTH);
		frame.add(cards,BorderLayout.NORTH);
		frame.add(card2, BorderLayout.CENTER);
		frame.add(card3, BorderLayout.SOUTH);
		//frame.add(fileUp, BorderLayout.NORTH);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
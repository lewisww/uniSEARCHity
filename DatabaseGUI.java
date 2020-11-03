import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DatabaseGUI implements ActionListener {
	
	public static void main(String[] args) throws IOException {
		File test = new File("c:/Users/proph/Desktop/CSE201/test.csv");
		int check = Database.addUniversity(test);
		if (check == 1)
			System.out.println("Not enough input");
		new DatabaseGUI();
	}
	
	public DatabaseGUI() {
		JPanel panel = new JPanel();
		JFrame frame = new JFrame();
		frame.setSize(1020, 60 + 115 * Database.universities.size());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setLayout(null);
		frame.add(panel);
		
		JButton nameButton = new JButton("University Name");
		nameButton.setBounds(10, 10, 180, 40);
		panel.add(nameButton);
		
		JButton gpaButton = new JButton("Average GPA");
		gpaButton.setBounds(210, 10, 180, 40);
		panel.add(gpaButton);
		
		JButton numButton = new JButton("Number Of Students");
		numButton.setBounds(410, 10, 180, 40);
		panel.add(numButton);
		
		JButton rateButton = new JButton("Admission Rate");
		rateButton.setBounds(610, 10, 180, 40);
		panel.add(rateButton);
		
		JButton majorButton = new JButton("Majors");
		majorButton.setBounds(810, 10, 180, 40);
		panel.add(majorButton);
		
		int size = Database.universities.size();
		for (int i = 0; i < size; i++) {
			JButton nameLabel = new JButton(Database.universities.get(i).getName());
			nameLabel.setBounds(10, 70 + i * 100, 180, 80);
			panel.add(nameLabel);
			
			JButton gpaLabel = new JButton(Database.universities.get(i).getAverageGPA() + "");
			gpaLabel.setBounds(210, 70 + i * 100, 180, 80);
			panel.add(gpaLabel);
			
			JButton numLabel = new JButton(Database.universities.get(i).getNumStudents() + "");
			numLabel.setBounds(410, 70 + i * 100, 180, 80);
			panel.add(numLabel);
			
			JButton rateLabel = new JButton(Database.universities.get(i).getAdmissionRate() + "");
			rateLabel.setBounds(610, 70 + i * 100, 180, 80);
			panel.add(rateLabel);
			
			JButton moreInfor = new JButton("More Information");
			moreInfor.setBounds(810, 70 + i * 100, 180, 80);
			moreInfor.addActionListener(this);
			panel.add(moreInfor);
			
		}
		
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		JPanel sPanel = new JPanel();
		JFrame sFrame = new JFrame();
		sFrame.setSize(600, 400);
		sFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sFrame.add(sPanel);
		
		JLabel major = new JLabel(Database.universities.get(0).getMajors() + "");
		major.setBounds(10, 100, 180, 80);
		sPanel.add(major);
		
		sFrame.setVisible(true);
		
	}
	
}

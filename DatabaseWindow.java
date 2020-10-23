
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class DatabaseWindow extends JFrame {

	private int rows, columns;
	private JPanel cellPanel, buttonPanel;
	private JLabel status;
	private Cell[][] cells;
	private JButton[] columnButtons;
	private static int CELL_SIZE = 70; // adjust this for larger or smaller cells
	private boolean player = true; // declare player1 as true, player2 as false
	private int[] rowRecord; // record and trace the cell during the game, index
								// implies column number, value implies the cell number
	private boolean[] isFulled; // stop button when a column line is filled

	public static void main(String[] args) {
		new DatabaseWindow(6, 8);
	}
	
	public DatabaseWindow(int rows, int columns) {
		super("Welcome to the database!");
		this.rows = rows;
		this.columns = columns;
		rowRecord = new int[columns];
		isFulled = new boolean[columns];
		frameSetup();
		cellPanelSetup();
		buttonPanelSetup();
		statusSetup();
		pack();
		setVisible(true);
	}


	private void frameSetup() {
		setLayout(new BorderLayout());
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}


	private void cellPanelSetup() {

		cellPanel = new JPanel(new GridLayout(rows, 0));
		cellPanel.setPreferredSize(new Dimension(CELL_SIZE * columns, CELL_SIZE * rows));

		cells = new Cell[rows][columns];
		for (int row = 0; row < cells.length; row++) {
			for (int cell = 0; cell < cells[0].length; cell++) {
				cells[row][cell] = new Cell();
				cellPanel.add(cells[row][cell]);
			}
		}
		add(cellPanel, BorderLayout.CENTER);
	}


	private void buttonPanelSetup() {
		buttonPanel = new JPanel(new GridLayout(1, 0));
		columnButtons = new JButton[columns];
		for (int i = 0; i < columns; i++) {
			if (i == 0)
				columnButtons[i] = new JButton("Name");
			else if (i == 1)
				columnButtons[i] = new JButton("GPA");
			else if (i == 2)
				columnButtons[i] = new JButton("Number");
			else if (i == 3)
				columnButtons[i] = new JButton("Admission Rate");
			else if (i == 4)
				columnButtons[i] = new JButton("Majors");
			else
				columnButtons[i] = new JButton("etc");
			columnButtons[i].setToolTipText("Move in column " + i);
			buttonPanel.add(columnButtons[i]);
		}
		add(buttonPanel, BorderLayout.NORTH);
		MyButtonListener buttonListener = new MyButtonListener();
		for (int i = 0; i < columns; i++) {
			columnButtons[i].addActionListener(buttonListener);
		}
	}

	private void statusSetup() {
		status = new JLabel("Welcome to the database!", JLabel.CENTER);
		add(status, BorderLayout.SOUTH);
	}

	private class MyButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object button = e.getSource();
			for (int i = 0; i < columns; i++) {
				if (button == columnButtons[i]) {
					if (player) {
						rowRecord(i);
					} else {
						rowRecord(i);
					}
					if (isFulled[i] == false) {
						player = !player;
					}
					if (isFulled[i] == true) {
						player = !player;
						columnButtons[i].setEnabled(false);
					}
				}
			}
		}
	}


	private void rowRecord(int column) {
		if (isFulled[column] == false) {
			rowRecord[column] += 1;
			if (rowRecord[column] == rows) {
				isFulled[column] = true;
			}
		}
	}
	
}

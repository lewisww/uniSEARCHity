import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;

public class Cell extends JPanel {

	public static final Color BACK_COLOR = Color.GRAY;
	public static final Color EMPTY_COLOR = Color.GRAY;

	public static final int BOUNDARY = 5;

	private String context;

	public Cell() {
		super();
		this.context = "name";
		setBackground(BACK_COLOR);
		Border blackline = BorderFactory.createLineBorder(Color.BLACK, 1);
		setBorder(blackline);
	}

	public void setContext(String context) {
		this.context = context;
		setToolTipText(context);
		repaint();
	}

	public String getContext() {
		return context;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		switch (context) {
		case "name":
			g.drawString("new University", 200, 200);
			break;
		case "gpa":
			g.drawString("new gpa", 200, 200);
			break;
		case "number":
			g.drawString("new number", 200, 200);
			break;
		case "admission rate":
			g.drawString("new admission rate", 200, 200);
			break;
		case "majors":
			g.drawString("new majors", 200, 200);
			break;
		}

		g.fillOval(BOUNDARY, BOUNDARY, this.getWidth() - 2 * BOUNDARY,
				this.getHeight() - 2 * BOUNDARY);

	}

}



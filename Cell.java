import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;

public class Cell extends JPanel {

	public static final Color BACK_COLOR = new Color(220, 220, 0);
	public static final Color EMPTY_COLOR = Color.GRAY;
	public static final Color PLAYER_1_COLOR = Color.RED;
	public static final Color PLAYER_2_COLOR = Color.BLACK;
	public static final int BOUNDARY = 5;
	private int player;

	public Cell() {
		super();
		this.player = 0;
		setBackground(BACK_COLOR);

		// A border around the square
		Border blackline = BorderFactory.createLineBorder(Color.BLACK, 1);
		setBorder(blackline);
	}


	public void setPlayer(int player) {
		if (player < 0 || player > 2)
			throw new IllegalArgumentException("Invalid occupant: " + player + ", must be 0, 1, or 2");
		this.player = player;
		setToolTipText("Player " + player);
		repaint();
	}

	public int getPlayer() {
		return player;

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		switch (player) {
		case 0:
			g.setColor(EMPTY_COLOR);
			break;
		case 1:
			g.setColor(PLAYER_1_COLOR);
			break;
		case 2:
			g.setColor(PLAYER_2_COLOR);
		}

		g.fillOval(BOUNDARY, BOUNDARY, this.getWidth() - 2 * BOUNDARY, this.getHeight() - 2 * BOUNDARY);

	}

}


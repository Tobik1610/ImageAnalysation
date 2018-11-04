import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;

public class ImageFrame extends JFrame {

	private Color[][] colors;
	private int width, height;
	private boolean borders;

	public ImageFrame(int width, int height, Color[][] colors, boolean borders) {
		this.colors = colors;
		this.width = width;
		this.height = height;
		this.borders = borders;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(width + 17, height + 41));
		setTitle("Farberkennung");
		setVisible(true);
		pack();
		setLocationRelativeTo(null);
	}

	public void paint(Graphics g) {
		int x = width / colors.length;
		int y = height / colors[0].length;
		for (int i = 0; i < colors.length; i++) {
			for (int j = 0; j < colors[i].length; j++) {
				g.setColor(colors[i][j]);
				g.fillRect(i * x + 8, j * y + 33, x, y);
				if (borders) {
					g.setColor(Color.BLACK);
					g.drawRect(i * x + 8, j * y + 33, x, y);
				}
			}
		}
	}
}

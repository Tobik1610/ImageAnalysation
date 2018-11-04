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
				int x1 = i * x + 8;
				int y1 = j * y + 33;
				g.setColor(colors[i][j]);
				g.fillRect(x1, y1, x, y);
				// Farbgruppierung
				if (borders) {
					g.setColor(Color.BLACK);
					// oben
					if (j > 0)
						if (!colors[i][j].equalColorSpace(colors[i][j - 1]))
							g.drawLine(x1, y1, x1 + x, y1);
					// rechts
					if (i < colors.length - 1)
						if (!colors[i][j].equalColorSpace(colors[i + 1][j]))
							g.drawLine(x1 + x, y1, x1 + x, y1 + y);
					// unten
					if (j < colors[i].length - 1)
						if (!colors[i][j].equalColorSpace(colors[i][j + 1]))
							g.drawLine(x1, y1 + y, x1 + x, y1 + y);
					// links
					if (i > 0)
						if (!colors[i][j].equalColorSpace(colors[i - 1][j]))
							g.drawLine(x1, y1, x1, y1 + y);
				}
			}
		}
	}
}

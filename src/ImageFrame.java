import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;

public class ImageFrame extends JFrame{
	
	private Color[][] colors;
	private int width, height;

	public ImageFrame(int width, int height, Color[][] colors) {
		this.colors = colors;
		this.width = width;
		this.height = height;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(width, height));
		setTitle("Farberkennung");
		setVisible(true);
		pack();
		setLocationRelativeTo(null);
	}
	
	public void paint(Graphics g) {
		int x = width/colors.length;
		int y = height/colors[0].length;
		for (int i = 0; i < colors.length; i++) {
			for (int j = 0; j < colors[i].length; j++) {
				g.setColor(colors[i][j]);
				g.fillRect(i * x, j * y, x, y);
			}
		}
	}
}

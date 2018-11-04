import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Main {

	public static void main(String[] args) {

		// Logik
		ColorRecognition colorReconizer = new ColorRecognition();

		BufferedImage img = null;
		Color[][] color;
		try {
			img = ImageIO.read(new File("src/sonnenuntergang.jpg"));
			
//			color = colorReconizer.AnalyzeImage(img, 10, 10);//Werte nicht größer als Auflösung
//			new ImageFrame(img.getWidth(), img.getHeight(), color, true);
			
			color = colorReconizer.AnalyzeImage(img, img.getWidth(), img.getHeight());//Werte nicht größer als Auflösung
			new ImageFrame(img.getWidth(), img.getHeight(), color, false);

//			for (int i = 0; i < color.length; i++) {
//				for (int j = 0; j < color[i].length; j++) {
//					System.out.println(i + "/" + j + " " + color[i][j][1] + " " + color[i][j][2] + " " + color[i][j][3]);
//				}
//			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

}

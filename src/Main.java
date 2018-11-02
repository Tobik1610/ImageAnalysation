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
			color = colorReconizer.AnalyzeImage(img, 960, 960);//Werte nicht gr��er als Aufl�sung

//			for (int i = 0; i < color.length; i++) {
//				for (int j = 0; j < color[i].length; j++) {
//					System.out.println(i + "/" + j + " " + color[i][j][1] + " " + color[i][j][2] + " " + color[i][j][3]);
//				}
//			}

			//Frame
			new ImageFrame(img.getWidth(), img.getHeight(), color);

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

}

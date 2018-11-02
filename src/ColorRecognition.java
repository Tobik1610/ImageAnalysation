import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.util.HashMap;
import java.util.Map;

public class ColorRecognition {

	private PixelGrabber grabber;
	private int[] data;
	private HashMap<Integer, Integer> colors = new HashMap<>();

	private Color[][] returnParams;

	public ColorRecognition() {

	}

	public Color[][] AnalyzeImage(BufferedImage img, int hTiles, int vTiles) {

		returnParams = new Color[hTiles][vTiles];

		int width = img.getWidth() / hTiles;
		int heigth = img.getHeight() / vTiles;

		for (int i = 0; i < returnParams.length; i++) {
			for (int j = 0; j < returnParams[i].length; j++) {
				returnParams[i][j] = AnalyzeImage(img.getSubimage(i * width, j * heigth, width, heigth));
			}
		}

		return returnParams;
	}

	public Color AnalyzeImage(Image img) {

		grabber = new PixelGrabber(img, 0, 0, -1, -1, false);

		data = null;
		colors = new HashMap();

		// Beschaffen der einzelnen Pixelfarben
		try {
			grabber.grabPixels();
			// int width = grabber.getWidth();
			// int height = grabber.getHeight();
			data = (int[]) grabber.getPixels();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Gruppieren der Farben
		for (int i = 0; i < data.length; i++) {
			if (colors.containsKey(data[i])) {
				colors.replace(data[i], colors.get(data[i]) + 1);
			} else {
				colors.put(data[i], 1);
			}
		}

		// Int in RGB Werte umrechnen
		int alpha = 0, red = 0, green = 0, blue = 0;

		for (Map.Entry<Integer, Integer> entry : colors.entrySet()) {
			alpha += ((entry.getKey() >> 24) & 0xff) * entry.getValue();
			red += ((entry.getKey() >> 16) & 0xff) * entry.getValue();
			green += ((entry.getKey() >> 8) & 0xff) * entry.getValue();
			blue += ((entry.getKey()) & 0xff) * entry.getValue();
		}
//alpha / data.length, 
		return new Color( red / data.length, green / data.length, blue / data.length );
	}

}

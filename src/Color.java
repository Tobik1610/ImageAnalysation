
public class Color extends java.awt.Color {

	public Color(int r, int g, int b) {
		super(r, g, b);
		// TODO Auto-generated constructor stub
	}

	public boolean equalColorSpace(Color c) {
//		return this.getColorSpace().getType() == c.getColorSpace().getType();
		double distance = (c.getRed() - this.getRed())*(c.getRed() - this.getRed()) + (c.getGreen() - this.getGreen())*(c.getGreen() - this.getGreen()) + (c.getBlue() - this.getBlue())*(c.getBlue() - this.getBlue());
			    if(distance < 800){
			        return true;
			    }else{
			        return false;
			    }
	}

}

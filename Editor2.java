import java.awt.Color;

/**
 * Demonstrates the scaling (resizing) operation featured by Runigram.java. 
 * The program recieves three command-line arguments: a string representing the name
 * of the PPM file of a source image, and two integers that specify the width and the
 * height of the scaled, output image. For example, to scale/resize ironman.ppm to a width
 * of 100 pixels and a height of 900 pixels, use: java Editor2 ironman.ppm 100 900
 */
public class Editor2 {

	public static void main (String[] args){
		String fileName = args[0];
		int newWidth = Integer.parseInt(args[1]);
		int newHeight = Integer.parseInt(args[2]);
		// Reads the input image and creates an empty output image
		Color[][] imageIn = Runigram.read(fileName);	
		Color[][] imageOut = new Color[newHeight][newWidth];
		// Applies the scaling operation
		for (int i = 0; i < newHeight; i++) {
			for (int j = 0; j < newWidth; j++) {
				int startI = i * imageIn.length / newHeight;
				int startJ = j * imageIn[0].length / newWidth;
				imageOut[i][j] = imageIn[startI][startJ];
			}
		}
	
		Runigram.setCanvas(imageIn);
		Runigram.display(imageIn);
		StdDraw.pause(3000);
		Runigram.setCanvas(imageOut);  
		Runigram.display(imageOut);
		StdDraw.pause(3000);	
	}
}

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture. This class inherits from SimplePicture and
 * allows the student to add functionality to the Picture class.
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 *
 *         02-27-15 altered by Leon Schram This file is made shorter to focus on
 *         the Lab15b assignment.
 *
 */

// ////////////////////////////////////////////////////////////////////////
//
// This is the student starting file of the Lab15b assignment.
//
// This is the only file that students use to write their methods.
//
// ////////////////////////////////////////////////////////////////////////

public class Picture extends SimplePicture {
	// /////////////////// constructors //////////////////////////////////

	/**
	 * Constructor that takes no arguments
	 */
	public Picture() {
		/*
		 * not needed but use it to show students the implicit call to super()
		 * child constructors always call a parent constructor
		 */
		super();
	}

	/**
	 * Constructor that takes a file name and creates the picture
	 * 
	 * @param fileName
	 *            the name of the file to create the picture from
	 */
	public Picture(String fileName) {
		// let the parent class handle this fileName
		super(fileName);
	}

	/**
	 * Constructor that takes the width and height
	 * 
	 * @param height
	 *            the height of the desired picture
	 * @param width
	 *            the width of the desired picture
	 */
	public Picture(int height, int width) {
		// let the parent class handle this width and height
		super(width, height);
	}

	/**
	 * Constructor that takes a picture and creates a copy of that picture
	 * 
	 * @param copyPicture
	 *            the picture to copy
	 */
	public Picture(Picture copyPicture) {
		// let the parent class do the copy
		super(copyPicture);
	}

	/**
	 * Constructor that takes a buffered image
	 * 
	 * @param image
	 *            the buffered image to use
	 */
	public Picture(BufferedImage image) {
		super(image);
	}

	// //////////////////// methods ///////////////////////////////////////

	/**
	 * Method to return a string with information about this picture.
	 * 
	 * @return a string with information about the picture such as fileName,
	 *         height and width.
	 */
	public String toString() {
		String output = "Picture, filename " + getFileName() + " height "
				+ getHeight() + " width " + getWidth();
		return output;

	}

	// //////////////////////////////////////////////////////////////////////

	// REQUIRED FOR 80-POINTS
	public void grayScale() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				double average = pixelObj.getAverage(); // Finds average of
														// colors
				pixelObj.setBlue((int) average);
				pixelObj.setGreen((int) average);
				pixelObj.setRed((int) average);

			}
		}
	}

	// ////////////////////////////////////////////////////////////////////////

	// REQUIRED FOR 80-POINTS
	public void mirror() {
		Pixel[][] pixels = this.getPixels2D();
		int height = pixels.length;
		int width = pixels[0].length;
		int midIndex = width / 2;
		int lastIndex = width - 1;
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < midIndex; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][lastIndex - col];
				Color temp = rightPixel.getColor();
				rightPixel.setColor(leftPixel.getColor());
				leftPixel.setColor(temp);
			}
		}
	}

	// //////////////////////////////////////////////////////////////////////////////////////

	// REQUIRED FOR 80-POINTS
	public void upsideDown() {
		Pixel[][] pixels = this.getPixels2D();
		int height = pixels.length;
		int width = pixels[0].length;
		int midIndex = height / 2;
		int lastIndex = height - 1;
		Pixel top = null;
		Pixel bottom = null;
		
		for (int col = 0; col < width; col++) {
			for (int row = 0; row < midIndex; row++) {
				top = pixels[row][col];
				bottom = pixels[lastIndex - row][col];
				Color temp = bottom.getColor();
				bottom.setColor(top.getColor());
				top.setColor(temp);
			}
		}
	}

	// ////////////////////////////////////////////////////////////////////////////////////////

	// REQUIRED FOR 90-POINTS
	public void mirrorVertical() {
	}

	// ////////////////////////////////////////////////////////////////////////////////

	// REQUIRED FOR 90-POINTS
	public void mirrorHorizontal() {
	}

	// ////////////////////////////////////////////////////////////////////////////////////////////////

	// REQUIRED FOR 90-POINTS
	public void mirrorDiagonal() {
	}

	// ///////////////////////////////////////////////////////////////////////////////////

	// REQUIRED FOR 100-POINTS
	public void mirrorTemple() {
	}

}

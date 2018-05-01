// Kartik Maheshwari
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * Original Picture Size : 748 X 421
 * Canvas size should be: 2244 X 842
 */

/**
 * A class that represents a picture.  This class inherits from
 * SimplePicture and allows the student to add functionality to
 * the Picture class.
 *
 * Copyright Georgia Institute of Technology 2004-2005
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends CollageRunner
{
  ///////////////////// constructors //////////////////////////////////

  /**
   * Constructor that takes no arguments
   */
  public void TestPicture17 ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor
     */
    super();
  }

  /**
   * Constructor that takes a file name and creates the picture
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }

  /**
   * Constructor that takes the width and height
   * @param width the width of the desired picture
   * @param height the height of the desired picture
   */
  public Picture(int width, int height)
  {
    // let the parent class handle this width and height
    super(width,height);
  }

  /**
   * Constructor that takes a picture and creates a
   * copy of that picture
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }

  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }

  ////////////////////// methods ///////////////////////////////////////

  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() +
      " height " + getHeight()
      + " width " + getWidth();
    return output;

  }

  public static void main(String[] args)
  {
     String fileName = FileChooser.pickAFile();
     Picture pictObj = new Picture(fileName);
     pictObj.explore();
  }

  // --------------------My Methords-------------------------

  public void gray()
  {
	  int average =0;
	  Pixel[] pixelArray = this.getPixels(); // this copies pixels in the array.
	  for (Pixel spot : pixelArray)
	  {
		  int redValue = spot.getRed();
	      int greenValue = spot.getGreen();
	      int blueValue = spot.getBlue();
	      average = (redValue + greenValue + blueValue) / 3;

	      spot.setRed(average);
	      spot.setGreen(average);
	      spot.setBlue(average);
	   }
	   this.explore();

  }
  
  public void recursive(
}

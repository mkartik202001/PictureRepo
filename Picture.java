// Kartik Maheshwari
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from
 * SimplePicture and allows the student to add functionality to
 * the Picture class.
 *
 * Copyright Georgia Institute of Technology 2004-2005
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture
{
  ///////////////////// constructors //////////////////////////////////
  /**
   * Constructor that takes no arguments
   */
  public Picture()
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

  public void gray()
  {
      Pixel[] pixelArray = this.getPixels(); //might not be the best idea if you have a lot of pixels
      Pixel pixel = null;
      int intensity = 0;
      int red, blue, green;
      int avg;
      for (Pixel spot: pixelArray)
      {
        red = spot.getRed();
        blue = spot.getBlue();
        green = spot.getGreen();
        avg = (red + blue + green)/3;
        spot.setRed(avg);
        spot.setBlue(avg);
        spot.setGreen(avg);
      }
      //pixe.explore();

  }

  public void copyKatie(/*"sourceFile*"*/) //better way to do the first line of gray
  {
      String sourceFile = ("images/KatieFancy.jpg");
      Picture sourcePicture = new Picture(sourceFile);

      Pixel sourcePixel = null; //what am I taking from
      Pixel targetPixel = null; //where I am putting it on

      //width of source must be = or < the canvas I am copy to
      //loop through the columns
      for (int sourceX = 0, targetX = 0; sourceX < sourcePicture.getWidth(); sourceX++, targetX++)
      {
          //loop through the rows
          for (int sourceY = 0, targetY = 0; sourceY < sourcePicture.getHeight(); sourceY++, targetY++)
          {
              //set the target pixel color to the source pixel color
              sourcePixel = sourcePicture.getPixel(sourceX, sourceY);
              targetPixel = this.getPixel(targetX, targetY);
              targetPixel.setColor(sourcePixel.getColor());
          }
      }

  }


  public static void main(String[] args)
  {
     String fileName = FileChooser.pickAFile();
     Picture pictObj = new Picture(fileName);
     pictObj.explore();
  }

 
 
   public void mirrorVertical()
   {
       int mirrorPoint = (this.getWidth())/2;
       int width = this.getWidth();
       Pixel leftPixel = null;
       Pixel rightPixel = null;
       
       //loop throw all the rows
       for (int y = 0; y < getHeight(); y++) //column major
       {
           //loop from 0 to the middle (mirror point) 
           for (int x =0; x < mirrorPoint; x++)
           {
               leftPixel = getPixel(x,y);
               rightPixel = getPixel(width - 1- x, y); //pixels are in an array so width - 1
               rightPixel.setColor(leftPixel.getColor());
           }
        }
   }
}
   /*
    public void recursiveCall(int h, int w)
   {
     int height = h;
     int width = w;
     MainPicture sourcePicture = this;

     Pixel sourcePixel = null; //what am I taking from
     Pixel targetPixel = null; //where I am putting it on
     
     //width of source must be = or < the canvas I am copy to
     //loop through the columns
     for (int sourceX = 0, targetX = 0; sourceX < sourcePicture.getWidth(); sourceX+=2, targetX++)
     {
         //loop through the rows
         for (int sourceY = 0, targetY = 0; sourceY < sourcePicture.getHeight(); sourceY+=2, targetY++)
         {
             //set the target pixel color to the source pixel color
             sourcePixel = sourcePicture.getPixel(sourceX, sourceY);
             targetPixel = this.getPixel(targetX, targetY);
             targetPixel.setColor(sourcePixel.getColor());
         }
     }
     
     if (height == 0 && width == 0)
     {
         height = 0;
         width = 0;
     }
     else
     {
         recursiveCall(height/2, width/2);
     }
    }
    
    
}// ends the main class

  
  
  
 /*

  public void glassEffect( double amount)
  {
      Pixel randomPixel; 
      Pixel currentPixel; 
      int randomY, randomX; 
      for (int x = 0; x > getWidth(); x++)
      {
          for (int y = 0; y > getHeight(); y++)
          {
              randomX = random(x-amount, x+amount);
              randomY = random(y-amount, y+amount); 
              
              if ( randomX > getWidth())
                  randomX -= getWidth(); 
              if ( randomX > getWidth())
                  randomY -= getHeight(); 
              if ( randomY <0)
                  randomY += getWidth();
              if ( randomY >0)
                  randomY += getHeight(); 
                   
             
              randomPixel = getPixel(randomX, randomY); 
              currentPixel = getPixel(x,y); 
              currentPixel = getPixel(
              
          }
      }
      
      
      
  }
 
  public void edgeDetection(double amount)
  {
      Pixel leftPixel = null;
      Pixel rightPixel = null;
      Pixel bottomPixel=null;
      Pixel[][] pixels = this.getPixels2D();
      Color rightColor = null;
      boolean black;
      for (int row = 0; row < pixels.length; row++)
      {
          for (int col = 0; col < pixels[0].length; col++)
          {
              black=false;
              leftPixel = pixels[row][col];
              if (col<pixels[0].length-1)
              {
                  rightPixel = pixels[row][col+1];
                  rightColor = rightPixel.getColor();
                  if (leftPixel.colorDistance(rightColor) > edgeDist)
                  black=true;
              }
              if (row<pixels.length-1)
              {
                  bottomPixel =pixels[row+1][col];
                  if (leftPixel.colorDistance(bottomPixel.getColor())>edgeDist)
                        black=true;

              }
              if (black)
                    leftPixel.setColor(Color.BLACK);
              else
                    leftPixel.setColor(Color.WHITE);
          }
      }
  }
  
  public void swapBackground(Picture originalBackground, Picture newBackground, double threshold)
  {
      //int currentPixel , oldPixel; 
      
      for (Pixel stuff : pixel)
      {
          int originalBackground = stuff.getRed(); 
          
          
      }
 
  
  
  }
  
  public void recursion(int counter)
  {
      Pixel sourcePixel = null; 
      Pixel targetPixel = null; 
      
      for (int sourceX = 0, targetX = 0,  )
  
   }
   
*/

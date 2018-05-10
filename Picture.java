// Kartik Maheshwari
// Picture Project
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List
import java.io.*; 
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
  /**
   * Method for turning the image in gray 
   */
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

 
   /**
    * A method that mirrors the image vertically 
    */
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
   /**
    * Method that recursively reduces the height and width of the image by a cetain 
    * interger value that is specified in the runner main class
    */  
    public void recursiveCall(int h, int w)
   {
     int height = h;
     int width = w;
     Picture sourcePicture = this;

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
    /**
     * Nothing specific alteration with the RGB values of the image, but make them 
     * look burned and dark as the RGB values in the image are divided with sertain 
     * constants. 
     */
    public void funColor()
    {
     Pixel[] pixelArray = this.getPixels();
      for (Pixel spot: pixelArray)
     {
         int red = Math.abs(spot.getRed());
         int blue = Math.abs(spot.getBlue());
         int green = Math.abs(spot.getGreen());
         
         if (((red < blue) && (red > green)) || ((red < green) && (red > blue)))
         {
             spot.setRed(red/5);
             spot.setBlue(blue/5);
             spot.setGreen(green/5);
         }
         else if (((blue < red) && (blue > green)) || ((blue < green) && (blue > red)))
         {
             spot.setRed(red/3);
             spot.setBlue(blue/2);
             spot.setGreen(green/1);
         }
         else 
         {
             spot.setRed(red/2);
             spot.setBlue(blue/2);
             spot.setGreen(green/2);
         }
     }
    }
    /**
     * Method that flip the parent image. 
     */
     public void flip()
    {
     int height = this.getHeight() - 1; //if  X or Y is 0, then there's going to be an error
     int width = this.getWidth() - 1;
     Pixel[] pixelArray = this.getPixels(); //might not be the best idea if you have a lot of pixels
     Picture sourcePicture = this;
     Pixel sourcePixel = null;
     Pixel targetPixel = null;
     Color temp = null;
     for (int sourceX = 0, targetX = 0; sourceX < sourcePicture.getWidth()/2; sourceX++, targetX++)
     {
         //loop through the rows
         for (int sourceY = 0, targetY = 0; sourceY < sourcePicture.getHeight(); sourceY++, targetY++) //can't have both values divided by 2 because 2 quadrants don't 
                                                                                                          //change then
         {
             sourcePixel = sourcePicture.getPixel(sourceX, sourceY);
             targetPixel = this.getPixel(width - sourceX, height - sourceY);
             temp = targetPixel.getColor();
             targetPixel.setColor(sourcePixel.getColor());
             sourcePixel.setColor(temp);
         }
     }
     
    }
    
    
    /**
     * An image that overlaps the parent image. 
     */
     public void overlapJoker()
 {
     String sourceFile = ("images/Joker.png");
      Picture sourcePicture = new Picture(sourceFile);

      Pixel sourcePixel = null; 
      Pixel targetPixel = null; 

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
              
              sourcePixel = sourcePicture.getPixel(sourceX, sourceY);
              targetPixel = this.getPixel(targetX, targetY);
              targetPixel.setColor(sourcePixel.getColor());
           }

        }
    }
    
   /**
    * Method that mirrors the image recursively by copying the bottom pixels 
    * to the top
    */ 
       public void mirrorHorizontalBottomToTop()
       {
       int height = this.getHeight();
       int mirrorPoint = height/2;
       Pixel topPixel = null;
       Pixel bottomPixel = null;
       
       for (int x = 0; x < this.getWidth(); x++)
       {
           for (int y =0; y < mirrorPoint; y++)
           {
               topPixel = getPixel(x, y);
               bottomPixel = getPixel(x, height - 1 - y);
               topPixel.setColor(bottomPixel.getColor());
           }
       }
   }
      
}// end of main
    
 


    
    


  
  
  
 /*

  
  public void swapBackground(Picture originalBackground, Picture newBackground, double threshold)
  {
      //int currentPixel , oldPixel; 
      
      for (Pixel stuff : pixel)
      {
          int originalBackground = stuff.getRed(); 
          
          
      }
 
  
  
  }
  

   
   
   
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
     
   
*/

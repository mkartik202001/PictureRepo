

/**
 * Write a description of class Collage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class PictureRunner
{
    public void main (String []args)
    {
        MainPicture picture_Original = new MainPicture ("images/BatmanOriginal.jpeg"); 
        MainPicture something = new MainPicture ("images/Image_BatmanNew1.jpeg");
        
        Pixel[] pixels; 
        picture_Original.explore(); 
    }
}

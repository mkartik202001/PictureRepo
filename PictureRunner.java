

/**
 * Write a description of class Collage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class PictureRunner
{
    public static void main (String []args)
    {
        Picture picture_Original = new Picture ("images/BatmanOriginal.jpg"); 
        Picture picture_1 = new Picture ("images/BatmanOriginal.jpg");
        //Picture picture_2 = new Picture ("images/BatmanOriginal.jpeg");
        //Picture picture_3 = new Picture ("images/BatmanOriginal.jpeg");
        //Picture picture_4 = new Picture ("images/BatmanOriginal.jpeg");
        //Picture something = new Picture ("images/Image_BatmanNew1.jpeg");
        
        //Pixel[] pixels; 
        
        picture_Original.explore(); 
        picture_Original.gray();
        picture_Original.explore(); 
        
        
        picture_1.explore();
        picture_1.mirrorVertical(); 
        picture_1.explore();
        /*
        canvas.copy(picture1, x, y);
        canvas.copy(picture2, x, y);
        */
        
    }
}

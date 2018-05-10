

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
        Picture picture_2 = new Picture ("images/BatmanOriginal.jpg");
        Picture picture_3 = new Picture ("images/BatmanOriginal.jpg");
        Picture picture_4 = new Picture ("images/BatmanOriginal.jpg");
        Picture picture_5 = new Picture ("images/BatmanOriginal.jpg");
        //Picture something = new Picture ("images/Image_BatmanNew1.jpg");
        
        //Pixel[] pixels; 
        
        picture_Original.explore(); 
        
        //picture_1.explore();
        picture_1.mirrorVertical(); 
        picture_1.explore();
        
        
        //picture_2.explore();
        picture_2.recursiveCall(10,10); 
        picture_2.explore();
        
        //picture_3.explore();
        picture_3.funColor(); 
        picture_3.explore();
        
        picture_4.gray();
        picture_4.explore();
        
        picture_5.mirrorHorizontalBottomToTop(); 
        picture_5.explore(); 
        
        picture_1.write("images/method1_Batman.jpg");
        picture_2.write("images/method2_Batman.jpg");
        picture_3.write("images/method3_Batman.jpg");
        picture_4.write("images/method4_Batman.jpg"); 
        picture_5.write("images/method5_Batman.jpg"); 
        
        
        //Project_canvas.copy(picture_1, 0, 0);
        //canvas.copy(picture2, x, y);
        
        
    }
}

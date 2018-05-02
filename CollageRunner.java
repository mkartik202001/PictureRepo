

/**
 * Write a description of class Collage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CollageRunner 
{
    public void main (String []args)
    {
        Picture picture1 = new Picture ("images/BatmanOriginal.jpeg"); 
        Picture new1 = new Picture ("images/Image_BatmanNew1.jpeg");
        
        Picel [] pixels; 
        picture1.explore(); 
        
        new1.explore(); 
    }
}
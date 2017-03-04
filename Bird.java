// Bird class, implements the jumping bird
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Bird{

    private int xPos;
    private int yPos;
    private int width;
    private int height;
    private int speed;
    private int acceleration;
    private int jump;
    private ImageIcon img;

    //Bird Class
    public Bird(){
		xPos=200;
		yPos=300-height/2; //Start bird in the middle of the screen
		img = new ImageIcon("BabyTux.png"); //Use the included avatar to represent the bird
		width=img.getIconWidth(); //Get avatar sizes
		height=img.getIconHeight();
		speed=-15; //start bird speed (negative is falling)
		acceleration=1; 
		jump=-17; //jump height (negative because Y coordinates are 0 at the top and move down with positive numbers
    }
    
    //Jump class, gets called when space is pressed
    public void jump(){
		yPos+=jump;//update height
		speed=-15;//reset speed
    }
    
    //Move class, makes the avatar constantly fall
    public void move(){
		speed+=acceleration;//updates speed as avatar falls
		yPos+=speed;//decrease height
    }
    
    //Paint Bird on screen
    public void paint(Graphics2D brush){
		brush.drawImage(img.getImage(),xPos,yPos,null);
    }
    
    //Make hitbox for avatar
    public Rectangle2D.Double getBounds(){
    	return new Rectangle2D.Double(xPos,yPos,width,height);		
    }
    
    //Reset speed and accelerations
    public void reset(){
		acceleration=1;
		speed=2;
    }
}

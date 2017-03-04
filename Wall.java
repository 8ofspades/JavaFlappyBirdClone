//Wall class, implements moving walls
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Wall{
    private int xPos;
    private int yPos;
    private int speed;
    private int width;
    private int height;
    private int gap;
    private Rectangle2D.Double wallBottom;
    private Rectangle2D.Double wallTop;

    //create wall
    public Wall(int x){
		height=500;
		width=45;
		gap=180;
		speed=-5;
		yPos=(int)(Math.random()*400)+100; //random starting (middle) position for wall
		xPos=x;
		wallBottom=new Rectangle2D.Double(xPos,yPos,width,height);
		wallTop=new Rectangle2D.Double(xPos,(yPos-gap-height),width,height);
    }
    
    //Moves the wall from right to left
    public void move(){
		xPos+=speed; // update x position
		//If the wall has moved past the screen, place it back to the end and reset its gap position
		if(xPos<=0){
		    xPos=800;
		    yPos=(int)(Math.random()*400)+100;
		}
		//Redraw wall at new position
		wallBottom.setRect(xPos,yPos,width,height);
		wallTop=new Rectangle2D.Double(xPos,(yPos-gap-height),width,height);
    }
    
    //Draws wall on screen
    public void paint(Graphics2D brush){
		brush.draw(wallBottom);
		brush.draw(wallTop);
		brush.setColor(Color.GREEN);
		brush.fill(wallBottom);
		brush.fill(wallTop);
    }
    
    //Get bottom wall hitbox
    public Rectangle2D.Double getBottomBounds(){
		return wallBottom;
    }
    
    //Get top wall hitbox
    public Rectangle2D.Double getTopBounds(){
		return wallTop;
    }
}

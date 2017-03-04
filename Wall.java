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

    public Wall(int x){
	height=500;
	width=45;
	gap=180;
	speed=-5;
	yPos=(int)(Math.random()*400)+100;
	xPos=x;
	wallBottom=new Rectangle2D.Double(xPos,yPos,width,height);
	wallTop=new Rectangle2D.Double(xPos,(yPos-gap-height),width,height);
    }
    public void move(){
	xPos+=speed;
	if(xPos<=0){
	    xPos=800;
	    yPos=(int)(Math.random()*400)+100;
	}
	wallBottom.setRect(xPos,yPos,width,height);
	wallTop=new Rectangle2D.Double(xPos,(yPos-gap-height),width,height);


    }
    public void paint(Graphics2D brush){
	brush.draw(wallBottom);
	brush.draw(wallTop);
	brush.setColor(Color.GREEN);
	brush.fill(wallBottom);
	brush.fill(wallTop);
    }
    public Rectangle2D.Double getBottomBounds(){
	return wallBottom;
    }
    public Rectangle2D.Double getTopBounds(){
	return wallTop;
    }
}

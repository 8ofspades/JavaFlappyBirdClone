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

    public Bird(){
	xPos=200;
	yPos=300-height/2;
	img = new ImageIcon("BabyTux.png");
	width=img.getIconWidth();
	height=img.getIconHeight();
	speed=-15;
	acceleration=1;
	jump=-17;
    }
    public void jump(){
	yPos+=jump;
	speed=-15;
    }
    public void move(){
	speed+=acceleration;
	yPos+=speed;
    }
    public void paint(Graphics2D brush){
	brush.drawImage(img.getImage(),xPos,yPos,null);
    }
    public Rectangle2D.Double getBounds(){
	return new Rectangle2D.Double(xPos,yPos,width,height);
    }
    public void reset(){
	acceleration=1;
	speed=2;
    }
}

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;

public class FlappyBird{
    public static void main(String[] args){
	JFrame frame = new JFrame();
	frame.setSize(800,600);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	GamePanel game=new GamePanel();
	frame.add(game);
	frame.setVisible(true);
    }
    private static class GamePanel extends JPanel{
	Bird bird;
	Wall wall1;
	Wall wall2;
	Timer movetimer;
	Timer scoretimer;
	int score;
	boolean isDead;
	public GamePanel(){
	    bird=new Bird();
	    wall1=new Wall(600);
	    wall2=new Wall(1000);
	    movetimer=new Timer(30,new GameMotion());
	    movetimer.start();
	    scoretimer=new Timer(2400,new ScoreCounter());
	    scoretimer.start();
	    score=0;
	    isDead=false;
	    addKeyListener(new KeyAdapter());
	    setFocusable(true);
	}
	private class KeyAdapter implements KeyListener{
	    public void keyPressed(KeyEvent evt){
		int key=evt.getKeyCode();
		if(key==KeyEvent.VK_SPACE){
		    bird.jump();
		}
		if(key==KeyEvent.VK_R){
		    System.out.println("R is pressed");
		    //		    init();
		}
	    }
	    public void keyReleased(KeyEvent evt){}
	    public void keyTyped(KeyEvent evt){}
	}
	private class GameMotion implements ActionListener{
	    public void actionPerformed(ActionEvent evt){
		wall1.move();
		wall2.move();
		bird.move();
		checkForHit();
		repaint();
	    }
	}
	private class ScoreCounter implements ActionListener{
	    public void actionPerformed(ActionEvent evt){
		score+=1;
	    }
	}
	public void paintComponent(Graphics g){
	    g.setColor(Color.WHITE);
	    super.paintComponent(g);
	    Graphics2D g2=(Graphics2D)g;
	    if (isDead==true){
		g2.setColor(Color.BLACK);
		g2.setFont(new Font("Serif",Font.PLAIN,30));
		g2.drawString("Game Over!",300,300);
		g2.drawString("Your final score is "+score,250,330);
		movetimer.stop();
		scoretimer.stop();
	    }
	    else{
		wall1.paint(g2);
		wall2.paint(g2);
		bird.paint(g2);
		g2.setColor(Color.BLACK);
		g2.setFont(new Font("Serif", Font.PLAIN,20));
		g2.drawString("Score: "+score,50,50);
	    }
	}
	public void checkForHit(){
	    if(wall1.getTopBounds().intersects(bird.getBounds())||wall2.getTopBounds().intersects(bird.getBounds())||wall1.getTopBounds().intersects(bird.getBounds())||
	       wall2.getBottomBounds().intersects(bird.getBounds())||wall2.getBottomBounds().intersects(bird.getBounds())||bird.getBounds().intersects(new Rectangle2D.Double(0,600,800,10))){
		isDead=true;
	    }
	}
	/*	public static void init(){
	    bird=new Bird();
	    wall1=new Wall(600);
	    wall2=new Wall(1000);
	    movetimer=new Timer(30,new GameMotion());
	    movetimer.start();
	    scoretimer=new Timer(2400,new ScoreCounter());
	    scoretimer.start();
	    score=0;
	    isDead=false;
	    addKeyListener(new KeyAdapter());
	    setFocusable(true);
	    }*/
    }
}




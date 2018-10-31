import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import java.util.ArrayList;

public class SnakeRunner extends Canvas
	{
		static Snake snake = new Snake();
		static int xSize = 876;
		static int ySize = 780;
		static boolean up=false;
		static boolean down=false;
		static boolean right=true;
		static boolean left=false;
		static boolean gameOver=false;

		static ArrayList<Body> fruits = new ArrayList<Body>();
		static boolean needsFruit = true;

		
		public static void main(String[] args)
			{
				
				JFrame frame = new JFrame("Snake");
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    
		        SnakeRunner ex = new SnakeRunner();
		        frame.getContentPane().add(ex);
		        frame.pack();
		        frame.setResizable(false);
		        frame.setVisible(true);
		        ex.requestFocus();
		        
			}
		 public SnakeRunner()
			 {
		        setSize(new Dimension(xSize, ySize));
		        setBackground(Color.BLACK);
		        addKeyListener(new KeyAdapter() 
		        {
		            @Override
		            public void keyPressed(KeyEvent e) 
		            {
		                switch(e.getKeyCode())
		                {
		                	case KeyEvent.VK_DOWN:
		                		falseAll();
		                		down = true;
		                		break;
		                	case KeyEvent.VK_UP:
		                		falseAll();
		                		up = true;
		                		break;
		                	case KeyEvent.VK_RIGHT:
		                		falseAll();
		                		right = true;
		                		break;
		                	case KeyEvent.VK_LEFT:
		                		falseAll();
		                		left = true;
		                		break;
		                	case KeyEvent.VK_SPACE:
		                		falseAll();
		                		break;
		                }
		            }
		            
		        });
		        if(needsFruit)
	            	{
	            		createNewFruit();
	            	}
		        
		      
		        
		    }
		 public void falseAll()
		 {
			 up = false;
			 down = false;
			 left = false;
			 right = false;
		 }
		 public void paint(Graphics g)
		 {
			 g.setColor(Color.CYAN);

			 g.fillRect(snake.getHead().getxPos(), snake.getHead().getyPos(), 24, 24);
			 g.setColor(Color.RED);
			 g.fillRect(fruits.get(0).getxPos(), fruits.get(0).getyPos(), 24, 24);
			 moveSnake();
			
		 }
		 public void moveSnake()
		 {
			 try
				 {
			 
				if(up)
				 {
					if(snake.getHead().getyPos() > 0)
						{
							snake.getHead().setyPos(snake.getHead().getyPos()-24);
						}
					else
						{
							gameOver = true;
						}
				 }
				else if(down)
				 {
					 if(snake.getHead().getyPos() < (ySize - 24))
							{
								snake.getHead().setyPos(snake.getHead().getyPos()+24);
							}
						else
							{
								gameOver = true;
							}	
				 }
				else if(right)
				 {
					 if(snake.getHead().getxPos() < (xSize - 24))
							{
								snake.getHead().setxPos(snake.getHead().getxPos()+24);
							}
						else
							{
								gameOver = true;
							}	
				 }
				else if(left)
				 {
					 if(snake.getHead().getxPos() > 0)
							{
								snake.getHead().setxPos(snake.getHead().getxPos()-24);
							}
						else
							{
								gameOver = true;
							}	
				 }
				repaint(); 
				Thread.sleep(100);

				 }
			 catch(Exception e)
				 {
					System.out.println("bet"); 
				 }
				
				
		 }
		 public void createNewFruit()
		 {
			 int fruitX = ((int) (Math.random()*37)) * 24;
			 int fruitY = ((int) (Math.random()*33)) * 24;
			 fruits.add(new Body(fruitX,fruitY));
		 }
		 
	}

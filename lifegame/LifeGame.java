package lifegame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class LifeGame extends JFrame
{
	private final World world;
	
	public LifeGame(int rows, int columns)
	{
		world = new World(rows, columns);
		new Thread(world).start();
		add(world);
	}
	
    public static void main(String[] args) 
    {
    	LifeGame frame = new LifeGame(40, 50);
    	
        JMenuBar menu = new JMenuBar();
        frame.setJMenuBar(menu);
        
        JMenu options = new JMenu("Options");
        menu.add(options);
        
        JMenuItem arrow = options.add("Circle");
        arrow.addActionListener(frame.new ArrowActionListener());
        
        JMenuItem square = options.add("Square");
        square.addActionListener(frame.new SquareActionListener());  
        
        JMenuItem random = options.add("Random");
        random.addActionListener(frame.new RandomActionListener());     
 
        
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1007, 865);
        frame.setTitle("LifeGame");
        frame.setVisible(true);
        frame.setResizable(false);
        
        
    }	
    
    class ArrowActionListener implements ActionListener
    {
    	public void actionPerformed(ActionEvent e) 
    	{
    		world.setArrow();
    	}
    }
    
    class SquareActionListener implements ActionListener
    {
    	public void actionPerformed(ActionEvent e) 
    	{
    		world.setSquare();
    	}
    }    
    
    class RandomActionListener implements ActionListener
    {
    	public void actionPerformed(ActionEvent e) 
    	{
    		world.setRandom();
    	}
    }

}

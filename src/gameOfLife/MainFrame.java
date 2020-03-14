package gameOfLife;

import java.awt.BorderLayout;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainFrame extends JFrame implements Runnable, ToolbarListener {

	private Toolbar toolbar; 
	protected Grid grid; 
	boolean running = false;
	protected CicleLifeThread thread; 
	private ToolbarListener toolbarlistener; 
	private int speed; 


	public MainFrame() {
		setTitle("Game Of Life");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(640,705);
		setVisible(true);
		setResizable(true); 
		setLocationRelativeTo(null);
		
		setLayout(new BorderLayout()); 
	
		toolbar = new Toolbar(this); 
		grid = new Grid();
		
		add(toolbar, BorderLayout.NORTH); 
		add(grid, BorderLayout.CENTER); 
	}
	
	

	public int getSpeed() {
		return speed;
	}



	public void setSpeed(int speed) {
		this.speed = speed;
	}



	@Override
	public void run() {
		new CicleLifeThread(this); 
		
	}


	@Override
	public void start() {
		
		toolbarlistener.start();
		
	}

	@Override
	public void clear() {
		
		toolbarlistener.clear();
	}

	@Override
	public void stop() {
	
		toolbarlistener.stop();
		
	}


	@Override
	public void speed() {
		toolbarlistener.speed();
		
	}
	

}
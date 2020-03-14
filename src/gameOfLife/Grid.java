package gameOfLife;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Grid extends JPanel implements MouseListener, MouseMotionListener {

	private World world;
	
	public Grid(){
		addMouseListener(this);
		addMouseMotionListener(this); 
		
		world = new World();
	}
	
	public void paintComponent(Graphics g){

		for(int col=0; col<world.getCOL(); col++){
			for(int row=0; row<world.getROW(); row++){
				if(world.getCelula(col,row).getEstado()==CellStatus.ALIVE)
					g.setColor(Color.YELLOW);		
				else
					g.setColor(Color.GRAY);
				g.fillRect(row*world.getROW(), col*world.getCOL(), world.getCOL(), world.getROW());	
				
				g.setColor(Color.BLACK);
				g.fillRect(row*world.getROW(), col*world.getCOL(), getWidth(), 1);
				g.fillRect(row*world.getROW(), col*world.getCOL(), 1, getHeight());
			}
		}	
	}
	public World getJuego(){ return world;}
	
	public void mouseClicked(MouseEvent arg0) {}

	public void mouseEntered(MouseEvent arg0) {}

	public void mouseExited(MouseEvent arg0) {}

	public void mousePressed(MouseEvent e) {
		world.setDeadOrAliveCell(Math.abs(e.getY()/world.getCOL()), Math.abs(e.getX()/world.getROW()));
		repaint();
	}

	public void mouseReleased(MouseEvent arg0) {}

	@Override
	public void mouseDragged(MouseEvent e) {
		world.setDeadOrAliveCell(Math.abs(e.getY()/world.getCOL()), Math.abs(e.getX()/world.getROW()));
		repaint();
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {}
	
	
}

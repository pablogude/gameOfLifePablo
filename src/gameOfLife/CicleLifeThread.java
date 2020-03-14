package gameOfLife;

public class CicleLifeThread implements Runnable {

	private MainFrame mainFrame;
	
	public CicleLifeThread(MainFrame mainFrame) {
	    this.mainFrame = mainFrame;	
	}

	@Override
	public void run() {

		while (mainFrame.running) {
			mainFrame.grid.getJuego().goThroughGrid();
			mainFrame.grid.getJuego().goThroughKillAndReborn();
			mainFrame.repaint();
			try {
				Thread.sleep(mainFrame.getSpeed());
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public MainFrame getMainFrame() {
		return mainFrame;
	}

	public void setMainFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

}

package gameOfLife;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class Toolbar extends JPanel implements ActionListener, ToolbarListener {
	private JButton btnClear;
	private JButton btnStart;
	private JButton btnStop;
	private JLabel speedLabel;
	private JComboBox speedList;
	private MainFrame mainFrame;
	//private CicleLifeThread thread; 
	
	String[] speed = { "slow", "medium", "fast" };

	public Toolbar(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		Border border = BorderFactory.createEtchedBorder();

		setBorder(border);
		btnClear = new JButton("Clear");
		btnClear.addActionListener(this);
		btnStart = new JButton("Start");
		btnStart.addActionListener(this);
		btnStop = new JButton("Stop");
		btnStop.addActionListener(this);

		speedLabel = new JLabel("Speed: ");
		speedList = new JComboBox(speed);
		speedList.setSelectedIndex(0);
		speedList.addActionListener(this);

		setLayout(new FlowLayout(FlowLayout.LEFT));

		add(btnClear);
		add(btnStart);
		add(btnStop);
		add(speedLabel);
		add(speedList);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnStart) {
			start();
		} else if (e.getSource() == btnStop) {
			stop();
		} else if (e.getSource() == btnClear) {
			clear();
		} else if(e.getSource() == speedList) {
			speed(); 
		}
	}

	@Override
	public void start() {
		mainFrame.running = true;
		CicleLifeThread cicleLife = new CicleLifeThread(mainFrame);
		Thread cicleLifeThread = new Thread(cicleLife);
		cicleLifeThread.start();

	}

	@Override
	public void clear() {
		mainFrame.running = false;
		mainFrame.grid.getJuego().clearGrid();
		btnStart.setText("Start");
		mainFrame.repaint();

	}

	@Override
	public void stop() {
		mainFrame.running = false;

	}

	@Override
	public void speed() { 
		int i; 
		int text = speedList.getSelectedIndex();
		System.out.println(text);
	
		switch(text) {
		case 1: 
			i = 1000; 
			mainFrame.setSpeed(i);
			break; 
		case 2: 
			i = 500; 
			//mainFrame.thread.setSpeed(i);
			break; 
		case 3: 
			//i = 1000 ;
			//mainFrame.thread.setSpeed(i);
			break; 
		}
		
	}

}

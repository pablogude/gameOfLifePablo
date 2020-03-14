package gameOfLife;

public class World  {
	
	private int COL = 25; 
	private int ROW = 25; 
	
	public Cell world[][]= new Cell[COL][ROW];
	
	public World(){
		for(int col=0; col<COL; col++){
			for(int row=0; row<ROW; row++){
				world[col][row]= new Cell(col,row,CellStatus.DEAD);
			}
		}	
	}

	public void goThroughGrid(){
		int neighboursCounter;
		for(int col=0; col<world.length; col++){
			for(int row=0; row<world[col].length; row++){		
					neighboursCounter=countNeighbours(col,row);
				if(neighboursCounter==3 && world[col][row].getEstado()==CellStatus.DEAD)
					world[col][row].setEstado(CellStatus.ALMOSTALIVE);
				else if((neighboursCounter<2 || neighboursCounter>3) && world[col][row].getEstado()==CellStatus.ALIVE)
					world[col][row].setEstado(CellStatus.ALMOSTDEAD);
			}
		}
	}
	public int countNeighbours(int col, int row){
		int neighboursCounter=0;
		for(int column=col-1; column<=col+1; column++){
			for(int roow=row-1; roow<=row+1; roow++){
				try {
					if((world[column][roow].getEstado()==CellStatus.ALIVE
							|| world[column][roow].getEstado()==CellStatus.ALMOSTDEAD)
							&& (column!=col || roow!=row))
						neighboursCounter++;	
				} catch(IndexOutOfBoundsException e){}						
			}
		}
		return neighboursCounter;
	}
	public void goThroughKillAndReborn(){
		for(int col=0; col<world.length; col++){
			for(int row=0; row<world[col].length; row++){		
				if(world[col][row].getEstado()==CellStatus.ALMOSTDEAD)
					world[col][row].setEstado(CellStatus.DEAD);
				else if(world[col][row].getEstado()==CellStatus.ALMOSTALIVE)
					world[col][row].setEstado(CellStatus.ALIVE);
			}
		}
	}
	
	public void clearGrid(){
			for(int col=0; col<world.length; col++){
				for(int row=0; row<world[col].length; row++){		
						world[col][row].setEstado(CellStatus.DEAD);
				}
			}
	}
	
	public Cell getCelula(int col, int row){
		return world[col][row];
	}
	
	public void setDeadOrAliveCell(int col, int row){
		if(world[col][row].getEstado()==CellStatus.DEAD || world[col][row].getEstado()==CellStatus.ALMOSTDEAD)
			world[col][row].setEstado(CellStatus.ALIVE);
		else
			world[col][row].setEstado(CellStatus.DEAD);
	}
	
	public int getCOL() {
		return COL;
	}

	public void setCOL(int cOL) {
		COL = cOL;
	}

	public int getROW() {
		return ROW;
	}

	public void setROW(int rOW) {
		ROW = rOW;
	}


}

package gameOfLife;

public class Cell {
	CellStatus estado;
	int x, y;

	public Cell(int fila, int colum, CellStatus estado) {
		this.estado = estado;
		this.x = fila;
		this.y = colum;
	}

	public CellStatus getEstado() {
		return estado;

	}

	public void setEstado(CellStatus estado) {
		this.estado = estado;

	}

	public int getCol() {
		return x;
	}

	public void setCol(int col) {
		this.x = col;
	}

	public int getRow() {
		return y;
	}

	public void setRow(int row) {
		this.y = row;
	}
	
	
}

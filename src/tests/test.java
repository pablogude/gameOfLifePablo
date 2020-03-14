package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

import gameOfLife.Cell;
import gameOfLife.CellStatus;
import gameOfLife.World;

class test {
	
	@Test
	void testIfnewGameIsCreateGameNotNull() {
		World game = new World();
		game.world = new Cell[3][3];
		
		assertNotNull(game); 	
	}
	
	// ---------------------------------------------------------------------------------------------
	// TESTING FIRST RULE
	//
	// Any live cell with fewer than two live neighbours dies, as if by UNDERPOPULATION.
	//
	// ---------------------------------------------------------------------------------------------
	
	@Test
	void testIfOnlyOneCellAndNoNeighboursCellDies() {
		World game = new World();
		
		game.world[0][0] = new Cell(0,0,CellStatus.ALIVE);
		game.goThroughGrid();
		game.goThroughKillAndReborn();
		
		assertEquals(game.world[0][0].getEstado(), CellStatus.DEAD); 	
	}
	
	@Test
	void testIfOnlyOneCellAndOnlyOneNeighboursCellDies() {
		World game = new World();
		
		game.world[0][0] = new Cell(0,0,CellStatus.ALIVE);
		game.world[0][1] = new Cell(0,1,CellStatus.ALIVE); 
		game.goThroughGrid();
		game.goThroughKillAndReborn();
		
		assertEquals(game.world[0][0].getEstado(), CellStatus.DEAD); 	
	}
	
	@Test
	void testIfOneCellAndTwoNeighboursCellDies() {
		World game = new World();
		
		game.world[0][0] = new Cell(0,0,CellStatus.ALIVE);
		game.world[0][1] = new Cell(0,1,CellStatus.ALIVE); 
		game.goThroughGrid();
		game.goThroughKillAndReborn();
		
		assertEquals(game.world[1][0].getEstado(), CellStatus.DEAD); 	
	}
	
	
	// ---------------------------------------------------------------------------------------------	
	// TESTING SECOND RULE
	//
	// Any live cell with two or three live neighbours lives on to the next generation.
	//
	// ---------------------------------------------------------------------------------------------	
	@Test
	void testIfOneCellWithTwoNeighboursLivesOnToTheNextGeneration() {
		World game = new World();
		
		game.world[0][0] = new Cell(0,0,CellStatus.ALIVE);
		game.world[0][1] = new Cell(0,1,CellStatus.ALIVE);
		game.world[1][1] = new Cell(1,1,CellStatus.ALIVE);
		
		game.goThroughGrid();
		game.goThroughKillAndReborn();
		
		assertEquals(game.world[1][1].getEstado(), CellStatus.ALIVE); 	
	}
	
	@Test
	void testIfOneCellWithThreeNeighboursLivesOnToTheNextGeneration() {
		World game = new World();
		
		game.world[0][0] = new Cell(0,0,CellStatus.ALIVE);
		game.world[0][1] = new Cell(0,1,CellStatus.ALIVE);
		game.world[1][0] = new Cell(1,0,CellStatus.ALIVE);
		game.world[1][1] = new Cell(1,1,CellStatus.ALIVE);
		
		game.goThroughGrid();
		game.goThroughKillAndReborn();
		
		assertEquals(game.world[0][0].getEstado(), CellStatus.ALIVE); 	
	}
	

	// ---------------------------------------------------------------------------------------------
	// TESTING THIRD RULE
	//
	// Any dead cell with exactly three live neighbours becomes a live cell, as if by REPRODUCTION.
	//
	// ---------------------------------------------------------------------------------------------
	
	
	@Test
	void testIfOneDeadCellWithThreeNeighboursBecomesAlive() {
		World game = new World();
		
		assertEquals(game.world[1][1].getEstado(), CellStatus.DEAD); 
		
		game.world[0][0] = new Cell(0,0,CellStatus.ALIVE);
		game.world[0][1] = new Cell(0,1,CellStatus.ALIVE);
		game.world[0][2] = new Cell(0,2,CellStatus.ALIVE);
		
		game.goThroughGrid();
		game.goThroughKillAndReborn();
		
		assertEquals(game.world[1][1].getEstado(), CellStatus.ALIVE); 	
	}
	
	// ---------------------------------------------------------------------------------------------	
	// TESTING FOURTH RULE
	//
	// Any live cell with more than three live neighbours dies, as if by OVERPOPULATION.
	//
	// ---------------------------------------------------------------------------------------------	
	
	@Test
	void testIfCellWithMoreThanThreeNeighboursDies() {
		World game = new World();
		
		game.world[0][0] = new Cell(0,0,CellStatus.ALIVE);
		game.world[0][1] = new Cell(0,1,CellStatus.ALIVE);
		game.world[1][0] = new Cell(1,0,CellStatus.ALIVE);
		game.world[2][2] = new Cell(2,2,CellStatus.ALIVE); 
		
		game.goThroughGrid();
		game.goThroughKillAndReborn();
		
		assertEquals(game.world[1][1].getEstado(), CellStatus.DEAD); 	
	}
	
	// ---------------------------------------------------------------------------------------------	
	//
	// TESTING IF GRID IS CLEARED WHEN PRESSING CLEARGRID BUTTON 
	//
	// ---------------------------------------------------------------------------------------------
	
	@Test
	void testIfButtonClearGridIsPressedGridIsCleared() {
		
		World game = new World();
		
		game.world[0][0] = new Cell(0,0,CellStatus.ALIVE);
		game.world[0][1] = new Cell(0,1,CellStatus.ALIVE);
		game.world[1][0] = new Cell(1,0,CellStatus.ALIVE);
		game.world[2][2] = new Cell(2,2,CellStatus.ALIVE); 
		
		game.goThroughGrid();
		game.goThroughKillAndReborn();
		game.clearGrid();
		
		assertEquals(game.world[0][0].getEstado(), CellStatus.DEAD); 
		assertEquals(game.world[0][1].getEstado(), CellStatus.DEAD);
		assertEquals(game.world[1][0].getEstado(), CellStatus.DEAD);
		assertEquals(game.world[2][2].getEstado(), CellStatus.DEAD);
		
	}
	
	// ---------------------------------------------------------------------------------------------	
	//
	// TESTING IF PRESSING ONTO AN ALIVE CELL -> BECOMES A DEAD CELL 
	//
	// ---------------------------------------------------------------------------------------------
	
	@Test
	void testIfPressingOntoAnAliveCellBecomesAdeadOne() {
		
		World game = new World();
		
		game.world[0][0] = new Cell(0,0,CellStatus.ALIVE);
		game.world[0][1] = new Cell(0,1,CellStatus.ALIVE);
		game.world[1][0] = new Cell(1,0,CellStatus.ALIVE);
		game.world[1][1] = new Cell(1,1,CellStatus.ALIVE);
		
		
		game.goThroughGrid();
		game.goThroughKillAndReborn();
		game.setDeadOrAliveCell(0,0);
		
		assertEquals(game.world[0][0].getEstado(), CellStatus.DEAD); 
		
	}
	
	// ---------------------------------------------------------------------------------------------	
	//
	// TESTING IF PRESSING ONTO A DEAD CELL -> BECOMES AN ALIVE CELL 
	//
	// ---------------------------------------------------------------------------------------------
	
	@Test
	void testIfPressingOntoAdeadCellBecomesAnAliveOne() {
		
		World game = new World();
		
		game.world[0][0] = new Cell(0,0,CellStatus.DEAD);
		
		game.goThroughGrid();
		game.goThroughKillAndReborn();
		game.setDeadOrAliveCell(0,0);
		
		assertEquals(game.world[0][0].getEstado(), CellStatus.ALIVE); 
		
	}
	
	// ---------------------------------------------------------------------------------------------	
	//
	// TESTING IF ACCESING TO THE GETCELULA METHOD -> CELL.X POSITION AND CELL.Y POSITION 
	//
	// ---------------------------------------------------------------------------------------------
	
	@Test
	void testIfPre() {
		
		Cell cell = new Cell(0,0,CellStatus.ALIVE); 
		World game = new World();
		game.getCelula(cell.getCol(), cell.getRow());
		
		equals(game.getCelula(0, 0)); 
		
	}
	
	
	

}

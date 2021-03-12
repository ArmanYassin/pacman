package pacman.test;

import static org.junit.jupiter.api.Assertions.*;
import pacman.MazeMap;
import pacman.Square;
import pacman.Direction;

import org.junit.jupiter.api.Test;
 
class SquareTest {

	@Test
	void test() {
	 
		MazeMap mazemap = new MazeMap(2, 3, new boolean[] {true,true,true,false,true,false});
		Square square00 = Square.of(mazemap, 0, 0);  
		Square square01 = Square.of(mazemap, 0, 1);  
		Square square10 = Square.of(mazemap, 1, 0);  
		Square square11 = Square.of(mazemap, 1, 1);
		Square square20 = Square.of(mazemap, 2, 0);
		Square square21 = Square.of(mazemap, 2, 1);
		assertEquals(0, square01.getRowIndex()); 
		assertEquals(1, square01.getColumnIndex());
		assertEquals(true, square01.isPassable());  
		//assertEquals(square11, square01.getNeighbor(Direction.UP));
		assertEquals(1, square00.getNeighbor(Direction.LEFT).getColumnIndex());
		assertEquals(square11.getMazeMap(), square01.getNeighbor(Direction.DOWN).getMazeMap());
		assertEquals(1, square01.getNeighbor(Direction.UP).getColumnIndex()); 
		assertEquals(1, square21.getNeighbor(Direction.UP).getColumnIndex()); 
		assertEquals(false, square01.canMove(Direction.UP));    
		assertEquals(2, square01.getPassableDirectionsExcept(Direction.DOWN).length);
		assertEquals(true, square11.equals(square11));	
		assertEquals(true, square21.canMove(Direction.LEFT));
		assertEquals(true, square21.canMove(Direction.RIGHT));   
		assertEquals(3, square00.getPassableDirectionsExcept(Direction.DOWN).length);
		assertEquals(1, square10.getPassableDirectionsExcept(Direction.UP).length);
		assertEquals(1, square20.getPassableDirectionsExcept(Direction.DOWN).length);
	} 

}

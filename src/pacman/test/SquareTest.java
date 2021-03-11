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
		Square square01 = Square.of(mazemap, 0, 1);  
		Square square11 = Square.of(mazemap, 1, 1);  
		Square square00 = Square.of(mazemap, 0, 0);  
		Square square10 = Square.of(mazemap, 1, 0);
		Square square02 = Square.of(mazemap, 0, 2);
		Square square12 = Square.of(mazemap, 1, 2);
		assertEquals(0, square01.getRowIndex()); 
		assertEquals(1, square01.getColumnIndex());
		assertEquals(true, square01.isPassable());  
//		//assertEquals(square11, square01.getNeighbor(Direction.UP));
		assertEquals(2, square00.getNeighbor(Direction.LEFT).getColumnIndex());
//		//assertEquals(square11.getMazeMap(), square01.getNeighbor(Direction.DOWN).getMazeMap());
		//assertEquals(0, square01.getNeighbor(Direction.UP).getColumnIndex()); 
		assertEquals(true, square01.canMove(Direction.UP));
		assertEquals(3, square01.getPassableDirectionsExcept(Direction.DOWN).length);
		assertEquals(true, square11.equals(square11));

		
	} 

}

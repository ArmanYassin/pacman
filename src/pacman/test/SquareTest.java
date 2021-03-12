package pacman.test;

import static org.junit.jupiter.api.Assertions.*;
import pacman.MazeMap;
import pacman.Square;
import pacman.Direction;

import org.junit.jupiter.api.Test;
 
class SquareTest {

	@Test
	void test() {
		MazeMap mazemap = new MazeMap(4, 3, new boolean[] 
				{true,true,true,true,
				false,true,false,true,
				true,false,true,true});
		Square square01 = Square.of(mazemap, 0, 1);  
		Square square11 = Square.of(mazemap, 1, 1);  
		Square square02 = Square.of(mazemap, 0, 2);
		Square square12 = Square.of(mazemap, 1, 2);
		Square square13 = Square.of(mazemap, 1, 3);
		Square square21 = Square.of(mazemap, 2, 1);
		Square square22 = Square.of(mazemap, 2, 2);
		assertEquals(0, square01.getRowIndex()); 
		assertEquals(1, square01.getColumnIndex());
		assertEquals(false, square21.isPassable());  
		assertEquals(true, square22.getNeighbor(Direction.DOWN).equals(square02));
		assertEquals(square11.getMazeMap(), square01.getNeighbor(Direction.DOWN).getMazeMap());
		assertEquals(1, square01.getNeighbor(Direction.UP).getColumnIndex()); 
		assertEquals(3, square12.getNeighbor(Direction.RIGHT).getColumnIndex()); 
		assertEquals(false, square11.canMove(Direction.DOWN));    
		assertEquals(1, square13.getPassableDirectionsExcept(Direction.DOWN).length);
		assertEquals(true, square11.equals(square11));		
	} 

}

package pacman.test;

import static org.junit.jupiter.api.Assertions.*;
import pacman.MazeMap;
import pacman.Square;
import pacman.Direction;

import org.junit.jupiter.api.Test;

class SquareTest {

	@Test
	void test() {
	
		MazeMap mazemap = new MazeMap(2, 2, new boolean[] {true,true,true,false});
		Square square = Square.of(mazemap, 0, 1); 
		Square square2 = Square.of(mazemap, 1, 1); 
		Square square00 = Square.of(mazemap, 0, 0);
		Square square10 = Square.of(mazemap, 1, 0);
		assertEquals(0, square.getRowIndex());
		assertEquals(1, square.getColumnIndex());
		assertEquals(true, square.isPassable());
		assertEquals(square2.getRowIndex(), square.getNeighbor(Direction.DOWN).getRowIndex());
		assertEquals(1, square.getNeighbor(Direction.UP).getColumnIndex());
		assertEquals(false, square.canMove(Direction.UP));
		assertEquals(2, square.getPassableDirectionsExcept(Direction.DOWN).length);
		assertEquals(true, square00.equals(square00));
	} 

}

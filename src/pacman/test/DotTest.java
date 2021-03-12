package pacman.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import pacman.Dot;
import pacman.MazeMap;
import pacman.Square;
import pacman.Direction;

class DotTest {

	@Test
	void test() {
		MazeMap mazemap = new MazeMap(2, 3, new boolean[] {true,true,true,false,false,true});
		Square square = Square.of(mazemap, 2, 1);
		Dot dot = new Dot(square);
		assertEquals(square, dot.getSquare());
		assertEquals(dot.getSquare().getRowIndex(), 2);
		assertEquals(dot.getSquare().getColumnIndex(), 1);
		assertEquals(dot.getSquare().isPassable(), true);
		assertEquals(dot.getSquare().getNeighbor(Direction.UP).isPassable(), false);
		assertEquals(dot.getSquare().getNeighbor(Direction.LEFT).isPassable(), false);
		assertEquals(dot.getSquare().getNeighbor(Direction.DOWN).isPassable(), true);
		assertEquals(dot.getSquare().getNeighbor(Direction.RIGHT).isPassable(), false);


	} 

} 

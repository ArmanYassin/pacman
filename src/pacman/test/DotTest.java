package pacman.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import pacman.Dot;
import pacman.MazeMap;
import pacman.Square;

class DotTest {

	@Test
	void test() {
		MazeMap mazemap = new MazeMap(2, 2, new boolean[] {true,true,true,false});
		Square square = Square.of(mazemap, 0, 1);
		Dot dot = new Dot(square);
		assertEquals(square, dot.getSquare());

	}

} 

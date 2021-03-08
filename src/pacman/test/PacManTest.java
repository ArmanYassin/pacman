package pacman.test;
 
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import pacman.PacMan;
import pacman.MazeMap;
import pacman.Square;

class PacManTest {

	@Test
	void test() {
		MazeMap mazemap = new MazeMap(2, 2, new boolean[] {true,true,true,false});
		Square square = Square.of(mazemap, 0, 1);
		Square square2 = Square.of(mazemap, 1, 1);
		Square square00 = Square.of(mazemap, 0, 0);
		Square square10 = Square.of(mazemap, 1, 0);
		PacMan pacman = new PacMan(3,square);
		assertEquals(3, pacman.getNbLives());
		assertEquals(square, pacman.getSquare());
		pacman.setSquare(square10);
		assertEquals(square10, pacman.getSquare());
		pacman.die();
		assertEquals(2, pacman.getNbLives());
		
	
	}

}

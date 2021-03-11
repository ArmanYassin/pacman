package pacman.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pacman.Direction;
import pacman.Ghost;
import pacman.MazeMap;
import pacman.Square;
import java.util.Random;
 
class GhostTest {

	@Test
	void test() {
		MazeMap mazemap = new MazeMap(2, 2, new boolean[] {true,true,true,false}); 
		Direction direction = Direction.DOWN;
		Square square = Square.of(mazemap, 0, 1); 
		Square square2 = Square.of(mazemap, 0, 0);				
		Ghost ghost = new Ghost(square, direction);
		assertEquals(Direction.DOWN, ghost.getDirection());
		ghost.setSquare(square2); 
		assertEquals(square2, ghost.getSquare());
		ghost.setDirection(Direction.UP);
		assertEquals(Direction.UP, ghost.getDirection());
		
		Random random = new Random();
		ghost.chooseNextMoveDirection(random);
		ghost.move(random);
		assertNotNull(ghost.getSquare());
		assertNotNull(ghost.getDirection());
		MazeMap mazemap2 = new MazeMap(2,2, new boolean[] {false,false,false,false});
		Square square3 = Square.of(mazemap2, 0, 0);
		Ghost ghost2 = new Ghost(square3, Direction.UP);
		assertNotNull(ghost2.chooseNextMoveDirection(random));
	}

}
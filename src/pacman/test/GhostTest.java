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
		MazeMap mazemap = new MazeMap(3, 2, new boolean[] {true,true,true,false,false,true}); 
		Direction direction = Direction.DOWN;
		Square square01 = Square.of(mazemap, 0, 1); 
		Square square00 = Square.of(mazemap, 0, 0);	
		Square square02 = Square.of(mazemap, 0, 2);
		Ghost ghost = new Ghost(square01, direction);
		assertEquals(Direction.DOWN, ghost.getDirection());
		ghost.setSquare(square00); 
		assertEquals(square00, ghost.getSquare());
		ghost.setDirection(Direction.UP);
		assertEquals(Direction.UP, ghost.getDirection());
		ghost.setSquare(square02);
		assertEquals(ghost.getSquare().getNeighbor(Direction.UP).getColumnIndex(),ghost.getSquare().getColumnIndex());
		
		Random random = new Random();
		ghost.chooseNextMoveDirection(random);
		ghost.move(random);
		assertNotNull(ghost.getSquare());
		assertNotNull(ghost.getDirection());
		MazeMap mazemap2 = new MazeMap(2,2, new boolean[] {true,false,false,false});
		Square square3 = Square.of(mazemap2, 0, 0);
		Ghost ghost2 = new Ghost(square3, Direction.UP);
		assertNotNull(ghost2.chooseNextMoveDirection(random));
	}

}
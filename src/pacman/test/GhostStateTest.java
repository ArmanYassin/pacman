package pacman.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

import pacman.Direction;
import pacman.Ghost;
import pacman.GhostState;
import pacman.MazeMap;
import pacman.RegularGhostState;
import pacman.Square;

class GhostStateTest {

	@Test
	void test() {
		MazeMap mazemap = new MazeMap(3, 2, new boolean[] {true,true,true,
														  false,false,true}); 
		Direction direction = Direction.DOWN;
		Square square00 = Square.of(mazemap, 0, 0);	
		Square square01 = Square.of(mazemap, 0, 1); 
		Square square02 = Square.of(mazemap, 0, 2);
		Square square10 = Square.of(mazemap, 1, 0);	
		Square square11 = Square.of(mazemap, 1, 1);	
		Square square12 = Square.of(mazemap, 1, 2);	
		Ghost ghost = new Ghost(square01, direction);
		Random random = new Random();
		ghost.state.move(ghost, random);
		ghost.pacManAtePowerPellet();
		ghost.setOriginalSquare();
		ghost.setRegularState();
		ghost.state.move(ghost, random);
	}

}

package pacman.test;

import static org.junit.jupiter.api.Assertions.*;

import pacman.MazeMap;

import org.junit.jupiter.api.Test;

class MazeMapTest {

	@Test
	void test() {
		
		MazeMap mazemap = new MazeMap(2, 2, new boolean[] {true,true,true,false});
		assertEquals(2, mazemap.getWidth());
		assertEquals(2, mazemap.getHeight());
		assertEquals(false, mazemap.isPassable(1,1));
	}

}

package pacman.test;

import static org.junit.jupiter.api.Assertions.*;

import pacman.MazeMap;

import org.junit.jupiter.api.Test;

class MazeMapTest {

	@Test
	void test() {
		
		MazeMap mazemap = new MazeMap(2, 3, new boolean[] {true,true,true,false,true,false});
		assertEquals(2, mazemap.getWidth());
		assertEquals(3, mazemap.getHeight());
		assertEquals(false, mazemap.isPassable(1,2)); 
	}

}
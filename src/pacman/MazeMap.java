package pacman;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Each instance of this class represents a maze layout, specifying the width and height of the maze
 * and, for each position in the maze, whether it is passable or not.
 * @invar 0 <= getWidth()
 * @invar 0 <= getHeight()
 */
public class MazeMap {
	
	
	private int width;
	private int height;
	private boolean [] passable;

	/**
	 * Returns the width (i.e. the number of columns) of this maze map.
	 * @basic	
	 */
	public int getWidth() { throw new RuntimeException("Not yet implemented"); }
	
	/**
	 * Returns the height (i.e. the number of rows) of this maze map.
	 * @basic
	 */
	public int getHeight() { throw new RuntimeException("Not yet implemented"); }
	
	/**
	 * Returns whether the square in this maze at row index {@code row} and column index {@code column} is passable.
	 * The square in the top-left corner of the maze has row index 0 and column index 0.
	 * @throws | rowIndex <= 0 || rowIndex >getWidth()
	 * @throws | columnIndex <= 0 || columnIndex >getHeight()
	 * @post   | result == true || result == false
	 * 
	 * 
	 * 
	 */
	public boolean isPassable(int rowIndex, int columnIndex) { throw new RuntimeException("Not yet implemented"); }
	
	/**
	 * //Defensief te werk gaan voor ongeldige argumenten constructor 
	 * Initializes this object so that it represents a maze layout with the given width, height, and
	 * passable positions. The passable positions are given in row-major order (i.e. the first {@code width} elements
	 * of {@code passable} specify the passability of the maze positions in the first row of the maze). 
	 * @throws | width <= 0 //strict kleiner mss?
	 * @throws | height <= 0 //strict kleiner mss?
	 * @throws | passable == null 
	 * @throws | passable.length == width*height
	 * 
	 * @post   | getWidth() == width
	 * @post   | getHeight() == height
	 *
	 * 
	 * 
	 * 
	 *         
	 *               
	 * 
	 */
	public MazeMap(int width, int height, boolean[] passable) {
		if (width <= 0)
			throw new IllegalArgumentException("Negative number of columns");
		if (height <= 0)
			throw new IllegalArgumentException("Negative number of rows");
		if (passable == null)
			throw new IllegalArgumentException("passable is null");
		if (passable.length == width * height)
			throw new IllegalArgumentException("length of passable deviates from dimension");
		
		//throw new RuntimeException("Not yet implemented");
	}
}

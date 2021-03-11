package pacman;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Each instance of this class represents a maze layout, specifying the width and height of the maze
 * and, for each position in the maze, whether it is passable or not.
 * 
 * @invar | 0 <= getWidth()
 * @invar | 0 <= getHeight()
 * 
 * 
 */
public class MazeMap {
	
	
	private int width;
	private int height;
	
	/**
	 * @representationObject
	 */
	private boolean [] passable;

	/**
	 * Returns the width (i.e. the number of columns) of this maze map.
	 * @basic	
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * Returns the height (i.e. the number of rows) of this maze map.
	 * @basic
	 */
	public int getHeight() { 
		return height;
	}
	
	/**
	 * Returns whether the square in this maze at row index {@code row} and column index {@code column} is passable.
	 * The square in the top-left corner of the maze has row index 0 and column index 0.
	 * @inspects | this
	 * @throws IndexOutOfBoundsException if the given rowIndex is less than zero or not less then the width of this MazeMap object
	 * 		| rowIndex < 0 || rowIndex > getWidth() //! ik denk strict kleiner omdat (0,0) nog bij de map hoort? 
	 * @throws IndexOutOfBoundsException if the given columnIndex is less than zero or not less then the width of this MazeMap object
	 *		| columnIndex < 0 || columnIndex > getHeight() 
	 * @post   | result == true || result == false
	 *  
	 * 
	 * 
	 * 
	 * 
	 */
	public boolean isPassable(int rowIndex, int columnIndex) { 
		if (rowIndex < 0 || rowIndex > getWidth()) throw new IndexOutOfBoundsException();
		if (columnIndex < 0 || columnIndex > getHeight()) throw new IndexOutOfBoundsException();
		return passable.clone()[rowIndex * getHeight() + columnIndex];
		
	}
	
	/**
	 * //Defensief te werk gaan voor ongeldige argumenten constructor 
	 * Initializes this object so that it represents a maze layout with the given width, height, and
	 * passable positions. The passable positions are given in row-major order (i.e. the first {@code width} elements
	 * of {@code passable} specify the passability of the maze positions in the first row of the maze). 
	 * @throws IllegalArgumentException if the given width is smaller than one.
	 * 		| width <= 0 
	 * @throws IllegalArgumentException if the given height is smaller than one.
	 * 		| height <= 0 
	 * @throws IllegalArgumentException if passable is null.
	 * 		| passable == null 
	 * @throws IllegalArgumentexception if the length of passable is not equal to the product of the given width and the given height.
	 * 		| passable.length != width*height
	 * 
	 * @post   | getWidth() == width
	 * @post   | getHeight() == height
	 * @post | IntStream.range(0, getWidth()).allMatch(rowIndex ->
	 *       |     IntStream.range(0, getHeight()).allMatch(columnIndex ->
	 *       |         passable[rowIndex * getHeight() + columnIndex] == isPassable(rowIndex,columnIndex)))
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
		if (passable.length != width * height)
			throw new IllegalArgumentException("length of passable deviates from dimension");
		
		this.width = width;
		this.height = height; 
		this.passable = passable.clone(); 
	}
}

package pacman;

/**
 * Each instance of this class represents a dot, located at a fixed position in a Pac-Man maze.
 * A dot serves as the food for Pac-Man.
 * 
 * @invar | getSquare() != null
 * 
 * @immutable
 */
public class Dot extends FoodItem {
	
	/**
	 * @invar | square != null
	 */
	
	
	final int size = 1;

	/**
	 * @throws IllegalArgumentException | square == null
	 * 
	 * @post | getSquare() == square
	 */	
	public Dot(Square square) {
		if (square == null)
			throw new IllegalArgumentException("`square` is null");
		
		this.square = square;
	}
	
	/**
	 * @post | result == 1
	 */
	public int getSize() {
		
		return size;	
	}
}
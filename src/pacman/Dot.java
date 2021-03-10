package pacman;

/**
 * Each instance of this class represents a dot (a piece of food for Pac-Man) in a Pac-Man maze. 
 * 
 * @immutable
 * @invar | getSquare() != null
 */
public class Dot {
	
	/**
	 * @invar | square != null
	 * 
	 * @representationObject
	 */
	private Square square;
	
	
	/**
	 * Returns the square of a dot object.
	 * @basic
	 * 
	 */
	public Square getSquare() {
		return square;
	}
	  
	/**
	 * Initializes this dot object with a given square.
	 * 
	 * @throws IllegalArgumentException if the given square is null.
	 * 		| square == null 
	 */
	
	public Dot(Square square) { 
		if (square == null) {
			throw new IllegalArgumentException("square is null");
		}
		this.square = square;
	}
 

}

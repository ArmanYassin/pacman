package pacman;

/**
 * Each instance of this class represents a dot (a piece of food for Pac-Man) in a Pac-Man maze.
 */
public class Dot {
	
	private Square square;
	
	
	/**
	 * Returns the square of a dot object.
	 * 
	 */
	public Square getSquare() {
		return square;
	}
	
	/**
	 * 
	 * Initializes this dot object with a given square.
	 */
	
	public Dot(Square square) { 
		this.square = square;
	}

}

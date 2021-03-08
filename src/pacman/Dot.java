package pacman;

/**
 * Each instance of this class represents a dot (a piece of food for Pac-Man) in a Pac-Man maze.
 */
public class Dot {
	
	private Square square;
	
	
	/**
	 * 
	 * @return
	 */
	public Square getSquare() {
		return square;
		//throw new RuntimeException("Not yet implemented"); 
	}
	
	/**
	 * 
	 * @param square
	 */

	public Dot(Square square) { 
		this.square = square;
		//throw new RuntimeException("Not yet implemented"); 
	}

}

package pacman;

/**
 * Each instance of this class represents the player-controlled Pac-Man character in a Pac-Man maze.
 * @invar | 0 <= getNbLives() && getNbLives()<4
 */
public class PacMan {
	
	/**
	 * @invar | 0 <= lives && lives <4
	 */
	private int lives;
	private Square square;
	
	/**
	 * Returns the current square of a pacman object.
	 */
	public Square getSquare() { 
		return square;
	}
	
	/**
	 * 
	 * Returns the number of lives of a pacman object.
	 */
	public int getNbLives() { 
		return lives;
	}

	// Moet er hier ook een @throw voor square? 
	// Of mogen we ervan uitgaan dat het gegeven square geldig is
	/**
	 * Initializes this object so that it represents the player-controlled Pac-Man character in a Pac-Man maze with a given 
	 * current number of lives and a given square.
	 * @throws IllegalArgumentException if the given number of lives is negative or higher than 3.
	 * 			| nbLives < 0 || nbLives > 3
	 *  
	 * @post	| getNbLives() == nbLives
	 * @post	| getSquare() == square
	 */
	public PacMan(int nbLives, Square square) {
		if (nbLives < 0) {
			throw new IllegalArgumentException("Negative number of lives");
		}
		if (nbLives > 3) {
			throw new IllegalArgumentException("The number of lives is greater than 3");
		}
		this.lives = nbLives;
		this.square = square;
	}
	
	/**
	 * Changes the square of the pacman object.
	 * 
	 */
	public void setSquare(Square square) { 
		this.square=square; 
	}
	
	/**
	 * Decreases this Pac-Man character's number of lives by one.
	 * 
	 * @post	| getNbLives() == old(getNbLives()) - 1
	 */
	public void die() {
		this.lives--;
	}
	
	
}

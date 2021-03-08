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
	 * 
	 * @return
	 */
	public Square getSquare() { 
		return square;
		//throw new RuntimeException("Not yet implemented"); 
	}
	
	/**
	 * 
	 * @return
	 */
	public int getNbLives() { 
		return lives;
		//throw new RuntimeException("Not yet implemented"); 
	}

	public PacMan(int nbLives, Square square) {
		this.lives = nbLives;
		this.square = square;
		//throw new RuntimeException("Not yet implemented");
	}
	
	public void setSquare(Square square) { 
		this.square=square;
		//throw new RuntimeException("Not yet implemented"); 
	}

	/**
	 * Decreases this Pac-Man character's number of lives by one.
	 */
	public void die() {
		this.lives--;
		//throw new RuntimeException("Not yet implemented");
	}
	
	
}

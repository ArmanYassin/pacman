package pacman;
import pacman.MazeMap;
import pacman.Square;
import pacman.Dot;
import pacman.Ghost;
import pacman.Direction;
/**
 * Each instance of this class represents the player-controlled Pac-Man character in a Pac-Man maze.
 * @invar | 0 <= getNbLives()
 * @invar | getSquare() != null 
 */
public class PacMan {
	 
	/**
	 * @invar | 0 <= lives
	 * @invar | square != null
	 * 
	 * @representationObject
	 */
	private int lives;
	private Square square;
	
	/**
	 * Returns the current square of a pacman object. 
	 * 
	 * @basic
	 */
	public Square getSquare() { 
		return square;
	}
	
	/**
	 * Returns the number of lives of a pacman object.
	 * 
	 * @basic
	 */
	public int getNbLives() { 
		return lives; 
	}
    
	/**
	 * Initializes this object so that it represents the player-controlled Pac-Man character in a Pac-Man maze with a given 
	 * current number of lives and a given square.
	 * @throws IllegalArgumentException if the given number of lives is negative.
	 * 			| nbLives < 0
	 * @throws IllegalArgumentException if the given square is null.
	 * 			| square == null 
	 * @throws IllegalArgumentException if the given square is not passable.
	 * 			| square.isPassable() == false
	 * @post	| getNbLives() == nbLives
	 * @post	| getSquare() == square
	 */
	public PacMan(int nbLives, Square square) {
		if (nbLives < 0) {
			throw new IllegalArgumentException("Negative number of lives");
		}
		if (nbLives > 3) {
			throw new IllegalArgumentException("The number of lives is higher than 3");
		}
		if (square == null) {
			throw new IllegalArgumentException("square is null");
		}
		if (square.isPassable()==false) {
			throw new IllegalArgumentException("square is in unpassable position");
		}
		this.lives = nbLives;
		this.square = square;
	}
	
	/**
	 * Changes the square of the pacman object.
	 * 
	 * @throws IllegalArgumentException if the given square is null.
	 * 			| square == null 
	 * @mutates | this
	 */
	public void setSquare(Square square) { 
		if (square == null) {
			throw new IllegalArgumentException("square is null");
		}
		this.square=square; 
	}
	
	/**
	 * Decreases this Pac-Man character's number of lives by one.
	 * 
	 * @post	| getNbLives() == old(getNbLives()) - 1
	 * @mutates | this
	 */
	public void die() {
		this.lives--;
	}
	
	
}
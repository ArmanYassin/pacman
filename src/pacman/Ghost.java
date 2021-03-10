package pacman;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * Each instance of this class represents a ghost in a Pac-Man maze.
 * 
 * @invar 	| getSquare() != null
 * @invar 	| getDirection() != null

 */
public class Ghost {
	
	/**
	 * @invar 	| square != null
     * @invar 	| direction != null
     * 
     * @representationObject
	 */
	private Square square;
	private Direction direction;
	
	/**
	 * Returns the square of a ghost object.
	 * 
	 * @basic
	 */
	public Square getSquare() {
		return square;
	}
	
	/**
	 * Returns the direction in which this ghost will preferably move next.
	 * 
	 * @basic
	 */
	public Direction getDirection() { 
		return direction; 
	}
	
	/**
	 * Initializes this object so that it represents a ghost enemy who the player has to avoid. 
	 * Each instance of this object has a given square, the position where it is, and a direction in which it is moving.
	 * 
	 * @throws IllegalArgumentException if the given square is null.
	 *  		| square == null 
	 * @throws IllegalArgumentException if the given direction is null.
	 * 	  		| direction == null 
	 * @post | getSquare() == square
	 * @post | getDirection() == direction
	 */
	public Ghost(Square square, Direction direction) { 
		if (square == null) {
			throw new IllegalArgumentException("square is null");
		}
		if (direction == null) {
			throw new IllegalArgumentException("direction is null");
		}
		this.square = square;
		this.direction = direction;
	}
	
	/**
	 * Changes the square of the ghost object to a given square.
	 * 
	 * @throws IllegalArgumentException if the given square is null.
	 *  		| square == null 
	 */
	public void setSquare(Square square) { 
		if (square == null) {
			throw new IllegalArgumentException("square is null");
		}
		this.square = square; 
	}
	
	/**
	 * Sets the direction of the ghost object.
	 * 
	 * @throws IllegalArgumentException if the given direction is null.
	 * 		| direction == null 
	 */
	public void setDirection(Direction direction) { 
		if (direction == null) {
			throw new IllegalArgumentException("direction is null");
		}
		this.direction = direction; 
	}
	
	private static int MOVE_FORWARD_PREFERENCE = 10;
	
	// No formal document required
	public Direction chooseNextMoveDirection(Random random) {
		int moveForwardPreference = getSquare().canMove(getDirection()) ? MOVE_FORWARD_PREFERENCE : 0;
		Direction[] passableDirections = getSquare().getPassableDirectionsExcept(getDirection().getOpposite());
		if (passableDirections.length == 0)
			return getDirection().getOpposite();
		int result = random.nextInt(moveForwardPreference + passableDirections.length);
		if (result < moveForwardPreference)
			return getDirection();
		return passableDirections[result - moveForwardPreference];
	}
	
	// No formal document required
	public void move(Random random) {
		setDirection(chooseNextMoveDirection(random));
		setSquare(getSquare().getNeighbor(getDirection()));
	}
}

package pacman;

import java.util.Random;

/**
 * Each instance of this class represents a ghost in a Pac-Man maze.
 */
public class Ghost {
	
	private Square square;
	private Direction direction;
	
	/**
	 * Returns the square of a ghost object.
	 * 
	 */
	public Square getSquare() {
		return square;
	}
	
	/**
	 * Returns the direction in which this ghost will preferably move next.
	 */
	public Direction getDirection() { 
		return direction; 
	}
	
	/**
	 * Initializes this object so that it represents a ghost enemy who the player has to avoid. 
	 * Each instance of this object has a given square, the position where it is, and a direction in which it is moving.
	 * 
	 * @post | getSquare() == square
	 * @post | getDirection() == direction
	 */
	public Ghost(Square square, Direction direction) { 
		this.square = square;
		this.direction = direction;
	}
	
	/**
	 * Changes the square of the ghost object to a given square.
	 * 
	 */
	public void setSquare(Square square) { 
		this.square = square; 
	}
	
	/**
	 * Sets the direction of the ghost object.
	 * 
	 */
	public void setDirection(Direction direction) { 
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

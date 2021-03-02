package pacman;

public enum Direction {
	RIGHT, DOWN, LEFT, UP;
	
	public Direction getOpposite() {
		return switch (this) {
		case RIGHT -> LEFT;
		case LEFT -> RIGHT;
		case UP -> DOWN;
		case DOWN -> UP;
		};
	}
	//klein test 'suit' Mag genegeerd worden. 
	public static void main(String args[]) 
	{ 
		Direction[] allDirections = new Direction []{Direction.LEFT, Direction.RIGHT,Direction.UP, Direction.DOWN};
		Direction [] passableDirection = new Direction[0];
		
		boolean isP = true;
		
		
			passableDirection = new Direction [] {Direction.UP, Direction.DOWN};
		
		if(isP)
			passableDirection = allDirections;
		System.out.println("test"+passableDirection[1]);
	} 
}

package pacman;

import java.util.stream.IntStream;



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
		Direction [] possibleDirection = new Direction [3];
		int pos = 0;
		for(int i = 0; i<4; i++)
			if(allDirections[i]==RIGHT)
				pos = i;
		for (int i = 0, k = 0; i < allDirections.length; i++) { 
			if (i == pos) { 
            continue; 
        } 
        possibleDirection[k++] = allDirections[i]; 
	    }
		boolean [] canMove = new boolean [] {true, false, true};
		int count = 0; 
		for(int i = 0; i<possibleDirection.length; i++) {
			if(canMove[i]) {
				count++; 						
			}	
		}
		Direction [] passableDirection = new Direction [count];
		
		for(int i = 0,k=0; i<possibleDirection.length; i++) {
			if(!canMove[i]) {
				continue;
			}
			passableDirection[k++] = possibleDirection[i];
		}
		


		System.out.println("test"+passableDirection[1]);
	} 
}

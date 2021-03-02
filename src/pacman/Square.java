package pacman;

import java.util.Arrays;

import pacman.MazeMap;

/**
 * Each instance of this class represents a position in a maze, specified by a row index and a column index.
 * The top row and the leftmost column have index 0.
 * 
 * @immutable 
 * @invar | 0 <= getRowIndex() 
 * @invar | 0 <= getColumnIndex()
 * @invar | getMazeMap() != null
 */
public class Square {
	
	private final MazeMap mazeMap;
	private final int rowIndex;
	private final int columnIndex;
	
	
	/**
	 * @basic
	 * 
	 */
	public MazeMap getMazeMap() { 
		return mazeMap;
	}
	
	/**
	 * Returns the row position of the square object
	 * 
	 * @basic
	 */
	
	public int getRowIndex() {
		return rowIndex;
	}
	
	/**
	 * Returns the column position of the square object
	 * @basic | 
	 */
	
	public int getColumnIndex() { 
		return columnIndex;
	}
	
	/**
	 * returns if the object Square is passable 
	 * 
	 * @post | getMazeMap().isPassable(getRowIndex(),getColumnIndex())
	 */
	
	public boolean isPassable() { 
		return mazeMap.isPassable(rowIndex, columnIndex);
		
	}
	
	/**
	 * Initialises this object to represent a square in a given location
	 * @post | getMazeMap() == mazeMap
	 * @post | getRowIndex() == rowIndex
	 * @post | getColumnIndex() == columnIndex
	 * 
	 */
	
	private Square (MazeMap mazeMap, int rowIndex, int columnIndex) {
		this.mazeMap = mazeMap;
		this.rowIndex = rowIndex;
		this.columnIndex = columnIndex;
	}
	
	/**
	 * Returns a square object with the given location 
	 * @throws IndexOutOfBoundsException if the given rowIndex is less than zero or not less then the width of this MazeMap object
	 * 		| rowIndex < 0 || rowIndex > mazeMap.getWidth()  
	 * @throws IndexOutOfBoundsException if the given columnIndex is less than zero or not less then the width of this MazeMap object
	 *		| columnIndex < 0 || columnIndex > mazeMap.getHeight()
	 * @throws IllegalArgumentException if MazeMap is null.
	 * 		| mazeMap == null 
	 * 
	 */
	public static Square of(MazeMap mazeMap, int rowIndex, int columnIndex) {
		if (rowIndex < 0 || rowIndex > mazeMap.getWidth()) throw new IndexOutOfBoundsException();
		if (columnIndex < 0 || columnIndex > mazeMap.getHeight()) throw new IndexOutOfBoundsException();
		if (mazeMap == null)
			throw new IllegalArgumentException("mazeMap is null");
		return new Square(mazeMap,rowIndex,columnIndex);
	}
	
	/**
	 * Returns this square's neighbor in the given direction.
	 * If this square has no neigbor in the given direction, return the square that is furthest away in the opposite direction.
	 */
	// No formal documentation required
	public Square getNeighbor(Direction direction) {
		// Implementation hint: use method java.lang.Math.floorMod.
		Square current = this;
		Square neighbor = current;

		if(direction == Direction.DOWN )
			neighbor = of(this.mazeMap, Math.floorMod(this.rowIndex+1,this.mazeMap.getHeight()), this.columnIndex);
		if(direction == Direction.UP)
			neighbor = of(this.mazeMap, Math.floorMod(this.rowIndex-1,this.mazeMap.getHeight()), this.columnIndex);
		if(direction == Direction.LEFT)
			neighbor = of(this.mazeMap, this.rowIndex, Math.floorMod(this.columnIndex-1,this.mazeMap.getWidth()));
		if(direction == Direction.RIGHT)
			neighbor = of(this.mazeMap, this.rowIndex, Math.floorMod(this.columnIndex+1,this.mazeMap.getWidth()));
		
		return neighbor;
		
		
		//throw new RuntimeException("Not yet implemented");
	}

	/**
	 * Returns whether this square's neighbor in the given direction is passable.
	 */
	// No formal documentation required
	public boolean canMove(Direction direction) {
		return this.getNeighbor(direction).isPassable();
		
		//throw new RuntimeException("Not yet implemented");
	}

	/**
	 * Returns the directions that are different from the given excluded direction and such that the neighbor in that direction is passable.
	 * The returned array shall have no null elements and shall have no duplicates.
	 */
	// No formal documentation required
	public Direction[] getPassableDirectionsExcept(Direction excludedDirection) {
		//Square current = this;
		Direction [] passableDirection = new Direction[0];

		Direction one =Direction.LEFT;
		Direction two =Direction.DOWN;
		
		//Is er een manier om zo een bruut enumeratie van alle mogelijkheden te vermijden????
		// want als ik zo verder ga zijn er per richting 7 mogelijkheden!
		int direction = 2;
		switch(direction) {
		case 1 :
			excludedDirection = one;
			if(canMove(excludedDirection.getOpposite())
					&&canMove(Direction.UP) 
					&&canMove(Direction.DOWN))
				passableDirection = new Direction [] {Direction.RIGHT,Direction.UP, Direction.DOWN};
			else if (!canMove(excludedDirection.getOpposite()))
				passableDirection = new Direction [] {Direction.UP, Direction.DOWN};
				break;
		}
		
		

			
			
		return passableDirection;
		//throw new RuntimeException("Not yet implemented");
	}
	
	/**
	 * Returns whether the given square refers to the same {@code MazeMap} object and has the same row and column index as this square.
	 *@throws IllegalArgumentException if the given square is null.
	 * 		| other == null 
	 * @post | result == this.equals(other)
	 */
	public boolean equals(Square other) {
		if (other == null)
			throw new IllegalArgumentException("Given square is null");
		return this.equals(other);
		//throw new RuntimeException("Not yet implemented");
	}
	
}

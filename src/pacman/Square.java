package pacman;

import java.util.Arrays;
import java.util.stream.IntStream;

import pacman.MazeMap;
import pacman.Direction;


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
	/**
	 * @invar | 0 <= rowIndex
     * @invar | 0 <= columnIndex
     * @invar | mazeMap != null
	 * @representationObject
	 */
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
	 *  @inspects | this 
	 *  @post | result == getMazeMap().isPassable(getRowIndex(), getColumnIndex())
	 *  
	 */
	
	public boolean isPassable() { 
		return this.getMazeMap().isPassable(rowIndex, columnIndex);	
	}
	
	/**
	 * Initializes this object to represent a square in a given location
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
	 * @post | result != null
	 * @post | result.getMazeMap() == mazeMap
	 * @post | result.getRowIndex() == rowIndex
	 * @post | result.getColumnIndex() == columnIndex
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
	 * If this square has no neighbor in the given direction, return the square that is furthest away in the opposite direction.
	 */
	// No formal documentation required
	public Square getNeighbor(Direction direction) {
		
		if(direction == Direction.DOWN )
			return of(mazeMap, Math.floorMod(rowIndex+1,mazeMap.getHeight()), columnIndex);
		if(direction == Direction.UP)
			return of(this.mazeMap, Math.floorMod(rowIndex-1,mazeMap.getHeight()), columnIndex);
		if(direction == Direction.LEFT)
			return of(mazeMap, rowIndex, Math.floorMod(columnIndex-1,mazeMap.getWidth()));
		if(direction == Direction.RIGHT)
			return of(mazeMap, rowIndex, Math.floorMod(columnIndex+1,mazeMap.getWidth()));
		
		return null;
		
		 

	}
 
	/**
	 * Returns whether this square's neighbor in the given direction is passable.
	 */
	// No formal documentation required
	public boolean canMove(Direction direction) {
		return this.getNeighbor(direction).isPassable();

	}

	/**
	 * Returns the directions that are different from the given excluded direction and such that the neighbor in that direction is passable.
	 * The returned array shall have no null elements and shall have no duplicates.
	 */
	// No formal documentation required
	public Direction[] getPassableDirectionsExcept(Direction excludedDirection) {
		Direction[] allDirections = new Direction []{Direction.LEFT, Direction.RIGHT,Direction.UP, Direction.DOWN};
		Direction [] possibleDirection = new Direction [3];
		int pos = 0;
			for(int i = 0; i<4; i++)
				if(allDirections[i]==excludedDirection)
					pos = i;
		for (int i = 0, k = 0; i < allDirections.length; i++) { 
            if (i == pos) { 
                continue; 
            } 
            possibleDirection[k++] = allDirections[i]; 
        }
		
		int count = 0;  
		for(int i = 0; i<possibleDirection.length; i++) {
			if(canMove(possibleDirection[i])) {
				count++; 						
			}	
		}
		Direction [] passableDirection = new Direction [count];
		for(int i = 0,k=0; i<possibleDirection.length; i++) {
			if(!canMove(possibleDirection[i])) {
				continue;
			}
			passableDirection[k++] = possibleDirection[i];
		}
		

	
	

		
		

			
			
		return passableDirection;

	}
	
	/**
	 * Returns whether the given square refers to the same {@code MazeMap} object and has the same row and column index as this square.
	 * @inspects | this, other
	 * @throws IllegalArgumentException if the given square is null.
	 * 		 | other == null 
	 * @post | result ==(this==other)
	 * 
	 */
	
	public boolean equals(Square other) {
		if (other == null)
			throw new IllegalArgumentException("Given square is null");
		return this == other;

	}
	public static void main(String[] args) {
		MazeMap mazemap = new MazeMap(2, 3, new boolean[] {true,true,true,false,false,false});
		Square square01 = Square.of(mazemap, 0, 1);  
		Square square11 = Square.of(mazemap, 1, 1);  
		Square square00 = Square.of(mazemap, 0, 0);
		Square square10 = Square.of(mazemap, 1, 0);
		Square square02 = Square.of(mazemap, 0, 2);
		Square square12 = Square.of(mazemap, 1, 2);
		System.out.println(square10.getPassableDirectionsExcept(Direction.DOWN));
	}

}

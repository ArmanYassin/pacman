package pacman;

public abstract class FoodItem {
	protected Square square;
	
	FoodItem food;
	int size;
	public Square getSquare() { return square; }
	/**
	 * 
	 * @post | result > 0
	 * 
	 * 
	 */
	public abstract int getSize();
//		if(food instanceof Dot)
//			return size;
//		else if(food instanceof PowerPellet) 
//			return 2*size;
//		return size;
	
}

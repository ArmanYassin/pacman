package pacman;

public abstract class FoodItem {
	protected Square square;
//	private FoodItem fooditem;

	public Square getSquare() { return square; }
	
	public abstract int getSize();
	
}

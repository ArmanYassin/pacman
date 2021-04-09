package pacman;

public class PowerPellet extends FoodItem{
	public PowerPellet(Square square){
		this.square = square;
	}
	
	public final int size = 2;
	
	/**
	 * @post | result == 2
	 */
	public int getSize() {
		
		return size;	
	}
}	

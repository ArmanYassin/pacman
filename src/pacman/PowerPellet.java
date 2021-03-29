package pacman;

public class PowerPellet extends FoodItem{
	int size = 2;
	public PowerPellet(Square square){
		this.square = square;
	}
	
	/**
	 * @post | result == 2 
	 */
	public int getSize() {
		return size;
	}
}	

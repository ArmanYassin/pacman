package pacman.wormholes;

import pacman.Square;
import java.util.HashSet;
import java.util.Set;

//Each departure portal is associated with a square
public class DeparturePortal {
	
	Square square;
	Set<Wormhole> wormholes = new HashSet<>(); 
	
	public Square getSquare() {
		return square;
	}
	public Set<Wormhole> getWormholes(){
		return Set.copyOf(wormholes);
	}
	//public DeparturePortal() {}
	 
	public DeparturePortal(Square square) {
		this.square = square;
	}
	
	

}

package pacman.wormholes;

import java.util.HashSet;
import java.util.Set;

//Each arrival portal is associated with a square

public class ArrivalPortal {
	
	Square square;
	Set<Wormhole> wormholes = new HashSet<>(); 
	
	public Square  getSquare() {
		return square;
	} 
	
	public Set<Wormhole> getWormholes(){
		return Set.copyOf(wormholes);
	}
	
	//public ArrivalPortal() {}
	
	public ArrivalPortal(Square square) {
		this.square = square;
		square.arrivalportals.add(this);
	}

}

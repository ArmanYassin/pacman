package pacman.wormholes;

import java.util.HashSet;
import java.util.Set;

import pacman.Square;

//Each arrival portal is associated with a square

public class ArrivalPortal {
	
	Square square;
	Set<Wormhole> wormholes = new HashSet<>(); 
	
	public Square getSquare() {
		return null;
	} 
	public Set<Wormhole> getWormholes(){
		return null;
	}
	
	public ArrivalPortal() {}
	
	public ArrivalPortal(Square square) {}

}

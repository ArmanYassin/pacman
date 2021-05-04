package pacman.wormholes;

import pacman.Square;
import java.util.HashSet;
import java.util.Set;

//Each departure portal is associated with a square
public class DeparturePortal {
	
	Square square;
	Set<Wormhole> wormholes = new HashSet<>(); 
	
	public Square getSquare() {
		return null;
	}
	public Set<Wormhole> getWormholes(){
		return null;
	}
	
	public DeparturePortal() {}
	 
	public DeparturePortal(Square square) {}

}

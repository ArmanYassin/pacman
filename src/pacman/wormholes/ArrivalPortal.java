package pacman.wormholes;

import java.util.HashSet;
import java.util.Set;

/**
 * Each arrival portal is associated with a square
 * @invar | getWormholes().stream().allMatch(w -> w == null || w.getArrivalPortal()==this)
 *
 */

public class ArrivalPortal {
	
	/**
	 * @invar | square !=null && square.arrivalportals.contains(this)
	 * @invar | wormholes == null || wormholes.stream().allMatch(w -> w.arrival == this)
	 * @peerObjects
	 */
	
	Square square;
	Set<Wormhole> wormholes = new HashSet<>(); 
	
	public Square  getSquare() {
		return square;
	} 
	/**
	 * @peerObjects
	 */
	public Set<Wormhole> getWormholes(){
		return Set.copyOf(wormholes);
	}
	
	//public ArrivalPortal() {}
	/**
	 * 
	 * @throws IllegalArgumentException | square == null
	 */
	public ArrivalPortal(Square square) {
		if (square == null)
			throw new IllegalArgumentException("square is null");
		this.square = square;
		square.arrivalportals.add(this);
	}

}

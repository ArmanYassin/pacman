package pacman.wormholes;

import java.util.HashSet;
import java.util.Set;

/**
 * Each departure portal is associated with a square
 * 
 * @invar | getWormholes().stream().allMatch(w -> w == null || w.getDeparturePortal()==this)
 * 
 *
 */
public class DeparturePortal {
	
	/**
	 * @invar | square !=null && square.departureportals.contains(this)
	 * @invar | wormholes == null || wormholes.stream().allMatch(w -> w.departure == this)
	 * @peerObjects
	 */
	
	Square square;
	Set<Wormhole> wormholes = new HashSet<>(); 
	
	/**
	 * 
	 * @post | result != null
	 */
	public Square getSquare() {
		return square;
	}
	/**
	 * @peerObjects
	 */
	public Set<Wormhole> getWormholes(){
		return Set.copyOf(wormholes);
	}
	//public DeparturePortal() {}
	/**
	 * 
	 * @throws IllegalArgumentException | square == null
	 */
	public DeparturePortal(Square square) {
		if (square == null)
			throw new IllegalArgumentException("square is null");
		this.square = square;
		square.departureportals.add(this);
	}
	
	

}

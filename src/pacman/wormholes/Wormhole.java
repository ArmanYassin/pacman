package pacman.wormholes;

import java.util.ArrayList;
import logicalcollections.LogicalSet;

/**
 * Each wormhole is associated, at each point in time, with exactly one departure
 * and exactly one arrival portal
 * 
 * @invar | getDeparturePortal() != null && getDeparturePortal().getWormholes().contains(this)
 * @invar | getArrivalPortal() != null && getArrivalPortal().getWormholes().contains(this)
 */
public class Wormhole {
	
	/**
	 * @invar | departure != null && departure.wormholes.contains(this)
	 * @invar | arrival != null && arrival.wormholes.contains(this)
	 * @peerObject
	 */
	
	DeparturePortal departure;
	ArrivalPortal arrival; 
	
	public ArrivalPortal getArrivalPortal() {
		return arrival;
	} 
	public DeparturePortal getDeparturePortal() {
		return departure;
	}
	/**
	 * 
	 * @throws IllegalArgumentException | depart == null
	 * @throws IllegalArgumentException | arrival == null
	 */
	public Wormhole(DeparturePortal depart, ArrivalPortal arrival) {
		if (depart == null)
			throw new IllegalArgumentException("departure portal is null");
		if (arrival == null)
			throw new IllegalArgumentException("arrival portal is null");
		this.departure = depart;
		this.arrival = arrival;
		depart.wormholes.add(this);
		arrival.wormholes.add(this);
	}
	
	
	/**
	 * @throws IllegalArgumentException | arrival == null
	 *  //@throws IllegalArgumentException | getArrivalPortal() != null
	 *  
	 *  @mutates_properties | getArrivalPortal(), arrival.getWormholes()
	 *  @post | arrival.getWormholes().equals(LogicalSet.plus(old(arrival.getWormholes()), this))
	 */
	public void setArrivalPortal(ArrivalPortal arrival) {
		if (arrival == null)
			throw new IllegalArgumentException("arrival portal is null");
//		if (this.arrival != null)
//			throw new IllegalArgumentException("arrival portal already availabe for this");
		this.arrival.wormholes.remove(this);//verwijder eerst oud portaal?
		this.arrival = arrival;
		arrival.wormholes.add(this);
	}
	
	/**
	 * @throws IllegalArgumentException | departure == null
	 *  //@throws IllegalArgumentException | getDeparturePortal() != null
	 *  @mutates_properties | getDeparturePortal(), departure.getWormholes()
	 *  @post | departure.getWormholes().equals(LogicalSet.plus(old(departure.getWormholes()), this))
	 */
	public void setDeparturePortal(DeparturePortal departure) {
		if (departure == null)
			throw new IllegalArgumentException("departure portal is null");
//		if (this.departure != null)
//			throw new IllegalArgumentException("departure portal already availabe for this");
		this.departure.wormholes.remove(this); //verwijder eerst oud portaal
		this.departure = departure;
		departure.wormholes.add(this);
		
	}
	
	

}

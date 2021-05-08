package pacman.wormholes;

/*
 * Each wormhole is associated, at each point in time, with exactly one departure
 * and exactly one arrival portal
 */
public class Wormhole {
	
	ArrivalPortal arrival; 
	DeparturePortal departure;
	
	public ArrivalPortal getArrivalPortal() {
		return arrival;
	} 
	public DeparturePortal getDeparturePortal() {
		return departure;
	}
	public Wormhole() {}
	public Wormhole(DeparturePortal depart, ArrivalPortal arrival) {}
	
	/**
	 * @throws IllegalArgumentException | arrival == null
	 * @throws IllegalArgumentException | getArrivalPortal() != null
	 */
	public void setArrivalPortal(ArrivalPortal arrival) {
		if (arrival == null)
			throw new IllegalArgumentException("arrival portal is null");
		if (this.arrival != null)
			throw new IllegalArgumentException("arrival portal already availabe for this");
		this.arrival = arrival;
		arrival.wormholes.add(this);
	}
	
	/**
	 * @throws IllegalArgumentException | departure == null
	 * @throws IllegalArgumentException | getDeparturePortal() != null
	 */
	public void setDeparturePortal(DeparturePortal departure) {
		if (departure == null)
			throw new IllegalArgumentException("departure portal is null");
		if (this.departure != null)
			throw new IllegalArgumentException("departure portal already availabe for this");
		this.departure = departure;
		departure.wormholes.add(this);
	}
	
	

}

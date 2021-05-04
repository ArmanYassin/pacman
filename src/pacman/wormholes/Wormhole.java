package pacman.wormholes;

/*
 * Each wormhole is associated, at each point in time, with exactly one departure
 * and exactly one arrival portal
 */
public class Wormhole {
	
	ArrivalPortal arrival; 
	DeparturePortal departure;
	
	public ArrivalPortal getArrivalPortal() {
		return null;
	} 
	public DeparturePortal getDeparturePortal() {
		return null;
	}
	
	public void setArrivalPortal() {}
	
	public void setDeparturePortal() {}
	
	public Wormhole() {}
	public Wormhole(ArrivalPortal arrival, DeparturePortal depart) {}

}

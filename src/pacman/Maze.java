package pacman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import pacman.wormholes.ArrivalPortal;
import pacman.wormholes.DeparturePortal;
import pacman.wormholes.Square;
import pacman.wormholes.Wormhole;

public class Maze {
	
	private Random random;
	private MazeMap map;
	private PacMan pacMan;
	private Ghost[] ghosts;
	private FoodItem[] foodItems;
	private ArrivalPortal[] arrivals;
	private DeparturePortal[] departures;
	private Wormhole [] wormholes;
	private ArrayList<Wormhole> wormholesList;
	
	public MazeMap getMap() { return map; }
	
	public PacMan getPacMan() { return pacMan; }
	
	public Ghost[] getGhosts() { return ghosts.clone(); }
	
	public FoodItem[] getFoodItems() { return foodItems.clone(); }
	
	//Extended
	public Maze(Random random, MazeMap map, PacMan pacMan, Ghost[] ghosts, FoodItem[] foodItems, DeparturePortal[] departures, ArrivalPortal[] arrivals) {
		this.random = random;
		this.map = map;
		this.pacMan = pacMan;
		this.ghosts = ghosts.clone();
		this.foodItems = foodItems.clone();
		this.departures = departures.clone();
		this.arrivals = arrivals.clone();
		
	}
	
	public boolean isCompleted() {
		return foodItems.length == 0;
	}
	
	private void checkPacManDamage() {
		for (Ghost ghost : ghosts)
			if (ghost.getSquare().equals(pacMan.getSquare()))
				ghost.hitBy(pacMan);
	}
	
	public void moveGhosts() {
		for (Ghost ghost : ghosts)
			ghost.move(random);
		checkPacManDamage();
	}
	
	public void pacManAtePowerPellet() {
		for (Ghost ghost : ghosts)
			ghost.pacManAtePowerPellet();
	}
	
	private void removeFoodItemsAtIndex(int index) {
		FoodItem[] newFoodItems = new FoodItem[foodItems.length - 1];
		System.arraycopy(foodItems, 0, newFoodItems, 0, index);
		System.arraycopy(foodItems, index + 1, newFoodItems, index, newFoodItems.length - index);
		foodItems = newFoodItems;
	}
	
	private void checkFoodItemCollision(Square square) {
		for (int i = 0; i < foodItems.length; i++) {
			if (foodItems[i].getSquare().equals(square)) {
				foodItems[i].eatenByPacMan(this);
				removeFoodItemsAtIndex(i);
				return;
			}
		}
	}
	
	public void movePacMan(Direction direction) {
		Square newSquare = pacMan.getSquare().getNeighbor(direction);
		if (newSquare.isPassable()) {
			pacMan.setSquare(newSquare);
			checkFoodItemCollision(newSquare);
			checkPacManDamage();
		}
		//toegevoegd: beter in laatste if opnemen?
		for(DeparturePortal depart : departures) {
			if(depart.getSquare().equals(newSquare)) {
				Wormhole[] worms = (Wormhole[]) depart.getWormholes().toArray();
				pacMan.setSquare(worms[random.nextInt(worms.length)].getArrivalPortal().getSquare());
				for (Ghost ghost : ghosts) {
					if(ghost.getSquare().equals(depart.getSquare())
							&&ghost.getSquare().equals(pacMan.getSquare()))
						ghost.hitBy(pacMan);
				}
				
			}
		}
	}
	//toegevoegd
	// Defensief niet vergeten
	public void addWormhole(Wormhole wormhole) {
		wormholesList = new ArrayList<>();
		wormholesList.add(wormhole);
	}
	//toegevoegd
	public Wormhole[] getWormholes(){
		wormholes = new Wormhole[wormholesList.size()];
		return wormholesList.toArray(wormholes).clone();
	}
	//toegevoegd
	public DeparturePortal[] getDeparturePortals() {
		for(int i = 0; i<departures.length-1;i++) {
			if(departures[i].getSquare().getColumnIndex()
					>departures[i+1].getSquare().getColumnIndex()  //sorteren links naar rechts
						&& departures[i].getSquare().getRowIndex()
						    >departures[i+1].getSquare().getRowIndex()) {
				DeparturePortal temp = departures[i];
                departures[i] = departures[i+1];
                departures[i+1] = temp;
			}
		}
//		ArrayList<DeparturePortal> depart = new ArrayList<DeparturePortal>();
//		for(int i = 0; i<departures.length;i++) {
//			for(int j = 1; j<departures.length;j++) {
//				if(departures[i].getSquare().getColumnIndex()
//					<departures[j].getSquare().getColumnIndex()  //sorteren links naar rechts
//						&& departures[i].getSquare().getRowIndex()
//						    <departures[j].getSquare().getRowIndex()) //sorteren boven naar onder
//					depart.add(departures[i]);
//			}			
//		}
		return departures;//depart.toArray(departures).clone();
	}
	//toegevoegd
	public ArrivalPortal[] getArrivalPortals() {
		
//		for(int i = 0; i<arrivals.length-1;i++) {
//			
//			if(arrivals[i].getSquare().getColumnIndex()
//					<arrivals[i+1].getSquare().getColumnIndex()  //sorteren links naar rechts
//						&& arrivals[i].getSquare().getRowIndex()
//						    <arrivals[i+1].getSquare().getRowIndex()) {
//				  ArrivalPortal temp = arrivals[i];
//                arrivals[i] = arrivals[i+1];
//                arrivals[i+1] = temp;
//			}
//		}
//		ArrayList<ArrivalPortal> arrival = new ArrayList<ArrivalPortal>();
		for(int i = 0; i<arrivals.length;i++) {
			for(int j = 1; j<arrivals.length;j++) {
				if(arrivals[i].getSquare().getColumnIndex()
					>arrivals[j].getSquare().getColumnIndex()  //sorteren links naar rechts
						&& arrivals[i].getSquare().getRowIndex()
						    >arrivals[j].getSquare().getRowIndex()) { //sorteren boven naar onde
					ArrivalPortal temp = arrivals[i];
	                arrivals[i] = arrivals[j];
	                arrivals[j] = temp;
					}
			}			
		}
		return arrivals;//arrival.toArray(arrivals).clone();
	}
	
	
}

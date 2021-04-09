package pacman;

import java.util.Arrays;
import java.util.Random;

public class Maze {
	
	private Random random;
	private MazeMap map;
	private PacMan pacMan; 
	private Ghost[] ghosts;
	//private Dot[] dots;
	private FoodItem[] fooditems;
	
	public MazeMap getMap() { return map; }
	
	public PacMan getPacMan() { return pacMan; }
	
	public Ghost[] getGhosts() { return ghosts.clone(); }
	
	//public Dot[] getDots() { return dots.clone(); }
	public FoodItem[] getFoodItems() { return fooditems.clone(); }
	
	public Maze(Random random, MazeMap map, PacMan pacMan, Ghost[] ghosts, FoodItem[] fooditems) {
		this.random = random;
		this.map = map;
		this.pacMan = pacMan;
		this.ghosts = ghosts.clone();
		//this.dots = dots.clone();
		this.fooditems = fooditems.clone();
	}
	
	public boolean isCompleted() {
		//return dots.length == 0;
		return fooditems.length == 0;

	}
	
	private void checkPacManDamage() {
		for (Ghost ghost : ghosts)
			if (ghost.getSquare().equals(pacMan.getSquare()))
//				pacMan.die();
				ghost.hitBy(pacMan);
	}
	
	public void moveGhosts() {
		for (Ghost ghost : ghosts)
			ghost.move(random);
		checkPacManDamage();
	}
	
	private void removeFoodItemAtIndex(int index) {
//		Dot[] newDots = new Dot[dots.length - 1];
//		System.arraycopy(dots, 0, newDots, 0, index);
//		System.arraycopy(dots, index + 1, newDots, index, newDots.length - index);
//		dots = newDots;
		
		FoodItem[] newFoodItems = new FoodItem[fooditems.length - 1];
		System.arraycopy(fooditems, 0, newFoodItems, 0, index);
		System.arraycopy(fooditems, index + 1, newFoodItems, index, newFoodItems.length - index);
		fooditems = newFoodItems;
	}
	
	private void removeFoodItemAtSquare(Square square) {
//		for (int i = 0; i < dots.length; i++) {
//			if (dots[i].getSquare().equals(square)) {
//				removeDotAtIndex(i);
//				return;
//			}
//		}
		
		for (int i = 0; i < fooditems.length; i++) {
			if (fooditems[i].getSquare().equals(square)) {
				removeFoodItemAtIndex(i);
				return;
			}
		}
	}
	
	//bug where pacman doesn't consistently eat food fixed
	public void movePacMan(Direction direction) {
		Square newSquare = pacMan.getSquare().getNeighbor(direction);
		if (newSquare.isPassable()) {
			pacMan.setSquare(newSquare);
			
			for (int i = 0; i < fooditems.length; i++) {
				if (fooditems[i].getSquare().equals(newSquare)) {
					FoodItem foodItemAtSquare = fooditems[i];
					if (foodItemAtSquare instanceof PowerPellet) {
						for (Ghost ghost : ghosts)
							ghost.pacManAtePowerPellet();
					}
				}
			}
					
					
//			if(fooditems[newSquare.getRowIndex()*map.getWidth()+newSquare.getColumnIndex()] instanceof PowerPellet) {
//				for (Ghost ghost : ghosts)
//					ghost.pacManAtePowerPellet();
//				}
					
			removeFoodItemAtSquare(newSquare);
			checkPacManDamage();
		}
	}
	
}

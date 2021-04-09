package pacman;

import java.util.Random;

public class RegularGhostState extends GhostState {
	
	RegularGhostState state;
	
	public RegularGhostState() {}
	
//	@Override
//	public GhostState getState() {
//		
//		return state;
//	}
	
	//bug fixed
	@Override
	public GhostState hitBy(Ghost ghost, PacMan pacMan) {
		pacMan.die();
		return ghost.getGhostState();
	}
	
	public GhostState move(Ghost ghost, Random random) {
		ghost.reallyMove(random);
		return ghost.getGhostState();
		
	}
}
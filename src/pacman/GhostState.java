package pacman;

import java.util.Random;

public abstract class GhostState {
	
	//GhostState state;
	int delay;
	int totalMoves;

	public GhostState() {
		this.delay = 1;
		this.totalMoves = 6;
	}
	
	
	//bug where vulnerable ghosts don't move fixed and moved to subclasses
	public abstract GhostState move(Ghost ghost, Random random);
//	public GhostState move(Ghost ghost, Random random) {
//		if(!ghost.isVulnerable()) {
//			ghost.reallyMove(random);
//			return ghost.getGhostState();
//			}
//		else 
//			if(delay==0) {
//				ghost.reallyMove(random);
//				delay++;
//				totalMoves--;
//				}
//			else delay--;
//		
//		if(totalMoves == 0) 
//			ghost.setRegularState();
//		return ghost.getGhostState(); 	
//	}
	
	//better to override?
	public GhostState hitBy(Ghost ghost, PacMan pacMan) {
		if(!ghost.isVulnerable()) {
			pacMan.die();
			return ghost.getGhostState();
		}
		else {
			
			ghost.setOriginalSquare();
			ghost.setRegularState();
		}
			
		
		return ghost.getGhostState();
	}

	//public abstract GhostState getState();

}

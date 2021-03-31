package pacman;

import java.util.Random;

public abstract class GhostState {
	
	GhostState state;
	int delay;
	int totalMoves = 6;

	
	
	
	public GhostState move(Ghost ghost, Random random) {
		if(!ghost.isVulnerable()) {
			ghost.reallyMove(random);
			return ghost.getGhostState();
			}
		else 
			delay = 1;
			if(delay==0) {
				ghost.reallyMove(random);
				totalMoves--;
				}
			else delay--;
		
		if(totalMoves == 0)
			ghost.setRegularState();
		return ghost.getGhostState(); 	
	}
	public GhostState hitBy(Ghost ghost, PacMan pacMan) {
		if(ghost.getSquare().equals(pacMan.getSquare())
				 /*&& state*/ )
			
			return state; 
		return state;
	}

	public abstract GhostState getState();

}

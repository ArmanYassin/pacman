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
		else {
			delay = 1;
			if(delay==0) {
				ghost.reallyMove(random);
				totalMoves--;
				}
			else delay--;
			}
		
		if(totalMoves == 0)
			ghost.setRegularState();
		return ghost.getGhostState(); 	
	}
	/*
	 * Aangepast 06/04
	 */
	public GhostState hitBy(Ghost ghost, PacMan pacMan) {
		if(!ghost.isVulnerable()) {
			pacMan.die();
			return ghost.getGhostState();
		}
		else {
			
			ghost.setSquare(ghost.getOriginalSquare());
			ghost.setRegularState();
		}
			
		
		return ghost.getGhostState();
	}

	public abstract GhostState getState();

}

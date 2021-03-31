package pacman;

import java.util.Random;

public abstract class GhostState {
	
	GhostState state;

	
	
	
	public GhostState move(Ghost ghost, Random random) {
		return null;
	}
	public GhostState hitBy(Ghost ghost, PacMan pacMan) {
		if(ghost.getSquare().equals(pacMan.getSquare())
				 /*&& state*/ )
			return state; 
		return state;
	}
	
	public abstract GhostState getState();

}

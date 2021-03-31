package pacman;

import java.util.Random;

public abstract class GhostState {
	
	GhostState state;

	
	
	
	public GhostState move(Ghost ghost, Random random) {
		//if(ghost.getGhostState() instanceof VulnerableGhostState)
		return state;
	}
	public GhostState hitBy(Ghost ghost, PacMan pacMan) {
		if(ghost.getSquare().equals(pacMan.getSquare())
				 /*&& state*/ )
			return state; 
		return state;
	}

	public abstract GhostState getState();

}

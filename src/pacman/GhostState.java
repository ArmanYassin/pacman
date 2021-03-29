package pacman;

public abstract class GhostState {
	
	private GhostState state;
	
	
	public GhostState hitBy(Ghost ghost, PacMan pacMan) {
		if(ghost.getSquare().equals(pacMan.getSquare())
				 /*&& state*/ )
			return state; 
		return state;
	}

}

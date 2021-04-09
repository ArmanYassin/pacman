package pacman;

import java.util.Random;

public class VulnerableGhostState extends GhostState{
	
	VulnerableGhostState state;
	
	public VulnerableGhostState() {}
		
//	@Override
//	public GhostState getState() {
//		return state;
//	}
	
	
	//bug fixed
	@Override
	public GhostState hitBy(Ghost ghost, PacMan pacMan) {
		ghost.setOriginalSquare();
		ghost.setRegularState();
		return ghost.getGhostState();
	}
	
	public GhostState move(Ghost ghost, Random random) {
		if(delay==0) {
			ghost.reallyMove(random);
			delay++;
			totalMoves--;
			}
		else delay--;
		if(totalMoves == 0) 
			ghost.setRegularState();
		return ghost.getGhostState();
	}
}

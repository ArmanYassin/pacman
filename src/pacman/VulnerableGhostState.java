package pacman;

public class VulnerableGhostState extends GhostState{
	
	Ghost ghost;
	VulnerableGhostState state;
	
	public VulnerableGhostState() {}
	
	@Override
	public GhostState getState() {
		return state;
	}

}

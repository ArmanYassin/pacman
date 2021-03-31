package pacman;

public class VulnerableGhostState extends GhostState{
	
	VulnerableGhostState state;
	
	public VulnerableGhostState() {}
	
	@Override
	public GhostState getState() {
		return state;
	}

}

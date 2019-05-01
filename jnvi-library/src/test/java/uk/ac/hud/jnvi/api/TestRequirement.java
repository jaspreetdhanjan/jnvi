package uk.ac.hud.jnvi.api;

public interface TestRequirement {
	default int getVectorSize() {
		return 4;
	}
}
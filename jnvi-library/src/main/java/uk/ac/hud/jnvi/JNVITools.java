package uk.ac.hud.jnvi;

/**
 * A class that caches any data from the {@link uk.ac.hud.jnvi.api.JNVIAPI} class to reduce native method calls.
 */

public class JNVITools {
	private static final int version;

	static {
		version = JNVITools.getVersion();
	}

	public static int getVersion() {
		return version;
	}
}
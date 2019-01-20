package uk.ac.hud.jnvi;

import uk.ac.hud.jnvi.api.JNVIAPI;

/**
 * A class that caches any data from the {@link uk.ac.hud.jnvi.api.JNVIAPI} class to reduce native method calls.
 */

public class JNVITools {
	private static Integer version;

	public static int getVersion() {
		if (version == null) {
			version = JNVIAPI.getVersion();
		}
		return version;
	}
}
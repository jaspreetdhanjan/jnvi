package uk.ac.hud.jnvi;

import java.io.File;

/**
 * A utility class that allows us to load our JNVI native library into the JVM.
 * <p>
 * Setting the System Property jnvi.library.dir to the folder enclosing our JNVI library is enough. This class will
 * find out what library is suited for this machine.
 *
 * @author Jaspreet Dhanjan
 * @date 25/12/2018
 */

public class SharedLibrary {
	private enum OSType {
		macOS(".jnilib"), windows(".dll"), linux(".so"), other(null);

		String extension;

		OSType(String extension) {
			this.extension = extension;
		}
	}

	public static final String LIBRARY_DIRECTORY_PROPERTY = "jnvi.library.dir";

	private static final String LIBRARY_DEFAULT_DIRECTORY = "target/";
	private static final String LIBRARY_NAME = "jnvi-lib";

	private static final OSType OS = getOS();

	private SharedLibrary() {
	}

	public static void load(boolean debug) {
		final String parentDirectoryProperty = System.getProperty(LIBRARY_DIRECTORY_PROPERTY, LIBRARY_DEFAULT_DIRECTORY);

		File parentDirectory = new File(parentDirectoryProperty);

		if (!parentDirectory.exists()) {
			throw new RuntimeException("The folder (" + parentDirectoryProperty + ") containing the native library does not exist!");
		}

		File libraryFile = new File(parentDirectory, getLibraryFilename());

		if (!libraryFile.exists()) {
			throw new RuntimeException("The native library does not exist within the " + parentDirectoryProperty + " folder!");
		}

		load(libraryFile, debug);
	}

	private static void load(File libraryFile, boolean debug) {
		final String libraryPath = libraryFile.getAbsolutePath();

		if (debug) {
			System.out.println("Loading -> " + libraryPath);
		}

		System.load(libraryPath);
	}

	private static String getLibraryFilename() {
		final String ext = OS.extension;

		if (ext == null) {
			throw new RuntimeException("JNVI Library is not supported on this platform!");
		}

		return LIBRARY_NAME + ext;
	}

	private static OSType getOS() {
		final String os = System.getProperty("os.name", "generic").toLowerCase();

		if (os.contains("mac") || os.contains("darwin")) {
			return OSType.macOS;
		} else if (os.contains("win")) {
			return OSType.windows;
		} else if (os.contains("nux")) {
			return OSType.linux;
		}

		return OSType.other;
	}
}
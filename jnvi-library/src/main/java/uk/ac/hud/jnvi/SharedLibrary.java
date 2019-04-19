package uk.ac.hud.jnvi;

import java.io.File;

/**
 * A utility class that allows us to load our JNVI native library into the JVM.
 *
 * @author Jaspreet Dhanjan
 */

public class SharedLibrary {
	private enum OSType {
		macOS(".jnilib"), windows(".dll"), linux(".so");

		String extension;

		OSType(String extension) {
			this.extension = extension;
		}
	}

	public static final String JNVI_LIBRARY_DIRECTORY_PROPERTY = "jnvi.library.dir";
	
	private static final String LIBRARY_DEFAULT_DIRECTORY = "src/main/resources/natives/";
	private static final String LIBRARY_NAME = "jnvi-lib";

	private static final OSType OS = getOS();

	private SharedLibrary() {
	}

	/**
	 * Will load the native library from the jnvi.library.dir system property. If this is unset, then the method will
	 * attempt to load the library from the default target output directory.
	 * <p>
	 * Setting the System Property jnvi.library.dir to the folder enclosing our JNVI library is enough. This class will
	 * find out what library extension is best suited for this machine.
	 * <p>
	 * If this machine is unsupported or the native library does not exist, a {@link RuntimeException} will be thrown.
	 */
	public static void load() {
		final String parentDirectoryProperty = System.getProperty(JNVI_LIBRARY_DIRECTORY_PROPERTY, LIBRARY_DEFAULT_DIRECTORY);

		File parentDirectory = new File(parentDirectoryProperty);

		if (!parentDirectory.exists()) {
			throw new RuntimeException("The folder (" + parentDirectoryProperty + ") containing the native library does not exist!");
		}

		File libraryFile = new File(parentDirectory, getLibraryFilename());

		if (!libraryFile.exists()) {
			throw new RuntimeException("The native library does not exist within the " + parentDirectoryProperty + " folder!");
		}

		System.load(libraryFile.getAbsolutePath());
	}

	private static String getLibraryFilename() {
		if (OS == null) {
			throw new RuntimeException("JNVI Library is not supported on this platform!");
		}

		return LIBRARY_NAME + OS.extension;
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

		return null;
	}
}
package uk.ac.hud.jnvi;

import java.io.File;

/**
 * A utility class that allows us to load our JNVI native library into the JVM.
 *
 * @author Jaspreet Dhanjan
 * @date 25/12/2018
 */

public class SharedLibrary {
	private enum OSType {
		macOS, windows, linux, other;
	}

	private static final String LIBRARY_DEFAULT_DIRECTORY = "target/";
	private static final String LIBRARY_NAME = "jnvi-lib";

	private static final String LIBRARY_DIRECTORY_PROPERTY = "jnvi.library.dir";

	private static final OSType OS = getOS();

	private SharedLibrary() {
	}

	public static void load(boolean debug) {
		final String parentDirectoryProperty = System.getProperty(LIBRARY_DIRECTORY_PROPERTY, LIBRARY_DEFAULT_DIRECTORY);

//		if (debug) {
//			System.out.println(System.getProperty("os.name") + " v" + System.getProperty("os.version"));
//			System.out.println(System.getProperty("java.version") + " " + System.getProperty("os.arch"));
//			System.out.println(System.getProperty("java.vm.name") + " v" + System.getProperty("java.vm.version") + " by " + System.getProperty("java.vm.vendor"));
//			System.out.println();
//		}

		File parentFile = new File(parentDirectoryProperty);

		if (!parentFile.exists()) {
			throw new RuntimeException("Folder containing the native library does not exist!");
		}

		File libraryFile = new File(parentFile, LIBRARY_NAME + getExtension(OS));

		if (!libraryFile.exists()) {
			throw new RuntimeException("Native library does not exist within the " + parentDirectoryProperty + " folder!");
		}

		String libraryPath = libraryFile.getAbsolutePath();

		if (debug) {
			System.out.println("Loading -> " + libraryPath);
		}

		System.load(libraryPath);
	}

	private static String getExtension(OSType osType) {
		if (osType == OSType.macOS) {
			return ".jnilib";
		} else if (osType == OSType.windows) {
			return ".dll";
		} else if (osType == OSType.linux) {
			return ".so";
		}

		throw new RuntimeException("JNVI Library is not supported on this platform!");
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
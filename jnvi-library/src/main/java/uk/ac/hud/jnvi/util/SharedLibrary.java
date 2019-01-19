package uk.ac.hud.jnvi.util;

import java.io.File;

/**
 * A utility class that allows us to load native libraries into the JVM through a given directory.
 *
 * @author Jaspreet Dhanjan
 * @date 25/12/2018
 */

public class SharedLibrary {
	// TODO switch to target once we bundle into the .jar
	private static final String LIBRARY_DIRECTORY = "target/";

	private SharedLibrary() {
	}

	public static void load(boolean debug) {
		if (debug) {
			System.out.println(System.getProperty("os.name") + " v" + System.getProperty("os.version"));
			System.out.println(System.getProperty("java.version") + " " + System.getProperty("os.arch"));
			System.out.println(System.getProperty("java.vm.name") + " v" + System.getProperty("java.vm.version") + " by " + System.getProperty("java.vm.vendor"));
			System.out.println();
		}

		File libraryDirectoryFile = new File(LIBRARY_DIRECTORY);

		File[] libraries = libraryDirectoryFile.listFiles();
		if (libraries == null || libraries.length == 0) {
			throw new RuntimeException("No shared libraries within the directory.");
		}

		for (File file : libraries) {
			if (file.getName().endsWith(".jnilib")) {
				String path = file.getAbsolutePath();
				System.load(path);
			}
		}
	}
}
package uk.ac.hud.jnvi.api;

/**
 * Lightweight class that defines the main API for the Java Native Vectorisation Interface.
 * <p>
 * It is essential that this class does not include any references to any non-JDK classes. This class is initially
 * compiled to generate the C header files. We do this to ensure all prior defined tests work before recompiling
 * the new changes.
 * <p>
 * Any package within uk.ac.hud.uk.ac.hud.jnvi.api.* is subject to this initial pre-compilation step.
 * <p>
 * It is highly recommended that no developers use this class directly and instead use the
 * VectorTools API provided which encapsulate all processes.
 *
 * @author Jaspreet Dhanjan
 * @date 25/12/2018
 * @since 1.0.0
 */

public class JNVIAPI {
	private static final boolean SUPPORTED;

	static {
		boolean supported = false;
		try {
			supported = nativeInit();
		} catch (UnsatisfiedLinkError unsatisfiedLinkError) {
			System.err.println("JNVI library not loaded! Use SharedLibrary.load() to load the shared libraries.");
		}

		SUPPORTED = supported;
	}

	/**
	 * Jaspreets-MBP:~ jaspreetdhanjan$ sysctl -a | grep machdep.cpu.features
	 * machdep.cpu.features: FPU VME DE PSE TSC MSR PAE MCE CX8 APIC SEP MTRR PGE MCA CMOV PAT PSE36 CLFSH DS ACPI MMX FXSR SSE SSE2 SS HTT TM PBE SSE3 PCLMULQDQ DTES64 MONDSCPL VMX EST TM2 SSSE3 FMA CX16 TPR PDCM SSE4.1 SSE4.2 x2APIC MOVBE POPCNT AES PCID XSAVE OSXSAVE SEGLIM64 TSCTMR AVX1.0 RDRAND F16C
	 */

	private JNVIAPI() {
	}

	/**
	 * An internal API operation notifying the native library when the JNVIAPI class is statically initialised.
	 *
	 * @return true if the API is supported on this machine's architecture, view {@link #isSupported()}.
	 * @since 1.0.0
	 */
	private static native boolean nativeInit();

	/**
	 * Allows the developer to gain insight into the shared library they have installed.
	 *
	 * @return the version of the JNVI API.
	 * @since 1.0.0
	 */
	public static native int getVersion();

	/**
	 * This API is specifically built for Intel's: MMX, SSE, SSE2, SSE3, SSSE3 AND SSE4.x architectures.
	 *
	 * @return true if the hardware supports Single Instruction, Multiple Data (SIMD) processes. False if otherwise.
	 * @since 1.0.0
	 */
	public static boolean isSupported() {
		return SUPPORTED;
	}

	/**
	 * Will multiply the vector data at addressA to the vector data at addressB and place the result at addressC. It is
	 * critically important that the vector information stored at addressA and addressB are of the same length.
	 * <p>
	 * It is important that this address is released as it exists within native memory.
	 * <p>
	 * Based off: https://stackoverflow.com/questions/1632367/passing-pointers-between-c-and-java-through-jni
	 *
	 * @since 1.0.0
	 */
	public static native void nativeMultiply(long addressA, long addressB, long addressC, long length);

	//public static native float[] multiply(float[] a, float[] b);
}
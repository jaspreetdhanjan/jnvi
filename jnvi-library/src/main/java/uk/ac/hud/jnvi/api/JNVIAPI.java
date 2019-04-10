package uk.ac.hud.jnvi.api;

/**
 * Defines the main API for the Java Native Vectorisation Interface. It gives us access to the plethora of low-level
 * Intel Single Instruction, Multiple Data (SIMD) intrinsics.
 * <p>
 * All off-heap data must be aligned and of the same length.
 * <p>
 * It is essential that this class does not include any references to any non-JDK classes. This class is initially
 * compiled to generate the C header files. We do this to ensure all prior defined tests work before recompiling
 * the new changes.
 * <p>
 * Any class within the uk.ac.hud.jnvi.api package is subject to this initial pre-compilation step.
 * <p>
 * Some documentation may have been lifted from: https://software.intel.com/sites/landingpage/IntrinsicsGuide
 *
 * @author Jaspreet Dhanjan
 * @since 1.0.0
 */

public class JNVIAPI {
	private static final int SUPPORT;
	private static Integer VERSION;

	public static final byte JNVI_DOUBLE_TYPE = 0x1;
	public static final byte JNVI_FLOAT_TYPE = 0x2;
	public static final byte JNVI_INT_TYPE = 0x3;

	static {
		int support = 0;

		try {
			support = nativeInit();
		} catch (UnsatisfiedLinkError unsatisfiedLinkError) {
			System.err.println("JNVI library not loaded! Use SharedLibrary.load() to load the shared libraries.");
			unsatisfiedLinkError.printStackTrace();
		}

		SUPPORT = support;
		System.out.println("JNVI Library successfully loaded! (With support for: 0b" + Integer.toBinaryString(support) + ")");
	}

	private JNVIAPI() {
	}

	//----------------------
	// API
	// ----------------------

	/**
	 * An internal API operation notifying the native library when the JNVIAPI class is statically initialised.
	 * <p>
	 * This should only be called once. The result is cached and can be accessed through the {@link #isSupported()}
	 * method.
	 * <p>
	 * This return type refers to a custom bit order that defines the user support for Intel's SIMD hardware. This bit
	 * order's schema is defined as following:
	 * <p>
	 * |--------------------------------------------------------|
	 * | AVX2 | AVX | SSE42 | SSE41 | SSSE3 | SSE3 | SSE2 | SSE |
	 * |--------------------------------------------------------|
	 * |   0  |  0  |   0   |   0   |   0   |   0  |   0  |  0  |
	 * |--------------------------------------------------------|
	 *
	 * @return an integer value (big endian) containing the corresponding bits that support the SIMD specification.
	 * @since 1.0.0
	 */
	private static native int nativeInit();

	/**
	 * Native implementation of {@link #getVersion()}
	 *
	 * @return the version of the JNVI API.
	 * @since 1.0.0
	 */
	private static native int getVersion0();

	/**
	 * Allows the developer to gain insight into the shared library they have installed.
	 *
	 * @return the version of the JNVI API.
	 * @since 1.0.0
	 */
	public static int getVersion() {
		if (VERSION == null) {
			VERSION = getVersion0();
		}

		return VERSION;
	}

	/**
	 * This API is specifically built for Intel's: SSE, SSE2, SSE3, SSSE3, SSE4.x, AVX and AVX2 architectures.
	 *
	 * @return true if the hardware supports on of the aforementioned architectures. False if otherwise.
	 * @since 1.0.0
	 */
	public static boolean isSupported() {
		return SUPPORT > 0;
	}

	//----------------------
	// Operations
	//----------------------

	/**
	 * Adds the elements within srcA to the elements within srcB and store the results in dest.
	 *
	 * @param type the type of memory we are using. This MUST be the same for all sources and the dest.
	 *             JNVI_DOUBLE_TYPE, JNVI_FLOAT_TYPE and JNVI_INT_TYPE is supported.
	 * @param srcA the memory location of value A.
	 * @param srcB the memory location of value B.
	 * @param dest the memory location of the calculation result.
	 * @since 1.0.0
	 */
	public static native void add(byte type, long srcA, long srcB, long dest);

	/**
	 * Subtracts the vector data at srcA to the vector data at srcB and place the result at dest.
	 *
	 * @param type the type of memory we are using. This MUST be the same for all sources and the dest.
	 *             JNVI_DOUBLE_TYPE, JNVI_FLOAT_TYPE and JNVI_INT_TYPE is supported.
	 * @param srcA the memory location of value A.
	 * @param srcB the memory location of value B.
	 * @param dest the memory location of the calculation result.
	 * @since 1.0.0
	 */
	public static native void sub(byte type, long srcA, long srcB, long dest);

	/**
	 * Multiplies the vector data at srcA to the vector data at srcB and place the result at dest.
	 * <p>
	 * It is critically important that the vector information stored at srcA, srcB and dest are of the same length.
	 *
	 * @param type the type of memory we are using. This MUST be the same for all sources and the dest.
	 *             JNVI_DOUBLE_TYPE, JNVI_FLOAT_TYPE and JNVI_INT_TYPE is supported.
	 * @param srcA the memory location of value A.
	 * @param srcB the memory location of value B.
	 * @param dest the memory location of the calculation result.
	 * @since 1.0.0
	 */
	public static native void mul(byte type, long srcA, long srcB, long dest);

	/**
	 * Divides the vector data at srcA to the vector data at srcB and place the result at dest.
	 *
	 * @param type the type of memory we are using. This MUST be the same for all sources and the dest.
	 *             JNVI_DOUBLE_TYPE, JNVI_FLOAT_TYPE and JNVI_INT_TYPE is supported.
	 * @param srcA the memory location of value A (numerator).
	 * @param srcB the memory location of value B (denominator).
	 * @param dest the memory location of the calculation result.
	 * @since 1.0.0
	 */
	public static native void div(byte type, long srcA, long srcB, long dest);
}
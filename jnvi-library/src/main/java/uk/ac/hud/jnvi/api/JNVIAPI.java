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

public final class JNVIAPI {
	private static final int SUPPORT;
	private static final int VERSION;
	
	public static final byte TYPE_DOUBLE = 0x1;
	public static final byte TYPE_FLOAT = 0x2;
	public static final byte TYPE_INT = 0x3;
	
	static {
		int support;
		try {
			support = nativeInit();
		} catch (UnsatisfiedLinkError unsatisfiedLinkError) {
			throw new RuntimeException("JNVI library not loaded! Use SharedLibrary.load() to load the shared libraries.",
					unsatisfiedLinkError);
		}
		
		SUPPORT = support;
		VERSION = getVersion0();
		
		System.out.println("JNVI Library successfully loaded! (With support for: 0b" + Integer.toBinaryString(support) + ")");
	}
	
	private JNVIAPI() {
		throw new RuntimeException("JNVIAPI should not be instantiated!");
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
	 * Adds the vector data at srcA to the elements within srcB and store the results in dest.
	 *
	 * @param type the type of memory we are using. This MUST be the same for all sources and the dest.
	 *             TYPE_DOUBLE, TYPE_FLOAT and TYPE_INT is supported.
	 * @param srcA the memory location of value A.
	 * @param srcB the memory location of value B.
	 * @param dest the memory location of the calculation result.
	 * @param n    the number of elements. Size of srcA, srcB and dest MUST be of this length.
	 * @since 1.0.0
	 */
	public static native void add(byte type, long srcA, long srcB, long dest, int n);
	
	/**
	 * Subtracts the vector data at srcA from the vector data at srcB and place the result at dest.
	 *
	 * @param type the type of memory we are using. This MUST be the same for all sources and the dest.
	 *             TYPE_DOUBLE, TYPE_FLOAT and TYPE_INT is supported.
	 * @param srcA the memory location of value A.
	 * @param srcB the memory location of value B.
	 * @param dest the memory location of the calculation result.
	 * @param n    the number of elements. Size of srcA, srcB and dest MUST be of this length.
	 * @since 1.0.0
	 */
	public static native void sub(byte type, long srcA, long srcB, long dest, int n);
	
	/**
	 * Multiplies the vector data at srcA to the vector data at srcB and place the result at dest.
	 *
	 * @param type the type of memory we are using. This MUST be the same for all sources and the dest.
	 *             TYPE_DOUBLE, TYPE_FLOAT and TYPE_INT is supported.
	 * @param srcA the memory location of value A.
	 * @param srcB the memory location of value B.
	 * @param dest the memory location of the calculation result.
	 * @param n    the number of elements. Size of srcA, srcB and dest MUST be of this length.
	 * @since 1.0.0
	 */
	public static native void mul(byte type, long srcA, long srcB, long dest, int n);
	
	/**
	 * Divides the vector data at srcA by the vector data at srcB and place the result at dest.
	 *
	 * @param type the type of memory we are using. This MUST be the same for all sources and the dest.
	 *             TYPE_DOUBLE, TYPE_FLOAT and TYPE_INT is supported.
	 * @param srcA the memory location of value A (numerator).
	 * @param srcB the memory location of value B (denominator).
	 * @param dest the memory location of the calculation result.
	 * @param n    the number of elements. Size of srcA, srcB and dest MUST be of this length.
	 * @since 1.0.0
	 */
	public static native void div(byte type, long srcA, long srcB, long dest, int n);
	
	/**
	 * Computes a vectorised dot (or scalar) product of the vector data at srcA and srcB and places the result
	 * at dest.
	 *
	 * @param type the type of memory we are using. This MUST be the same for all sources and the dest.
	 *             TYPE_DOUBLE, TYPE_FLOAT and TYPE_INT is supported.
	 * @param srcA the memory location of value A (numerator).
	 * @param srcB the memory location of value B (denominator).
	 * @param dest the memory location of the calculation result.
	 * @param n    the number of elements. Size of srcA and srcB MUST be of this length.
	 * @since 1.0.0
	 */
	public static native void dot(byte type, long srcA, long srcB, long dest, int n);
	
	/**
	 * Computes a vectorised horizontal sum of all values at src and places the result at dest.
	 * <b>dest should be a singular value for the result.</b>
	 *
	 * @param type the type of memory we are using. This MUST be the same for all sources and the dest.
	 *             TYPE_DOUBLE and TYPE_FLOAT is supported.
	 * @param src  the memory location of value.
	 * @param dest the memory location of the calculation result.
	 * @param n    the number of elements.
	 * @since 1.0.0
	 */
	public static native void sum(byte type, long src, long dest, int n);
	
	/**
	 * Computes the square-root on the vector data, in parallel, at src and places the result at dest.
	 *
	 * @param type the type of memory we are using. This MUST be the same for all sources and the dest.
	 *             TYPE_DOUBLE and TYPE_FLOAT is supported.
	 * @param src  the memory location of value.
	 * @param dest the memory location of the calculation result.
	 * @param n    the number of elements.
	 * @since 1.0.0
	 */
	public static native void sqrt(byte type, long src, long dest, int n);
	
	/**
	 * Computes the approximate reciprocal square-root on the vector data at src and places the result at dest.
	 *
	 * <b>Only supports TYPE_FLOAT!</b>
	 *
	 * @param src  the memory location of value.
	 * @param dest the memory location of the calculation result.
	 * @param n    the number of elements.
	 * @since 1.0.0
	 */
	public static native void rsqrt(long src, long dest, int n);
}
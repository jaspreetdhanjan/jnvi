package uk.ac.hud.jnvi.memory;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * A wrapper class allowing us to access and use sun.misc.Unsafe methods. Using the Unsafe class is the only way
 * we can possibly manipulate memory from the JVM without writing more slow native code.
 * <p>
 * Largely contains 'peak and poke' operations. The compiler should optimize these to intrinsics.
 * <p>
 * <b>WARNING:</b> It is absolutely important that any memory allocated through this class MUST be deallocated using the
 * {@link #freeMemory(long)} method.
 * <p>
 * Any method-level documentation is taken from:
 * http://hg.openjdk.java.net/jdk8/jdk8/jdk/file/687fd7c7986d/src/share/classes/sun/misc/Unsafe.java
 *
 * @author Jaspreet Dhanjan
 * @date 25/12/2018
 * @since 1.0.0
 */

public class UnsafeAccessor {
	private static final Unsafe UNSAFE;

	static {
		try {
			Field f = Unsafe.class.getDeclaredField("theUnsafe");
			f.setAccessible(true);
			UNSAFE = (Unsafe) f.get(null);
		} catch (Exception e) {
			throw new RuntimeException("Unable to access Unsafe.");
		}
	}

	private UnsafeAccessor() {
	}

	/**
	 * Allocates a new block of native memory, of the given size in bytes.  The
	 * contents of the memory are uninitialized; they will generally be
	 * garbage.  The resulting native pointer will never be zero, and will be
	 * aligned for all value types.  Dispose of this memory by calling {@link
	 * #freeMemory}, or resize it with {@link #reallocateMemory}.
	 *
	 * @throws IllegalArgumentException if the size is negative or too large
	 *                                  for the native size_t type
	 * @throws OutOfMemoryError         if the allocation is refused by the system
	 * @see #getByte(long)
	 * @see #putByte(long, byte)
	 */
	public static long allocateMemory(long size) {
		return UNSAFE.allocateMemory(size);
	}

	/**
	 * Resizes a new block of native memory, to the given size in bytes.  The
	 * contents of the new block past the size of the old block are
	 * uninitialized; they will generally be garbage.  The resulting native
	 * pointer will be zero if and only if the requested size is zero.  The
	 * resulting native pointer will be aligned for all value types.  Dispose
	 * of this memory by calling {@link #freeMemory}, or resize it with {@link
	 * #reallocateMemory}.  The address passed to this method may be null, in
	 * which case an allocation will be performed.
	 *
	 * @throws IllegalArgumentException if the size is negative or too large
	 *                                  for the native size_t type
	 * @throws OutOfMemoryError         if the allocation is refused by the system
	 * @see #allocateMemory
	 */
	public static long reallocateMemory(long address, long newSize) {
		return UNSAFE.reallocateMemory(address, newSize);
	}

	/**
	 * Disposes of a block of native memory, as obtained from {@link
	 * #allocateMemory} or {@link #reallocateMemory}.  The address passed to
	 * this method may be null, in which case no action is taken.
	 *
	 * @see #allocateMemory
	 */
	public static void freeMemory(long address) {
		UNSAFE.freeMemory(address);
	}

	/**
	 * Sets all bytes in a given block of memory to a fixed value
	 * (usually zero).  This provides a <em>single-register</em> addressing mode,
	 * as discussed in {@link #getInt(long)}.
	 *
	 * <p>Equivalent to <code>setMemory(null, address, bytes, value)</code>.
	 */
	public static void setMemory(long address, long size, byte value) {
		UNSAFE.setMemory(address, size, value);
	}

	public static void putByte(long address, byte value) {
		UNSAFE.putByte(address, value);
	}

	public static byte getByte(long address) {
		return UNSAFE.getByte(address);
	}

	public static void putInt(long address, int value) {
		UNSAFE.putInt(address, value);
	}

	public static int getInt(long address) {
		return UNSAFE.getInt(address);
	}

	public static void putFloat(long address, float value) {
		UNSAFE.putFloat(address, value);
	}

	public static float getFloat(long address) {
		return UNSAFE.getFloat(address);
	}

	public static void putDouble(long address, double value) {
		UNSAFE.putDouble(address, value);
	}

	public static double getDouble(long address) {
		return UNSAFE.getDouble(address);
	}

	public static void putLong(long address, long value) {
		UNSAFE.putLong(address, value);
	}

	public static long getLong(long address) {
		return UNSAFE.getLong(address);
	}
}
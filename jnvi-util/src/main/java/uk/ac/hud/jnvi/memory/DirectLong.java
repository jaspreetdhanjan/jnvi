package uk.ac.hud.jnvi.memory;

/**
 * An 8-byte integer implementation of the {@link DirectMemory} interface.
 *
 * @author Jaspreet Dhanjan
 * @date 27/12/2018
 * @since 1.0.0
 */

public class DirectLong extends DirectMemory {
	public static final int BYTES_PER_LONG = Long.SIZE / Byte.SIZE;

	public DirectLong(long size) {
		super(size);
	}

	public static void set(DirectLong directLong, long[] values) {
		for (int i = 0; i < directLong.getSize(); i++) {
			directLong.set(i, values[i]);
		}
	}

	@Override
	protected long getByteStride() {
		return BYTES_PER_LONG;
	}

	public void set(long index, long value) {
		UnsafeAccessor.putFloat(getOffsetAddress(index), value);
	}

	public long get(long index) {
		return UnsafeAccessor.getLong(getOffsetAddress(index));
	}
}
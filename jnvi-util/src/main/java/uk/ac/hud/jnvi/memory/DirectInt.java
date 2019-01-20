package uk.ac.hud.jnvi.memory;

/**
 * An 4-byte integer implementation of the {@link DirectMemory} interface.
 *
 * @author Jaspreet Dhanjan
 * @date 27/12/2018
 * @since 1.0.0
 */

public class DirectInt extends DirectMemory {
	public static final int BYTES_PER_INT = Integer.SIZE / Byte.SIZE;

	public DirectInt(long size) {
		super(size);
	}

	public static void set(DirectInt directLong, int[] values) {
		for (int i = 0; i < directLong.getSize(); i++) {
			directLong.set(i, values[i]);
		}
	}

	@Override
	protected long getByteStride() {
		return BYTES_PER_INT;
	}

	public void set(long index, int value) {
		UnsafeAccessor.putInt(getOffsetAddress(index), value);
	}

	public int get(long index) {
		return UnsafeAccessor.getInt(getOffsetAddress(index));
	}
}
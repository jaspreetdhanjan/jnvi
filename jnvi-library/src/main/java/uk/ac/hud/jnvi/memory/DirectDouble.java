package uk.ac.hud.jnvi.memory;

import uk.ac.hud.jnvi.util.UnsafeAccessor;

/**
 * An 8-byte floating-point implementation of the {@link DirectMemory} interface.
 *
 * @author Jaspreet Dhanjan
 * @date 27/12/2018
 * @since 1.0.0
 */

public class DirectDouble extends DirectMemory {
	public static final int BYTES_PER_DOUBLE = Double.SIZE / Byte.SIZE;

	public DirectDouble(long size) {
		super(size);
	}

	public static void set(DirectDouble directLong, double[] values) {
		for (int i = 0; i < directLong.getSize(); i++) {
			directLong.set(i, values[i]);
		}
	}

	@Override
	protected long getByteStride() {
		return BYTES_PER_DOUBLE;
	}

	public void set(long index, double value) {
		UnsafeAccessor.putDouble(getOffsetAddress(index), value);
	}

	public double get(long index) {
		return UnsafeAccessor.getDouble(getOffsetAddress(index));
	}
}
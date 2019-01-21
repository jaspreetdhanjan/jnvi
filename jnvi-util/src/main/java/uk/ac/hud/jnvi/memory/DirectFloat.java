package uk.ac.hud.jnvi.memory;

/**
 * A 4-byte floating-point implementation of the {@link DirectMemory} interface.
 *
 * @author Jaspreet Dhanjan
 * @date 25/12/2018
 * @since 1.0.0
 */

public class DirectFloat extends DirectMemory {
	public static final int BYTES_PER_FLOAT = Float.SIZE / Byte.SIZE;

	public DirectFloat(long size) {
		super(size);
	}

	public static void set(DirectFloat directFloat, float[] values) {
		for (int i = 0; i < directFloat.getSize(); i++) {
			directFloat.set(i, values[i]);
		}
	}

	@Override
	protected long getByteStride() {
		return BYTES_PER_FLOAT;
	}

	public void set(long index, float value) {
		UnsafeMemory.putFloat(getOffsetAddress(index), value);
	}

	public float get(long index) {
		return UnsafeMemory.getFloat(getOffsetAddress(index));
	}
}
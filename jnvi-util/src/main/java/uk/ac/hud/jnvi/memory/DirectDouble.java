package uk.ac.hud.jnvi.memory;

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

	public static void set(DirectDouble directLong, double... values) {
		for (int i = 0; i < directLong.getSize(); i++) {
			directLong.set(i, values[i]);
		}
	}

	public static DirectDouble allocateDirect(double... values) {
		DirectDouble dd = new DirectDouble(values.length);
		DirectDouble.set(dd, values);
		return dd;
	}

	@Override
	protected long getByteStride() {
		return BYTES_PER_DOUBLE;
	}

	public void set(long index, double value) {
		UnsafeMemory.putDouble(getOffsetAddress(index), value);
	}

	public double get(long index) {
		return UnsafeMemory.getDouble(getOffsetAddress(index));
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder("[");

		final long len = getSize() - 1;
		for (long i = 0; i <= len; i++) {
			stringBuilder.append(get(i));
			if (i != len) {
				stringBuilder.append(", ");
			}
		}

		return stringBuilder.append("]").toString();
	}
}
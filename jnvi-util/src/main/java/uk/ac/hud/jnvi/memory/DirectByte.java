package uk.ac.hud.jnvi.memory;

/**
 * An single byte implementation of the {@link DirectMemory} interface.
 *
 * @author Jaspreet Dhanjan
 * @date 22/01/2019
 * @since 1.0.0
 */

public class DirectByte extends DirectMemory {
	public static final int BYTES_PER_BYTE = 1;

	public DirectByte(long size) {
		super(size);
	}

	public static void set(DirectByte directByte, byte[] values) {
		for (int i = 0; i < directByte.getSize(); i++) {
			directByte.set(i, values[i]);
		}
	}

	@Override
	protected long getByteStride() {
		return BYTES_PER_BYTE;
	}

	public void set(long index, byte value) {
		UnsafeMemory.putByte(getOffsetAddress(index), value);
	}

	public byte get(long index) {
		return UnsafeMemory.getByte(getOffsetAddress(index));
	}
}
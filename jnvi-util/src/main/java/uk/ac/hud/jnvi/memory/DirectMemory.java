package uk.ac.hud.jnvi.memory;

/**
 * Memory allocated using this class will be off-heap and inaccessible to the Java Virtual Machine, including garbage
 * collector. It is <b>essential</b> that any instantiations of any inherited classes of this type <b>should</b> be
 * destroyed after it has been used.
 *
 * @author Jaspreet Dhanjan
 * @date 27/12/2018
 * @since 1.0.0
 */

public abstract class DirectMemory {
	private final long sizeInBytes;
	private final long address;

	/**
	 * The constructor will allocated the memory, with the given size, when the object is created.
	 */
	public DirectMemory(long size) {
		this.sizeInBytes = size * getByteStride();
		this.address = UnsafeMemory.allocateMemory(sizeInBytes);

		// allocateMemory returns uninitialised memory. We need to clear it.
		UnsafeMemory.setMemory(address, sizeInBytes, (byte) 0);
	}

	protected abstract long getByteStride();

	protected long getOffsetAddress(long index) {
		return getAddress() + (index * getByteStride());
	}

	/**
	 * Destroy the off-heap memory allocation of this class. This object cannot be used after this is done.
	 *
	 * @since 1.0.0
	 */
	public void destroy() {
		UnsafeMemory.freeMemory(address);
	}

	/**
	 * @return the size of this type in it's primitive type.
	 * @since 1.0.0
	 */
	public long getSize() {
		return sizeInBytes / getByteStride();
	}

	/**
	 * @return the size of this type in bytes.
	 * @since 1.0.0
	 */
	public long getSizeInBytes() {
		return sizeInBytes;
	}

	/**
	 * @return the address location of this off-heap memory at the native level. This points to the first word in the memory chunk.
	 * @since 1.0.0
	 */
	public long getAddress() {
		return address;
	}

	/**
	 * @return {@link #getAddress()} as a hexadecimal string with the '0x' prefix.
	 * @since 1.0.0
	 */
	public String getAddressString() {
		return "0x" + Long.toHexString(getAddress());
	}
}
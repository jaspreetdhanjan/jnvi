package uk.ac.hud.jnvi.memory;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DirectByteTest {
	@Test
	public void setGetTest() {
		DirectByte directByte = new DirectByte(4);

		byte value0 = directByte.get(0);
		byte value1 = directByte.get(1);
		byte value2 = directByte.get(2);
		byte value3 = directByte.get(3);

		assertEquals("We clear this memory. We should get 0.", value0, (byte) 0);
		assertEquals("We clear this memory. We should get 0.", value1, (byte) 0);
		assertEquals("We clear this memory. We should get 0.", value2, (byte) 0);
		assertEquals("We clear this memory. We should get 0.", value3, (byte) 0);

		directByte.set(0, (byte) 0xf3);
		directByte.set(1, (byte) 0xee);
		directByte.set(2, (byte) 0x00);
		directByte.set(3, (byte) 0x10);

		value0 = directByte.get(0);
		value1 = directByte.get(1);
		value2 = directByte.get(2);
		value3 = directByte.get(3);

		assertEquals("Value at index 0 should be what we gave it.", value0, (byte) 0xf3);
		assertEquals("Value at index 1 should be what we gave it.", value1, (byte) 0xee);
		assertEquals("Value at index 2 should be what we gave it.", value2, (byte) 0x00);
		assertEquals("Value at index 3 should be what we gave it.", value3, (byte) 0x10);

		directByte.destroy();
	}

	@Test
	public void sizeTest() {
		DirectByte directByte = new DirectByte(15);

		assertEquals("This DirectByte should have 15 available bytes.", directByte.getSize(), 15);
		assertEquals("This DirectByte should have 60 available bytes.", directByte.getSizeInBytes(), 15);

		assertEquals("Real size and byte size should always be identical for this case.", directByte.getSize(), directByte.getSizeInBytes());

		directByte.destroy();
	}

	@Test
	public void getAddressTest() {
		DirectByte directByte = new DirectByte(1);

		final long address = directByte.getAddress();

		assertTrue("Address should never be zero or negative.", address > 0);

		directByte.destroy();
	}
}
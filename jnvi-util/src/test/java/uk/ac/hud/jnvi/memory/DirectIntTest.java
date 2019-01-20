package uk.ac.hud.jnvi.memory;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DirectIntTest {
	@Test
	public void setGetTest() {
		DirectInt directInt = new DirectInt(4);

		int value0 = directInt.get(0);
		int value1 = directInt.get(1);
		int value2 = directInt.get(2);
		int value3 = directInt.get(3);

		assertEquals("We clear this memory. We should get 0.", value0, 0);
		assertEquals("We clear this memory. We should get 0.", value1, 0);
		assertEquals("We clear this memory. We should get 0.", value2, 0);
		assertEquals("We clear this memory. We should get 0.", value3, 0);

		directInt.set(0, 12);
		directInt.set(1, 34525);
		directInt.set(2, -1);
		directInt.set(3, Integer.MIN_VALUE);

		value0 = directInt.get(0);
		value1 = directInt.get(1);
		value2 = directInt.get(2);
		value3 = directInt.get(3);

		assertEquals("Value at index 0 should be what we gave it.", value0, 12);
		assertEquals("Value at index 1 should be what we gave it.", value1, 34525);
		assertEquals("Value at index 2 should be what we gave it.", value2, -1);
		assertEquals("Value at index 3 should be what we gave it.", value3, Integer.MIN_VALUE);

		directInt.destroy();
	}

	@Test
	public void sizeTest() {
		DirectInt directInt = new DirectInt(15);

		assertEquals("This DirectInt should have 15 available ints.", directInt.getSize(), 15);
		assertEquals("This DirectInt should have 60 available bytes.", directInt.getSizeInBytes(), 60);

		directInt.destroy();
	}

	@Test
	public void getAddressTest() {
		DirectInt directInt = new DirectInt(1);

		final long address = directInt.getAddress();

		assertTrue("Address should never be zero or negative.", address > 0);

		directInt.destroy();
	}
}
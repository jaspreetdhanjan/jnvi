package uk.ac.hud.jnvi.memory;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DirectLongTest {
	@Test
	public void setGetTest() {
		DirectLong directLong = new DirectLong(4);

		long value0 = directLong.get(0);
		long value1 = directLong.get(1);
		long value2 = directLong.get(2);
		long value3 = directLong.get(3);

		assertEquals("We clear this memory. We should get 0.", value0, 0, 0.0f);
		assertEquals("We clear this memory. We should get 0.", value1, 0, 0.0f);
		assertEquals("We clear this memory. We should get 0.", value2, 0, 0.0f);
		assertEquals("We clear this memory. We should get 0.", value3, 0, 0.0f);

		directLong.set(0, 36345);
		directLong.set(1, Long.MAX_VALUE);
		directLong.set(2, 0);
		directLong.set(3, -35632);

		value0 = directLong.get(0);
		value1 = directLong.get(1);
		value2 = directLong.get(2);
		value3 = directLong.get(3);

		assertEquals("Value at index 0 should be what we gave it.", value0, 36345);
		assertEquals("Value at index 1 should be what we gave it.", value1, Long.MAX_VALUE);
		assertEquals("Value at index 2 should be what we gave it.", value2, 0);
		assertEquals("Value at index 3 should be what we gave it.", value3, -35632);

		directLong.destroy();
	}

	@Test
	public void sizeTest() {
		DirectLong directLong = new DirectLong(15);

		assertEquals("This DirectLong should have 15 available longs.", directLong.getSize(), 15);
		assertEquals("This DirectLong should have 60 available bytes.", directLong.getSizeInBytes(), 120);

		directLong.destroy();
	}

	@Test
	public void getAddressTest() {
		DirectLong directLong = new DirectLong(1);

		final long address = directLong.getAddress();

		assertTrue("Address should never be zero or negative.", address > 0);

		directLong.destroy();
	}
}
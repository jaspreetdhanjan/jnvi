package uk.ac.hud.jnvi.memory;

import org.junit.Test;

import static org.junit.Assert.*;

public class DirectDoubleTest {
	@Test(expected = IllegalArgumentException.class)
	public void testBadArgs() {
		DirectDouble directDouble = new DirectDouble(-1);

		assertNull("Off-heap memory cannot be allocated because a size of -1 is invalid.", directDouble);
	}

	@Test
	public void setGetTest() {
		DirectDouble directDouble = new DirectDouble(4);

		double value0 = directDouble.get(0);
		double value1 = directDouble.get(1);
		double value2 = directDouble.get(2);
		double value3 = directDouble.get(3);

		assertEquals("We clear this memory. We should get 0.", value0, 0, 0.0f);
		assertEquals("We clear this memory. We should get 0.", value1, 0, 0.0f);
		assertEquals("We clear this memory. We should get 0.", value2, 0, 0.0f);
		assertEquals("We clear this memory. We should get 0.", value3, 0, 0.0f);

		directDouble.set(0, 343452.0245252);
		directDouble.set(1, 756756.0011);
		directDouble.set(2, 45.54);
		directDouble.set(3, -345543.69);

		value0 = directDouble.get(0);
		value1 = directDouble.get(1);
		value2 = directDouble.get(2);
		value3 = directDouble.get(3);

		assertEquals("Value at index 0 should be what we gave it.", value0, 343452.0245252, 0.0f);
		assertEquals("Value at index 1 should be what we gave it.", value1, 756756.0011, 0.0f);
		assertEquals("Value at index 2 should be what we gave it.", value2, 45.54, 0.0f);
		assertEquals("Value at index 3 should be what we gave it.", value3, -345543.69, 0.0f);

		directDouble.destroy();
	}

	@Test
	public void sizeTest() {
		DirectDouble directDouble = new DirectDouble(15);

		assertEquals("This DirectDouble should have 15 available doubles.", directDouble.getSize(), 15);
		assertEquals("This DirectDouble should have 60 available bytes.", directDouble.getSizeInBytes(), 120);

		directDouble.destroy();
	}

	@Test
	public void getAddressTest() {
		DirectDouble directDouble = new DirectDouble(1);

		final long address = directDouble.getAddress();

		assertTrue("Address should never be zero or negative.", address > 0);

		directDouble.destroy();
	}
}
package jnvi.memory;

import org.junit.BeforeClass;
import org.junit.Test;
import uk.ac.hud.jnvi.memory.DirectFloat;
import uk.ac.hud.jnvi.util.SharedLibrary;

import static org.junit.Assert.*;

public class DirectFloatTest {
	@BeforeClass
	public static void beforeClass() {
		SharedLibrary.load(false);
	}

	@Test
	public void setGetTest() {
		DirectFloat directFloat = new DirectFloat(4);

		float value0 = directFloat.get(0);
		float value1 = directFloat.get(1);
		float value2 = directFloat.get(2);
		float value3 = directFloat.get(3);

		assertEquals("We clear this memory. We should get 0.", value0, 0, 0.0f);
		assertEquals("We clear this memory. We should get 0.", value1, 0, 0.0f);
		assertEquals("We clear this memory. We should get 0.", value2, 0, 0.0f);
		assertEquals("We clear this memory. We should get 0.", value3, 0, 0.0f);

		directFloat.set(0, 13454531f);
		directFloat.set(1, 34524f);
		directFloat.set(2, 1.4623f);
		directFloat.set(3, 56.565656f);

		value0 = directFloat.get(0);
		value1 = directFloat.get(1);
		value2 = directFloat.get(2);
		value3 = directFloat.get(3);

		assertEquals("Value at index 0 should be what we gave it.", value0, 13454531f, 0.0f);
		assertEquals("Value at index 1 should be what we gave it.", value1, 34524f, 0.0f);
		assertEquals("Value at index 2 should be what we gave it.", value2, 1.4623f, 0.0f);
		assertEquals("Value at index 3 should be what we gave it.", value3, 56.565656f, 0.0f);

		directFloat.destroy();
	}

	@Test
	public void sizeTest() {
		DirectFloat directFloat = new DirectFloat(15);

		assertEquals("This DirectFloat should have 15 available floats.", directFloat.getSize(), 15);
		assertEquals("This DirectFloat should have 60 available bytes.", directFloat.getSizeInBytes(), 60);
	}
}
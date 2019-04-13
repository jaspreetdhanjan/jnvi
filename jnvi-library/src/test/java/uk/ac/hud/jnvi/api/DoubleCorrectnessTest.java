package uk.ac.hud.jnvi.api;

import org.junit.rules.ErrorCollector;

import java.util.Random;

public class DoubleCorrectnessTest implements CorrectnessTest {
	private final ErrorCollector collector;
	private final Random random;

	public DoubleCorrectnessTest(ErrorCollector collector, Random random) {
		this.collector = collector;
		this.random = random;
	}

	private double getRandomDouble() {
		return random.nextDouble() * random.nextInt(10000);
	}

	private int getVectorSize() {
		return 8;
	}

	@Override
	public void testAddCorrectness() {

	}

	@Override
	public void testSubCorrectness() {

	}

	@Override
	public void testMulCorrectness() {

	}

	@Override
	public void testDivCorrectness() {

	}
}
package uk.ac.hud.jnvi.api;

import org.junit.rules.ErrorCollector;

import java.util.Random;

public class IntCorrectnessTest implements CorrectnessTest {
	private ErrorCollector collector;
	private Random random;

	public IntCorrectnessTest(ErrorCollector collector, Random random) {
		this.collector = collector;
		this.random = random;
	}

	private int getRandomInt() {
		return random.nextInt(10000);
	}

	private int getVectorSize() {
		return 4;
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
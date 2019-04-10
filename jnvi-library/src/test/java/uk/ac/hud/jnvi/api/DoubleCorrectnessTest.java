package uk.ac.hud.jnvi.api;

import org.junit.rules.ErrorCollector;
import uk.ac.hud.jnvi.memory.DirectDouble;

import java.util.Random;

import static org.hamcrest.core.IsEqual.equalTo;

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

	public void testAddCorrectness() {
		final double a0 = getRandomDouble();
		final double b0 = getRandomDouble();
		final double c0 = getRandomDouble();
		final double d0 = getRandomDouble();
		final double e0 = getRandomDouble();
		final double f0 = getRandomDouble();
		final double g0 = getRandomDouble();
		final double h0 = getRandomDouble();

		final DirectDouble vector0 = new DirectDouble(8);
		DirectDouble.set(vector0, a0, b0, c0, d0, e0, f0, g0, h0);

		final double a1 = getRandomDouble();
		final double b1 = getRandomDouble();
		final double c1 = getRandomDouble();
		final double d1 = getRandomDouble();
		final double e1 = getRandomDouble();
		final double f1 = getRandomDouble();
		final double g1 = getRandomDouble();
		final double h1 = getRandomDouble();

		final DirectDouble vector1 = new DirectDouble(8);
		DirectDouble.set(vector1, a1, b1, c1, d1, e1, f1, g1, h1);

		final DirectDouble resultVector = new DirectDouble(8);
		JNVIAPI.add(JNVIAPI.JNVI_DOUBLE_TYPE, vector0.getAddress(), vector1.getAddress(), resultVector.getAddress());

		collector.checkThat(a0 + " + " + a1 + " calculation should be correct.", a0 + a1, equalTo(resultVector.get(0)));
		collector.checkThat(b0 + " + " + b1 + " calculation should be correct.", b0 + b1, equalTo(resultVector.get(1)));
		collector.checkThat(c0 + " + " + c1 + " calculation should be correct.", c0 + c1, equalTo(resultVector.get(2)));
		collector.checkThat(d0 + " + " + d1 + " calculation should be correct.", d0 + d1, equalTo(resultVector.get(3)));
		collector.checkThat(e0 + " + " + e1 + " calculation should be correct.", e0 + e1, equalTo(resultVector.get(4)));
		collector.checkThat(f0 + " + " + f1 + " calculation should be correct.", f0 + f1, equalTo(resultVector.get(5)));
		collector.checkThat(g0 + " + " + g1 + " calculation should be correct.", g0 + g1, equalTo(resultVector.get(6)));
		collector.checkThat(h0 + " + " + h1 + " calculation should be correct.", h0 + h1, equalTo(resultVector.get(7)));

		vector0.destroy();
		vector1.destroy();
		resultVector.destroy();
	}

	public void testSubCorrectness() {
		final double a0 = getRandomDouble();
		final double b0 = getRandomDouble();
		final double c0 = getRandomDouble();
		final double d0 = getRandomDouble();
		final double e0 = getRandomDouble();
		final double f0 = getRandomDouble();
		final double g0 = getRandomDouble();
		final double h0 = getRandomDouble();

		final DirectDouble vector0 = new DirectDouble(8);
		DirectDouble.set(vector0, a0, b0, c0, d0, e0, f0, g0, h0);

		final double a1 = getRandomDouble();
		final double b1 = getRandomDouble();
		final double c1 = getRandomDouble();
		final double d1 = getRandomDouble();
		final double e1 = getRandomDouble();
		final double f1 = getRandomDouble();
		final double g1 = getRandomDouble();
		final double h1 = getRandomDouble();

		final DirectDouble vector1 = new DirectDouble(8);
		DirectDouble.set(vector1, a1, b1, c1, d1, e1, f1, g1, h1);

		final DirectDouble resultVector = new DirectDouble(8);
		JNVIAPI.sub(JNVIAPI.JNVI_DOUBLE_TYPE, vector0.getAddress(), vector1.getAddress(), resultVector.getAddress());

		collector.checkThat(a0 + " - " + a1 + " calculation should be correct.", a0 - a1, equalTo(resultVector.get(0)));
		collector.checkThat(b0 + " - " + b1 + " calculation should be correct.", b0 - b1, equalTo(resultVector.get(1)));
		collector.checkThat(c0 + " - " + c1 + " calculation should be correct.", c0 - c1, equalTo(resultVector.get(2)));
		collector.checkThat(d0 + " - " + d1 + " calculation should be correct.", d0 - d1, equalTo(resultVector.get(3)));
		collector.checkThat(e0 + " - " + e1 + " calculation should be correct.", e0 - e1, equalTo(resultVector.get(4)));
		collector.checkThat(f0 + " - " + f1 + " calculation should be correct.", f0 - f1, equalTo(resultVector.get(5)));
		collector.checkThat(g0 + " - " + g1 + " calculation should be correct.", g0 - g1, equalTo(resultVector.get(6)));
		collector.checkThat(h0 + " - " + h1 + " calculation should be correct.", h0 - h1, equalTo(resultVector.get(7)));

		vector0.destroy();
		vector1.destroy();
		resultVector.destroy();
	}

	public void testMulCorrectness() {
		final double a0 = getRandomDouble();
		final double b0 = getRandomDouble();
		final double c0 = getRandomDouble();
		final double d0 = getRandomDouble();
		final double e0 = getRandomDouble();
		final double f0 = getRandomDouble();
		final double g0 = getRandomDouble();
		final double h0 = getRandomDouble();

		final DirectDouble vector0 = new DirectDouble(8);
		DirectDouble.set(vector0, a0, b0, c0, d0, e0, f0, g0, h0);

		final double a1 = getRandomDouble();
		final double b1 = getRandomDouble();
		final double c1 = getRandomDouble();
		final double d1 = getRandomDouble();
		final double e1 = getRandomDouble();
		final double f1 = getRandomDouble();
		final double g1 = getRandomDouble();
		final double h1 = getRandomDouble();

		final DirectDouble vector1 = new DirectDouble(8);
		DirectDouble.set(vector1, a1, b1, c1, d1, e1, f1, g1, h1);

		final DirectDouble resultVector = new DirectDouble(8);
		JNVIAPI.mul(JNVIAPI.JNVI_DOUBLE_TYPE, vector0.getAddress(), vector1.getAddress(), resultVector.getAddress());

		collector.checkThat(a0 + " * " + a1 + " calculation should be correct.", a0 * a1, equalTo(resultVector.get(0)));
		collector.checkThat(b0 + " * " + b1 + " calculation should be correct.", b0 * b1, equalTo(resultVector.get(1)));
		collector.checkThat(c0 + " * " + c1 + " calculation should be correct.", c0 * c1, equalTo(resultVector.get(2)));
		collector.checkThat(d0 + " * " + d1 + " calculation should be correct.", d0 * d1, equalTo(resultVector.get(3)));
		collector.checkThat(e0 + " * " + e1 + " calculation should be correct.", e0 * e1, equalTo(resultVector.get(4)));
		collector.checkThat(f0 + " * " + f1 + " calculation should be correct.", f0 * f1, equalTo(resultVector.get(5)));
		collector.checkThat(g0 + " * " + g1 + " calculation should be correct.", g0 * g1, equalTo(resultVector.get(6)));
		collector.checkThat(h0 + " * " + h1 + " calculation should be correct.", h0 * h1, equalTo(resultVector.get(7)));

		vector0.destroy();
		vector1.destroy();
		resultVector.destroy();
	}

	public void testDivCorrectness() {
		final double a0 = getRandomDouble();
		final double b0 = getRandomDouble();
		final double c0 = getRandomDouble();
		final double d0 = getRandomDouble();
		final double e0 = getRandomDouble();
		final double f0 = getRandomDouble();
		final double g0 = getRandomDouble();
		final double h0 = getRandomDouble();

		final DirectDouble vector0 = new DirectDouble(8);
		DirectDouble.set(vector0, a0, b0, c0, d0, e0, f0, g0, h0);

		final double a1 = getRandomDouble();
		final double b1 = getRandomDouble();
		final double c1 = getRandomDouble();
		final double d1 = getRandomDouble();
		final double e1 = getRandomDouble();
		final double f1 = getRandomDouble();
		final double g1 = getRandomDouble();
		final double h1 = getRandomDouble();

		final DirectDouble vector1 = new DirectDouble(8);
		DirectDouble.set(vector1, a1, b1, c1, d1, e1, f1, g1, h1);

		final DirectDouble resultVector = new DirectDouble(8);
		JNVIAPI.div(JNVIAPI.JNVI_DOUBLE_TYPE, vector0.getAddress(), vector1.getAddress(), resultVector.getAddress());

		collector.checkThat(a0 + " / " + a1 + " calculation should be correct.", a0 / a1, equalTo(resultVector.get(0)));
		collector.checkThat(b0 + " / " + b1 + " calculation should be correct.", b0 / b1, equalTo(resultVector.get(1)));
		collector.checkThat(c0 + " / " + c1 + " calculation should be correct.", c0 / c1, equalTo(resultVector.get(2)));
		collector.checkThat(d0 + " / " + d1 + " calculation should be correct.", d0 / d1, equalTo(resultVector.get(3)));
		collector.checkThat(e0 + " / " + e1 + " calculation should be correct.", e0 / e1, equalTo(resultVector.get(4)));
		collector.checkThat(f0 + " / " + f1 + " calculation should be correct.", f0 / f1, equalTo(resultVector.get(5)));
		collector.checkThat(g0 + " / " + g1 + " calculation should be correct.", g0 / g1, equalTo(resultVector.get(6)));
		collector.checkThat(h0 + " / " + h1 + " calculation should be correct.", h0 / h1, equalTo(resultVector.get(7)));

		vector0.destroy();
		vector1.destroy();
		resultVector.destroy();
	}
}
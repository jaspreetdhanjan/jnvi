package uk.ac.hud.jnvi.api;

import org.junit.rules.ErrorCollector;
import uk.ac.hud.jnvi.memory.DirectFloat;

import java.util.Random;

import static org.hamcrest.core.IsEqual.equalTo;

public class FloatCorrectnessTest implements CorrectnessTest {
	private final ErrorCollector collector;
	private final Random random;

	public FloatCorrectnessTest(ErrorCollector collector, Random random) {
		this.collector = collector;
		this.random = random;
	}

	private float getRandomFloat() {
		return random.nextFloat() * random.nextInt(10000);
	}

	public void testAddCorrectness() {
		final float a0 = getRandomFloat();
		final float b0 = getRandomFloat();
		final float c0 = getRandomFloat();
		final float d0 = getRandomFloat();
		final float e0 = getRandomFloat();
		final float f0 = getRandomFloat();
		final float g0 = getRandomFloat();
		final float h0 = getRandomFloat();

		final DirectFloat vector0 = new DirectFloat(8);
		DirectFloat.set(vector0, a0, b0, c0, d0, e0, f0, g0, h0);

		final float a1 = getRandomFloat();
		final float b1 = getRandomFloat();
		final float c1 = getRandomFloat();
		final float d1 = getRandomFloat();
		final float e1 = getRandomFloat();
		final float f1 = getRandomFloat();
		final float g1 = getRandomFloat();
		final float h1 = getRandomFloat();

		final DirectFloat vector1 = new DirectFloat(8);
		DirectFloat.set(vector1, a1, b1, c1, d1, e1, f1, g1, h1);

		final DirectFloat resultVector = new DirectFloat(8);
		JNVIAPI.add(JNVIAPI.JNVI_FLOAT_TYPE, vector0.getAddress(), vector1.getAddress(), resultVector.getAddress());

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
		final float a0 = getRandomFloat();
		final float b0 = getRandomFloat();
		final float c0 = getRandomFloat();
		final float d0 = getRandomFloat();
		final float e0 = getRandomFloat();
		final float f0 = getRandomFloat();
		final float g0 = getRandomFloat();
		final float h0 = getRandomFloat();

		final DirectFloat vector0 = new DirectFloat(8);
		DirectFloat.set(vector0, a0, b0, c0, d0, e0, f0, g0, h0);

		final float a1 = getRandomFloat();
		final float b1 = getRandomFloat();
		final float c1 = getRandomFloat();
		final float d1 = getRandomFloat();
		final float e1 = getRandomFloat();
		final float f1 = getRandomFloat();
		final float g1 = getRandomFloat();
		final float h1 = getRandomFloat();

		final DirectFloat vector1 = new DirectFloat(8);
		DirectFloat.set(vector1, a1, b1, c1, d1, e1, f1, g1, h1);

		final DirectFloat resultVector = new DirectFloat(8);
		JNVIAPI.sub(JNVIAPI.JNVI_FLOAT_TYPE, vector0.getAddress(), vector1.getAddress(), resultVector.getAddress());

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
		final float a0 = getRandomFloat();
		final float b0 = getRandomFloat();
		final float c0 = getRandomFloat();
		final float d0 = getRandomFloat();
		final float e0 = getRandomFloat();
		final float f0 = getRandomFloat();
		final float g0 = getRandomFloat();
		final float h0 = getRandomFloat();

		final DirectFloat vector0 = new DirectFloat(8);
		DirectFloat.set(vector0, a0, b0, c0, d0, e0, f0, g0, h0);

		final float a1 = getRandomFloat();
		final float b1 = getRandomFloat();
		final float c1 = getRandomFloat();
		final float d1 = getRandomFloat();
		final float e1 = getRandomFloat();
		final float f1 = getRandomFloat();
		final float g1 = getRandomFloat();
		final float h1 = getRandomFloat();

		final DirectFloat vector1 = new DirectFloat(8);
		DirectFloat.set(vector1, a1, b1, c1, d1, e1, f1, g1, h1);

		final DirectFloat resultVector = new DirectFloat(8);
		JNVIAPI.mul(JNVIAPI.JNVI_FLOAT_TYPE, vector0.getAddress(), vector1.getAddress(), resultVector.getAddress());

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
		final float a0 = getRandomFloat();
		final float b0 = getRandomFloat();
		final float c0 = getRandomFloat();
		final float d0 = getRandomFloat();
		final float e0 = getRandomFloat();
		final float f0 = getRandomFloat();
		final float g0 = getRandomFloat();
		final float h0 = getRandomFloat();

		final DirectFloat vector0 = new DirectFloat(8);
		DirectFloat.set(vector0, a0, b0, c0, d0, e0, f0, g0, h0);

		final float a1 = getRandomFloat();
		final float b1 = getRandomFloat();
		final float c1 = getRandomFloat();
		final float d1 = getRandomFloat();
		final float e1 = getRandomFloat();
		final float f1 = getRandomFloat();
		final float g1 = getRandomFloat();
		final float h1 = getRandomFloat();

		final DirectFloat vector1 = new DirectFloat(8);
		DirectFloat.set(vector1, a1, b1, c1, d1, e1, f1, g1, h1);

		final DirectFloat resultVector = new DirectFloat(8);
		JNVIAPI.div(JNVIAPI.JNVI_FLOAT_TYPE, vector0.getAddress(), vector1.getAddress(), resultVector.getAddress());

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
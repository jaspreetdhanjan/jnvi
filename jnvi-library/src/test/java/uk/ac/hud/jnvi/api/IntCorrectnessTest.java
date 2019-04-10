package uk.ac.hud.jnvi.api;

import org.junit.rules.ErrorCollector;
import uk.ac.hud.jnvi.memory.DirectInt;

import java.util.Random;

import static org.hamcrest.core.IsEqual.equalTo;

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

	public void testAddCorrectness() {
		final int a0 = getRandomInt();
		final int b0 = getRandomInt();
		final int c0 = getRandomInt();
		final int d0 = getRandomInt();
		final int e0 = getRandomInt();
		final int f0 = getRandomInt();
		final int g0 = getRandomInt();
		final int h0 = getRandomInt();

		final DirectInt vector0 = new DirectInt(8);
		DirectInt.set(vector0, a0, b0, c0, d0, e0, f0, g0, h0);

		final int a1 = getRandomInt();
		final int b1 = getRandomInt();
		final int c1 = getRandomInt();
		final int d1 = getRandomInt();
		final int e1 = getRandomInt();
		final int f1 = getRandomInt();
		final int g1 = getRandomInt();
		final int h1 = getRandomInt();

		final DirectInt vector1 = new DirectInt(8);
		DirectInt.set(vector1, a1, b1, c1, d1, e1, f1, g1, h1);

		final DirectInt resultVector = new DirectInt(8);
		JNVIAPI.add(JNVIAPI.JNVI_INT_TYPE, vector0.getAddress(), vector1.getAddress(), resultVector.getAddress());

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
		final int a0 = getRandomInt();
		final int b0 = getRandomInt();
		final int c0 = getRandomInt();
		final int d0 = getRandomInt();
		final int e0 = getRandomInt();
		final int f0 = getRandomInt();
		final int g0 = getRandomInt();
		final int h0 = getRandomInt();

		final DirectInt vector0 = new DirectInt(8);
		DirectInt.set(vector0, a0, b0, c0, d0, e0, f0, g0, h0);

		final int a1 = getRandomInt();
		final int b1 = getRandomInt();
		final int c1 = getRandomInt();
		final int d1 = getRandomInt();
		final int e1 = getRandomInt();
		final int f1 = getRandomInt();
		final int g1 = getRandomInt();
		final int h1 = getRandomInt();

		final DirectInt vector1 = new DirectInt(8);
		DirectInt.set(vector1, a1, b1, c1, d1, e1, f1, g1, h1);

		final DirectInt resultVector = new DirectInt(8);
		JNVIAPI.sub(JNVIAPI.JNVI_INT_TYPE, vector0.getAddress(), vector1.getAddress(), resultVector.getAddress());

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
		final int a0 = getRandomInt();
		final int b0 = getRandomInt();
		final int c0 = getRandomInt();
		final int d0 = getRandomInt();
		final int e0 = getRandomInt();
		final int f0 = getRandomInt();
		final int g0 = getRandomInt();
		final int h0 = getRandomInt();

		final DirectInt vector0 = new DirectInt(8);
		DirectInt.set(vector0, a0, b0, c0, d0, e0, f0, g0, h0);

		final int a1 = getRandomInt();
		final int b1 = getRandomInt();
		final int c1 = getRandomInt();
		final int d1 = getRandomInt();
		final int e1 = getRandomInt();
		final int f1 = getRandomInt();
		final int g1 = getRandomInt();
		final int h1 = getRandomInt();

		final DirectInt vector1 = new DirectInt(8);
		DirectInt.set(vector1, a1, b1, c1, d1, e1, f1, g1, h1);

		final DirectInt resultVector = new DirectInt(8);
		JNVIAPI.mul(JNVIAPI.JNVI_INT_TYPE, vector0.getAddress(), vector1.getAddress(), resultVector.getAddress());

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
		final int a0 = getRandomInt();
		final int b0 = getRandomInt();
		final int c0 = getRandomInt();
		final int d0 = getRandomInt();
		final int e0 = getRandomInt();
		final int f0 = getRandomInt();
		final int g0 = getRandomInt();
		final int h0 = getRandomInt();

		final DirectInt vector0 = new DirectInt(8);
		DirectInt.set(vector0, a0, b0, c0, d0, e0, f0, g0, h0);

		final int a1 = getRandomInt();
		final int b1 = getRandomInt();
		final int c1 = getRandomInt();
		final int d1 = getRandomInt();
		final int e1 = getRandomInt();
		final int f1 = getRandomInt();
		final int g1 = getRandomInt();
		final int h1 = getRandomInt();

		final DirectInt vector1 = new DirectInt(8);
		DirectInt.set(vector1, a1, b1, c1, d1, e1, f1, g1, h1);

		final DirectInt resultVector = new DirectInt(8);
		JNVIAPI.div(JNVIAPI.JNVI_INT_TYPE, vector0.getAddress(), vector1.getAddress(), resultVector.getAddress());

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
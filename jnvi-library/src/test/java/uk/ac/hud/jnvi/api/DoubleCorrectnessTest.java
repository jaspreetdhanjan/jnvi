package uk.ac.hud.jnvi.api;

import org.junit.rules.ErrorCollector;
import uk.ac.hud.TestUtils;
import uk.ac.hud.jnvi.memory.DirectDouble;

import java.util.Random;

import static org.hamcrest.core.IsEqual.equalTo;

public class DoubleCorrectnessTest implements CorrectnessTest, TestRequirement {
	private final ErrorCollector collector;
	private final Random random;
	
	public DoubleCorrectnessTest(ErrorCollector collector, Random random) {
		this.collector = collector;
		this.random = random;
	}
	
	@Override
	public void testAddCorrectness() {
		double[] vectorData0 = TestUtils.getRandomDoubleArray(random, getVectorSize());
		double[] vectorData1 = TestUtils.getRandomDoubleArray(random, getVectorSize());
		
		DirectDouble vector0 = DirectDouble.allocateDirect(vectorData0);
		DirectDouble vector1 = DirectDouble.allocateDirect(vectorData1);
		
		DirectDouble resultVector = new DirectDouble(getVectorSize());
		
		JNVIAPI.add(JNVIAPI.TYPE_DOUBLE, vector0.getAddress(), vector1.getAddress(), resultVector.getAddress(), getVectorSize());
		
		for (int i = 0; i < getVectorSize(); i++) {
			final double actual = vectorData0[i] + vectorData1[i];
			
			collector.checkThat(vectorData0[i] + " + " + vectorData1[i] + " calculation should be correct.", resultVector.get(i), equalTo(actual));
		}
		
		vector0.destroy();
		vector1.destroy();
		resultVector.destroy();
	}
	
	@Override
	public void testSubCorrectness() {
		double[] vectorData0 = TestUtils.getRandomDoubleArray(random, getVectorSize());
		double[] vectorData1 = TestUtils.getRandomDoubleArray(random, getVectorSize());
		
		DirectDouble vector0 = DirectDouble.allocateDirect(vectorData0);
		DirectDouble vector1 = DirectDouble.allocateDirect(vectorData1);
		
		DirectDouble resultVector = new DirectDouble(getVectorSize());
		
		JNVIAPI.sub(JNVIAPI.TYPE_DOUBLE, vector0.getAddress(), vector1.getAddress(), resultVector.getAddress(), getVectorSize());
		
		for (int i = 0; i < getVectorSize(); i++) {
			final double actual = vectorData0[i] - vectorData1[i];
			
			collector.checkThat(vectorData0[i] + " - " + vectorData1[i] + " calculation should be correct.", resultVector.get(i), equalTo(actual));
		}
		
		vector0.destroy();
		vector1.destroy();
		resultVector.destroy();
	}
	
	@Override
	public void testMulCorrectness() {
		double[] vectorData0 = TestUtils.getRandomDoubleArray(random, getVectorSize());
		double[] vectorData1 = TestUtils.getRandomDoubleArray(random, getVectorSize());
		
		DirectDouble vector0 = DirectDouble.allocateDirect(vectorData0);
		DirectDouble vector1 = DirectDouble.allocateDirect(vectorData1);
		
		DirectDouble resultVector = new DirectDouble(getVectorSize());
		
		JNVIAPI.mul(JNVIAPI.TYPE_DOUBLE, vector0.getAddress(), vector1.getAddress(), resultVector.getAddress(), getVectorSize());
		
		for (int i = 0; i < getVectorSize(); i++) {
			final double actual = vectorData0[i] * vectorData1[i];
			
			collector.checkThat(vectorData0[i] + " * " + vectorData1[i] + " calculation should be correct.", resultVector.get(i), equalTo(actual));
		}
		
		vector0.destroy();
		vector1.destroy();
		resultVector.destroy();
	}
	
	@Override
	public void testDivCorrectness() {
		double[] vectorData0 = TestUtils.getRandomDoubleArray(random, getVectorSize());
		double[] vectorData1 = TestUtils.getRandomDoubleArray(random, getVectorSize());
		
		DirectDouble vector0 = DirectDouble.allocateDirect(vectorData0);
		DirectDouble vector1 = DirectDouble.allocateDirect(vectorData1);
		
		DirectDouble resultVector = new DirectDouble(getVectorSize());
		
		JNVIAPI.div(JNVIAPI.TYPE_DOUBLE, vector0.getAddress(), vector1.getAddress(), resultVector.getAddress(), getVectorSize());
		
		for (int i = 0; i < getVectorSize(); i++) {
			final double actual = vectorData0[i] / vectorData1[i];
			
			collector.checkThat(vectorData0[i] + " / " + vectorData1[i] + " calculation should be correct.", resultVector.get(i), equalTo(actual));
		}
		
		vector0.destroy();
		vector1.destroy();
		resultVector.destroy();
	}
	
	@Override
	public void testDotCorrectness() {
		double[] vectorData0 = TestUtils.getRandomDoubleArray(random, getVectorSize());
		double[] vectorData1 = TestUtils.getRandomDoubleArray(random, getVectorSize());
		
		DirectDouble vector0 = DirectDouble.allocateDirect(vectorData0);
		DirectDouble vector1 = DirectDouble.allocateDirect(vectorData1);
		
		DirectDouble result = new DirectDouble(1);
		
		JNVIAPI.dot(JNVIAPI.TYPE_DOUBLE, vector0.getAddress(), vector1.getAddress(), result.getAddress(), getVectorSize());
		
		double dot = 0;
		for (int i = 0; i < getVectorSize(); i++) {
			dot += (vectorData0[i] * vectorData1[i]);
		}
		
		collector.checkThat("Dot product values should match.", result.get(0), equalTo(dot));
		
		vector0.destroy();
		vector1.destroy();
		result.destroy();
	}
	
	@Override
	public void testSumCorrectness() {
		double[] data = TestUtils.getRandomDoubleArray(random, getVectorSize());
		
		DirectDouble vector = DirectDouble.allocateDirect(data);
		DirectDouble result = new DirectDouble(1);
		
		JNVIAPI.sum(JNVIAPI.TYPE_DOUBLE, vector.getAddress(), result.getAddress(), getVectorSize());
		
		double sum = 0;
		for (int i = 0; i < getVectorSize(); i++) {
			sum += data[i];
		}
		
		collector.checkThat("Sum value should match.", result.get(0), equalTo(sum));
		
		vector.destroy();
		result.destroy();
	}
	
	@Override
	public void testFurtherTypeSpecificCorrectness() {
		testSqrtCorrectness();
	}
	
	private void testSqrtCorrectness() {
		double[] vectorData = TestUtils.getRandomDoubleArray(random, getVectorSize());
		
		DirectDouble vector = DirectDouble.allocateDirect(vectorData);
		DirectDouble resultVector = new DirectDouble(getVectorSize());
		
		JNVIAPI.sqrt(JNVIAPI.TYPE_DOUBLE, vector.getAddress(), resultVector.getAddress(), getVectorSize());
		
		for (int i = 0; i < getVectorSize(); i++) {
			final double actual = Math.sqrt(vectorData[i]);
			
			collector.checkThat("sqrt(" + vectorData[i] + ") calculation should be correct.", resultVector.get(i), equalTo(actual));
		}
		
		vector.destroy();
		resultVector.destroy();
	}
}
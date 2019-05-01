package uk.ac.hud.jnvi.api;

import org.junit.rules.ErrorCollector;
import uk.ac.hud.TestUtils;
import uk.ac.hud.jnvi.memory.DirectInt;

import java.util.Random;

import static org.hamcrest.core.IsEqual.equalTo;

public class IntCorrectnessTest implements CorrectnessTest, TestRequirement {
	private ErrorCollector collector;
	private Random random;
	
	public IntCorrectnessTest(ErrorCollector collector, Random random) {
		this.collector = collector;
		this.random = random;
	}
	
	@Override
	public void testAddCorrectness() {
		int[] vectorData0 = TestUtils.getRandomIntArray(random, getVectorSize());
		int[] vectorData1 = TestUtils.getRandomIntArray(random, getVectorSize());
		
		DirectInt vector0 = DirectInt.allocateDirect(vectorData0);
		DirectInt vector1 = DirectInt.allocateDirect(vectorData1);
		
		DirectInt resultVector = new DirectInt(getVectorSize());
		
		JNVIAPI.add(JNVIAPI.TYPE_INT, vector0.getAddress(), vector1.getAddress(), resultVector.getAddress(), getVectorSize());
		
		for (int i = 0; i < getVectorSize(); i++) {
			final int actual = vectorData0[i] + vectorData1[i];
			
			collector.checkThat(vectorData0[i] + " + " + vectorData1[i] + " calculation should be correct.", resultVector.get(i), equalTo(actual));
		}
		
		vector0.destroy();
		vector1.destroy();
		resultVector.destroy();
	}
	
	@Override
	public void testSubCorrectness() {
		int[] vectorData0 = TestUtils.getRandomIntArray(random, getVectorSize());
		int[] vectorData1 = TestUtils.getRandomIntArray(random, getVectorSize());
		
		DirectInt vector0 = DirectInt.allocateDirect(vectorData0);
		DirectInt vector1 = DirectInt.allocateDirect(vectorData1);
		
		DirectInt resultVector = new DirectInt(getVectorSize());
		
		JNVIAPI.sub(JNVIAPI.TYPE_INT, vector0.getAddress(), vector1.getAddress(), resultVector.getAddress(), getVectorSize());
		
		for (int i = 0; i < getVectorSize(); i++) {
			final int actual = vectorData0[i] - vectorData1[i];
			
			collector.checkThat(vectorData0[i] + " - " + vectorData1[i] + " calculation should be correct.", resultVector.get(i), equalTo(actual));
		}
		
		vector0.destroy();
		vector1.destroy();
		resultVector.destroy();
	}
	
	@Override
	public void testMulCorrectness() {
		int[] vectorData0 = TestUtils.getRandomIntArray(random, getVectorSize());
		int[] vectorData1 = TestUtils.getRandomIntArray(random, getVectorSize());
		
		DirectInt vector0 = DirectInt.allocateDirect(vectorData0);
		DirectInt vector1 = DirectInt.allocateDirect(vectorData1);
		
		DirectInt resultVector = new DirectInt(getVectorSize());
		
		JNVIAPI.mul(JNVIAPI.TYPE_INT, vector0.getAddress(), vector1.getAddress(), resultVector.getAddress(), getVectorSize());
		
		for (int i = 0; i < getVectorSize(); i++) {
			final int actual = vectorData0[i] * vectorData1[i];
			
			collector.checkThat(vectorData0[i] + " * " + vectorData1[i] + " calculation should be correct.", resultVector.get(i), equalTo(actual));
		}
		
		vector0.destroy();
		vector1.destroy();
		resultVector.destroy();
	}
	
	@Override
	public void testDivCorrectness() {
		int[] vectorData0 = TestUtils.getRandomIntArray(random, getVectorSize());
		int[] vectorData1 = TestUtils.getRandomIntArray(random, getVectorSize());
		
		DirectInt vector0 = DirectInt.allocateDirect(vectorData0);
		DirectInt vector1 = DirectInt.allocateDirect(vectorData1);
		
		DirectInt resultVector = new DirectInt(getVectorSize());
		
		JNVIAPI.div(JNVIAPI.TYPE_INT, vector0.getAddress(), vector1.getAddress(), resultVector.getAddress(), getVectorSize());
		
		for (int i = 0; i < getVectorSize(); i++) {
			final int actual = vectorData0[i] / vectorData1[i];
			
			collector.checkThat(vectorData0[i] + " / " + vectorData1[i] + " calculation should be correct.", resultVector.get(i), equalTo(actual));
		}
		
		vector0.destroy();
		vector1.destroy();
		resultVector.destroy();
	}
	
	@Override
	public void testDotCorrectness() {
		int[] vectorData0 = TestUtils.getRandomIntArray(random, getVectorSize());
		int[] vectorData1 = TestUtils.getRandomIntArray(random, getVectorSize());
		
		DirectInt vector0 = DirectInt.allocateDirect(vectorData0);
		DirectInt vector1 = DirectInt.allocateDirect(vectorData1);
		
		DirectInt result = new DirectInt(1);
		
		JNVIAPI.dot(JNVIAPI.TYPE_INT, vector0.getAddress(), vector1.getAddress(), result.getAddress(), getVectorSize());
		
		int dot = 0;
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
		int[] data = TestUtils.getRandomIntArray(random, getVectorSize());
		
		DirectInt vector = DirectInt.allocateDirect(data);
		DirectInt result = new DirectInt(1);
		
		JNVIAPI.sum(JNVIAPI.TYPE_INT, vector.getAddress(), result.getAddress(), getVectorSize());
		
		int sum = 0;
		for (int i = 0; i < getVectorSize(); i++) {
			sum += data[i];
		}
		
		collector.checkThat("Sum value should match.", result.get(0), equalTo(sum));
		
		vector.destroy();
		result.destroy();
	}
}
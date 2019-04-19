package uk.ac.hud.jnvi.api;

import org.junit.rules.ErrorCollector;
import uk.ac.hud.TestUtils;
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
	
	private int getVectorSize() {
		return 8;
	}
	
	@Override
	public void testAddCorrectness() {
		float[] vectorData0 = TestUtils.getRandomFloatArray(random, getVectorSize());
		float[] vectorData1 = TestUtils.getRandomFloatArray(random, getVectorSize());
		
		DirectFloat vector0 = DirectFloat.allocateDirect(vectorData0);
		DirectFloat vector1 = DirectFloat.allocateDirect(vectorData1);
		
		DirectFloat resultVector = new DirectFloat(getVectorSize());
		
		JNVIAPI.add(JNVIAPI.TYPE_FLOAT, vector0.getAddress(), vector1.getAddress(), resultVector.getAddress(), getVectorSize());
		
		for (int i = 0; i < getVectorSize(); i++) {
			final float actual = vectorData0[i] + vectorData1[i];
			
			collector.checkThat(vectorData0[i] + " + " + vectorData1[i] + " calculation should be correct.", resultVector.get(i), equalTo(actual));
		}
		
		vector0.destroy();
		vector1.destroy();
		resultVector.destroy();
	}
	
	@Override
	public void testSubCorrectness() {
		float[] vectorData0 = TestUtils.getRandomFloatArray(random, getVectorSize());
		float[] vectorData1 = TestUtils.getRandomFloatArray(random, getVectorSize());
		
		DirectFloat vector0 = DirectFloat.allocateDirect(vectorData0);
		DirectFloat vector1 = DirectFloat.allocateDirect(vectorData1);
		
		DirectFloat resultVector = new DirectFloat(getVectorSize());
		
		JNVIAPI.sub(JNVIAPI.TYPE_FLOAT, vector0.getAddress(), vector1.getAddress(), resultVector.getAddress(), getVectorSize());
		
		for (int i = 0; i < getVectorSize(); i++) {
			final float actual = vectorData0[i] - vectorData1[i];
			
			collector.checkThat(vectorData0[i] + " - " + vectorData1[i] + " calculation should be correct.", resultVector.get(i), equalTo(actual));
		}
		
		vector0.destroy();
		vector1.destroy();
		resultVector.destroy();
	}
	
	@Override
	public void testMulCorrectness() {
		float[] vectorData0 = TestUtils.getRandomFloatArray(random, getVectorSize());
		float[] vectorData1 = TestUtils.getRandomFloatArray(random, getVectorSize());
		
		DirectFloat vector0 = DirectFloat.allocateDirect(vectorData0);
		DirectFloat vector1 = DirectFloat.allocateDirect(vectorData1);
		
		DirectFloat resultVector = new DirectFloat(getVectorSize());
		
		JNVIAPI.mul(JNVIAPI.TYPE_FLOAT, vector0.getAddress(), vector1.getAddress(), resultVector.getAddress(), getVectorSize());
		
		for (int i = 0; i < getVectorSize(); i++) {
			final float actual = vectorData0[i] * vectorData1[i];
			
			collector.checkThat(vectorData0[i] + " * " + vectorData1[i] + " calculation should be correct.", resultVector.get(i), equalTo(actual));
		}
		
		vector0.destroy();
		vector1.destroy();
		resultVector.destroy();
	}
	
	@Override
	public void testDivCorrectness() {
		float[] vectorData0 = TestUtils.getRandomFloatArray(random, getVectorSize());
		float[] vectorData1 = TestUtils.getRandomFloatArray(random, getVectorSize());
		
		DirectFloat vector0 = DirectFloat.allocateDirect(vectorData0);
		DirectFloat vector1 = DirectFloat.allocateDirect(vectorData1);
		
		DirectFloat resultVector = new DirectFloat(getVectorSize());
		
		JNVIAPI.div(JNVIAPI.TYPE_FLOAT, vector0.getAddress(), vector1.getAddress(), resultVector.getAddress(), getVectorSize());
		
		for (int i = 0; i < getVectorSize(); i++) {
			final float actual = vectorData0[i] / vectorData1[i];
			
			collector.checkThat(vectorData0[i] + " / " + vectorData1[i] + " calculation should be correct.", resultVector.get(i), equalTo(actual));
		}
		
		vector0.destroy();
		vector1.destroy();
		resultVector.destroy();
	}
	
	//	@Override
	public void testSqrtCorrectness() {
		float[] vectorData = TestUtils.getRandomFloatArray(random, getVectorSize());
		
		DirectFloat vector = DirectFloat.allocateDirect(vectorData);
		DirectFloat resultVector = new DirectFloat(getVectorSize());
		
		JNVIAPI.sqrt(JNVIAPI.TYPE_FLOAT, vector.getAddress(), resultVector.getAddress(), getVectorSize());
		
		for (int i = 0; i < getVectorSize(); i++) {
			final float actual = (float) Math.sqrt(vectorData[i]);
			
			collector.checkThat("sqrt(" + vectorData[i] + ") calculation should be correct.", resultVector.get(i), equalTo(actual));
		}
		
		vector.destroy();
		resultVector.destroy();
	}
	
	//	@Override
	public void testReciprocalSqrtCorrectness() {
		float[] vectorData = TestUtils.getRandomFloatArray(random, getVectorSize());
		
		DirectFloat vector = DirectFloat.allocateDirect(vectorData);
		DirectFloat resultVector = new DirectFloat(getVectorSize());
		
		JNVIAPI.rsqrt(vector.getAddress(), resultVector.getAddress(), getVectorSize());
		
		for (int i = 0; i < getVectorSize(); i++) {
			final float actual = (float) (1.0 / Math.sqrt(vectorData[i]));
			
			collector.checkThat("sqrt(" + vectorData[i] + ") calculation should be correct.", resultVector.get(i), equalTo(actual));
		}
		
		vector.destroy();
		resultVector.destroy();
	}

}
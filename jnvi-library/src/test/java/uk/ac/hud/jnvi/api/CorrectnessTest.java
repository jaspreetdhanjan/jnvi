package uk.ac.hud.jnvi.api;

public interface CorrectnessTest {
	// Java does not allow static interfaces so we essentially replicate the functionality in JNVIAPI here to secure
	// the test contract.
	
	void testAddCorrectness();

	void testSubCorrectness();

	void testMulCorrectness();
	
	void testDivCorrectness();
	
	void testDotCorrectness();
	
	void testSumCorrectness();
	
	default void testFurtherTypeSpecificCorrectness() {
	}
}
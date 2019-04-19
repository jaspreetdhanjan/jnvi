package uk.ac.hud.jnvi.benchmark;

import org.openjdk.jmh.annotations.*;


@State(Scope.Thread)
public class LinearBenchmark implements BenchmarkRequirement {
	private float[] vectorA;
	private float[] vectorB;
	private float[] result;
	
	@Setup
	public void setup() {
		vectorA = getRandomFloatArray();
		vectorB = getRandomFloatArray();
		result = new float[getVectorLength()];
	}
	
	@TearDown
	public void tearDown() {
		vectorA = null;
		vectorB = null;
		result = null;
	}
	
	
	@Benchmark
	@Fork(value = 1, warmups = 0)
	@BenchmarkMode(Mode.Throughput)
	public void multiplyVectors() {
		for (int i = 0; i < getVectorLength(); i++) {
			result[i] = vectorA[i] * vectorB[i];
		}
	}
	
	@Benchmark
	@Fork(value = 1, warmups = 0)
	@BenchmarkMode(Mode.Throughput)
	public void divideVectors() {
		for (int i = 0; i < getVectorLength(); i++) {
			result[i] = vectorA[i] / vectorB[i];
		}
	}
	
	@Benchmark
	@Fork(value = 1, warmups = 0)
	@BenchmarkMode(Mode.Throughput)
	public void rSqrtVectors() {
		for (int i = 0; i < getVectorLength(); i++) {
			result[i] = (float) (1.0 / Math.sqrt(vectorA[i]));
		}
	}
	
	@Benchmark
	@Fork(value = 1, warmups = 0)
	@BenchmarkMode(Mode.Throughput)
	public void sqrtVectors() {
		for (int i = 0; i < getVectorLength(); i++) {
			result[i] = (float) Math.sqrt(vectorA[i]);
		}
	}
}
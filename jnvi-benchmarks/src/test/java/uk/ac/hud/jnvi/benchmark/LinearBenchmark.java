package uk.ac.hud.jnvi.benchmark;

import org.openjdk.jmh.annotations.*;

@State(Scope.Benchmark)
public class LinearBenchmark implements BenchmarkRequirement, BenchmarkOperation {
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
//	@Fork(value = 10, warmups = 10, jvmArgsAppend = "-XX:+UseSuperWord")
	@Fork(value = 10, warmups = 10)
	@BenchmarkMode(Mode.Throughput)
	public void addVectors() {
		for (int i = 0; i < getVectorLength(); i++) {
			result[i] = vectorA[i] + vectorB[i];
		}
	}
	
	@Benchmark
	@Fork(value = 10, warmups = 10)
	@BenchmarkMode(Mode.Throughput)
	public void subtractVectors() {
		for (int i = 0; i < getVectorLength(); i++) {
			result[i] = vectorA[i] - vectorB[i];
		}
	}
	
	@Benchmark
	@Fork(value = 10, warmups = 10)
	@BenchmarkMode(Mode.Throughput)
	public void multiplyVectors() {
		for (int i = 0; i < getVectorLength(); i++) {
			result[i] = vectorA[i] * vectorB[i];
		}
	}
	
	@Benchmark
	@Fork(value = 10, warmups = 10)
	@BenchmarkMode(Mode.Throughput)
	public void divideVectors() {
		for (int i = 0; i < getVectorLength(); i++) {
			result[i] = vectorA[i] / vectorB[i];
		}
	}
	
	@Benchmark
	@Fork(value = 10, warmups = 10)
	@BenchmarkMode(Mode.Throughput)
	public void vectorDot() {
		for (int i = 0; i < getVectorLength(); i++) {
			result[i] += vectorA[i] * vectorB[i];
		}
	}
	
	@Benchmark
	@Fork(value = 10, warmups = 10)
	@BenchmarkMode(Mode.Throughput)
	public void vectorSum() {
		int sum = 0;
		for (int i = 0; i < getVectorLength(); i++) {
			sum += vectorA[i];
		}
		result[0] = sum;
	}
	
	@Benchmark
	@Fork(value = 10, warmups = 10)
	@BenchmarkMode(Mode.Throughput)
	public void rSqrtVectors() {
		for (int i = 0; i < 4; i++) {
			result[i] = (float) (1.0 / Math.sqrt(vectorA[i]));
		}
	}
	
	@Benchmark
	@Fork(value = 10, warmups = 10)
	@BenchmarkMode(Mode.Throughput)
	public void sqrtVectors() {
		for (int i = 0; i < 4; i++) {
			result[i] = (float) Math.sqrt(vectorA[i]);
		}
	}
}
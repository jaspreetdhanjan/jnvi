package uk.ac.hud.jnvi.benchmark;

import org.openjdk.jmh.annotations.*;
import uk.ac.hud.jnvi.SharedLibrary;
import uk.ac.hud.jnvi.api.JNVIAPI;
import uk.ac.hud.jnvi.memory.DirectFloat;

@State(Scope.Benchmark)
public class JNVIBenchmark implements BenchmarkRequirement, BenchmarkOperation {
	private DirectFloat vectorA;
	private DirectFloat vectorB;
	private DirectFloat result;
	
	private long addressVectorA;
	private long addressVectorB;
	private long addressResult;
	
	@Setup
	public void setup() {
		System.setProperty(SharedLibrary.JNVI_LIBRARY_DIRECTORY_PROPERTY, "src/test/resources/natives/");
		SharedLibrary.load();
		
		vectorA = DirectFloat.allocateDirect(getRandomFloatArray());
		vectorB = DirectFloat.allocateDirect(getRandomFloatArray());
		result = new DirectFloat(getVectorLength());
		
		addressVectorA = vectorA.getAddress();
		addressVectorB = vectorB.getAddress();
		addressResult = result.getAddress();
	}
	
	@TearDown
	public void tearDown() {
		vectorA.destroy();
		vectorB.destroy();
		result.destroy();
	}
	
	@Benchmark
	@Fork(value = 10, warmups = 10)
	@BenchmarkMode(Mode.Throughput)
	public void addVectors() {
		JNVIAPI.add(JNVIAPI.TYPE_FLOAT, addressVectorA, addressVectorB, addressResult, getVectorLength());
	}
	
	@Benchmark
	@Fork(value = 10, warmups = 10)
	@BenchmarkMode(Mode.Throughput)
	public void subtractVectors() {
		JNVIAPI.sub(JNVIAPI.TYPE_FLOAT, addressVectorA, addressVectorB, addressResult, getVectorLength());
	}
	
	@Benchmark
	@Fork(value = 10, warmups = 10)
	@BenchmarkMode(Mode.Throughput)
	public void multiplyVectors() {
		JNVIAPI.mul(JNVIAPI.TYPE_FLOAT, addressVectorA, addressVectorB, addressResult, getVectorLength());
	}
	
	@Benchmark
	@Fork(value = 10, warmups = 10)
	@BenchmarkMode(Mode.Throughput)
	public void divideVectors() {
		JNVIAPI.div(JNVIAPI.TYPE_FLOAT, addressVectorA, addressVectorB, addressResult, getVectorLength());
	}
	
	@Benchmark
	@Fork(value = 10, warmups = 10)
	@BenchmarkMode(Mode.Throughput)
	public void vectorSum() {
		JNVIAPI.sum(JNVIAPI.TYPE_FLOAT, addressVectorA, addressResult, getVectorLength());
	}
	
	@Benchmark
	@Fork(value = 10, warmups = 10)
	@BenchmarkMode(Mode.Throughput)
	public void vectorDot() {
		JNVIAPI.div(JNVIAPI.TYPE_FLOAT, addressVectorA, addressVectorB, addressResult, getVectorLength());
	}
	
	@Benchmark
	@Fork(value = 10, warmups = 10)
	@BenchmarkMode(Mode.Throughput)
	public void rSqrtVectors() {
		JNVIAPI.rsqrt(addressVectorA, addressResult, 4);
	}
	
	@Benchmark
	@Fork(value = 10, warmups = 10)
	@BenchmarkMode(Mode.Throughput)
	public void sqrtVectors() {
		JNVIAPI.sqrt(JNVIAPI.TYPE_FLOAT, addressVectorB, addressResult, 4);
	}
}
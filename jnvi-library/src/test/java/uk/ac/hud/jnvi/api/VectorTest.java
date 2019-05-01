package uk.ac.hud.jnvi.api;

import uk.ac.hud.jnvi.memory.DirectDouble;

public class VectorTest {
	public interface Vector {
		Vector multiply(Vector other);
		
		double getX();
		
		double getY();
		
		double getZ();
	}
	
	public final class SlowVector implements Vector {
		private final double x, y, z;
		
		public SlowVector(double x, double y, double z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
		
		@Override
		public Vector multiply(Vector other) {
			double newX = x * other.getX();
			double newY = y * other.getY();
			double newZ = z * other.getZ();
			
			return new SlowVector(newX, newY, newZ);
		}
		
		@Override
		public double getX() {
			return x;
		}
		
		@Override
		public double getY() {
			return y;
		}
		
		@Override
		public double getZ() {
			return z;
		}
	}
	
	public final class FastVector implements Vector {
		private final double x, y, z;
		
		public FastVector(double x, double y, double z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
		
		@Override
		public Vector multiply(Vector other) {
			// Copy data off-heap
			DirectDouble vectorA = DirectDouble.allocateDirect(x, y, z);
			DirectDouble vectorB = DirectDouble.allocateDirect(other.getX(), other.getY(), other.getZ());
			
			DirectDouble result = new DirectDouble(3);
			
			// Multiply x, y, z in parallel
			JNVIAPI.mul(JNVIAPI.TYPE_DOUBLE, vectorA.getAddress(), vectorB.getAddress(), result.getAddress(), 3);
			
			return new SlowVector(result.get(0), result.get(1), result.get(2));
		}
		
		@Override
		public double getX() {
			return x;
		}
		
		@Override
		public double getY() {
			return y;
		}
		
		@Override
		public double getZ() {
			return z;
		}
	}
}
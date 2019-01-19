package uk.ac.hud.jnvi;

import uk.ac.hud.jnvi.api.JNVIAPI;
import uk.ac.hud.jnvi.memory.DirectFloat;

import java.util.Objects;

/**
 * Provides the developer with a useful class to perform mathematical operations on vectorised arrays.
 *
 * @author Jaspreet Dhanjan
 * @date 27/12/2018
 */

public class VectorTools implements Tools {
	@Override
	public void multiply(DirectFloat a, DirectFloat b, DirectFloat c) {
		Objects.requireNonNull(a);
		Objects.requireNonNull(b);
		Objects.requireNonNull(c);

		final long aLen = a.getSizeInBytes();
		final long bLen = b.getSizeInBytes();
		final long cLen = c.getSizeInBytes();
		if (aLen != bLen || bLen != cLen) {
			throw new IllegalArgumentException("Vectors a and b must be of equal length to maintain alignment!");
		}

		JNVIAPI.nativeMultiply(a.getAddress(), b.getAddress(), c.getAddress(), aLen);
	}
}
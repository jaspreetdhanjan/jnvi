package uk.ac.hud.jnvi;

import uk.ac.hud.jnvi.memory.DirectFloat;

/**
 * The Tools interface defines a helper contract specifically defined for developers who wish to utilise the
 * benefits of Single Instruction, Multiple Data (SIMD) intrinsics in their code.
 *
 * @author Jaspreet Dhanjan
 * @date 27/12/2018
 */

public interface Tools {
	/**
	 * Multiplies the vector a by the vector b and places the result within the vector c.
	 */
	void multiply(DirectFloat a, DirectFloat b, DirectFloat c);
}
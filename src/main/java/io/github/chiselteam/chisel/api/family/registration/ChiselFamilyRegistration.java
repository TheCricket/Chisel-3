package io.github.chiselteam.chisel.api.family.registration;

import net.minecraft.resources.Identifier;
import org.jetbrains.annotations.ApiStatus;

/**
 * A read-only handle for a queued addon family registration.
 */
@ApiStatus.Experimental
public record ChiselFamilyRegistration(Identifier familyId) {
}

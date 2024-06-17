package com.github.L_Ender.lionfishapi.server.event;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.neoforge.event.entity.living.LivingEvent;


public class StandOnFluidEvent extends LivingEvent implements ICancellableEvent {
    private final FluidState fluid;

    public StandOnFluidEvent(LivingEntity entity, FluidState fluid) {
        super(entity);
        this.fluid = fluid;
    }

    public FluidState getFluidState() {
        return fluid;
    }

}
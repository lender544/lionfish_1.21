package com.github.L_Ender.lionfishapi.client.event;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.stats.Stats;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.Event;
import net.neoforged.neoforge.event.entity.player.PlayerSpawnPhantomsEvent;


@OnlyIn(Dist.CLIENT)
public class EventGetFluidRenderType extends Event {
    private FluidState fluidState;
    private RenderType renderType;
    private Result result = Result.DEFAULT;

    public EventGetFluidRenderType(FluidState fluidState, RenderType renderType) {
        this.fluidState = fluidState;
        this.renderType = renderType;
    }

    public FluidState getFluidState() {
        return fluidState;
    }

    public RenderType getRenderType() {
        return renderType;
    }

    public void setRenderType(RenderType renderType) {
        this.renderType = renderType;
    }


    public void setResult(Result result) {
        this.result = result;
    }
    public Result getResult() {
        return result;
    }

    public static enum Result {
        /**
         * A spawn attempt will always be made, bypassing all rules described in {@link #DEFAULT}.
         */
        ALLOW,

        /**
         * A spawn attempt will only be made if the dimension does not have skylight
         * <b>or</b> the player's Y-level is above sea level and they can see the sky.
         * <p>
         * Additionally, the local difficulty must be higher than a random threshold in [0, 3)
         * and a random number check based on the player's {@link Stats#TIME_SINCE_REST} must succeed.
         */
        DEFAULT,

        /**
         * A spawn attempt will never be made.
         */
        DENY;
    }
}

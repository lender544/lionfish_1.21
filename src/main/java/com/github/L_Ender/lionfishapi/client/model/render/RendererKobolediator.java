package com.github.L_Ender.lionfishapi.client.model.render;


import com.github.L_Ender.lionfishapi.LionfishAPI;
import com.github.L_Ender.lionfishapi.server.entity.Kobolediator_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RendererKobolediator extends MobRenderer<Kobolediator_Entity, ModelKobolediator> {

    private static final ResourceLocation KOBOLEDIATOR_TEXTURES = LionfishAPI.getModelTexture("cubeofannihilation.png");


    public RendererKobolediator(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new ModelKobolediator(), 1.25F);

    }
    @Override
    public ResourceLocation getTextureLocation(Kobolediator_Entity entity) {
        return KOBOLEDIATOR_TEXTURES;
    }

    @Override
    protected float getFlipDegrees(Kobolediator_Entity entity) {
        return 0;
    }

    @Override
    protected void scale(Kobolediator_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.0F, 1.0F, 1.0F);
    }
}


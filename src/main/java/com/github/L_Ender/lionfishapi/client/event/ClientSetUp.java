package com.github.L_Ender.lionfishapi.client.event;

import com.github.L_Ender.lionfishapi.LionfishAPI;
import com.github.L_Ender.lionfishapi.client.model.render.RendererKobolediator;
import com.github.L_Ender.lionfishapi.client.screen.OptifineWarningScreen;
import com.github.L_Ender.lionfishapi.server.entity.ModEntities;
import com.ibm.icu.text.RuleBasedNumberFormat;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.SplashRenderer;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.server.packs.resources.ReloadableResourceManager;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.ScreenEvent;

import java.time.LocalDate;
import java.time.Month;
import java.util.Locale;

@OnlyIn(Dist.CLIENT)
@EventBusSubscriber(modid = LionfishAPI.MODID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class ClientSetUp {

    public static boolean optifinePresent = false;


    @EventBusSubscriber(value = Dist.CLIENT, bus = EventBusSubscriber.Bus.GAME, modid = LionfishAPI.MODID)
    public static class ForgeEvents {
        private static boolean firstTitleScreenShown = false;

        @SubscribeEvent
        public static void showOptifineWarning(ScreenEvent.Init.Post event) {
            if (firstTitleScreenShown || !(event.getScreen() instanceof TitleScreen)) return;

            if (optifinePresent) {
                Minecraft.getInstance().setScreen(new OptifineWarningScreen(event.getScreen()));
            }

            firstTitleScreenShown = true;
        }
    }

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent evt) {
        try {
            Class.forName("net.optifine.Config");
            optifinePresent = true;
        } catch (ClassNotFoundException e) {
            optifinePresent = false;
        }
    }


    @SubscribeEvent
    public static void registerEntityRenders(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.KOBOLEDIATOR.get(), RendererKobolediator::new);
    }

}

package com.github.L_Ender.lionfishapi.server.entity;


import com.github.L_Ender.lionfishapi.LionfishAPI;
import com.google.common.base.Predicates;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.*;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Predicate;

@EventBusSubscriber(modid = LionfishAPI.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPE = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, LionfishAPI.MODID);

    public static final DeferredHolder<EntityType<?>,EntityType<Kobolediator_Entity>> KOBOLEDIATOR = ENTITY_TYPE.register("kobolediator", () -> EntityType.Builder.of(Kobolediator_Entity::new, MobCategory.MONSTER)
            .sized(2.4F, 4.4f)
            .clientTrackingRange(8)
            .build(LionfishAPI.MODID + ":kobolediator"));


    public static Predicate<LivingEntity> buildPredicateFromTag(TagKey<EntityType<?>> entityTag){
        if(entityTag == null){
            return Predicates.alwaysFalse();
        }else{
            return (com.google.common.base.Predicate<LivingEntity>) e -> e.isAlive() && e.getType().is(entityTag);
        }
    }

    public static boolean rollSpawn(int rolls, RandomSource random, MobSpawnType reason){
        if(reason == MobSpawnType.SPAWNER){
            return true;
        }else{
            return rolls <= 0 || random.nextInt(rolls) == 0;
        }
    }
    @SubscribeEvent
    public static void initializeAttributes(EntityAttributeCreationEvent event) {
        event.put(KOBOLEDIATOR.get(), Kobolediator_Entity.kobolediator().build());
    }
}


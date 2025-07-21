package org.akazukin.template.compat.neoforge.common;

import lombok.extern.slf4j.Slf4j;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.akazukin.template.TemplateMod;
import org.akazukin.template.api.ITemplateMod;

@Slf4j
@Mod(value = "template", dist = Dist.CLIENT)
public final class NeoForgeTemplateMod implements ITemplateMod {
    public NeoForgeTemplateMod(final IEventBus eventBus, final ModContainer modContainer) {
        eventBus.addListener(this::onInitialize);
    }

    public void onInitialize(final FMLCommonSetupEvent event) {
        log.info(TemplateMod.MOD_NAME + " initializing...");

        log.info(TemplateMod.MOD_NAME + " initialized");
    }

    @EventBusSubscriber(Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(final FMLClientSetupEvent event) {
        }
    }
}

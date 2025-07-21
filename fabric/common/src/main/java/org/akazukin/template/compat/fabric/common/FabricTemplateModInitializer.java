package org.akazukin.template.compat.fabric.common;

import lombok.extern.slf4j.Slf4j;
import net.fabricmc.api.ModInitializer;
import org.akazukin.template.TemplateMod;

@Slf4j
public final class FabricTemplateModInitializer implements ModInitializer {
    public FabricTemplateModInitializer() {
        log.info(TemplateMod.MOD_NAME + " is being constructed");
    }

    @Override
    public void onInitialize() {
        log.info(TemplateMod.MOD_NAME + " initializing...");

        if (((IFabricTemplateMod) TemplateMod.getInstance()).getCompat() == null) {
            throw new UnsupportedOperationException("The version is not supported by " + TemplateMod.MOD_NAME);
        } else {
            log.debug("The version is supported by " + TemplateMod.MOD_NAME);
        }

        log.info("Successfully " + TemplateMod.MOD_NAME + " initialized");
    }
}

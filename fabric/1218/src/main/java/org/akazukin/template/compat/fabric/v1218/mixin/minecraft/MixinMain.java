package org.akazukin.template.compat.fabric.v1218.mixin.minecraft;

import net.minecraft.MinecraftVersion;
import net.minecraft.client.main.Main;
import org.akazukin.template.TemplateMod;
import org.akazukin.template.compat.fabric.common.ICompatFabric;
import org.akazukin.template.compat.fabric.common.IFabricTemplateMod;
import org.akazukin.template.compat.fabric.v1218.CompatFabric1218;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(value = Main.class, remap = false)
public class MixinMain {
    @Inject(method = "main", at = @At(value = "INVOKE", target = "Ljoptsimple/OptionParser;<init>()V"))
    private static void main(final String[] args, final CallbackInfo ci) {
        final ICompatFabric compat = new CompatFabric1218();
        if (Objects.equals(MinecraftVersion.CURRENT.name(), compat.getVersion())) {
            compat.init();
            ((IFabricTemplateMod) TemplateMod.getInstance()).setCompat(compat);
        }
    }
}

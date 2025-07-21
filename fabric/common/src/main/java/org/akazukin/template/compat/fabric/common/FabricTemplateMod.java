package org.akazukin.template.compat.fabric.common;

import lombok.Getter;
import lombok.Setter;
import org.akazukin.template.api.ITemplateMod;

public class FabricTemplateMod implements ITemplateMod, IFabricTemplateMod {
    @Setter
    @Getter
    ICompatFabric compat;

    public FabricTemplateMod() {
    }
}

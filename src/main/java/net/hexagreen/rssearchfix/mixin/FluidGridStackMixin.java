package net.hexagreen.rssearchfix.mixin;

import net.hexagreen.rssearchfix.interfaces.IGridStackExtension;
import com.refinedmods.refinedstorage.screen.grid.stack.FluidGridStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value = FluidGridStack.class, remap = false)
public abstract class FluidGridStackMixin implements IGridStackExtension {

    @Final
    @Shadow
    private FluidStack stack;

    @Override
    @Unique
    public String rssearchfix$getItemId() {
        try {
            Fluid fluid = stack.getFluid();
            ResourceLocation key = ForgeRegistries.FLUIDS.getKey(fluid);
            return key != null ? key.toString() : "";
        } catch (Exception e) {
            return "";
        }
    }
}

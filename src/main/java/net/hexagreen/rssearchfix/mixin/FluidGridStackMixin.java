package net.hexagreen.rssearchfix.mixin;

import net.hexagreen.rssearchfix.EnglishContents;
import net.hexagreen.rssearchfix.interfaces.IGridStackExtension;
import com.refinedmods.refinedstorage.screen.grid.stack.FluidGridStack;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.contents.TranslatableContents;
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

    @Shadow
    private String cachedName;

    @Override
    @Unique
    public String rssearchfix$getItemId() {
        try {
            Fluid fluid = stack.getFluid();
            ResourceLocation key = ForgeRegistries.FLUIDS.getKey(fluid);
            if(key != null) cachedName += key.getPath();
            return cachedName;
        }
        catch (Exception e) {
            return cachedName;
        }
    }

    @Override
    @Unique
    public String rssearchfix$getEnName() {
        try {
            cachedName += MutableComponent.create(new EnglishContents(stack.getTranslationKey(), null, TranslatableContents.NO_ARGS)).getString();
            return cachedName;
        }
        catch (Exception e) {
            return cachedName;
        }
    }
}

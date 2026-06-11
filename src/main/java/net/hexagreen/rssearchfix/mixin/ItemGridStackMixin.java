package net.hexagreen.rssearchfix.mixin;

import net.hexagreen.rssearchfix.interfaces.IGridStackExtension;
import com.refinedmods.refinedstorage.screen.grid.stack.ItemGridStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value = ItemGridStack.class, remap = false)
public abstract class ItemGridStackMixin implements IGridStackExtension {

    @Final
    @Shadow
    private ItemStack stack;

    @Override
    @Unique
    public String rssearchfix$getItemId() {
        try {
            ResourceLocation key = ForgeRegistries.ITEMS.getKey(stack.getItem());
            return key != null ? key.toString() : "";
        } catch (Exception e) {
            return "";
        }
    }
}

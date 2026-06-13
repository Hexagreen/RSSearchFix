package net.hexagreen.rssearchfix.mixin;

import net.hexagreen.rssearchfix.EnglishContents;
import net.hexagreen.rssearchfix.interfaces.IGridStackExtension;
import com.refinedmods.refinedstorage.screen.grid.stack.ItemGridStack;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value = ItemGridStack.class, remap = false)
public abstract class ItemGridStackMixin implements IGridStackExtension {
    @Final
    @Shadow
    private ItemStack stack;

    @Shadow
    private String cachedName;

    @Override
    @Unique
    public String rssearchfix$getItemId() {
        try {
            cachedName += stack.getItem().toString();
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
            cachedName += MutableComponent.create(new EnglishContents(stack.getDescriptionId(), null, TranslatableContents.NO_ARGS)).getString();
            return cachedName;
        }
        catch (Exception e) {
            return cachedName;
        }
    }
}

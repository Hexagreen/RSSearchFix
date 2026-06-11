package net.hexagreen.rssearchfix.mixin;

import net.hexagreen.rssearchfix.interfaces.IGridStackExtension;
import com.refinedmods.refinedstorage.screen.grid.stack.IGridStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(
    value = com.refinedmods.refinedstorage.screen.grid.filtering.NameGridFilter.class,
    remap = false
)
public abstract class NameGridFilterMixin {

    @Final
    @Shadow
    private String name;

    @Inject(
        method = "test(Lcom/refinedmods/refinedstorage/screen/grid/stack/IGridStack;)Z",
        at = @At("RETURN"),
        cancellable = true,
        remap = false
    )
    private void extendTestWithItemId(IGridStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (cir.getReturnValue()) {
            return;
        }

        if (stack instanceof IGridStackExtension ext) {
            String itemId = ext.rssearchfix$getItemId();
            if (itemId != null && itemId.toLowerCase().contains(name)) {
                cir.setReturnValue(true);
            }
        }
    }
}

package net.hexagreen.rssearchfix.mixin;

import com.refinedmods.refinedstorage.screen.grid.filtering.GridFilterParser;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = GridFilterParser.class, remap = false)
public abstract class GridFilterParserMixin {

    @Redirect(
        method = "getFilters(Ljava/lang/String;)Ljava/util/List;",
        at = @At(
            value = "INVOKE",
            target = "Ljava/lang/String;startsWith(Ljava/lang/String;)Z",
            ordinal = 1
        ),
        remap = false
    )
    private static boolean redirectHashCheck(String part, String prefix) {
        return part.startsWith("$");
    }

    @Redirect(
        method = "getFilters(Ljava/lang/String;)Ljava/util/List;",
        at = @At(
            value = "INVOKE",
            target = "Ljava/lang/String;startsWith(Ljava/lang/String;)Z",
            ordinal = 2
        ),
        remap = false
    )
    private static boolean redirectDollarCheck(String part, String prefix) {
        return part.startsWith("#");
    }
}

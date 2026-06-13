package net.hexagreen.rssearchfix.mixin;

import net.hexagreen.rssearchfix.EnglishContents;
import net.hexagreen.rssearchfix.RSSearchFix;
import net.minecraft.locale.Language;
import net.minecraft.network.chat.contents.TranslatableContents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(TranslatableContents.class)
public abstract class TranslatableContentsMixin {

    @Redirect(method = "decompose", at = @At(value = "INVOKE", target = "Lnet/minecraft/locale/Language;getInstance()Lnet/minecraft/locale/Language;"))
    private Language setLanguage() {
        if((Object) this instanceof EnglishContents) {
            if(RSSearchFix.EN_LANG != null) return RSSearchFix.EN_LANG;
        }
        return Language.getInstance();
    }
}

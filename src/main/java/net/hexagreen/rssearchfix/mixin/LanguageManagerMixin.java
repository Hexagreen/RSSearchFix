package net.hexagreen.rssearchfix.mixin;

import net.hexagreen.rssearchfix.RSSearchFix;
import net.minecraft.client.resources.language.ClientLanguage;
import net.minecraft.client.resources.language.LanguageManager;
import net.minecraft.server.packs.resources.ResourceManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(LanguageManager.class)
public abstract class LanguageManagerMixin {
    @Inject(method = "onResourceManagerReload", at = @At("RETURN"))
    public void updateEnglishResources(ResourceManager p_118973_, CallbackInfo ci) {
        RSSearchFix.EN_LANG = ClientLanguage.loadFrom(p_118973_, List.of("en_us"), false);
    }
}

package net.hexagreen.rssearchfix;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(RSSearchFix.MOD_ID)
public class RSSearchFix {

    public static final String MOD_ID = "rssearchfix";
    private static final Logger LOGGER = LogManager.getLogger(RSSearchFix.class);

    public RSSearchFix() {
        LOGGER.info("[RSSearchFix] Loaded. Refined Storage Grid search behavior has been modified.");
        LOGGER.info("[RSSearchFix] '#' → Tag Search, '$' → Tooltip Search (swapped from original)");
        LOGGER.info("[RSSearchFix] You can now also searches by item ID.");
    }
}

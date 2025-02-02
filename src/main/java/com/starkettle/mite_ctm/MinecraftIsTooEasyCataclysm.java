package com.starkettle.mite_ctm;

import com.starkettle.mite_ctm.blocks.ModBlocks;
import com.starkettle.mite_ctm.effects.ModEffects;
import com.starkettle.mite_ctm.items.ModItems;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(MinecraftIsTooEasyCataclysm.MOD_ID)
public class MinecraftIsTooEasyCataclysm {
    public static final String MOD_ID = "mite_ctm";
    public static final Logger LOGGER = LogManager.getLogger("Minecraft Is Too Easy:Cataclysm");

    public MinecraftIsTooEasyCataclysm(IEventBus modEventBus) {
        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        ModEffects.register(modEventBus);
        LOGGER.info("""
                
                  __  __  _                                  __  _     _____        _______              ______                        _____        _                _
                 |  \\/  |(_)                                / _|| |   |_   _|      |__   __|            |  ____|                   _  / ____|      | |              | |
                 | \\  / | _  _ __    ___   ___  _ __  __ _ | |_ | |_    | |   ___     | |  ___    ___   | |__    __ _  ___  _   _ (_)| |      __ _ | |_  __ _   ___ | | _   _  ___  _ __ ___
                 | |\\/| || || '_ \\  / _ \\ / __|| '__|/ _` ||  _|| __|   | |  / __|    | | / _ \\  / _ \\  |  __|  / _` |/ __|| | | |   | |     / _` || __|/ _` | / __|| || | | |/ __|| '_ ` _ \\
                 | |  | || || | | ||  __/| (__ | |  | (_| || |  | |_   _| |_ \\__ \\    | || (_) || (_) | | |____| (_| |\\__ \\| |_| | _ | |____| (_| || |_| (_| || (__ | || |_| |\\__ \\| | | | | |
                 |_|  |_||_||_| |_| \\___| \\___||_|   \\__,_||_|   \\__| |_____||___/    |_| \\___/  \\___/  |______|\\__,_||___/ \\__, |(_) \\_____|\\__,_| \\__|\\__,_| \\___||_| \\__, ||___/|_| |_| |_|
                                                                                                                             __/ |                                       __/ |
                                                                                                                            |___/                                       |___/
                """);
    }
}

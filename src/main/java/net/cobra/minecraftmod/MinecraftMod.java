package net.cobra.minecraftmod;

import net.cobra.minecraftmod.block.ModBlocks;
import net.cobra.minecraftmod.item.ModItemGroups;
import net.cobra.minecraftmod.item.ModItems;
import net.cobra.minecraftmod.util.ModCustomTrades;
import net.cobra.minecraftmod.util.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MinecraftMod implements ModInitializer {
	public static final String MOD_ID = "minecraftmod";
    public static final Logger LOGGER = LoggerFactory.getLogger("minecraftmod");

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModLootTableModifiers.modifyLootTables();
		ModCustomTrades.registerCustomTrades();
		FuelRegistry.INSTANCE.add(ModItems.WOOD_PELLET , 1000);

	}
}
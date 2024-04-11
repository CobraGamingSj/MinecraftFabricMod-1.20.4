package net.cobra.minecraftmod.block;

import net.cobra.minecraftmod.MinecraftMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.Instrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    private static void addBlocksToBuilding_BlocksItemGroup(FabricItemGroupEntries entries) {
        entries.add(ModBlocks.RUBY_BLOCK);
        entries.add(ModBlocks.RADIANT_BLOCK);
        entries.add(ModBlocks.SAPPHIRE_BLOCK);
        entries.add(ModBlocks.GREEN_SAPPHIRE_BLOCK);
        entries.add(ModBlocks.RUBY_ORE);
        entries.add(ModBlocks.DEEPSLATE_RUBY_ORE);
    }

    public static final Block RUBY_BLOCK = registerBlock("ruby_block",
            new Block(FabricBlockSettings.create().strength(5.0f, 6.0f).sounds(BlockSoundGroup.METAL).hardness(5.0f).requiresTool().instrument(Instrument.BELL).mapColor(MapColor.BRIGHT_RED)));
    public static final Block RADIANT_BLOCK = registerBlock("radiant_block",
            new Block(FabricBlockSettings.create().strength(4.0f, 5.0f).sounds(BlockSoundGroup.METAL).hardness(4.0f).requiresTool().instrument(Instrument.BELL).mapColor(MapColor.DARK_RED)));
    public static final Block SAPPHIRE_BLOCK = registerBlock("sapphire_block",
            new Block(FabricBlockSettings.create().strength(3.0f, 4.0f).sounds(BlockSoundGroup.METAL).hardness(3.0f).requiresTool().instrument(Instrument.BELL).mapColor(MapColor.BLUE)));
    public static final Block GREEN_SAPPHIRE_BLOCK = registerBlock("green_sapphire_block",
            new Block(FabricBlockSettings.create().strength(3.0f, 4.0f).sounds(BlockSoundGroup.METAL).hardness(3.0f).requiresTool().instrument(Instrument.BELL).mapColor(MapColor.EMERALD_GREEN)));
    public static final Block RUBY_ORE = registerBlock("ruby_ore",
            new Block(FabricBlockSettings.create().strength(4.0f, 4.0f).sounds(BlockSoundGroup.STONE).hardness(4.0f).requiresTool().mapColor(MapColor.STONE_GRAY).instrument(Instrument.BASS)));
    public static final Block DEEPSLATE_RUBY_ORE = registerBlock("ddepslate_ruby_ore",
            new Block(FabricBlockSettings.create().strength(4.5f, 4.5f).sounds(BlockSoundGroup.STONE).hardness(4.5f).requiresTool().mapColor(MapColor.STONE_GRAY).instrument(Instrument.BASS)))
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(MinecraftMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(MinecraftMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }


    public static void registerModBlocks() {
        MinecraftMod.LOGGER.info("Registering ModBlocks for" + MinecraftMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ModBlocks::addBlocksToBuilding_BlocksItemGroup);
    }

}

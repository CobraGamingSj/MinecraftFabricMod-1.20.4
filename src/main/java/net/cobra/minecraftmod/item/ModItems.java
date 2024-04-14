package net.cobra.minecraftmod.item;

import net.cobra.minecraftmod.MinecraftMod;
import net.cobra.minecraftmod.block.ModBlocks;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));
    public static final Item RADIANT = registerItem("radiant", new Item(new FabricItemSettings()));
    public static final Item SAPPHIRE = registerItem("sapphire", new Item(new FabricItemSettings()));
    public static final Item GREEN_SAPPHIRE = registerItem("green_sapphire", new Item(new FabricItemSettings()));
    public static final Item PINEAPPLE = registerItem("pineapple", new Item(new FabricItemSettings().food(ModFoodComponents.PINEAPPLE)));
    public static final Item WOOD_PELLET = registerItem("wood_pellet", new Item(new FabricItemSettings()));

    public static final Item RUBY_PICKAXE = registerItem("ruby_pickaxe", new PickaxeItem(ModToolMaterial.RUBY, 2, 1.5f, new FabricItemSettings()));
    public static final Item RUBY_AXE = registerItem("ruby_axe", new AxeItem(ModToolMaterial.RUBY, 6, 2.1f, new FabricItemSettings()));
    public static final Item RUBY_SWORD = registerItem("ruby_sword", new SwordItem(ModToolMaterial.RUBY, 9, 2.5f, new FabricItemSettings()));
    public static final Item RUBY_SHOVEL = registerItem("ruby_shovel", new ShovelItem(ModToolMaterial.RUBY, 2, 1.5f, new FabricItemSettings()));
    public static final Item RUBY_HOE = registerItem("ruby_hoe", new HoeItem(ModToolMaterial.RUBY, -3, 0, new FabricItemSettings()));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(RUBY);
        entries.add(RADIANT);
        entries.add(SAPPHIRE);
        entries.add(GREEN_SAPPHIRE);
        entries.add(WOOD_PELLET);
    }

    private static void addItemsToFoodsAndDrinksItemGroup(FabricItemGroupEntries entries) {
       entries.add(ModItems.PINEAPPLE);
    }
   private static void addToolsToToolsGroup(FabricItemGroupEntries entries) {
        entries.add(ModItems.RUBY_PICKAXE);
        entries.add(ModItems.RUBY_AXE);
        entries.add(ModItems.RUBY_SHOVEL);
        entries.add(ModItems.RUBY_HOE);
   }
    private static void addToolsToCombatGroup(FabricItemGroupEntries entries) {
        entries.add(ModItems.RUBY_SWORD);
    }


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(MinecraftMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        MinecraftMod.LOGGER.info("Registering Mod Items for" + MinecraftMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemsToFoodsAndDrinksItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addToolsToCombatGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addToolsToToolsGroup);
    }

}

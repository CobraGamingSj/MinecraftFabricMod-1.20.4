package net.cobra.minecraftmod.item;

import net.cobra.minecraftmod.MinecraftMod;
import net.cobra.minecraftmod.block.ModBlocks;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));
    public static Item RADIANT = registerItem("radiant", new Item(new FabricItemSettings()));
    public static Item SAPPHIRE = registerItem("sapphire", new Item(new FabricItemSettings()));
    public static Item GREEN_SAPPHIRE = registerItem("green_sapphire", new Item(new FabricItemSettings()));
    public static Item PINEAPPLE = registerItem("pineapple", new Item(new FabricItemSettings().food(ModFoodComponents.PINEAPPLE)));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(RUBY);
        entries.add(RADIANT);
        entries.add(SAPPHIRE);
        entries.add(GREEN_SAPPHIRE);
    }

    private static void addItemsToFoodsAndDrinksItemGroup(FabricItemGroupEntries entries) {
       entries.add(ModItems.PINEAPPLE);
    }



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(MinecraftMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        MinecraftMod.LOGGER.info("Registering Mod Items for" + MinecraftMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemsToFoodsAndDrinksItemGroup);
    }

}

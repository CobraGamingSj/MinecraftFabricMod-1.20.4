package net.cobra.minecraftmod.util;

import net.cobra.minecraftmod.item.ModItems;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;

public class ModCustomTrades {
    public static void registerCustomTrades() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 5,
                factories -> {
                      factories.add((entity, random) -> new TradeOffer(
                              new ItemStack(Items.DIAMOND, 21),
                              new ItemStack(ModItems.RUBY_SWORD, 1), 3, 5, 0.05f
                      ));
                });
    }




}

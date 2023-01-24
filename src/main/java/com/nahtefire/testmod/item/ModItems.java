package com.nahtefire.testmod.item;

import com.nahtefire.testmod.TestModMain;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item POO = registerItem("fecal-matter", new Item(new FabricItemSettings()));
    public static final Item PEE = registerItem("jar-of-urine", new Item(new FabricItemSettings()));



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(TestModMain.MOD_ID, name), item);
    }
    public static void registerModItems() {
        TestModMain.LOGGER.debug("Registering mod items for: " + TestModMain.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {
            content.addAfter(Items.OAK_DOOR, PEE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {
            content.addAfter(Items.OAK_DOOR, POO);
        });

        //ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> entries.add(POO));
    }
}

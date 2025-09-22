package com.example.slashblade.registry;

import com.example.slashblade.SlashBladeMod;
import com.example.slashblade.item.KatanaItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item KATANA_BLACK = register("katana_black",
            new KatanaItem(ToolMaterials.NETHERITE, 3, -2.2f, new Item.Settings().maxCount(1)));

    public static final Item KATANA_WHITE = register("katana_white",
            new KatanaItem(ToolMaterials.IRON, 2, -2.0f, new Item.Settings().maxCount(1)));

    public static final Item KATANA_RED = register("katana_red",
            new KatanaItem(ToolMaterials.DIAMOND, 3, -2.4f, new Item.Settings().maxCount(1)));

    public static final Item KATANA_GOLD = register("katana_gold",
            new KatanaItem(ToolMaterials.GOLD, 2, -1.8f, new Item.Settings().maxCount(1)));

    private static Item register(String name, Item item) {
        // 1.21 新写法：Identifier.of(namespace, path)
        return Registry.register(Registries.ITEM, Identifier.of(SlashBladeMod.MOD_ID, name), item);
    }

    /** 空方法，用于在 Mod 初始化时触发类加载/注册 */
    public static void registerAll() {}
}

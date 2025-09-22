package com.example.slashblade.util;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;

public class ComboData {
    private static final String DRAWN = "Drawn"; // 是否处于“拔刀”状态

    /** 从 ItemStack 的 CUSTOM_DATA 组件读取拔刀状态 */
    public static boolean isDrawn(ItemStack stack) {
        NbtComponent comp = stack.get(DataComponentTypes.CUSTOM_DATA);
        if (comp == null) return false;
        NbtCompound nbt = comp.copyNbt();
        return nbt.getBoolean(DRAWN);
    }

    /** 切换拔刀状态并写回 CUSTOM_DATA 组件 */
    public static void toggleDrawn(ItemStack stack) {
        NbtComponent comp = stack.get(DataComponentTypes.CUSTOM_DATA);
        NbtCompound nbt = comp != null ? comp.copyNbt() : new NbtCompound();
        nbt.putBoolean(DRAWN, !nbt.getBoolean(DRAWN));
        stack.set(DataComponentTypes.CUSTOM_DATA, NbtComponent.of(nbt));
    }
}

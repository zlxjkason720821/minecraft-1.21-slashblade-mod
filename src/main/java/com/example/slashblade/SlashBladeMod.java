package com.example.slashblade;

import com.example.slashblade.registry.ModItems;
import net.fabricmc.api.ModInitializer;

public class SlashBladeMod implements ModInitializer {
    public static final String MOD_ID = "slashblade";

    @Override
    public void onInitialize() {
        // 触发物品注册（静态字段加载）
        ModItems.registerAll();
        System.out.println("[SlashBlade] initialized.");
    }
}

package com.example.slashblade.item;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundEvents;
import net.minecraft.item.Item;

public class KatanaItem extends SwordItem {

    public KatanaItem(ToolMaterial material, int attackDamage, float attackSpeed, Item.Settings settings) {
        // 1.21 要用 createAttributeModifiers 来传入 attackDamage/attackSpeed
        super(material, settings.attributeModifiers(
                SwordItem.createAttributeModifiers(material, attackDamage, attackSpeed)
        ));
    }

   @Override
public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
    if (attacker instanceof PlayerEntity player) {
        // 播放音效
        player.playSound(SoundEvents.ITEM_TRIDENT_RETURN, 0.7f, 1.0f);

        // 损耗耐久
        stack.damage(1, attacker, EquipmentSlot.MAINHAND);

    }
    return super.postHit(stack, target, attacker);
}

}

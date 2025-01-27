package com.starkettle.mite_ctm.mixins;

import com.starkettle.mite_ctm.capabilities.IFoodValue;
import com.starkettle.mite_ctm.capabilities.IPlayerFoodValue;
import com.starkettle.mite_ctm.capabilities.ModCapabilities;
import com.starkettle.mite_ctm.effects.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(Item.class)
public class ItemMixin {
    @Inject(method = "finishUsingItem", at = @At("HEAD"))
    public void finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity, CallbackInfoReturnable<ItemStack> cir){
        if(livingEntity instanceof Player player){
            Optional<IFoodValue> optionalIFoodValue = Optional.ofNullable(stack.getCapability(ModCapabilities.FOOD_VALUE_HANDLER));
            Optional<IPlayerFoodValue> optionalIPlayerFoodValue = Optional.ofNullable(player.getCapability(ModCapabilities.PLAYER_FOOD_VALUE_HANDLER));
            optionalIPlayerFoodValue.ifPresent(cap1 -> optionalIFoodValue.ifPresent(cap2 -> {
                cap1.increaseAll(cap2.getProtein(), cap2.getPhytonutrients(), cap2.getInsulinResponse());
                if(player.hasEffect(ModEffects.INSULIN_RESISTANCE)&&cap2.getInsulinResponse()>0){
                    int effectAmplifier = player.getEffect(ModEffects.INSULIN_RESISTANCE).getAmplifier();
                    player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 20*20, effectAmplifier));
                    if(effectAmplifier>=2){
                        player.addEffect(new MobEffectInstance(MobEffects.POISON, cap2.getInsulinResponse()/960*20));
                    }
                }
            }));
        }
    }
}

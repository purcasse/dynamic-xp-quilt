package com.purcase.dxp.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class PlayerMixin extends LivingEntity
{
	@Shadow
	public int experienceLevel;

	protected PlayerMixin(EntityType<? extends LivingEntity> entityType, World world) {
		super(entityType, world);
	}

	@Inject(method = "getXpToDrop", at = @At(value = "FIELD", target = "Lnet/minecraft/entity/player/PlayerEntity;experienceLevel:I", shift = At.Shift.BEFORE), cancellable = true)
	private void getXpToDropMixin(CallbackInfoReturnable<Integer> cir)
	{
		int level = this.experienceLevel;
		if (level < 17) {
			cir.setReturnValue((int) ((level * level + 6 * level) * 0.6));
		}
		if (level > 16 && level < 32) {
			cir.setReturnValue((int) ((int) (2.5 * level * level - 40.5 * level + 360) * 0.7));
		}
		if (level > 31) {
			cir.setReturnValue((int) ((int) (4.5 * level * level - 162.5 * level + 2220) * 0.8));
		}
	}
}

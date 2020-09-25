package com.shikareth.chickens.item;

import java.util.Random;

import com.shikareth.chickens.ChickensItems;
import com.shikareth.chickens.data.DataChicken;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class ItemCatcher extends ItemBase{

	public ItemCatcher() {
		super(ChickensItems.DEFAULT_ITEM_PROPERTIES.maxDamage(64));
	}

	@Override
	public ActionResultType itemInteractionForEntity(ItemStack stack, PlayerEntity playerIn, LivingEntity target, Hand hand) {
		World world = target.getEntityWorld();
		Vector3d pos = target.getPositionVec();
		DataChicken chickenData = DataChicken.getDataFromEntity(target);
		
		if (chickenData == null) {
			return ActionResultType.FAIL;
		} else if (target.isChild()) {
			if (world.isRemote) {
				spawnParticles(pos, world, ParticleTypes.SMOKE);
			}
			world.playSound(playerIn, pos.x, pos.y, pos.z, SoundEvents.ENTITY_CHICKEN_HURT, target.getSoundCategory(), 1.0F, 1.0F);
		} else {
			if (world.isRemote) {
				spawnParticles(pos, world, ParticleTypes.EXPLOSION);
			} else {
				ItemEntity item = target.entityDropItem(chickenData.buildChickenStack(), 1.0F);
				item.setMotion(0, 0.2D, 0); 
				target.remove();
			}
			world.playSound(playerIn, pos.x, pos.y, pos.z, SoundEvents.ENTITY_CHICKEN_EGG, target.getSoundCategory(), 1.0F, 1.0F);
			stack.damageItem(1, playerIn, null);
		}
		
		return ActionResultType.CONSUME;
	}
	
	private void spawnParticles(Vector3d pos, World world, BasicParticleType particleType) {
		Random rand = new Random();
	
		for (int k = 0; k < 20; ++k) {
			double xCoord = pos.x + (rand.nextDouble() * 0.6D) - 0.3D;
			double yCoord = pos.y + (rand.nextDouble() * 0.6D);
			double zCoord = pos.z + (rand.nextDouble() * 0.6D) - 0.3D;
			double xSpeed = rand.nextGaussian() * 0.02D;
			double ySpeed = rand.nextGaussian() * 0.2D;
			double zSpeed = rand.nextGaussian() * 0.02D;
			world.addParticle(particleType, xCoord, yCoord, zCoord, xSpeed, ySpeed, zSpeed);
		}
	}
}

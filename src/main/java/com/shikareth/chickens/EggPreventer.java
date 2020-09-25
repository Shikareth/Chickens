package com.shikareth.chickens;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EggPreventer {
	
	  @SubscribeEvent
	  public static void onLivingUpdate(LivingEvent.LivingUpdateEvent e) {
		  if(e.getEntity().isLiving()) {
			  if(e.getEntity().getType().equals(EntityType.CHICKEN)) {
				  ChickenEntity chicken = (ChickenEntity)e.getEntityLiving();
				  chicken.timeUntilNextEgg = 999999;
			  }  
		  }
	  }
}

package com.natamus.petnames.forge.events;

import com.natamus.petnames.events.NamingEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.BabyEntitySpawnEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class ForgeNamingEvent {
	@SubscribeEvent
	public void onBaby(BabyEntitySpawnEvent e) {
		Entity entity = e.getChild();
		Level level = entity.getCommandSenderWorld();
		if (level.isClientSide) {
			return;
		}

		Mob parentA = e.getParentA();
		Mob parentB = e.getParentB();
		if (!(parentA instanceof Animal) || !(parentB instanceof Animal)) {
			return;
		}

		NamingEvent.onBaby((ServerLevel)level, (Animal)parentA, (Animal)parentB, e.getChild());
	}
}

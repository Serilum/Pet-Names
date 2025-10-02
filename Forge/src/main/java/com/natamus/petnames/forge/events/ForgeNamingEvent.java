package com.natamus.petnames.forge.events;

import com.natamus.petnames.events.NamingEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.BabyEntitySpawnEvent;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;

import java.lang.invoke.MethodHandles;

public class ForgeNamingEvent {
	public static void registerEventsInBus() {
		// BusGroup.DEFAULT.register(MethodHandles.lookup(), ForgeNamingEvent.class);

		BabyEntitySpawnEvent.BUS.addListener(ForgeNamingEvent::onBaby);
	}

	@SubscribeEvent
	public static void onBaby(BabyEntitySpawnEvent e) {
		Entity entity = e.getChild();
		Level level = entity.level();
		if (level.isClientSide()) {
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

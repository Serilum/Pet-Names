package com.natamus.petnames;

import com.natamus.collective.check.RegisterMod;
import com.natamus.collective.fabric.callbacks.CollectiveAnimalEvents;
import com.natamus.petnames.events.NamingEvent;
import com.natamus.petnames.util.Reference;
import net.fabricmc.api.ModInitializer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.animal.Animal;

public class ModFabric implements ModInitializer {
	
	@Override
	public void onInitialize() {
		setGlobalConstants();
		ModCommon.init();

		loadEvents();

		RegisterMod.register(Reference.NAME, Reference.MOD_ID, Reference.VERSION, Reference.ACCEPTED_VERSIONS);
	}

	private void loadEvents() {
		CollectiveAnimalEvents.PRE_BABY_SPAWN.register((ServerLevel world, Animal parentA, Animal parentB, AgeableMob offspring) -> {
			NamingEvent.onBaby(world, parentA, parentB, offspring);
			return true;
		});
	}

	private static void setGlobalConstants() {

	}
}

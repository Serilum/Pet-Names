package com.natamus.petnames.events;

import com.natamus.collective.functions.EntityFunctions;
import com.natamus.collective.functions.StringFunctions;
import com.natamus.petnames.config.ConfigHandler;
import com.natamus.petnames.util.Util;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.animal.Animal;

public class NamingEvent {
	public static void onBaby(ServerLevel world, Animal parentA, Animal parentB, AgeableMob offspring) {
		if (!Util.isNamable(offspring)) {
			return;
		}
		
		EntityFunctions.nameEntity(offspring, StringFunctions.getRandomName(ConfigHandler._useFemaleNames, ConfigHandler._useMaleNames));
	}
}

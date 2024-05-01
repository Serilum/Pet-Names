package com.natamus.petnames.util;

import com.natamus.petnames.config.ConfigHandler;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.animal.horse.Donkey;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.animal.horse.Llama;
import net.minecraft.world.entity.animal.horse.Mule;

public class Util {
	public static boolean isNamable(Entity entity) {
		if (entity instanceof Wolf) {
			return ConfigHandler.nameWolves;
		}
		else if (entity instanceof Cat) {
			return ConfigHandler.nameCats;
		}
		else if (entity instanceof Horse) {
			return ConfigHandler.nameHorses;
		}
		else if (entity instanceof Donkey) {
			return ConfigHandler.nameDonkeys;
		}
		else if (entity instanceof Mule) {
			return ConfigHandler.nameMules;
		}
		else if (entity instanceof Llama) {
			return ConfigHandler.nameLlamas;
		}
		else {
			return false;
		}
	}
}

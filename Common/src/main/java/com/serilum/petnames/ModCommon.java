package com.serilum.petnames;

import com.natamus.collective.config.GenerateJSONFiles;
import com.serilum.petnames.config.ConfigHandler;
import com.serilum.petnames.util.Reference;

public class ModCommon {

	public static void init() {
		ConfigHandler.initConfig();
		load();
	}

	private static void load() {
		GenerateJSONFiles.requestJSONFile(Reference.MOD_ID, "entity_names.json");
	}
}
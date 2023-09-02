package org.purcase.dxp;

import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DynamicXp implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("Dynamic XP");
	@Override
	public void onInitialize(ModContainer mod) {
		LOGGER.info("Successfully loaded nothing for {}!", mod.metadata().name());
	}
}

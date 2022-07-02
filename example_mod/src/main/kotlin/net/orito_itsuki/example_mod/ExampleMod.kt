package net.orito_itsuki.example_mod;

import net.fabricmc.api.ModInitializer
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Suppress("UNUSED")
object ExampleMod: ModInitializer {
    const val MOD_ID = "example_mod"
    val LOGGER: Logger = LoggerFactory.getLogger(MOD_ID)

    override fun onInitialize() {
        LOGGER.info("Hello Fabric world!")
    }
}

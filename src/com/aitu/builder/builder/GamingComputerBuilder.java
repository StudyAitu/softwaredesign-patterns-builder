package com.aitu.builder.builder;

import com.aitu.builder.exception.InvalidComputerException;
import com.aitu.builder.model.Computer;

public class GamingComputerBuilder extends AbstractComputerBuilder {

    private static final int MINIMUM_GAMING_RAM_GB = 16;
    private static final int MINIMUM_GAMING_POWER_SUPPLY_WATTS = 600;

    public GamingComputerBuilder() {
        processor = "Intel Core i7-14700K";
        graphicsCard = "NVIDIA RTX 4070 Ti";
        ramSizeGb = 32;
        storageCapacityGb = 1000;
        powerSupplyWattage = 750;
        rgbLightingEnabled = true;
        operatingSystem = "Windows 11 Home";
    }

    @Override
    public Computer build() {
        validateCommonConfiguration();
        validateGamingConfiguration();

        return createComputer();
    }

    private void validateGamingConfiguration() {
        if (ramSizeGb < MINIMUM_GAMING_RAM_GB) {
            throw new InvalidComputerException(
                    "Gaming PC requires at least "
                            + MINIMUM_GAMING_RAM_GB + "GB RAM."
            );
        }

        if (powerSupplyWattage < MINIMUM_GAMING_POWER_SUPPLY_WATTS) {
            throw new InvalidComputerException(
                    "Gaming PC power supply must be at least "
                            + MINIMUM_GAMING_POWER_SUPPLY_WATTS + "W."
            );
        }
    }
}
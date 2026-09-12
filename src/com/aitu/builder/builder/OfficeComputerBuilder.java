package com.aitu.builder.builder;

import com.aitu.builder.exception.InvalidComputerException;
import com.aitu.builder.model.Computer;

public class OfficeComputerBuilder extends AbstractComputerBuilder {

    private static final int MINIMUM_OFFICE_RAM_GB = 8;
    private static final int MINIMUM_OFFICE_POWER_SUPPLY_WATTS = 300;

    public OfficeComputerBuilder() {
        processor = "Intel Core i3-13100";
        graphicsCard = "Integrated Intel UHD Graphics";
        ramSizeGb = 8;
        storageCapacityGb = 512;
        powerSupplyWattage = 350;
        rgbLightingEnabled = false;
        operatingSystem = "Windows 11 Pro";
    }

    @Override
    public Computer build() {
        validateCommonConfiguration();
        validateOfficeConfiguration();

        return createComputer();
    }

    private void validateOfficeConfiguration() {
        if (ramSizeGb < MINIMUM_OFFICE_RAM_GB) {
            throw new InvalidComputerException(
                    "Office PC requires at least "
                            + MINIMUM_OFFICE_RAM_GB + "GB RAM."
            );
        }

        if (powerSupplyWattage < MINIMUM_OFFICE_POWER_SUPPLY_WATTS) {
            throw new InvalidComputerException(
                    "Office PC power supply must be at least "
                            + MINIMUM_OFFICE_POWER_SUPPLY_WATTS + "W."
            );
        }
    }
}
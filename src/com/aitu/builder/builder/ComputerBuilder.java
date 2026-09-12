package com.aitu.builder.builder;

import com.aitu.builder.model.Computer;

public interface ComputerBuilder {

    ComputerBuilder setProcessor(String processor);

    ComputerBuilder setGraphicsCard(String graphicsCard);

    ComputerBuilder setRamSizeGb(int ramSizeGb);

    ComputerBuilder setStorageCapacityGb(int storageCapacityGb);

    ComputerBuilder setPowerSupplyWattage(int powerSupplyWattage);

    ComputerBuilder setRgbLighting(boolean enabled);

    ComputerBuilder setOperatingSystem(String operatingSystem);

    Computer build();
}
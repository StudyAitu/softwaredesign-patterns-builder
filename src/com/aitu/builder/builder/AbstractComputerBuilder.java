package com.aitu.builder.builder;

import com.aitu.builder.exception.InvalidComputerException;
import com.aitu.builder.model.Computer;

public abstract class AbstractComputerBuilder implements ComputerBuilder {

    protected String processor;
    protected String graphicsCard;
    protected int ramSizeGb;
    protected int storageCapacityGb;
    protected int powerSupplyWattage;
    protected boolean rgbLightingEnabled;
    protected String operatingSystem;

    @Override
    public ComputerBuilder setProcessor(String processor) {
        this.processor = processor;
        return this;
    }

    @Override
    public ComputerBuilder setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
        return this;
    }

    @Override
    public ComputerBuilder setRamSizeGb(int ramSizeGb) {
        this.ramSizeGb = ramSizeGb;
        return this;
    }

    @Override
    public ComputerBuilder setStorageCapacityGb(int storageCapacityGb) {
        this.storageCapacityGb = storageCapacityGb;
        return this;
    }

    @Override
    public ComputerBuilder setPowerSupplyWattage(int powerSupplyWattage) {
        this.powerSupplyWattage = powerSupplyWattage;
        return this;
    }

    @Override
    public ComputerBuilder setRgbLighting(boolean enabled) {
        this.rgbLightingEnabled = enabled;
        return this;
    }

    @Override
    public ComputerBuilder setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
        return this;
    }

    protected void validateCommonConfiguration() {
        if (processor == null || processor.isBlank()) {
            throw new InvalidComputerException(
                    "Processor component cannot be empty."
            );
        }

        if (graphicsCard == null || graphicsCard.isBlank()) {
            throw new InvalidComputerException(
                    "Graphics card component cannot be empty."
            );
        }

        if (ramSizeGb <= 0) {
            throw new InvalidComputerException(
                    "RAM size must be greater than 0."
            );
        }

        if (storageCapacityGb <= 0) {
            throw new InvalidComputerException(
                    "Storage capacity must be greater than 0."
            );
        }

        if (powerSupplyWattage <= 0) {
            throw new InvalidComputerException(
                    "Power supply wattage must be greater than 0."
            );
        }

        if (operatingSystem == null || operatingSystem.isBlank()) {
            throw new InvalidComputerException(
                    "Operating system cannot be empty."
            );
        }
    }

    protected Computer createComputer() {
        return new Computer(
                processor,
                graphicsCard,
                ramSizeGb,
                storageCapacityGb,
                powerSupplyWattage,
                rgbLightingEnabled,
                operatingSystem
        );
    }
}
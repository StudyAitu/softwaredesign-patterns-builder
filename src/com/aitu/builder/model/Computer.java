package com.aitu.builder.model;

public final class Computer {

    private final String processor;
    private final String graphicsCard;
    private final int ramSizeGb;
    private final int storageCapacityGb;
    private final int powerSupplyWattage;
    private final boolean rgbLightingEnabled;
    private final String operatingSystem;

    public Computer(
            String processor,
            String graphicsCard,
            int ramSizeGb,
            int storageCapacityGb,
            int powerSupplyWattage,
            boolean rgbLightingEnabled,
            String operatingSystem) {

        this.processor = processor;
        this.graphicsCard = graphicsCard;
        this.ramSizeGb = ramSizeGb;
        this.storageCapacityGb = storageCapacityGb;
        this.powerSupplyWattage = powerSupplyWattage;
        this.rgbLightingEnabled = rgbLightingEnabled;
        this.operatingSystem = operatingSystem;
    }

    public String getProcessor() {
        return processor;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    public int getRamSizeGb() {
        return ramSizeGb;
    }

    public int getStorageCapacityGb() {
        return storageCapacityGb;
    }

    public int getPowerSupplyWattage() {
        return powerSupplyWattage;
    }

    public boolean isRgbLightingEnabled() {
        return rgbLightingEnabled;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    @Override
    public String toString() {
        return String.format(
                "Computer Configuration:%n" +
                        "  - CPU: %s%n" +
                        "  - GPU: %s%n" +
                        "  - RAM: %d GB%n" +
                        "  - Storage: %d GB SSD%n" +
                        "  - Power Supply: %d W%n" +
                        "  - RGB Lighting: %s%n" +
                        "  - OS: %s%n",
                processor,
                graphicsCard,
                ramSizeGb,
                storageCapacityGb,
                powerSupplyWattage,
                rgbLightingEnabled ? "Yes" : "No",
                operatingSystem
        );
    }
}
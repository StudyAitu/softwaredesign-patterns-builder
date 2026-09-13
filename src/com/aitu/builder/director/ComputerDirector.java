package com.aitu.builder.director;

import com.aitu.builder.builder.ComputerBuilder;
import com.aitu.builder.model.Computer;

public class ComputerDirector {

    public Computer constructUltraGamingPC(ComputerBuilder builder) {
        return builder
                .setProcessor("AMD Ryzen 9 7950X3D")
                .setGraphicsCard("NVIDIA RTX 4090")
                .setRamSizeGb(64)
                .setStorageCapacityGb(2000)
                .setPowerSupplyWattage(1000)
                .setRgbLighting(true)
                .setOperatingSystem("Windows 11 Pro")
                .build();
    }

    public Computer constructBudgetOfficePC(ComputerBuilder builder) {
        return builder
                .setProcessor("Intel Core i3-12100")
                .setGraphicsCard("Integrated UHD Graphics 730")
                .setRamSizeGb(8)
                .setStorageCapacityGb(256)
                .setPowerSupplyWattage(350)
                .setRgbLighting(false)
                .setOperatingSystem("Ubuntu 22.04 LTS")
                .build();
    }
}
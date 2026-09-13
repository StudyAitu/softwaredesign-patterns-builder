package com.aitu.builder;

import com.aitu.builder.builder.ComputerBuilder;
import com.aitu.builder.builder.GamingComputerBuilder;
import com.aitu.builder.builder.OfficeComputerBuilder;
import com.aitu.builder.director.ComputerDirector;
import com.aitu.builder.exception.InvalidComputerException;
import com.aitu.builder.model.Computer;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== 1. Custom Fluent API Construction ===");

        Computer customGamingPc = new GamingComputerBuilder()
                .setProcessor("Intel Core i9-14900K")
                .setGraphicsCard("NVIDIA RTX 4080 Super")
                .setRamSizeGb(32)
                .setStorageCapacityGb(2000)
                .setPowerSupplyWattage(850)
                .setRgbLighting(true)
                .setOperatingSystem("Windows 11 Home")
                .build();

        System.out.println(customGamingPc);

        System.out.println("=== 2. Pre-defined Configurations via Director ===");

        ComputerDirector director = new ComputerDirector();

        ComputerBuilder gamingBuilder = new GamingComputerBuilder();

        Computer ultraGamingPc =
                director.constructUltraGamingPC(gamingBuilder);

        System.out.println("[Director Created] Ultra Gaming PC:");
        System.out.println(ultraGamingPc);

        ComputerBuilder officeBuilder = new OfficeComputerBuilder();

        Computer budgetOfficePc =
                director.constructBudgetOfficePC(officeBuilder);

        System.out.println("[Director Created] Budget Office PC:");
        System.out.println(budgetOfficePc);

        System.out.println("=== 3. Validation Tests ===");

        testInvalidGamingRam();
        testInvalidGamingPowerSupply();
        testInvalidOfficeRam();
    }

    private static void testInvalidGamingRam() {
        try {
            new GamingComputerBuilder()
                    .setRamSizeGb(4)
                    .build();

        } catch (InvalidComputerException e) {
            System.out.println(
                    "Gaming RAM validation passed: " + e.getMessage()
            );
        }
    }

    private static void testInvalidGamingPowerSupply() {
        try {
            new GamingComputerBuilder()
                    .setPowerSupplyWattage(400)
                    .build();

        } catch (InvalidComputerException e) {
            System.out.println(
                    "Gaming PSU validation passed: " + e.getMessage()
            );
        }
    }

    private static void testInvalidOfficeRam() {
        try {
            new OfficeComputerBuilder()
                    .setRamSizeGb(4)
                    .build();

        } catch (InvalidComputerException e) {
            System.out.println(
                    "Office RAM validation passed: " + e.getMessage()
            );
        }
    }
}
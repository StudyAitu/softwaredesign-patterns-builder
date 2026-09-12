# Builder Pattern — Computer Configuration

## Overview

This project demonstrates the **Builder Design Pattern** using Java.

The goal is to build different computer configurations step by step without creating large and complicated constructors.

The project includes gaming and office computer builders, a Director for predefined configurations, fluent API, and validation.

## Technologies

* Java
* JDK 17
* IntelliJ IDEA

## Project Structure

```text
src/
└── com/aitu/builder/
    ├── builder/
    │   ├── ComputerBuilder.java
    │   ├── AbstractComputerBuilder.java
    │   ├── GamingComputerBuilder.java
    │   └── OfficeComputerBuilder.java
    │
    ├── director/
    │   └── ComputerDirector.java
    │
    ├── exception/
    │   └── InvalidComputerException.java
    │
    ├── model/
    │   └── Computer.java
    │
    └── Main.java
```

## Builder Pattern Structure

The project contains the following roles:

* **Product** — `Computer`
* **Builder** — `ComputerBuilder`
* **Abstract Builder** — `AbstractComputerBuilder`
* **Concrete Builders** — `GamingComputerBuilder` and `OfficeComputerBuilder`
* **Director** — `ComputerDirector`
* **Client** — `Main`

## Features

### 1. Custom Fluent API

A computer can be configured step by step using method chaining:

```java
Computer customGamingPc = new GamingComputerBuilder()
        .setProcessor("Intel Core i9-14900K")
        .setGraphicsCard("NVIDIA RTX 4080 Super")
        .setRamSizeGb(32)
        .setStorageCapacityGb(2000)
        .setPowerSupplyWattage(850)
        .setRgbLighting(true)
        .setOperatingSystem("Windows 11 Home")
        .build();
```

### 2. Predefined Configurations

`ComputerDirector` provides predefined configurations:

* Ultra Gaming PC
* Budget Office PC

The Director uses the Builder interface, so the construction process is separated from the concrete product configuration.

### 3. Validation

The project validates computer configurations before creating the final product.

Examples:

* Gaming PC requires at least 16 GB RAM.
* Gaming PC requires at least 600 W power supply.
* Office PC requires at least 8 GB RAM.
* Office PC requires at least 300 W power supply.
* Processor, graphics card, storage, power supply, and operating system cannot be empty or invalid.

Invalid configurations throw `InvalidComputerException`.

## Clean Code

The project applies several Clean Code principles:

1. **Meaningful names** — classes, methods, and constants clearly describe their purpose.
2. **Single Responsibility** — each class has a focused responsibility.
3. **No duplicated construction logic** — common construction logic is located in `AbstractComputerBuilder`.
4. **Small methods** — validation and construction logic are separated into focused methods.
5. **Constants instead of magic numbers** — validation limits are stored in named constants.
6. **Validation before object creation** — invalid configurations are rejected before creating a `Computer`.

## How to Run

1. Open the project in IntelliJ IDEA.
2. Make sure JDK 17 is configured.
3. Open `Main.java`.
4. Run the `main()` method.

The program demonstrates custom construction, predefined configurations, and validation tests.

## Example Output

```text
=== 1. Custom Fluent API Construction ===
Computer Configuration:
  - CPU: Intel Core i9-14900K
  - GPU: NVIDIA RTX 4080 Super
  - RAM: 32 GB
  - Storage: 2000 GB SSD
  - Power Supply: 850 W
  - RGB Lighting: Yes
  - OS: Windows 11 Home

=== 2. Pre-defined Configurations via Director ===
[Director Created] Ultra Gaming PC:
Computer Configuration:
  - CPU: AMD Ryzen 9 7950X3D
  - GPU: NVIDIA RTX 4090
  - RAM: 64 GB
  - Storage: 2000 GB SSD
  - Power Supply: 1000 W
  - RGB Lighting: Yes
  - OS: Windows 11 Pro

[Director Created] Budget Office PC:
Computer Configuration:
  - CPU: Intel Core i3-12100
  - GPU: Integrated UHD Graphics 730
  - RAM: 8 GB
  - Storage: 256 GB SSD
  - Power Supply: 350 W
  - RGB Lighting: No
  - OS: Ubuntu 22.04 LTS

=== 3. Validation Tests ===
Gaming RAM validation passed: Gaming PC requires at least 16GB RAM.
Gaming PSU validation passed: Gaming PC power supply must be at least 600W.
Office RAM validation passed: Office PC requires at least 8GB RAM.
```

## UML Diagram

The UML diagram shows the relationships between the Product, Builder, Concrete Builders, and Director.

The diagram is available in the `docs/` directory.

## Conclusion

This project demonstrates how the Builder Pattern can simplify the creation of complex `Computer` objects.

Using the Builder Pattern makes the construction process more readable, flexible, and easier to maintain. The abstract builder also prevents duplicated construction logic between different concrete builders.

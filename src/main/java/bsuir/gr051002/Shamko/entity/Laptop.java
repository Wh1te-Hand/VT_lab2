package bsuir.gr051002.Shamko.entity;

import java.util.ArrayList;

public class Laptop extends Appliance {
    private int batteryCapacity;
    private String os;
    private int memoryRom;
    private int systemMemory;
    private int cpu;
    private int displayInches;

    public Laptop(int batteryCapacity, String os, int memoryRom, int systemMemory, int cpu, int displayInches, int price) {
        this.batteryCapacity = batteryCapacity;
        this.os = os;
        this.memoryRom = memoryRom;
        this.systemMemory = systemMemory;
        this.cpu = cpu;
        this.displayInches = displayInches;
        this.setPrice(price);
    }

    public static Laptop createInstance(ArrayList<String> params) {
        return new Laptop(
                Integer.parseInt(params.get(0)),
                params.get(1),
                Integer.parseInt(params.get(2)),
                Integer.parseInt(params.get(3)),
                Integer.parseInt(params.get(4)),
                Integer.parseInt(params.get(5)),
                Integer.parseInt(params.get(6))
        );
    }

    public Object getFieldByName(String name) {
        return switch (name) {
            case "BATTERY_CAPACITY" -> batteryCapacity;
            case "OS" -> os;
            case "MEMORY_ROM" -> memoryRom;
            case "SYSTEM_MEMORY" -> systemMemory;
            case "CPU" -> cpu;
            case "DISPLAY_INCHES" -> displayInches;
            case "PRICE" -> getPrice();
            default -> null;
        };
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "batteryCapacity=" + batteryCapacity +
                ", os='" + os + "'" +
                ", memoryRom=" + memoryRom +
                ", systemMemory=" + systemMemory +
                ", cpu=" + cpu +
                ", displayInches=" + displayInches +
                ", price=" + getPrice() +
                '}';
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public String getOs() {
        return os;
    }

    public int getMemoryRom() {
        return memoryRom;
    }

    public int getSystemMemory() {
        return systemMemory;
    }

    public int getCpu() {
        return cpu;
    }

    public int getDisplayInches() {
        return displayInches;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public void setMemoryRom(int memoryRom) {
        this.memoryRom = memoryRom;
    }

    public void setSystemMemory(int systemMemory) {
        this.systemMemory = systemMemory;
    }

    public void setCpu(int cpu) {
        this.cpu = cpu;
    }

    public void setDisplayInches(int displayInches) {
        this.displayInches = displayInches;
    }

}

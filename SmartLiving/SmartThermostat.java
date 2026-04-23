package org.example.SmartLiving;

public class SmartThermostat extends SmartDevice implements Controllable {
    private int temperature;

    public SmartThermostat(RoomType room, String name, int temperature) {
        super(room, name);
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public SmartThermostat(RoomType room, String name) {
        super(room, name);
    }

    @Override
    public void increaseValue() {
        if (temperature < 19) {
            temperature=22;
            System.out.println(name + ": температура " + temperature);
        }
    }

    @Override
    public void decreaseValue() {
        if (temperature > 23) {
            temperature=22;
            System.out.println(name + ": температура " + temperature);
        }
    }
}

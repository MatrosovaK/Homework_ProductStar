package org.example.SmartLiving;

import java.util.ArrayList;
import java.util.List;

public class SmartHome {

    private final List<SmartDevice> devices;

    public SmartHome(){
        devices = new ArrayList<>();
    }
    public void addDevice(SmartDevice device){
        devices.add(device);
    }

    public void turnOnAll(){
        for (SmartDevice device : devices) {
            device.turnOn();
        }
    }

    public void turnOffAll(){
        for (SmartDevice device : devices) {
            device.turnOff();
        }
    }

    static final class HomeStats {
        private final int totalDevices;
        private final int activeDevices;

        public HomeStats(int totalDevices, int activeDevices) {
            this.totalDevices = totalDevices;
            this.activeDevices = activeDevices;
        }
        public void printHomeStats(){
            System.out.println("Всего устройств: " + totalDevices);
            System.out.println("Всего устройств включено: " + activeDevices);
            System.out.println("Всего устройств выключено: " + (totalDevices - activeDevices));
        }
    }



       public HomeStats getStats(){
            int count = 0;
            for (SmartDevice device:devices){
               if(device.isOn()) {
                   count++;
               }
            }
            return new HomeStats(devices.size(), count);
       }
    }






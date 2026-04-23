package org.example.SmartLiving;

import static org.example.SmartLiving.RoomType.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        SmartLight officeLight = new SmartLight(OFFICE, "ЛампаОФИС", 100);
        SmartLight kitchenLight = new SmartLight(KITCHEN, "ЛампаКУХНЯ", 100);
        SmartTV tv = new SmartTV(BEDROOM, "тв", 100);
        SmartThermostat thermostat = new SmartThermostat(BATHROOM, "градусник", 100);

        SmartHome home = new SmartHome();

        home.addDevice(officeLight);
        home.addDevice(kitchenLight);
        home.addDevice(tv);
        home.addDevice(thermostat);
        home.turnOnAll();

        SmartHome.HomeStats stats = home.getStats();
        stats.printHomeStats();

        tv.turnOff();
        SmartHome.HomeStats stats1 = home.getStats();
        stats1.printHomeStats();

        thermostat.decreaseValue();






    }
}
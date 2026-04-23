package org.example.SmartLiving;

public class SmartLight extends SmartDevice implements Controllable{
    private int brightness;

    public SmartLight(RoomType room, String name, int brightness) {
        super(room, name);
        this.brightness = brightness;
    }

    @Override
    public void increaseValue() {
        if(brightness<50){
            brightness++;
            System.out.println(name + ": яркость" + brightness);
        }
    }

    @Override
    public void decreaseValue() {
        if(brightness > 100){
            brightness--;
            System.out.println(name + ": яркость" + brightness);
        }
    }

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }




}

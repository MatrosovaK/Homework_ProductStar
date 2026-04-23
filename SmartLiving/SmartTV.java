package org.example.SmartLiving;

public class SmartTV extends SmartDevice implements Controllable{
    private int volume;

    public SmartTV(RoomType room, String name, int volume) {
        super(room, name);
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }



    @Override
    public void increaseValue() {
        if (volume < 10) {
            volume=13;
            System.out.println(name + "громкость" + volume);
        }
    }

    @Override
    public void decreaseValue() {
        if (volume > 16) {
            volume=13;
            System.out.println(name + "громкость" + volume);
        }
    }
}

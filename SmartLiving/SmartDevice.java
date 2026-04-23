package org.example.SmartLiving;

public abstract class SmartDevice implements Controllable{

        protected String name;
        protected boolean isOn;
        protected RoomType room;

        public SmartDevice(RoomType room, String name) {
                this.name = name;
                this.room = room;

        }

        @Override
        public abstract void increaseValue();

    @Override
        public abstract void decreaseValue();

    public final void turnOn() {
            isOn = true;
            System.out.println(name + " включено. ");
        }

        public final void turnOff() {
                isOn = false;
                System.out.println(name + " выключено. ");
        }



        public RoomType getRoom() {
                return room;
        }

        public void setRoom(RoomType room) {
                this.room = room;
        }

        public boolean isOn() {
                return isOn;
        }
}

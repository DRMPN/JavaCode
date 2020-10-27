package model.Instruments;

import model.Orchestra;

public abstract class BrassInstrument implements Instrument {

    private Orchestra orchestra;
    private String owner;

    private String instrumentName;
    private boolean tuned;

    public BrassInstrument(String instrumentName) {
        this.orchestra = null;
        this.owner = null;
        this.instrumentName = instrumentName;
        this.tuned = false;
    }

    // getters
    public String getInstrumentName() {
        return instrumentName;
    }
    public boolean isTuned() {
        return tuned;
    }
    public String getOwner() {
        return owner;
    }

    // setters
    public void setOrchestra(Orchestra orchestra) {
        this.orchestra = orchestra;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public void tune() {
        this.tuned = true;
    }

    @Override
    public void startPlaying() {
        System.out.println("Start blowing.");
    }

    @Override
    public void stopPlaying() {
        System.out.println("Stop blowing.");
    }

}

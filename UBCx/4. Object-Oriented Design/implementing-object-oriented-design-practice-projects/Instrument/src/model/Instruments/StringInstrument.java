package model.Instruments;

import model.Orchestra;

public abstract class StringInstrument implements Instrument {

    private Orchestra orchestra;
    private String owner;

    private String instrumentName;
    private boolean tuned;

    public StringInstrument(String instrumentName) {
        this.orchestra = null;
        this.owner = null;
        this.instrumentName = instrumentName;
        this.tuned = false;
    }

    // getters
    public String getOwner() {
        return owner;
    }
    public String getInstrumentName() {
        return instrumentName;
    }
    public boolean isTuned() {
        return tuned;
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
        System.out.println("Touch strings.");
    }

    @Override
    public void stopPlaying() {
        System.out.println("Stop touching strings.");
    }

}

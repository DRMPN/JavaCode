package model.Instruments;

public interface Instrument {

    // Effects: tunes current instrument
    void tune();

    // Effects: start playing on the current instrument
    void startPlaying();

    // Effects: stop playing on the current instrument
    void stopPlaying();

}

package model;

import model.Instruments.Instrument;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Orchestra {

    /*
    TODO 1: make method to get all instruments
    TODO 2: make method to get all instruments of specific type
    TODO 3: make method to start and stop performance

    TODO *: create human class and change owner and conductor fields (bi-association with instrument?)
    TODO **: create types of instruments, change constructors and hashMap
    */

    private String orchestraName;
    private String conductor;
    private Map<String, ArrayList<Instrument>> orchestraInstruments;

    public Orchestra(String orchestraName, String conductor) {
        this.orchestraName = orchestraName;
        this.conductor = conductor;
        this.orchestraInstruments = new HashMap<>();
    }

    // getters
    public String getOrchestraName() {
        return orchestraName;
    }
    public String getConductor() {
        return conductor;
    }
    public Map<String, ArrayList<Instrument>> getOrchestraInstruments() {
        return orchestraInstruments;
    }

    public void addInstrumentToOrchestra(String type, Instrument newInstrument) {
        if (orchestraInstruments.isEmpty()) {
            orchestraInstruments.put(type, new ArrayList<>());
        }
        ArrayList<Instrument> olderInstruments = orchestraInstruments.get(type);
        olderInstruments.add(newInstrument);
    }



}
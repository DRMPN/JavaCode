package test;

import model.Instruments.Instrument;
import model.Instruments.Trumpet;
import model.Instruments.Violin;
import model.Orchestra;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OrchestraTest {

    private Orchestra testOrchestra;
    private Instrument testStringInstrument;
    private Instrument testBrassInstrument;

    @Before
    public void setUp() {
        testOrchestra = new Orchestra("testOrchestra","testConductor");
        testStringInstrument = new Violin();
        testBrassInstrument = new Trumpet();
    }

    @Test
    public void addInstrumentTest() {
        assertEquals(0, testOrchestra.getOrchestraInstruments().size());
        testOrchestra.addInstrumentToOrchestra("Sting", testStringInstrument);
        testOrchestra.addInstrumentToOrchestra("Brass",testBrassInstrument);
        assertEquals(2, testOrchestra.getOrchestraInstruments().size());
    }

}

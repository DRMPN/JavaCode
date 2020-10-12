package test;

import model.Fingerprint;
import model.Person;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testFingerprint{

    Person testPerson;
    Fingerprint testFingerprint;

    @Before
    public void setUp() {
        testPerson = new Person("Steve");
        testFingerprint = new Fingerprint(testPerson,"Police department #2");
    }

    @Test
    public void testFingerprintPerson(){
        assertEquals(testPerson.getFingerprint().getAssociatedPerson().getName(),testPerson.getName());
        assertEquals(testPerson, testFingerprint.getAssociatedPerson());
        testFingerprint.track();
    }
}

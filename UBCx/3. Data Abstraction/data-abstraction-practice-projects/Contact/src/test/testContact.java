package test;

import model.Contact;
import model.ContactType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testContact {

    Contact testContact1;
    Contact testContact2;

    @Before
    public void SetUp() {
        testContact1 = new Contact("Tester 1");
        testContact1.setNumber("123456");
        testContact1.setType(ContactType.WORK);

        testContact2 = new Contact("Tester 2");
        testContact2.setNumber("654321");
        testContact2.setType(ContactType.FAMILY);
    }

    @Test
    public void testAutomateResponse(){
        assertEquals(testContact1.automateResponse(), "I'll get back to you at work.");
        assertEquals(testContact2.automateResponse(), "See you at home.");
    }
}

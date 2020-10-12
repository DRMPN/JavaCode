package test;

import model.Call;
import model.Cellphone;
import model.Person;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testCall{

    Person testPerson;
    Cellphone testPhone;
    Call testCall;

    @Before
    public void setUp() {
        testPerson = new Person("James");
        testPhone = new Cellphone(testPerson,660099);
        testCall = new Call(testPhone);
    }

    @Test
    public void testCallandPhone() {
        assertEquals(testPhone.getRecentCalls().size(), 1);
        assertEquals(testPhone, testCall.getTrace());
        Call testCallTwo = new Call(testPhone);
        assertEquals(testPhone.getRecentCalls().size(), 2);
    }


}

package test;

import model.Task;
import model.Todo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TaskTest {

    private Task t;
    Todo td1;
        Todo td21;
        Todo td22;
            Task t211;
            Task t212;
            Task t213;
        Todo td23;
            Task t231;
            Task t232;


    @Before
    public void setUp() {
        t = new Task("Get a coffee", "08/16/2017", "JJ Bean");
        td1 = new Todo("Throw party");
            td21 = new Todo("Send out invitations");
            td22 = new Todo("Get cake ingredients");
                t211 = new Task("Buy flour", "09/12/2017","Whole Foods");
                t212 = new Task("Get a new cake tin","09/13/2017","Williams Sonoma");
                t213 = new Task("Buy a dozen eggs","09/12/2017","Farmer's market");
            td23 = new Todo("Bake cake and food");
                t231 = new Task("Mix flour","09/14/2017","Anna's house");
                t232 = new Task("Grill fillet of sole","09/14/2017","Anna's grill");

        td22.addDoable(t211);
        td22.addDoable(t212);
        td22.addDoable(t213);
        td23.addDoable(t231);
        td23.addDoable(t232);
        td1.addDoable(td21);
        td1.addDoable(td22);
        td1.addDoable(td23);
    }

    @Test
    public void testGetters() {
        assertEquals(t.getDate(), "08/16/2017");
        assertEquals(t.getLocation(), "JJ Bean");
        assertEquals(t.getDescription(), "Get a coffee on 08/16/2017 @JJ Bean");
    }

    @Test
    public void testSetters() {
        assertEquals(t.getDate(), "08/16/2017");
        t.setDate("09/16/2017");
        assertEquals(t.getDate(), "09/16/2017");
        assertEquals(t.getLocation(), "JJ Bean");
        t.setLocation("Starbucks");
        assertEquals(t.getLocation(), "Starbucks");
    }

    @Test
    public void testcomplete() {
        assertFalse(t.getStatus());
        t.complete();
        assertTrue(t.getStatus());
        td1.display(" ");
    }


}
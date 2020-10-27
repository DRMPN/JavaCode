package test;

import model.Movie;
import model.MovieGoer;
import model.Ticket;
import model.TicketKiosk;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovieGoerTest {

    private Movie m1, m2;
    private MovieGoer mg1, mg2;
    private Ticket t1, t2;
    private TicketKiosk tk;

    @Before
    public void setUp() {
        tk = new TicketKiosk("Scotiabank Theatre");
        mg1 = new MovieGoer("Tom Hanks", 28, tk);
        mg2 = new MovieGoer("Sarah Johnson", 17, tk);
        m1 = new Movie("Arrival", 19, 50);
        m2 = new Movie("Ratatouille", 0, 100);
        t1 = new Ticket(m1);
        t2 = new Ticket(m2);
    }

    @Test
    public void testGetters() {
        assertEquals(mg1.getName(),"Tom Hanks");
        assertEquals(mg2.getName(),"Sarah Johnson");
        assertEquals(mg1.getAge(),28);
        assertEquals(mg2.getAge(),17);
        assertEquals(mg1.getTicketKiosk(), tk);
        assertEquals(mg2.getTicketKiosk(), tk);
    }

    @Test
    public void testBuyTicketNoUnderAgeException() {
        assertTrue(tk.sellTicket(mg1,m1));
        assertTrue(tk.sellTicket(mg2,m2));
    }

    @Test
    public void testBuyTicketUnderAgeException() {
        assertFalse(tk.sellTicket(mg2,m1));
    }


    @Test
    public void testBuyTicketNoShowingFullException() {
        for (int i = 0; i < 49; i++) {
            tk.sellTicket(mg1,m1);
        }
        assertTrue(tk.sellTicket(mg1,m1));
    }

    @Test
    public void testBuyTicketShowingFullException() {
        for (int i = 0; i < 100; i++) {
            tk.sellTicket(mg2,m2);
        }
        assertFalse(tk.sellTicket(mg2,m2));
    }


}
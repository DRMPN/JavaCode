public class Movie {

    public static int movie(int card, int ticket, double perc) {
        int count = 0;
        double priceA = 0;
        double priceB = card;
        double ticketB = ticket;

        do {
            ticketB = ticketB * perc;
            priceA += ticket;
            priceB += ticketB;
            count++;
        } while (Math.ceil(priceB) >= priceA);

        return count;
    }
}
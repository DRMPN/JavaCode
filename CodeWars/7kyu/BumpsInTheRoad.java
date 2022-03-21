public class BumpsTheRoad {
    public static String bumps(final String road) {
        return road.replace("_", "").length() > 15 ? "Car Dead" : "Woohoo!";
    }
}
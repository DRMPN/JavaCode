import java.util.ArrayList;

class Metro {

  public static int countPassengers(ArrayList<int[]> stops) {
      var ppl = 0;
      for (int i = 0; i < stops.size(); i++) {
        ppl += stops.get(i)[0];
        ppl -= stops.get(i)[1];
      }
      return ppl;
  }
}
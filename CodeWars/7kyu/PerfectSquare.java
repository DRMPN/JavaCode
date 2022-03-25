import java.util.*;

public class Square {    
    public static boolean isSquare(int n) {
        return n >= 0 ? Math.sqrt(n) % 1 == 0 : false;
    }
}
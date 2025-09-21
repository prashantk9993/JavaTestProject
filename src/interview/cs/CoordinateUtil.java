package interview.cs;

import java.util.*;

public class CoordinateUtil {

    private CoordinateUtil() { 
        // private constructor to prevent instantiation
    }

    // Thread-safe immutable list of points
    public static final List<Point> COORDINATES = Collections.unmodifiableList(
        Arrays.asList(
            new Point(2, 3),
            new Point(5, 5),
            new Point(1, 1),
            new Point(7, 8),
            new Point(-1, -3),
            new Point(10, -2),
            new Point(4, 9)
        )
    );
}

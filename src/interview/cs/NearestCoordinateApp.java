package interview.cs;

public class NearestCoordinateApp {
    public static void main(String[] args) {
        Point target = new Point(3, 4);

        NearestNeighborService service = NearestNeighborService.getInstance();
        Point nearest = service.findNearest(target, CoordinateUtil.COORDINATES);

        System.out.println("Target: " + target);
        System.out.println("Nearest: " + nearest);
    }
}

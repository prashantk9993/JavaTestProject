package interview.cs;

import java.util.*;

public class NearestNeighborService {
    private static volatile NearestNeighborService instance;

    private NearestNeighborService() { }

    public static NearestNeighborService getInstance() {
        if (instance == null) {
            synchronized (NearestNeighborService.class) {
                if (instance == null) {
                    instance = new NearestNeighborService();
                }
            }
        }
        return instance;
    }

    private double calculateDistance(Point a, Point b) {
        return Math.sqrt(
            Math.pow(a.getX() - b.getX(), 2) +
            Math.pow(a.getY() - b.getY(), 2)
        );
    }

    public Point findNearest(Point target, List<Point> candidates) {
        if (candidates == null || candidates.isEmpty()) {
            throw new IllegalArgumentException("Candidate list is empty");
        }

        Point nearest = null;
        double minDist = Double.MAX_VALUE;

        for (Point candidate : candidates) {
            double dist = calculateDistance(target, candidate);
            if (dist < minDist) {
                minDist = dist;
                nearest = candidate;
            }
        }
        return nearest;
    }
}

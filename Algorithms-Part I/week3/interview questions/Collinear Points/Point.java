import edu.princeton.cs.algs4.StdDraw;

import java.util.Comparator;

public class Point implements Comparable<Point> {
    private final int x;
    private final int y;

    private class PointComparator implements Comparator<Point> {
        public int compare(Point a, Point b) {
            double aSlope = slopeTo(a);
            double bSlope = slopeTo(b);
            if (aSlope < bSlope) return -1;
            if (bSlope > aSlope) return 1;
            return 0;
        }
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw() {
        StdDraw.point(x, y);
    }

    public void drawTo(Point that) {
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public int compareTo(Point that) {
        if (this.y > that.y) {
            return 1;
        } else if (this.y == that.y) {
            if (this.x > that.x) {
                return 1;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }

    public double slopeTo(Point that) {
        if (this.x == that.x) {
            if (this.y == that.y) {
                return Double.NEGATIVE_INFINITY;
            }
            return Double.POSITIVE_INFINITY;
        } else if (this.y == that.y) {
            return +0.0;
        }
        return (double) (that.y - this.y) / (double) (that.x - this.x);
    }

    public Comparator<Point> slopeOrder() {
        return new PointComparator();
    }
}

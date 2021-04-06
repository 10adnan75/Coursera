import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;

public class BruteCollinearPoints {
    private LineSegment[] lineSegments;

    public BruteCollinearPoints(Point[] points) {
        if (isNull(points)) throw new NullPointerException();
        Point[] copyPoints = Arrays.copyOf(points, points.length);
        Arrays.sort(copyPoints);
        if (isDuplicate(copyPoints)) throw new IllegalArgumentException();
        int length = copyPoints.length;
        ArrayList<LineSegment> ls = new ArrayList<>();
        for (int p = 0; p < length - 3; p++)
            for (int q = p + 1; q < length - 2; q++)
                for (int r = q + 1; r < length - 1; r++)
                    for (int s = r + 1; s < length; s++) {
                        if (copyPoints[p].slopeTo(copyPoints[q]) == copyPoints[p].slopeTo(copyPoints[r]) && copyPoints[p].slopeTo(copyPoints[q]) == copyPoints[p].slopeTo(copyPoints[s])) {
                            LineSegment tempLineSegment = new LineSegment(copyPoints[p], copyPoints[s]);
                            if (!ls.contains(tempLineSegment)) ls.add(tempLineSegment);
                        }
                    }
        lineSegments = ls.toArray(new LineSegment[ls.size()]);
    }

    public int numberOfSegments() {
        return lineSegments.length;
    }

    public LineSegment[] segments() {
        return Arrays.copyOf(lineSegments, lineSegments.length);
    }

    private boolean isNull(Point[] points) {
        if (points == null) return true;
        for (Point p : points) {
            if (p == null) return true;
        }
        return false;
    }

    private boolean isDuplicate(Point[] points) {
        for (int i = 0; i < points.length - 1; i++) {
            if (points[i].compareTo(points[i + 1]) == 0) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}

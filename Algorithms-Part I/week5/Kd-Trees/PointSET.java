import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.SET;

public class PointSET {

    private SET<Point2D> points;

    public PointSET() {
        points = new SET<>();
    }

    public boolean isEmpty() {
        return points.isEmpty();
    }

    public int size() {
        return points.size();
    }

    public void insert(Point2D p) {
        if (p == null) throw new NullPointerException("couldn't insert a null point");
        points.add(p);
    }

    public boolean contains(Point2D p) {
        if (p == null) throw new NullPointerException("couldn't check a null point");
        return points.contains(p);
    }

    public void draw() {
        for (Point2D point2D : points) {
            point2D.draw();
        }
    }

    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null) throw new NullPointerException("couldn't infer an empty rectangle");
        Queue<Point2D> range = new Queue<>();
        for (Point2D point2D : points) {
            if (rect.contains(point2D)) {
                range.enqueue(point2D);
            }
        }
        return range;
    }

    public Point2D nearest(Point2D p) {
        if (p == null) throw new NullPointerException("couldn't check a null point");
        if (isEmpty()) return null;
        Point2D nearest = null;
        for (Point2D point2D : points) {
            if (nearest == null || (p.distanceTo(point2D) < p.distanceTo(nearest))) {
                nearest = point2D;
            }
        }
        return nearest;
    }

    public static void main(String[] args) {

    }
}

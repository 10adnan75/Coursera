import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;

public class KdTree {
    private static final int VERTICAL = 1;
    private static final int HORIZONTAL = 0;
    private Node root;
    private int size;

    private static class Node {
        private Point2D point2D;
        private int div;
        private Node left, right;

        private Node(Point2D point2D) {
            this.point2D = point2D;
            left = null;
            right = null;
        }
    }

    public KdTree() {
        root = null;
        size = 0;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return size;
    }

    public void insert(Point2D p) {
        if (p == null) throw new NullPointerException("couldn't insert a null point");
        if (!contains(p)) {
            Node node = new Node(p);
            root = insertNode(node, root);
            size++;
        }
    }

    public boolean contains(Point2D p) {
        if (p == null) throw new NullPointerException("couldn't check a null point");
        Node curr = root;
        while (true) {
            if (curr == null) return false;
            if (curr.point2D.equals(p)) return true;
            if (isLessThanPoint(p, curr.point2D, curr.div)) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    public void draw() {
        drawNode(root, 0, 1, 0, 1);
    }

    public Iterable<Point2D> range(RectHV rectHV) {
        if (rectHV == null) throw new NullPointerException("couldn't infer an empty rectangle");
        Queue<Point2D> range = new Queue<>();
        rangeNode(root, rectHV, range);
        return range;
    }

    public Point2D nearest(Point2D p) {
        if (p == null) throw new NullPointerException("couldn't check a null point");
        if (isEmpty()) return null;
        return nearestNode(p, root, root.point2D);
    }

    private Node insertNode(Node node, Node parentNode) {
        if (parentNode == null) {
            node.div = VERTICAL;
            return node;
        }

        if (isLessThanPoint(node.point2D, parentNode.point2D, parentNode.div)) {
            if (parentNode.left == null) {
                node.div = getDivisionByNode(parentNode);
                parentNode.left = node;
            } else {
                parentNode.left = insertNode(node, parentNode.left);
            }
        } else {
            if (parentNode.right == null) {
                node.div = getDivisionByNode(parentNode);
                parentNode.right = node;
            } else {
                parentNode.right = insertNode(node, parentNode.right);
            }
        }
        return parentNode;
    }

    private void drawNode(Node node, double minX, double maxX, double minY, double maxY) {
        if (node == null) return;
        drawPoint(node.point2D);
        drawDivision(node, minX, maxX, minY, maxY);
        if (node.div == VERTICAL) {
            drawNode(node.left, minX, node.point2D.x(), minY, maxY);
            drawNode(node.right, node.point2D.x(), maxX, minY, maxY);
        } else {
            drawNode(node.left, minX, maxX, minY, node.point2D.y());
            drawNode(node.right, minX, maxX, node.point2D.y(), maxY);
        }
    }

    private void drawPoint(Point2D point) {
        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(StdDraw.BLACK);
        point.draw();
    }

    private void drawDivision(Node node, double minX, double maxX, double minY, double maxY) {
        StdDraw.setPenRadius();
        if (node.div == VERTICAL) {
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.line(node.point2D.x(), minY, node.point2D.x(), maxY);
        } else {
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.line(minX, node.point2D.y(), maxX, node.point2D.y());
        }
    }

    private void rangeNode(Node node, RectHV rect, Queue<Point2D> range) {
        if (node == null) return;
        if (rect.contains(node.point2D)) {
            range.enqueue(node.point2D);
        }
        if (node.div == VERTICAL) {
            if (node.point2D.x() > rect.xmin()) {
                rangeNode(node.left, rect, range);
            }
            if (node.point2D.x() <= rect.xmax()) {
                rangeNode(node.right, rect, range);
            }
        } else {
            if (node.point2D.y() > rect.ymin()) {
                rangeNode(node.left, rect, range);
            }
            if (node.point2D.y() <= rect.ymax()) {
                rangeNode(node.right, rect, range);
            }
        }
    }

    private Point2D nearestNode(Point2D point, Node node, Point2D nearest) {
        if (node == null) return nearest;
        if (node.point2D.distanceTo(point) < nearest.distanceTo(point)) {
            nearest = node.point2D;
        }

        Point2D nearestPossibleFromAnotherNode;
        Node morePrioritizedNode;
        Node lessPrioritizedNode;

        if (node.div == VERTICAL) {
            nearestPossibleFromAnotherNode = new Point2D(node.point2D.x(), point.y());
            if (point.x() < node.point2D.x()) {
                morePrioritizedNode = node.left;
                lessPrioritizedNode = node.right;
            } else {
                morePrioritizedNode = node.right;
                lessPrioritizedNode = node.left;
            }
        } else {
            nearestPossibleFromAnotherNode = new Point2D(point.x(), node.point2D.y());
            if (point.y() < node.point2D.y()) {
                morePrioritizedNode = node.left;
                lessPrioritizedNode = node.right;
            } else {
                morePrioritizedNode = node.right;
                lessPrioritizedNode = node.left;
            }
        }

        nearest = nearestNode(point, morePrioritizedNode, nearest);

        if (nearestPossibleFromAnotherNode.distanceTo(point) < nearest.distanceTo(point)) {
            nearest = nearestNode(point, lessPrioritizedNode, nearest);
        }

        return nearest;
    }

    private int getDivisionByNode(Node node) {
        if (node.div == VERTICAL) {
            return HORIZONTAL;
        }
        return VERTICAL;
    }

    private boolean isLessThanPoint(Point2D nodePoint, Point2D rootPoint, int division) {
        if (division == VERTICAL) {
            return nodePoint.x() < rootPoint.x();
        }
        return nodePoint.y() < rootPoint.y();
    }

    public static void main(String[] args) {

    }
}

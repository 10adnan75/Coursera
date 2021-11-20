class Solution<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private int count;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        }
        return x.count < 0;
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        }
        return Math.abs(x.count);
    }

    private Node rotateLeft(Node h) {
        if (h == null) {
            return null;
        }
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.count = h.count;
        h.count = -Math.abs(1 + size(h.left) + size(h.right));
        return x;
    }

    private Node rotateRight(Node h) {
        if (h == null) {
            return null;
        }
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.count = h.count;
        h.count = -Math.abs(1 + size(h.left) + size(h.right));
        return x;
    }

    private void flipColors(Node h) {
        if (h == null) {
            return;
        }
        h.count = -h.count;
        h.left.count = -h.left.count;
        h.right.count = -h.right.count;
    }
    
    public static void main (String[] args) {
        
    }
}

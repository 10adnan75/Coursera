class Solution {
    private int N;
    private Node data;
    private Node max;

    private class Node {
        private double item;
        private Node next;
    }

    public Solution() {
        this.N = 0;
        this.data = null;
        this.max = null;
    }

    public double getMax() {
        return max.item;
    }

    public void push(double item) {
        Node oldFirst = data;
        data = new Node();
        data.item = item;
        data.next = oldFirst;
        N++;
        if (item >= getMax()) {
            Node oldMax = max;
            max = new Node();
            max.next = oldMax;
        }
    }

    public double pop() {
        double temp = data.item;
        data = data.next;
        N--;
        if (temp == getMax()) {
            max = max.next;
        }
        return temp;
    }
    
    public static void main (String[] args) {
        
    }
}

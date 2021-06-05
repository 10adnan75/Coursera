import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.util.Comparator;

public class Solver {
    private Node finalNode;
    private boolean solvable;

    private static class Node {
        private Board board;
        private Node previous;

        public Node(Board board, Node previous) {
            this.board = board;
            this.previous = previous;
        }
    }

    public Solver(Board initial) {
        Comparator<Node> nodeComparator = (o1, o2) -> o1.board.manhattan() + numOfMoves(o1) - o2.board.manhattan() - numOfMoves(o2);
        MinPQ<Node> pq = new MinPQ<>(nodeComparator);
        MinPQ<Node> pqTwin = new MinPQ<>(nodeComparator);
        solvable = false;
        Node node = new Node(initial, null);
        Node nodeTwin = new Node(initial.twin(), null);
        pq.insert(node);
        pqTwin.insert(nodeTwin);
        node = pq.delMin();
        nodeTwin = pqTwin.delMin();
        while (!node.board.isGoal() && !nodeTwin.board.isGoal()) {
            for (Board board : node.board.neighbors()) {
                if (node.previous == null || !board.equals(node.previous.board)) {
                    Node neighbour = new Node(board, node);
                    pq.insert(neighbour);
                }
            }
            for (Board boardTwin : nodeTwin.board.neighbors()) {
                if (nodeTwin.previous == null || !boardTwin.equals(nodeTwin.previous.board)) {
                    Node neighbour = new Node(boardTwin, nodeTwin);
                    pqTwin.insert(neighbour);
                }
            }
            node = pq.delMin();
            nodeTwin = pqTwin.delMin();
        }
        if (node.board.isGoal()) {
            solvable = true;
            finalNode = node;
        }
    }

    public boolean isSolvable() {
        return solvable;
    }

    public int moves() {
        if (!solvable) return -1;
        Node curr = finalNode;
        int moves = 0;
        while (curr.previous != null) {
            moves++;
            curr = curr.previous;
        }
        return moves;
    }

    private static int numOfMoves(Node node) {
        int moves = 0;
        Node curr = node;
        while (curr.previous != null) {
            moves++;
            curr = curr.previous;
        }
        return moves;
    }

    public Iterable<Board> solution() {
        if (!solvable) return null;
        Node curr = finalNode;
        Stack<Board> boards = new Stack<>();
        boards.push(curr.board);
        while (curr.previous != null) {
            boards.push(curr.previous.board);
            curr = curr.previous;
        }
        return boards;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] tiles = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                tiles[i][j] = in.readInt();
        Board initial = new Board(tiles);
        Solver solver = new Solver(initial);
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }
}

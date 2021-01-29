import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private static final int TOP = 0;
    private final boolean[][] opened;
    private final int size;
    private final int bottom;
    private int openSites;
    private final WeightedQuickUnionUF qf;

    public Percolation(int n) {
        size = n;
        bottom = size * size + 1;
        qf = new WeightedQuickUnionUF(size * size + 2);
        opened = new boolean[size][size];
        openSites = 0;
    }

    public void open(int row, int col) {
        opened[row - 1][col - 1] = true;
        ++openSites;
        if (row == 1)
            qf.union(getQuickFindIndex(row, col), TOP);
        if (row == size)
            qf.union(getQuickFindIndex(row, col), bottom);
        if (row > 1 && isOpen(row - 1, col))
            qf.union(getQuickFindIndex(row, col), getQuickFindIndex(row - 1, col));
        if (row < size && isOpen(row + 1, col))
            qf.union(getQuickFindIndex(row, col), getQuickFindIndex(row + 1, col));
        if (col > 1 && isOpen(row, col - 1))
            qf.union(getQuickFindIndex(row, col), getQuickFindIndex(row, col - 1));
        if (col < size && isOpen(row, col + 1))
            qf.union(getQuickFindIndex(row, col), getQuickFindIndex(row, col + 1));
    }

    public boolean isOpen(int row, int col) {
        return opened[row - 1][col - 1];
    }

    public int numberOfOpenSites() {
        return openSites;
    }

    public boolean isFull(int row, int col) {
        return qf.find(TOP) == qf.find(getQuickFindIndex(row, col));
    }

    private int getQuickFindIndex(int row, int col) {
        return size * (row - 1) + col;
    }

    public boolean percolates() {
        return qf.find(TOP) == qf.find(bottom);
    }

}

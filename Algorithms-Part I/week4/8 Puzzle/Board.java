import edu.princeton.cs.algs4.Stack;

public class Board {
    private final int size;
    private final int[][] data;

    public Board(int[][] tiles) {
        this.size = tiles.length;
        this.data = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                this.data[row][col] = tiles[row][col];
            }
        }
    }

    public String toString() {
        String toStr = dimension() + "\n";
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                toStr += data[row][col];
                toStr += " ";
            }
            toStr += "\n";
        }
        return toStr;
    }

    public int dimension() {
        return size;
    }

    public int hamming() {
        int hammingValue = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == size - 1 && j == size - 1) break;
                if (data[i][j] != i * size + j + 1) hammingValue++;
            }
        }
        return hammingValue;
    }

    public int manhattan() {
        int manhattanValue = 0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (data[row][col] == 0) continue;
                int i = (data[row][col] - 1) / size;
                int j = (data[row][col] - 1) % size;
                manhattanValue += Math.abs(row - i) + Math.abs(col - j);
            }
        }
        return manhattanValue;
    }

    public boolean isGoal() {
        int num = 1;
        if (data[size - 1][size - 1] != 0) return false;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (data[row][col] == 0) break;
                if (data[row][col] != num) return false;
                num++;
            }
        }
        return true;
    }

    public boolean equals(Object y) {
        if (y == null || y.getClass() != getClass()) return false;
        if (y == this) return true;
        Board that = (Board) y;
        if (that.dimension() != this.dimension()) return false;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (this.data[i][j] != (that.data)[i][j]) return false;
            }
        }
        return true;
    }

    public Iterable<Board> neighbors() {
        Stack<Board> stack = new Stack<>();
        int row = 0, col = 0;
        int[][] tempData = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                tempData[i][j] = data[i][j];
                if (data[i][j] == 0) {
                    row = i;
                    col = j;
                }
            }
        }
        if (col > 0) {
            exch(tempData, row, col, row, col - 1);
            stack.push(new Board(tempData));
            exch(tempData, row, col, row, col - 1);
        }
        if (col < size - 1) {
            exch(tempData, row, col, row, col + 1);
            stack.push(new Board(tempData));
            exch(tempData, row, col, row, col + 1);
        }
        if (row > 0) {
            exch(tempData, row, col, row - 1, col);
            stack.push(new Board(tempData));
            exch(tempData, row, col, row - 1, col);
        }
        if (row < size - 1) {
            exch(tempData, row, col, row + 1, col);
            stack.push(new Board(tempData));
            exch(tempData, row, col, row + 1, col);
        }
        return stack;
    }

    private void exch(int[][] a, int i, int j, int p, int q) {
        int swap = a[i][j];
        a[i][j] = a[p][q];
        a[p][q] = swap;
    }

    public Board twin() {
        Board twinBoard = new Board(data);
        if (twinBoard.data[0][0] == 0) {
            exch(twinBoard.data, 1, 0, 1, 1);
        } else if (twinBoard.data[0][1] == 0) {
            exch(twinBoard.data, 1, 0, 1, 1);
        } else {
            exch(twinBoard.data, 0, 0, 0, 1);
        }
        return twinBoard;
    }
}

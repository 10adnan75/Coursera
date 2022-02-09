import java.util.Stack;

class Solution {
    Stack<Integer> stack1, stack2;

    public Solution() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enQueue(int data) {
        stack1.push(data);
    }

    public int deQueue() {
        stackExchange();
        return stack2.pop();
    }

    public int peek() {
        stackExchange();
        return stack2.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public void stackExchange() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i=1; i<11; i++) solution.enQueue(i);
        while (!solution.isEmpty()) System.out.print(solution.deQueue() + " ");
    }
}

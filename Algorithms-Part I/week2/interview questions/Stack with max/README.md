**Question:**

Create a data structure that efficiently supports the stack operations (push and pop) and also a return-the-maximum operation. Assume the elements are real numbers so that you can compare them.

---

**Answer:**

The numbers are stored in one stack, while the _max-so-far_ is kept in the other. Time complexity of the _push_ operation is _O(1)_. Time complexity of the _getMax_ function is _O(1)_. The space complexity of the data structure is double that of a standard stack, although it is still _O(N)_.

Algorithm:

    public class StackArray<E> 
        private E[] stack
        private int N

        public StackArray() 
            stack = (E[]) new Object[1]
            N = 0;

        public boolean isEmpty() 
            return N == 0

        public int size() 
            return N

        public void resize(int capacity) 
            E[] newStack = (E[]) new Object[capacity]
            for i = 0 to N do:
                newStack[i] = stack[i]
            end for
            stack = newStack
            return

        public void push(E data) 
            stack[N++] = data
            if N == stack.length then:
                resize(stack.length*2)
            end if
            return

        public E pop() 
            E data = stack[--N]
            stack[N] = null
            if N > 0 and N == stack.length/4 then:
                resize(stack.length/2)
            end if
            return data

        public int getMax() 
            int copySize = N, max = 0
            while copySize-- > 0 do:
                if stack[copySize] > max then:
                    max = stack[copySize]
                end if
            end while
            return max

        public static void main(String[] args) // client
        
References:

+ [StackWithMax.java](https://github.com/10adnan75/DSA/blob/main/Algorithms/Stacks/StackWithMax.java)

**Question:**

Create a data structure that efficiently supports the stack operations (push and pop) and also a return-the-maximum operation. Assume the elements are real numbers so that you can compare them.

---

**Answer:**

The numbers are stored in one stack, while the _max-so-far_ is kept in the other. Time complexity of the _push_ operation is _O(1)_. Time complexity of the _getMax_ function is _O(1)_. The space complexity of the data structure is double that of a standard stack, although it is still _O(N)_.

Algorithm:

    public void push(double item) 
        Node oldFirst = data
        data = new Node()
        data.item = item
        data.next = oldFirst
        N++
        if item >= getMax() then:
            Node oldMax = max
            max = new Node()
            max.next = oldMax
        end if

    public double pop() 
        double temp = data.item
        data = data.next
        N--
        if temp == getMax() then:
            max = max.next
        end if
        return temp

    public double getMax() 
        return max.item

References:

+ [StackWithMax.java](https://github.com/10adnan75/DSA/blob/main/Algorithms/Stacks/StackWithMax.java)

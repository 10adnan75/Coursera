**Question:**

Implement a queue with two stacks so that each queue operations takes a constant amortized number of stack operations.

---

**Answer:** 

Generate two stacks, one for enqueueing and the other for dequeuing. Push all components from the very first stack into the second stack if enqueue is invoked. Pop out of the second stack if dequeue is called. _FIFO_ operation will be performed. The stack procedure would eventually be reversed, resulting in a queue (FIFO).

Algorithm:

    // initialization of the stacks
    Stack<Integer> stack1, stack2
    
    // enqueue
    stack1.push(data)
    
    // dequeue
    if (stack2.isEmpty()) then:
        while not stack1.isEmpty() do:
            stack2.push(stack1.pop())
        end while
    end if
    return stack2.pop()
    
References:

+ [QueueWithStacks.java](https://github.com/10adnan75/DSA/blob/main/Data%20Structures/Stacks/QueueWithStacks.java)

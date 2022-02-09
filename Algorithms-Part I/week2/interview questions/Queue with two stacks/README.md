**Question:**

Implement a queue with two stacks so that each queue operations takes a constant amortized number of stack operations.

---

**Answer:** 

Generate two stacks, one for enqueueing and the other for dequeuing. Push all components from the very first stack into the second stack if enqueue is invoked. Pop out of the second stack if dequeue is called. _FIFO_ operation will be performed. The stack procedure would eventually be reversed, resulting in a queue (FIFO).

Algorithm:

    add
    
References:

+ []()

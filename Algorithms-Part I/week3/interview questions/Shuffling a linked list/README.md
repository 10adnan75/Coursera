**Question:**

Given a singly-linked list containing n items, rearrange the items uniformly at random. Your algorithm should consume a logarithmic (or constant) amount of extra memory and run in time proportional to nlogn in the worst case. 

---

**Answer:**

The solution is divided into two phases: first, partition the list in half; second, shuffle the elements altogether. Splitting the list in two is more difficult than it appears; you must locate the halfway and break the link that connects the first and second halves. This can be accomplished in a variety of ways.

One simple method is to count the number of elements in the list, then scan halfway through the list, breaking the last link followed.

It is possible to iteratively interleave the lists. We'll preserve a pointer to the list's last element so that we can keep adding to it. This will result in the first member of the new, interleaved list being returned.

Algorithm:

    class ShuffleLinkedList 
        private Node head
        private int size

        private class Node 
            int data
            Node next

            public Node(int data) 
                this.data = data

        public void add(int data) 
            if head == null then:
                head = new Node(data)
            else:
                Node curr = head
                while curr.next != null do: 
                    curr = curr.next
                end while
                curr.next = new Node(data)
                size = size + 1
            end if

        public void shuffle() 
            if this.head == null then:
                return
            end if
            Node half = splitAtHalf(head)
            interleave(head, half)
            head = half

        public Node splitAtHalf(Node first) 
            Node fast = first
            while fast.next.next != null do:
                fast = fast.next.next
                first = first.next
            end while
            Node result = first.next
            first.next = null
            return result

        public void interleave(Node first, Node second) 
            Node tail = null
            while second != null do:
                if tail == null then: 
                    tail = second
                else:
                    tail.next = second
                end if
                Node next = second.next
                second.next = first
                second = next
                tail = first
                next = first.next
                first.next = null
                first = next
            end while
    
References:

+ [ShuffleLL.java](https://github.com/10adnan75/DSA/blob/main/Algorithms/Linked%20lists/ShuffleLL.java)
+ [ListShuffling](https://web.stanford.edu/class/cs9/sample_probs/ListShuffling.pdf)

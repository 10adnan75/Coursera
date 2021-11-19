**Question:** 

Design an algorithm that takes a sequence of n document words and a sequence of m query words and find the shortest interval in which the m query words appear in the document in the order given. The length of an interval is the number of words in that interval.

---

**Answer:**

Best data structure to use: [Queue](https://github.com/10adnan75/DSA/blob/main/Data%20Structures/Queues/QueueLL.java)

Algorithm:

    read document
    initialize a symbol table for word occurences
    bestLo = -1, bestHi = words.length
    read query
    create new queues()
    for i = 0 to query.length do
        queues[i] = st[query[i]]
    end for
    start = st[query[0]]
    for i = 0 to start.length do
        end = true
        lo = i, hi = lo
        for j = 1 to queues.length do
            while queues[j].peek() <= hi do
                queues[j].dequeue()
            end while
            if queues[j] = null 
                end = false
                break
            else
                hi = queues[j].peek()
            end if
        end for
        if end = true and hi - lo < bestHi - bestLo
            bestHi = hi
            bestLo = lo
        end if
    end for
    if bestLo >= 0
        interval = bestHi - bestLo
        print interval
    end if    
    
References:

+ [ST.java](https://github.com/10adnan75/DSA/blob/main/Data%20Structures/Symbol%20tables/ST.java)

**Question:**

Given a social network containing n members and a log file containing m timestamps at which times pairs of members formed friendships, design an algorithm to determine the earliest time at which all members are connected (i.e., every member is a friend of a friend of a friend ... of a friend). Assume that the log file is sorted by timestamp and that friendship is an equivalence relation. The running time of your algorithm should be mlogn or better and use extra space proportional to n.

---

**Answer:**

Implement union-find algorithm. Use weighted union find, and for each log from earliest to oldest, union the two people, check if all the union find count is 1.

Algorithm:

    public class SocialNetwork 
        private WeightedQuickUnionUF uf
        private int total
        
        public static class Log 
            private final long timestamp
            private final int peopleA
            private final int peopleB

            public Log(long timestamp, int peopleA, int peopleB) 
                this.timestamp = timestamp
                this.peopleA = peopleA
                this.peopleB = peopleB
                
        
        public static long earliestTimeToConnectAllMember(int n, List<Log> sortedTimeStampLog) 
            if n = 1 
                return 0
            end if
            WeightedQuickUnionUF uf = new WeightedQuickUnionUF(n)
            for Log log : sortedTimeStampLog
                uf.union(log.peopleA, log.peopleB)
                if uf.count() = 1 
                    return log.timestamp
                end if
            end for
            return -1
  
References:

+ [WeightedQuickUnionUF.java](https://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/WeightedQuickUnionUF.java.html)

**Question:** 

Describe how to save the memory for storing the color information when implementing a red–black BST. 

---

**Answer:**

Modifying the RedBlackBST would do the work for us. If it's an internal node, reverse the left and right child to mark it red. If it's a leaf node, make its left and right child point to itself to mark it red, otherwise let it be null.

API:

    class RedBlackBSTNoExtraColoringMemory {
        private Node root;
        
        private class Node {
            private Key key;
            private Value value;
            private Node left, right;
            private int count;
            
            public Node(Key key, Value value) {
                this.key = key; 
                this.value = value;
            }
        }
        
        private boolean isRed(Node x) {
            return x.count < 0;
        }
        
        private Node rotateLeft(Node h) {
            Node x = h.right;
            h.right = x.left;
            x.left = h;
            x.count = h.count;
            h.count = -Math.abs(1 + size(h.left) + size(h.right));
            return x;
        }
        
        private Node rotateRight(Node h) {
            Node x = h.left;
            h.left = x.right;
            x.right = h;
            x.count = h.count;
            h.count = -Math.abs(1 + size(h.left) + size(h.right));
            return x;
        }
        
        private void flipColors(Node h) {
            h.count = -h.count;
            h.left.count = -h.left.count;
            h.right.count = -h.right.count;
        }
    }

References:

+ [Stackoverflow](https://stackoverflow.com/questions/16088364/how-to-save-the-memory-when-storing-color-information-in-red-black-trees)
+ [2-3 Balanced Search Tree](https://github.com/10adnan75/DSA/blob/main/Data%20Structures/Trees/RedBlackBST.java)

**Question:**

Explain why Java prohibits generic array creation.

---

**Answer:**

In Java, creating generic arrays is forbidden because the runtime would encounter a safety check fault since determining the type of array would be difficult.

Consider the following code:

    public class GenericArrayTrial<E> { 
        public <E> E[] getArray() { 
            return new E[7];    
        } 
    }   

A _'generic array creation'_ error occurs as a result of this. The compiler cannot assign a run-time type to the array created because arrays do not support type erasure as well as the parametrized type E does not exist at run-time.

References:

+ [Why is Generic Array Creation not Allowed in Java?](https://www.tothenew.com/blog/why-is-generic-array-creation-not-allowed-in-java/)
+ [stack overflow](https://stackoverflow.com/questions/2927391/whats-the-reason-i-cant-create-generic-array-types-in-java#:~:text=Arrays%20of%20generic%20types%20are%20not%20%20allowed,are%20statically%20%20sound%20and%20not%20dynamically%20checked.)
+ [Quora](https://www.quora.com/Why-does-Java-prohibit-generic-array-creation)

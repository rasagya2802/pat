package Day3;

public class QueueWithStack {
    // Implementing a queue using two stacks
    // Stack 1 is used for enqueue operation
    // Stack 2 is used for dequeue operation
    // Enqueue operation: push the element onto stack 1
    // Dequeue operation: if stack 2 is empty, pop all elements from stack 1 and push them onto stack 2, then pop the top element from stack 2  
    // Time complexity: O(1) for enqueue, O(n) for dequeue in the worst case, but O(1) amortized time for dequeue
    // Space complexity: O(n) for the two stacks combined

}

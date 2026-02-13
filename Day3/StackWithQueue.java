package Day3;

public class StackWithQueue {
    // 2 ways, you can use 2 queues, or 1 queue.
    // 2 queues: push to the empty queue, then move all elements from the other queue to this queue. O(n) for push, O(1) for pop.
    // 1 queue: push to the queue, then for pop, move all elements except the last one to the back of the queue, then pop the last one. O(1) for push, O(n) for pop.    
    // space complexity: O(n) for the queue.
}

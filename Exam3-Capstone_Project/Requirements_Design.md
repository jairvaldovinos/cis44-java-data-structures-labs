

## Problem

In some systems, tasks shouldn’t be done in the order they come in. Instead, the more important ones should go first. A good example is an emergency room, where serious cases are handled before minor ones. So the problem is how to organize tasks so that higher-priority ones are always handled first.



## Design Choice

To solve this problem, I chose to use a Max-Heap. A Max-Heap is useful because it always keeps the highest value at the top. This means the most important task is always easy to access and remove without having to search through everything.



## Trade-Off

I considered using a regular list or array, since it is very simple and allows tasks to be added quickly. However, the downside is that finding the highest-priority task would require checking every element, which takes O(n) time. In contrast, a Max-Heap takes a bit more work when adding elements, since it needs to maintain its structure, but it allows both inserting and removing the highest-priority task in O(log n) time. Even though insertion is slightly slower, the overall performance is better because it avoids repeatedly scanning the entire list.



## Big-O Justification

The Max-Heap is efficient for this type of scheduling problem. Adding a task takes O(log n) time because the heap needs to reorder itself to maintain its structure. Removing the highest-priority task also takes O(log n) for the same reason. However, accessing the highest-priority task is very fast at O(1), since it is always stored at the top of the heap. This balance of efficiency makes the Max-Heap a good choice for systems where tasks are constantly being added and processed.



## UML Diagram


+-------------------+
|       Task        |
+-------------------+
| - name: String    |
| - priority: int   |
+-------------------+
| + getName()       |
| + getPriority()   |
+-------------------+

+------------------------+
|       MaxHeap          |
+------------------------+
| - heap: ArrayList<Task>|
+------------------------+
| + insert(Task)         |
| + poll(): Task         |
| + peek(): Task         |
| - heapifyUp()          |
| - heapifyDown()        |
+------------------------+
```

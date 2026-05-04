

## Problem

In some systems, tasks shouldn’t be done in the order they come in. Instead, the more important ones should go first. A good example is an emergency room, where serious cases are handled before minor ones. So the problem is how to organize tasks so that higher-priority ones are always handled first.



## Design Choice

For this, I chose a Max-Heap. The reason is simple: a Max-Heap always keeps the highest value at the top. That means the most important task is always easy to access and remove.



## Trade-Off

I thought about just using a regular list, but that has a problem.

* **List/Array**

  * Easy to add items (O(1))
  * Hard to find the highest priority (O(n))

* **Max-Heap**

  * Adding takes O(log n)
  * Removing highest also takes O(log n)

So even though the heap is a little slower to insert, it saves time overall because it doesn’t need to search through everything.



## Big-O Justification

The Max-Heap works well here because it keeps things efficient. Adding a task takes O(log n) since the heap has to reorder itself. Removing the highest-priority task also takes O(log n). Looking at the top task is O(1) because it’s always at the front. This makes it a good fit for a system where tasks are constantly being added and removed.



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

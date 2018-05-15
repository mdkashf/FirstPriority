# FirstPriority
Kashf Mashrafi, Jessica Wu, Rohan Ahammed

We used ArrayList to contruct the queue. The queue only accepts String elements as required by prompt. The class contains the methods from the PriorityQueue interface and the most important methods to an APQ (also justified by looking at the API).

## Methods

* *add(String input)*:
Adds input to the end of queue, regardless of priority, with a runtime of O(1) (amortized constant time).

* *isEmpty()*:
Returns true if size of arrayList is 0, false otherwise with a runtime of O(1);

* *peekMin()*:
Iterates trough the arrayList and returns the least priority element with a runtime of O(n).

* *removeMin()*:
Uses peekMin to determine the least priority elemnt in queue. It then traverses through the arrayList to find the index of the element and calls remove() function of ArrayList to remove the element. This has a runtime of O(n).

These methods have these runtimes as specified by the API and are implemented in this way because it is the simplest way to implement an ArrayPriorityQueue. Trying to determine priority when adding adds a lot of complications that is simply solved by making peekMin and reverseMin linear runtime, and add as constant, instead of vice versa.

## Heap todo
Prioritized list of methods to implement:
1) isEmpty()
2) peekMin()
3) toString()
4) add(int newVal)
5) minChildPos()
6) minRemove()

Our prioritized list puts methods that are very easy to code (isEmpty(), peekMin() and toString()) at the top because these methods require a few lines of code to make functional and are very simple. add() is the next method because it is simpler than remove() and we already have an algorithm for how to do it on minHeaps. minChildPos() is before minRemove() because it is simpler and a helper for minRemove(). 


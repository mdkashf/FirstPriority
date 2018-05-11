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

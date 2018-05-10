# FirstPriority
Kashf Mashrafi, Jessica Wu, Rohan Ahammed

We used ArrayList to contruct the queue. 

Methods

add:
Adds to the end of queue regardless of priority with a runtime of O(n).

isEmpty():
Returns true if size of arrayList is 0, false otherwise with a runtime of O(1);

PeekMin():
Iterates trough the arrayList and returns the least priority element with a runtime of O(n).

removeMin():
Uses peekMin to determine the least priority elemnt in queue. It then traverses through the arrayList to find the index of the elemnt and calls remove() function of ArrayList to remove the element. This has a runtime of O(n).



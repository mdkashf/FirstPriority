/* RunMed Algo: 

getMedian():
Case 1 - If size of min and max heaps are equal
Return the mean of the roots of the min and max heaps.
Case 2 - If min heap is larger than max heap
Return root of min heap
Case 3 - If max heap is larger than min heap
Return root of max heap.

add(): 
1. If the value is less than the root of the min heap, add it to the min heap
If the value is greater than the root of the max heap, add it to the max heap

2. To balance:
If the min heap size is larger, add the value at the root to max heap and remove the root from min heap.
If the max heap size is larger, add the value at the root to min heap and remove the root from max heap. 

After all the values are added into their respective heap, then median can be found.
 */
import java.util.NoSuchElementException;//in order to import exception
public class RunMed {

    //instance vars
    ALHeapMin lilVals;
    ALHeapMax bigVals; 
    
    public RunMed(){
	
	lilVals = new ALHeapMin();
	bigVals = new ALHeapMax();
    }

    public int getMedian(){
	
	int median;
	if (lilVals.size() == 0 && bigVals.size() == 0){
	    throw new NoSuchElementException();
	}
	if (lilVals.size() == bigVals.size()) {
	    median =  (lilVals.peekMin() + bigVals.peekMax()) / 2;
	    return median;
	}
	else if (lilVals.size() > bigVals.size()){
	    median = lilVals.peekMin();
	}
	else {
	    median = bigVals.peekMax();

	}
	return median;
    }
    public void add(Integer newVal){
	
	if (lilVals.peekMin() > newVal){
	    lilVals.add(newVal);
	}
	else if (bigVals.peekMax() <= newVal) {
	    bigVals.add(newVal);
	}
	if (lilVals.size() > bigVals.size() + 1) {
	    bigVals.add(lilVals.peekMin());
	    lilVals.removeMin();
	}
	else if (bigVals.size() > lilVals.size() + 1) {
	    lilVals.add(bigVals.peekMax());
	    bigVals.removeMax();
	}
    }
    public static void main(String[] args){
    }
    
} //end class RunMed
  

/* RunMed Algo: 

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
  

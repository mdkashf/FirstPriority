/* RunMed Algo: 

 */
public class RunMed {
    
    ALHeapMin lilVals;
    ALHeapMax bigVals; 
    
    public RunMed(){
	
	lilVals = new ALHeapMin();
	bigVals = new ALHeapMax();
    }

    public int getMedian(){
	
	int median;
	
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
    
} //end class RunMed
  

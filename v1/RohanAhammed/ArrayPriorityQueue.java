//Kairo
//Rohan Ahammed, Kaitlin Wan
//Rohan Ahammed
//APCS2 pd08
//HW46 -- Arrr, There Be Priorities Here Matey
//2018-05-09
import java.util.ArrayList;
public class ArrayPriorityQueue implements PriorityQueue{

    ArrayList<String> _data = new ArrayList<>();

    public void add(String newStr){
	_data.add(newStr);
    }//O(1) runtime (amortized constant)
    public boolean isEmpty(){
	return _data.size() == 0;
    }//O(1) runtime
    public String peekMin(){
	String minStr = _data.get(0);
	for (String s: _data){
	    if (s.compareTo(minStr) < 1){
		minStr = s;
	    }
	}
	return minStr;
    }//O(n) runtime because you need to iterate through ArrayList with a for each loop
    public String removeMin(){
	String minStr = _data.get(0);
	int minIndex = 0;
	for (int i = 1; i < _data.size(); i++){
	    String a = _data.get(i);
	    if (a.compareTo(minStr)< 1){
		minStr = a;
		minIndex = i;
	    }
	}
	return _data.remove(minIndex);
    }
    //O(n) runtime because you need to iterate through ArrayList with a for loop to find the min
    public static void main (String[] args){
	ArrayPriorityQueue library = new ArrayPriorityQueue();
	library.add("foo");
	library.add("moo");
	library.add("boo");
	library.add("moo");
	library.add("boo");
	System.out.println("expected removeMin: boo");
	System.out.println(library.removeMin());
	System.out.println("expected removeMin: boo");
	System.out.println(library.removeMin());
	System.out.println("expected removeMin: foo");
	System.out.println(library.removeMin());
	System.out.println("expected removeMin: moo");
	System.out.println(library.removeMin());
	System.out.println("expected removeMin: moo");
	System.out.println(library.removeMin());
    }
		    
    
}// end of class

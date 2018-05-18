/*****************************************************
 * class ALHeapMin
 * SKELETON
 * Implements a min heap using an ArrayList as underlying container
 *****************************************************/

import java.util.ArrayList;

public class ALHeapMin
{

    //instance vars
    private ArrayList<Integer> _heap; 

    /*****************************************************
     * default constructor  ---  inits empty heap
     *****************************************************/
    public ALHeapMin() 
    {
	_heap = new ArrayList<Integer>();
    }



    /*****************************************************
     * toString()  ---  overrides inherited method
     * Returns either 
     * a) a level-order traversal of the tree (simple version)
* b) ASCII representation of the tree (more complicated, more fun)
   *****************************************************/
  public String toString() 
  {
      //Level order traversal
      String retStr = "";
      for (Integer x: _heap){
	  retStr += x + " ";
      }
      return retStr;
      //can also use toString of ArrayList
  }//O(n)


  /*****************************************************
   * boolean isEmpty()
   * Returns true if no meaningful elements in heap, false otherwise
   *****************************************************/
  public boolean isEmpty()
  {
      return _heap.size() == 0;
  }//O(1)


  /*****************************************************
   * Integer peekMin()
   * Returns min value in heap
   * Postcondition: Heap remains unchanged.
   *****************************************************/
  public Integer peekMin()
  {
      if (_heap.size() < 1){
	  return null;
      }
      else{
	  return _heap.get(0);
      }
  }//O(1)


    /* Algorithm for adding:
       1) Add the element to the heap (end of AL, next avail spot in heap)
       2) If the element that was added is less than its parent, swap the parent with the added element. If not, STOP.
       3) Repeat step 2 for every swap made until the element is in correct pos
    */
  /*****************************************************
   * add(Integer) 
   * Inserts an element in the heap
   * Postcondition: Tree exhibits heap property.
   *****************************************************/
  public void add( Integer addVal )
  {
      _heap.add(addVal);
      
      int newIndex = _heap.size() - 1;
      int parentPos;


      while(newIndex > 0 ) {
	  parentPos = (newIndex-1) / 2;//used to find parent

	  if ( addVal < _heap.get(parentPos) ) {
	      swap( newIndex, parentPos );
	      newIndex = parentPos;
	  }
	  else 
	      break;//exit out of while loop because element is in correctpos
      }
  }//O(logn)

    /* Algorithm for removing:
       1) Swap the bottom, rightmost (last element in AL) element in heap with the root. Remove the former root (last element in AL).
       2) If the new root is greater than the least child, swap. If not, STOP.
       3) Repeat step 2 for every swap made until the element is in correct pos
	   */
  /*****************************************************
   * removeMin()  ---  means of removing an element from heap
   * Removes and returns least element in heap.
   * Postcondition: Tree maintains heap property.
   *****************************************************/
  public Integer removeMin()
  {
      if ( isEmpty() ) 
	    return null;

      Integer retInt = peekMin();//needs to be returned


	//store val about to be swapped into root
      Integer newRoot = _heap.get( _heap.size() - 1);//furthest right node of heap
	swap( 0, _heap.size() - 1 );
	_heap.remove( _heap.size() - 1);//this is better than leaving a "hole"

	//put the new root in the correct position 
	int pos = 0;//pos of newly added element
	int minChild;

	while( pos < _heap.size() ) {
	    //choose the child with the lesser value
	    minChild = minChildPos(pos);
	    //if no children, you are at correct position
	    if ( minChild == -1 ) {
		break;
	    }
	    //less than the least child
	    else if ( newRoot <=  _heap.get(minChild) ){
		break;
	    }
	    //greater than least child (out of place)
	    else {
		swap( pos, minChild );
		pos = minChild;
	    }
	}
	return retInt;
  }//O(logn)


  /*****************************************************
   * minChildPos(int)  ---  helper fxn for removeMin()
   * Returns index of least child, or 
   * -1 if no children, or if input pos is not in ArrayList
   * Postcondition: Tree unchanged
   *****************************************************/
  private int minChildPos( int pos )
  {
      int retInt;
      int lc = 2*pos + 1; //index of left child
      int rc = 2*pos + 2; //index of right child
      
      //element is not in the heap or the element is a leaf
      if ( pos < 0 || pos >= _heap.size() || lc >= _heap.size() ){
	  retInt = -1;
      }
      //right child not present
      else if ( rc >= _heap.size() ){
	  retInt = lc;
      }
      //2 children
      else if ( _heap.get(lc) < (_heap.get(rc)) ){
	  retInt = lc;
      }
      else{
	  retInt = rc;
      }
      return retInt;
  }//O(1)
  

  //************ aux helper fxns ***************
  private Integer minOf( Integer a, Integer b )
  {
    if ( a.compareTo(b) < 0 )
	    return a;
    else
	    return b;
  }

  //swap for an ArrayList
  private void swap( int pos1, int pos2 )
  {
    _heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );	
  }
  //********************************************

    public int size() {
	return _heap.size();
    }

  //main method for testing
  public static void main( String[] args )
  {
      ALHeapMin pile = new ALHeapMin();

      pile.add(2);
      System.out.println(pile);
      pile.add(4);
      System.out.println(pile);
      pile.add(6);
      System.out.println(pile);
      pile.add(8);
      System.out.println(pile);
      pile.add(10);
      System.out.println(pile);
      pile.add(1);
      System.out.println(pile);
      pile.add(3);
      System.out.println(pile);
      pile.add(5);
      System.out.println(pile);
      pile.add(7);
      System.out.println(pile);
      pile.add(9);
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
          /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class ALHeapMin

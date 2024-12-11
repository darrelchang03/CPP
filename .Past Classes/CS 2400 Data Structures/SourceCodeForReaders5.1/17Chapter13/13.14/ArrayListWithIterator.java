import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
   A class that implements the ADT list by using a resizable array and 
   gives it an iterator. 
   
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class ArrayListWithIterator<T> implements ListWithIteratorInterface<T>
{
	private T[] list; // Array of list entries; ignore list[0]
	private int numberOfEntries;
   private boolean integrityOK = false;
	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;
   
	public ArrayListWithIterator()
	{
		this(DEFAULT_CAPACITY);
	} // end default constructor
   
	public ArrayListWithIterator(int initialCapacity)
	{
      integrityOK = false;

      // Is initialCapacity too small?
      if (initialCapacity < DEFAULT_CAPACITY)
         initialCapacity = DEFAULT_CAPACITY;
      else // Is initialCapacity too big?
         checkCapacity(initialCapacity);
      
      // The cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      T[] tempList = (T[])new Object[initialCapacity + 1];
      list = tempList;
      numberOfEntries = 0;
      integrityOK = true;
	} // end constructor
   
/* < Implementations of the methods of the ADT list go here;
     you can see them in Chapter 11, beginning at Segment 11.5. */
   
   public Iterator<T> iterator()
   {
      return new IteratorForArrayList();
   } // end iterator
   
   public Iterator<T> getIterator()
   {
      return iterator();
   } // end getIterator
   
   private class IteratorForArrayList implements Iterator<T>
   {
      private int     nextIndex;     // Index of next entry in the iteration
      private boolean wasNextCalled; // Needed by remove
     
      private IteratorForArrayList()
      {
         nextIndex = 1;         // Iteration begins at list's first entry
         wasNextCalled = false;
      } // end default constructor
     
      // Implementations of the methods in the interface Iterator go here.
      
   } // end IteratorForArrayList
} // end ArrayListWithIterator


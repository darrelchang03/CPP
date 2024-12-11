import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
/**
   A class that implements the ADT list by using an array.
   The list has entries that are numbered beginning at 1.
   The list has an iterator that implements the interface ListIterator.
   Iterator positions (indexes) are numbered beginning at 0.
   
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class ArrayListWithListIterator<T>
             implements ListWithListIteratorInterface<T>
{
   private T[] list;  // Array of list entries; ignore list[0]
   private int numberOfEntries; 
   private boolean integrityOK;
   private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;

   public ArrayListWithListIterator()
   {
      this(DEFAULT_CAPACITY);
   } // end default constructor

   public ArrayListWithListIterator(int initialCapacity)
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
   
   public ListIterator<T> getIterator()
   {
      return new ListIteratorForArrayList();
   } // end getIterator
   
   public Iterator<T> iterator()
   {
      return getIterator();
   } // end iterator
   
   private class ListIteratorForArrayList implements ListIterator<T>
   {
      // The details of this class begin with Segment 13.24.
   } // end ListIteratorForArrayList
} // end ArrayListWithListIterator

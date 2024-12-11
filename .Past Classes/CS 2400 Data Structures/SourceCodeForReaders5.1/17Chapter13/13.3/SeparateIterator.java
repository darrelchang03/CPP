import java.util.Iterator;
import java.util.NoSuchElementException;
/**
   A class that represents an iterator for the ADT list.
   
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class SeparateIterator<T> implements Iterator<T>
{
   private ListInterface<T> list;
   private int              nextPosition;  // Position of entry last returned by next()
   private boolean          wasNextCalled; // Needed by remove

   public SeparateIterator(ListInterface<T> myList)
   {
      list = myList;
      nextPosition = 0;
      wasNextCalled = false;
   } // end constructor

/* < Implementations of the methods hasNext, next, and remove go here. >
     . . . */
} // end SeparateIterator

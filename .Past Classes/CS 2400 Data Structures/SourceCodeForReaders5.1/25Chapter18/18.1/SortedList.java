import java.util.*;
/**
   A class that implements the ADT sorted list by extending LList.
   Duplicate entries are allowed.
  
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class SortedList<T extends Comparable<? super T>>
             extends LList<T> implements SortedListInterface<T>
{
   public void add(T newEntry)
   {
      int newPosition = Math.abs(getPosition(newEntry));
      super.add(newPosition, newEntry);
   } // end add

/* < Implementations of remove(anEntry) and getPosition(anEntry) go here. >
   . . . */
} // end SortedList

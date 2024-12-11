/**
   A class that implements the ADT sorted list by using an instance of LList.
 
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class SortedList<T extends Comparable<? super T>>
             implements SortedListInterface<T>
{
   private ListInterface<T> list;

   public SortedList()
   {
      list = new LList<T>();
   } // end default constructor

 // . . .

} // end SortedList

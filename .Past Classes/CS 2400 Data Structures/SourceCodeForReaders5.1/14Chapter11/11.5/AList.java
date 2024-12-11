import java.util.Arrays;
/**
   A class that implements a list of objects by using an array.
   Entries in a list have positions that begin with 1.
   Duplicate entries are allowed.
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class AList<T> implements ListInterface<T>
{
	private T[] list;   // Array of list entries; ignore list[0]
	private int numberOfEntries;
   private boolean integrityOK;
	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;
   
	public AList()
	{
		this(DEFAULT_CAPACITY);
	} // end default constructor
   
	public AList(int initialCapacity)
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
   
	public void add(T newEntry)
	{
       checkIntegrity();
       list[numberOfEntries + 1] = newEntry;
       numberOfEntries++;
       ensureCapacity();
//     add(numberOfEntries + 1, newEntry);  // ALTERNATE CODE
	} // end add

	public void add(int newPosition, T newEntry)
	{  /* < Implementation deferred > */
	} // end add

	public T remove(int givenPosition)
	{ /* < Implementation deferred > */
	} // end remove

	public void clear()
	{ /* < Implementation deferred > */
	} // end clear

	public T replace(int givenPosition, T newEntry)
	{ /* < Implementation deferred > */
	} // end replace

	public T getEntry(int givenPosition) 
	{ /* < Implementation deferred > */
	} // end getEntry

   public T[] toArray()
   {
		checkIntegrity();
      
      // The cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      T[] result = (T[])new Object[numberOfEntries]; // Unchecked cast
      for (int index = 0; index < numberOfEntries; index++)
      {
         result[index] = list[index + 1];
      } // end for
      
      return result;
   } // end toArray
   
	public boolean contains(T anEntry)
	{ /* < Implementation deferred > */
	} // end contains

	public int getLength()
	{
		return numberOfEntries;
	} // end getLength

	public boolean isEmpty()
	{
		return numberOfEntries == 0; // Or getLength() == 0
	} // end isEmpty

   // Doubles the capacity of the array list if it is full.
   // Precondition: checkIntegrity has been called.
   private void ensureCapacity()
   {
      int capacity = list.length - 1;
      if (numberOfEntries >= capacity)
      {
         int newCapacity = 2 * capacity;
         checkCapacity(newCapacity); // Is capacity too big?
         list = Arrays.copyOf(list, newCapacity + 1);
      } // end if
   } // end ensureCapacity

/* < This class will define checkCapacity, checkIntegrity, and two more private methods that will be discussed later. > */
} // end AList

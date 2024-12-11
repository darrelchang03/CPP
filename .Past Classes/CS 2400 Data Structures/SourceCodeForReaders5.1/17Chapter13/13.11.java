// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public T next()
{
   T result;
   if (hasNext())
   {
      result = nextNode.getData();
      nextNode = nextNode.getNextNode(); // Advance iterator
   }
   else
      throw new NoSuchElementException("Illegal call to next(); " +
                                       "iterator is after end of list.");
   return result; // Return next entry in iteration
} // end next

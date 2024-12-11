// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public T next()
{
   if (hasNext())
   {
      wasNextCalled = true;
      nextPosition++;
      return list.getEntry(nextPosition);
   }
   else
      throw new NoSuchElementException("Illegal call to next(); " +
                                       "iterator is after end of list.");
} // end next


// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public boolean hasPrevious()
{
   return (nextIndex > 1) && (nextIndex <= numberOfEntries + 1);
} // end hasPrevious

public T previous()
{
   if (hasPrevious())
   {
      lastMove = Move.PREVIOUS;
      isRemoveOrSetLegal = true;

      T previousEntry = list[nextIndex - 1];
      nextIndex--; // Move iterator back
      return previousEntry;
   }
   else
      throw new NoSuchElementException("Illegal call to previous(); " +
                                       "iterator is before beginning of list.");
} // end previous

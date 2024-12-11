// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public void set(T newEntry)
{
   if (isRemoveOrSetLegal)
   {
      if (lastMove.equals(Move.NEXT))
         list[nextIndex - 1] = newEntry; // Replace entry last returned by next()
      else
      {
         // Assertion: lastMove.equals(Move.PREVIOUS)
         list[nextIndex] = newEntry; // Replace entry last returned by previous()
      } // end if
   }
   else
      throw new IllegalStateException("Illegal call to set(); " +
                                      "next() or previous() not called, OR " +
                                      "add() or remove() called since then.");
} // end set

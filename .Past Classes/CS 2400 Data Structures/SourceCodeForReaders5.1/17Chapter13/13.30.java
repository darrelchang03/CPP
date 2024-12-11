// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public void remove()
{
   if (isRemoveOrSetLegal)
   {
      isRemoveOrSetLegal = false;

      if (lastMove.equals(Move.NEXT))
      {
         // next() called, but neither add() nor remove() has been
         // called since.

         // Remove entry last returned by next().

         // nextIndex is 1 more than the index of the entry
         // returned by next()
         ArrayListWithListIterator.this.remove(nextIndex - 1);
         nextIndex--; // Move iterator back
      }
      else
      {
         // previous() called, but neither add() nor remove() has been
         // called since

         // Remove entry last returned by previous().

         // nextIndex is the index of the entry returned by previous().
         ArrayListWithListIterator.this.remove(nextIndex);
      } // end if
   }
   else
      throw new IllegalStateException("Illegal call to remove(); " +
                                      "next() or previous() not called, OR " +
                                      "add() or remove() called since then.");
} // end remove


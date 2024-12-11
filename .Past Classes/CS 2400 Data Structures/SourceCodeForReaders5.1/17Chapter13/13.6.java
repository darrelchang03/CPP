// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public void remove()
{
   if (wasNextCalled)
   {
      // nextPosition was incremented by the call to next(), so
      // it is the position number of the entry to be removed
      list.remove(nextPosition);
      nextPosition--;        // A subsequent call to next() must be
                             // unaffected by this removal
      wasNextCalled = false; // Reset flag
   }
   else
      throw new IllegalStateException("Illegal call to remove(); " +
                                      "next() was not called.");
} // end remove


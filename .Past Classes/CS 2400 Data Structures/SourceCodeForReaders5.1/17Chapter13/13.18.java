// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public void remove()
{
   checkIntegrity();
   if (wasNextCalled)
   {
      // nextIndex was incremented by the call to next, so it is
      // 1 larger than the position number of the entry to be removed
      ArrayListWithIterator.this.remove(nextIndex − 1);
      nextIndex−−;               // Index of next entry in iteration
      wasNextCalled = false;     // Reset flag
   }
   else
      throw new IllegalStateException("Illegal call to remove(); " +
                                      "next() was not called.");
} // end remove


// Doubles the size of the array queue if it is full.
// Precondition: checkIntegrity has been called.
// @author Frank M. Carrano, Timothy M. Henry
// @version 5.1
private void ensureCapacity()
{
   if (frontIndex == ((backIndex + 2) % queue.length)) // If array is full,
   {                                                   // double size of array
      T[] oldQueue = queue;
      int oldSize = oldQueue.length;
      int newSize = 2 * oldSize;
      checkCapacity(newSize - 1);
      integrityOK = false;

      // The cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      T[] tempQueue = (T[]) new Object[newSize];
      queue = tempQueue;
      for (int index = 0; index < oldSize - 1; index++)
      {
         queue[index] = oldQueue[frontIndex];
         frontIndex = (frontIndex + 1) % oldSize;
      } // end for
      
      frontIndex = 0;
      backIndex = oldSize - 2;
      integrityOK = true;
   } // end if
} // end ensureCapacity


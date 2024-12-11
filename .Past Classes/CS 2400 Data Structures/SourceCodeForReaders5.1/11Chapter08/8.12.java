// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public void enqueue(T newEntry)
{
   checkIntegrity();
   ensureCapacity();
   backIndex = (backIndex + 1) % queue.length;
   queue[backIndex] = newEntry;
} // end enqueue


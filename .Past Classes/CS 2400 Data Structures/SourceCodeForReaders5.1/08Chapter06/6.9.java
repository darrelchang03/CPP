// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public void push(T newEntry)
{
   checkInyegrity();
   ensureCapacity();
   stack[topIndex + 1] = newEntry;
   topIndex++;
} // end push

private void ensureCapacity()
{
   if (topIndex >= stack.length - 1) // If array is full, double its size
   {
      int newLength = 2 * stack.length;
      checkCapacity(newLength);
      stack = Arrays.copyOf(stack, newLength);
   } // end if
} // end ensureCapacity


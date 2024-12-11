// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0

private enum Move {NEXT, PREVIOUS}

private class ListIteratorForArrayList implements ListIterator<T>
{
   private int nextIndex; // Index of next entry in the iteration
   private boolean isRemoveOrSetLegal;
   private Move lastMove;
   
   private ListIteratorForArrayList()
   {
      nextIndex = 1; // Iteration begins at list's first entry
      isRemoveOrSetLegal = false;
      lastMove = null;
   } // end default constructor
   

// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0

private class InorderIterator implements Iterator<T>
{
   private StackInterface<BinaryNode<T>> nodeStack;
   private BinaryNode<T> currentNode;

   public InorderIterator()
   {
      nodeStack = new LinkedStack<>();
      currentNode = root;
   } // end default constructor

   public boolean hasNext() 
   {
      return !nodeStack.isEmpty() || (currentNode != null);
   } // end hasNext

   public T next()
   {
      BinaryNode<T> nextNode = null;

      // Find leftmost node with no left child
      while (currentNode != null)
      {
         nodeStack.push(currentNode);
         currentNode = currentNode.getLeftChild();
      } // end while

      // Get leftmost node, then move to its right subtree
      if (!nodeStack.isEmpty())
      {
         nextNode = nodeStack.pop();
         // Assertion: nextNode != null, since nodeStack was not empty
         // before the pop
         currentNode = nextNode.getRightChild();
      }
      else
         throw new NoSuchElementException();

      return nextNode.getData(); 
   } // end next

   public void remove()
   {
      throw new UnsupportedOperationException();
   } // end remove
} // end InorderIterator


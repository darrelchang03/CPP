/** @author Frank M. Carrano, Timothy M. Henry
    @version 5.0 */
public T add(T newEntry)
{
   T result = null;

   if (isEmpty())
      setRootNode(new BinaryNode<>(newEntry));
   else
   {
      BinaryNode<T> rootNode = getRootNode();
      result = addEntry(rootNode, newEntry);
      setRootNode(rebalance(rootNode));
   } // end if

   return result;
} // end add

private T addEntry(BinaryNode<T> rootNode, T newEntry)
{
   // Assertion: rootNode != null
   T result = null;
   int comparison = newEntry.compareTo(rootNode.getData());

   if (comparison == 0)
   {
      result = rootNode.getData();
      rootNode.setData(newEntry);
   }
   else if (comparison < 0)
   {
      if (rootNode.hasLeftChild())
      {
         BinaryNode<T> leftChild = rootNode.getLeftChild();
         result = addEntry(leftChild, newEntry);
         rootNode.setLeftChild(rebalance(leftChild));
      }
      else
         rootNode.setLeftChild(new BinaryNode<>(newEntry));
   }
   else
   {
      // Assertion: comparison > 0

      if (rootNode.hasRightChild())
      {
         BinaryNode<T> rightChild = rootNode.getRightChild();
         result = addEntry(rightChild, newEntry);
         rootNode.setRightChild(rebalance(rightChild));
      }
      else
         rootNode.setRightChild(new BinaryNode<>(newEntry));
   } // end if

   return result;
} // end addEntry



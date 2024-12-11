// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0

public void setRootData(T rootData)
{
   root.setData(rootData);
} // end setRootData

public T getRootData()
{
   if (isEmpty())
      throw new EmptyTreeException();
   else
      return root.getData();
} // end getRootData

public boolean isEmpty()
{
   return root == null;
} // end isEmpty

public void clear()
{
   root = null;
} // end clear

protected void setRootNode(BinaryNode<T> rootNode)
{
   root = rootNode;
} // end setRootNode

protected BinaryNode<T> getRootNode()
{
   return root;
} // end getRootNode


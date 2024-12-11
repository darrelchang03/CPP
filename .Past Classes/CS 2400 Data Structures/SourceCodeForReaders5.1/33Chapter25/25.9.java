// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0

public int getHeight()
{
   int height = 0;
   if (root != null)
      height = root.getHeight();
   return height;
} // end getHeight

public int getNumberOfNodes()
{
   int numberOfNodes = 0;
   if (root != null)
      numberOfNodes = root.getNumberOfNodes();
   return numberOfNodes;
} // end getNumberOfNodes


// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public boolean isEmpty()
{
   return vertices.isEmpty();
} // end isEmpty

public void clear()
{
   vertices.clear();
   edgeCount = 0;
} // end clear

public int getNumberOfVertices()
{
   return vertices.getSize();
} // end getNumberOfVertices

public int getNumberOfEdges()
{
   return edgeCount;
} // end getNumberOfEdges


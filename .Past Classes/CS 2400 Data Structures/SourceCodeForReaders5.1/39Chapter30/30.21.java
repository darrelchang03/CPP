// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
protected void resetVertices()
{
   Iterator<VertexInterface<T>> vertexIterator = vertices.getValueIterator();
   while (vertexIterator.hasNext())
   {
      VertexInterface<T> nextVertex = VertexIterator.next();
      nextVertex.unvisit();
      nextVertex.setCost(0);
      nextVertex.setPredecessor(null);
   } // end while
} // end resetVertices


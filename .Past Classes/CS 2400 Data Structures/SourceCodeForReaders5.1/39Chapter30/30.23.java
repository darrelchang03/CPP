// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public QueueInterface<T> getBreadthFirstTraversal(T origin)
{
   resetVertices();
   QueueInterface<T> traversalOrder = new LinkedQueue<>();
   QueueInterface<VertexInterface<T>> vertexQueue = new LinkedQueue<>();
   
   VertexInterface<T> originVertex = vertices.getValue(origin);
   originVertex.visit();
   traversalOrder.enqueue(origin);    // Enqueue vertex label
   vertexQueue.enqueue(originVertex); // Enqueue vertex

   while (!vertexQueue.isEmpty())
   {
      VertexInterface<T> frontVertex = vertexQueue.dequeue();
      Iterator<VertexInterface<T>> neighbors = frontVertex.getNeighborIterator();

      while (neighbors.hasNext())
      {
         VertexInterface<T> nextNeighbor = neighbors.next();
         if (!nextNeighbor.isVisited())
         {
            nextNeighbor.visit();
            traversalOrder.enqueue(nextNeighbor.getLabel());
            vertexQueue.enqueue(nextNeighbor);
         } // end if
      } // end while
   } // end while

   return traversalOrder;
} // end getBreadthFirstTraversal


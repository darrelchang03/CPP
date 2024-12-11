// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
protected class Edge
{
   private VertexInterface<T> vertex; // Vertex at end of edge
   private double weight;

   protected Edge(VertexInterface<T> endVertex, double edgeWeight)
   {
      vertex = endVertex;
      weight = edgeWeight;
   } // end constructor

   protected Edge(VertexInterface<T> endVertex)
   {
      vertex = endVertex;
      weight = 0;
   } // end constructor
   
   protected VertexInterface<T> getEndVertex()
   {
      return vertex; 
   } // end getEndVertex

   protected double getWeight() 
   {
      return weight; 
   } // end getWeight
} // end Edge


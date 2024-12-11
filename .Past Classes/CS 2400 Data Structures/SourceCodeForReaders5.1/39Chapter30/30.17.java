// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public boolean addVertex(T vertexLabel)
{
   VertexInterface<T> addOutcome = vertices.add(vertexLabel, new Vertex<>(vertexLabel));
   return addOutcome == null; // Was addition to dictionary successful?
} // end addVertex


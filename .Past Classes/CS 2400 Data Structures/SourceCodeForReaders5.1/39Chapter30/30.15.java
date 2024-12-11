// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public boolean equals(Object other)
{
   boolean result;

   if ((other == null) || (getClass() != other.getClass()))
      result = false;
   else
   {
      // The cast is safe within this else clause
      @SuppressWarnings("unchecked")
      Vertex<T> otherVertex = (Vertex<T>)other;
      result = label.equals(otherVertex.label);
   } // end if

   return result;
} // end equals

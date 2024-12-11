// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public T pop()
{
   T top = peek();  // Might throw EmptyStackException

   // Assertion: topNode != null
   topNode = topNode.getNextNode();

   return top;
} // end pop


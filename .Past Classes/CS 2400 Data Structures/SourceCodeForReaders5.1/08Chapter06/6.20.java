// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public boolean isEmpty()
{
   checkIntegrity();
   return stack.isEmpty();
} // end isEmpty

public void clear()
{
   checkIntegrity();
   stack.clear();
} // end clear


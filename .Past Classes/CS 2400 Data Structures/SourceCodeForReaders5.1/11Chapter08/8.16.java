// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public boolean isEmpty()
{
   checkIntegrity():
   return frontIndex == ((backIndex + 1) % queue.length);
} // end isEmpty


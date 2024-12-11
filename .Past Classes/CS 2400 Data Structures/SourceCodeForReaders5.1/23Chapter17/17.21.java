// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public void add(T newEntry)
{
   int newPosition = Math.abs(getPosition(newEntry));
   list.add(newPosition, newEntry);
} // end add

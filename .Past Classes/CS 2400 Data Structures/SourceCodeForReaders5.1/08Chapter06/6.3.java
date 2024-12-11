// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public void push(T newEntry)
{
   Node newNode = new Node(newEntry, topNode);
   topNode = newNode;
} // end push


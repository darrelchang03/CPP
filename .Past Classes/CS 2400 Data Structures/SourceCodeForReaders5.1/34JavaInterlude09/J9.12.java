// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0

public class LList<T extends Copyable> implements CloneableListInterface<T>
{
   private Node firstNode; // Reference to first node of chain
   private int  numberOfEntries;
   // . . .

  

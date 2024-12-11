// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
	/** Adds a new entry to this bag.
	    @param newEntry  The object to be added as a new entry.
	    @return  True. */
	public boolean add(T newEntry) // OutOfMemoryError possible
	{
      // Add to beginning of chain:
		Node newNode = new Node(newEntry);
		newNode.next = firstNode;  // Make new node reference rest of chain
                                 // (firstNode is null if chain is empty)        
      firstNode = newNode;       // New node is at beginning of chain
		numberOfEntries++;
      
		return true;
	} // end add

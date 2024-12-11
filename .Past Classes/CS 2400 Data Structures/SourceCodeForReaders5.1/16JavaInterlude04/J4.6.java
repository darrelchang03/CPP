// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
ListInterface<String> nameList = new MyList<>();
nameList.add("Jamie");
nameList.add("Joey");
nameList.add("Rachel");

Iterator<String> nameIterator = nameList.iterator();

nameIterator.hasNext() // Returns true because a next entry exists.
nameIterator.next()    // Returns the string Jamie and advances the iterator.
nameIterator.next()    // Returns the string Joey and advances the iterator.
nameIterator.next()    // Returns the string Rachel and advances the iterator.
nameIterator.hasNext() // Returns false because the iterator is beyond the end of the list.
nameIterator.next()    // Causes a NoSuchElementException.

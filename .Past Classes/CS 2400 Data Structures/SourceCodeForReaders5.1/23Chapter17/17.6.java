// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
nameList.getPosition("Jamie"); // Returns 3, the position of Jamie in the list
nameList.contains("Jill");     // Returns false, because Jill is not in the list
nameList.getPosition("Jill");  // Returns –4, because Jill belongs at position 4 in the list
nameList.getEntry(2);          // Returns Carlos, because he is at position 2 in the list
nameList.remove("Tom");
nameList.remove(1);

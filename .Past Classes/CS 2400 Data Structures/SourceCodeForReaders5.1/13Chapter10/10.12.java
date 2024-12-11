// Make an alphabetical list of names as students enter a room
// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
ListInterface<String> alphaList = new AList<>();

alphaList.add(1, "Amy");    // Amy
alphaList.add(2, "Elias");  // Amy Elias
alphaList.add(2, "Bob");    // Amy Bob Elias
alphaList.add(3, "Drew");   // Amy Bob Drew Elias
alphaList.add(1, "Aaron");  // Aaron Amy Bob Drew Elias
alphaList.add(4, "Carol");  // Aaron Amy Bob Carol Drew Elias

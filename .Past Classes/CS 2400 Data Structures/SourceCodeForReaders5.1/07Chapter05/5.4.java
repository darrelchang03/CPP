// @author Frank M. Carrano
// @author Timothy M. Henry
// @version 5.0
StackInterface<String> stringStack = new OurStack<>();
stringStack.push("Jim");
stringStack.push("Jess");
stringStack.push("Jill");
stringStack.push("Jane");
stringStack.push("Joe");

String top = stringStack.peek(); // Returns "Joe"
System.out.println(top + " is at the top of the stack.");

top = stringStack.pop();         // Removes and returns "Joe"
System.out.println(top + " is removed from the stack.");

top = stringStack.peek();        // Returns "Jane"
System.out.println(top + " is at the top of the stack.");

top = stringStack.pop();         // Removes and returns "Jane"
System.out.println(top + " is removed from the stack.");

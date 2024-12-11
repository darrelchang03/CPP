// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
QueueInterface<String> myQueue = new LinkedQueue<>();
myQueue.enqueue("Jada");
myQueue.enqueue("Jess");
myQueue.enqueue("Jazmin");
myQueue.enqueue("Jorge");
myQueue.enqueue("Jamal");

String front = myQueue.getFront(); // Returns "Jada"
System.out.println(front + " is at the front of the queue.");

front = myQueue.dequeue(); // Removes and returns "Jada"
System.out.println(front + " is removed from the queue.");

myQueue.enqueue("Jerry"); // Adds "Jerry"

front = myQueue.getFront(); // Returns "Jess"
System.out.println(front + " is at the front of the queue.");

front = myQueue.dequeue(); // Removes and returns "Jess"
System.out.println(front + " is removed from the queue.");

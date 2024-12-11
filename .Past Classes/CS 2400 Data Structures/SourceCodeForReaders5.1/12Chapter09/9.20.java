// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
public void display()
{
   displayChain(firstNode);
} // end display

private void displayChain(Node nodeOne) 
{
   if (nodeOne != null)
   {
      System.out.println(nodeOne.getData()); // Display data in first node
      displayChain(nodeOne.getNextNode());   // Display rest of chain
   } // end if
} // end displayChain


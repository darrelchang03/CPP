/**
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class SubClass extends SuperClass
{
   public void someMethod() throws Exception2 // OK, assuming Exception2
   {                                          // extends Exception1
   
   } // end someMethod
} // end SubClass

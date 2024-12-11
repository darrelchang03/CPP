import java.util.Vector;
/**
    A class of stacks whose entries are stored in a vector.
    @author Frank M. Carrano and Timothy M. Henry
    @version 5.0
*/
public final class VectorStack<T> implements StackInterface<T>
{
   private Vector<T> stack;   // Last element is the top entry in stack
   private boolean integrityOK;
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;
  
   public VectorStack()
   {
      this(DEFAULT_CAPACITY);
   } // end default constructor
  
   public VectorStack(int initialCapacity)
   {
      integrityOK = false;
      checkCapacity(initialCapacity);
      stack = new Vector<>(initialCapacity); // Size doubles as needed
      integrityOK = true;
   } // end constructor
  
//  < Implementations of checkIntegrity, checkCapacity, and the stack
//    operations go here. >
//  . . .
} // end VectorStack

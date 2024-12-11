import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
/**
   A class of methods that create and display a binary file of
   random integers.
 
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class BinaryFileOperations
{
   /** Writes a given number of random integers to the named binary file.
    @param fileName The file name as a string.
    @param howMany  The positive number of integers to be written.
    @return  An integer code indicating the outcome of the operation:
    0 = Success; > 0 = Error opening (1), writing (2), or closing (3)
    the file. */
   public static int createRandomIntegerFile(String fileName, int howMany)
   {
      int resultCode = 0;
      Random generator = new Random();
      DataOutputStream toFile = null;
      try
      {
         FileOutputStream fos = new FileOutputStream(fileName);
         toFile = new DataOutputStream(fos);
         
         for (int counter = 0; counter < howMany; counter++)
         {
            toFile.writeInt(generator.nextInt());
         } // end for
      }
      catch (FileNotFoundException e)
      {
         resultCode = 1;    // Error opening file
      }
      catch (IOException e)
      {
         resultCode = 2;    // Error writing file
      }
      finally
      {
         try
         {
            if (toFile != null)
               toFile.close();
         }
         catch (IOException e)
         {
            resultCode = 3; // Error closing file
         }
         
         return resultCode;
      }
   } // end createRandomIntegerFile
   
   /** Displays all integers in the named binary file.
       @param fileName  The file name as a string.
       @return  An integer code indicating the outcome of the operation:
                0 = Success; > 0 = Error opening (1), reading (2), closing (3)
                the file. */
   public static int displayBinaryFile(String fileName)
   {
      int resultCode = 0;
      DataInputStream fromFile = null;
      try
      {
         FileInputStream fis = new FileInputStream(fileName);
         fromFile = new DataInputStream(fis);
         
         while (true)
         {
            int number = fromFile.readInt();
            System.out.println(number);
         } // end while
      }
      catch (FileNotFoundException e)
      {
         resultCode = 1;    // Error opening file
      }
      catch (EOFException e)
      {
         // Normal occurrence since entire file is read; ignore exception
      }
      catch (IOException e)
      {
         resultCode = 2;    // Error reading file
      }
      finally
      {
         try
         {
            if (fromFile != null)
               fromFile.close();
         }
         catch (IOException e)
         {
            resultCode = 3; // Error closing file
         }
         
         return resultCode;
      }
   } // end displayBinaryFile
} // end BinaryFileOperations

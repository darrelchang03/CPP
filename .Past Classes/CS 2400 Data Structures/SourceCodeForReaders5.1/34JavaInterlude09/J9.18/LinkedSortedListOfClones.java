/**
   A class that implements the ADT sorted list by using a chain of linked nodes.
   Entries must be Cloneable and Comparable, since clones of entries
   are added to the list instead of the original entry, and clones of
   list entries are returned by getEntry instead of the list's actual entry.
   Duplicate entries are allowed.
  
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class LinkedSortedListOfClones <T extends ComparableAndCopyable<? super T>>
             implements SortedListOfClonesInterface<T>
{
// . . .
} // end LinkedSortedListOfClones

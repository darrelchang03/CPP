// Shifts entries that are beyond the entry to be removed to the
// next lower position.
// Precondition: 1 <= givenPosition < numberOfEntries;
//               numberOfEntries is list's length before removal;
//               checkIntegrity has been called.
// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
private void removeGap(int givenPosition)
{
   int removedIndex = givenPosition;
   for (int index = removedIndex; index < numberOfEntries; index++)
      list[index] = list[index + 1];
} // end removeGap


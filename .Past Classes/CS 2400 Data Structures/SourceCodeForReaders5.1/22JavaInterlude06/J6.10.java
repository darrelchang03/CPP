// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0

// Add to the class ImmutableName:
public ImmutableName(Name aName)
{
   first = aName.getFirst();
   last  = aName.getLast();
} // end constructor

public Name getMutable()
{
   return new Name(first, last);
} // end getMutable

// Add to the class Name
public Name(ImmutableName aName)
{
   first = aName.getFirst();
   last  = aName.getLast();
} // end constructor

public ImmutableName getImmutable()
{
   return new ImmutableName(first, last);
} // end getMutable

// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
Name flexibleName = new Name("Maria", "Mocha");
ImmutableName fixedName = new ImmutableName(flexibleName);
// ImmutableName fixedName = flexibleName.getImmutable();
ImmutableName persistent = new ImmutableName("Jesse", "Java");
Name transient = new Name(persistent);
// Name transient = persistent.getMutable()

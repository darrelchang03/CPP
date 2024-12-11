// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
Name chris = new Name("Chris", "Coffee");
ListInterface<Name> nameList = new LList<>();
nameList.add(1, chris);
chris.setLast("Smith");
System.out.println(nameList.getEntry(1));

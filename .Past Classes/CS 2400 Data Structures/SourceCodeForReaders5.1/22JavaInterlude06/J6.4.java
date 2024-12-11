// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
Name jesse = new Name("Jesse", "Java");
Name rob = new Name("Rob", "Bean");
ListInterface<Name> alphaList = new AList<>();
alphaList.add(jesse);
alphaList.add(1, rob);

rob.setLast("Smith");


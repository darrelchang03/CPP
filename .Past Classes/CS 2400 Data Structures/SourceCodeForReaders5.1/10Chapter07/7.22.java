// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
AssignmentLog myHomework = new AssignmentLog();
myHomework.addProject("CSC211", "Pg 50, Ex 2", Date.valueOf("2019-2-20"));
Assignment pg75Ex8 = new Assignment("CSC215", "Pg 75, Ex 8", Date.valueOf("2019-3-14"));
myHomework.addProject(pg75Ex8);
// . . .
System.out.println("The following assignment is due next:");
System.out.println(myHomework.getNextProject());
// . . .
System.out.println("The following assignment is due next:");
System.out.println(myHomework.getNextProject());
// . . .


// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
int hash = 0;
int n = s.length();
for (int i = 0; i < n; i++)
   hash = g * hash + s.charAt(i);


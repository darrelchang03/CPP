// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
long bits = Double.doubleToLongBits(key);
int hashCode = (int)(bits ^ (bits >> 32));


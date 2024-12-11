'''
(1) Enter a file name. If the file can’t open, use a proper exception (not a catch all exception) to catch this error and handle it by printing out an error message.
(2) Assume each line of the file contains a number (could be valid or invalid integer).  If the number read in is not a valid integer, try to catch this particular type of error (not a catch all exception) and ignore the number.
(3) Add all valid numbers up and calculate average. Note: if all numbers are invalid, you may encounter a divide by zero error which should be caught and reported properly. 
(4) If no exception,  print out  a message “Good Job”. (This code must be placed after all Except clauses).  
(5) At the end  (i.e. with or without exception)  close the file and print out "Done".
'''

try: 
    file = input("Enter file name: ")
    f = open(file)
    sum = 0
    lines = f.readlines()
    numValid = len(lines)
    for line in lines:
        try:
            int(line)
            sum += int(line)
        except ValueError:
            print("Not an integer")
            numValid -= 1
            
    avg = sum / numValid
except OSError:
    print("Could not open file")
except ZeroDivisionError:
    print("No valid numbers")
else:
    print("Good job")
finally:
    f.close()
    print("Done")
#Authors: Darrel Chang
#Assignment: Assignment 1
#Completed (or last revision): 01/30/2024

# Task 1
presentValue = float(input("Enter present value (float): "))
interestRate = float(input("Enter interest rate (float): "))
years = int(input("Enter number of years (integer): "))
futureValue = (pow((1+(interestRate / 100)), years)) * presentValue
print("The future value is: $%.2f" % futureValue)

'''
Test Case 1
    Enter present value (float): 1000.0
    Enter interest rate (float): 5.0
    Enter number of years (integer): 30
    The future value is: $4321.94

Test Cast 2
    Enter present value (float): 1530.50
    Enter interest rate (float): 3.5
    Enter number of years (integer): 15
    The future value is: $2564.12

Test Case 3
    Enter present value (float): 100
    Enter interest rate (float): 10
    Enter number of years (integer): 5
    The future value is: $161.05
'''

# Task 2
x = int(input("Enter integer for number 1: "))
y = int(input("Enter integer for number 2: "))
x,y = y,x
print("After swapping number 1 is:", x)
print("After swapping number 2 is:", y)

'''
    Enter integer for number 1: 7
    Enter integer for number 2: 9
    After swapping number 1 is: 9
    After swapping number 2 is: 7

    Enter integer for number 1: 10
    Enter integer for number 2: 2
    After swapping number 1 is: 2
    After swapping number 2 is: 10
'''

    # Task 3
num1 = int(input("Enter the interger value of num1: "))
num2 = int(input("Enter the interger value of num2: "))
quotient = num1 // num2
remainder = num1 % num2
print("Quotient when", num1, "/", num2, "is:", quotient)
print("Remainder when", num1, "is divided by", num2, "is:", remainder)

'''
    Enter the interger value of num1: 12
    Enter the interger value of num2: 35
    Quotient when 12 / 35 is: 0
    Remainder when 12 is divided by 35 is: 12

    Enter the interger value of num1: 35
    Enter the interger value of num2: 13
    Quotient when 35 / 13 is: 2
    Remainder when 35 is divided by 13 is: 9

    Enter the interger value of num1: 35
    Enter the interger value of num2: 0
    Traceback (most recent call last):
    File "c:\\Users\\darre\\Desktop\\CS_2560\\assignment1.py", line 54, in <module>
        quotient = num1 // num2
                ~~~~~^^~~~~~
    ZeroDivisionError: integer division or modulo by zero
'''

# Task 4
unitType = input("Choose USA or Metric: ")

if unitType == "USA":
    weight = float(input("Enter your weight in lbs: "))
    height = float(input("Enter height in inches: "))
    BMI = 703 * (weight / (height**2))
elif unitType == "Metric":
    weight = float(input("Enter your weight in kgs: "))
    height = float(input("Enter height in meters: "))
    BMI = (weight / (height**2))
else :
    print("Error: Please select a unit type 'USA' or 'Metric'.\n")
if BMI < 18:
    print("Your BMI is: %.2f You are considered underweight." % BMI)
elif BMI < 25:
    print("Your BMI is: %.2f You are considered healthy." % BMI)
else:
    print("Your BMI is: %.2f You are considered overweight." % BMI)

'''
1
    Choose USA or Metric: USA
    Enter your weight in lbs: 155
    Enter height in inches: 70
    Your BMI is: 22.24 You are considered healthy.
2
    Choose USA or Metric: USA
    Enter your weight in lbs: 172
    Enter height in inches: 68
    Your BMI is: 26.15 You are considered overweight.
3
    Choose USA or Metric: Metric
    Enter your weight in kgs: 75
    Enter height in meters: 1.83
    Your BMI is: 22.40 You are considered healthy.
4
    Choose USA or Metric: Metric
    Enter your weight in kgs: 51.5
    Enter height in meters: 1.68
    Your BMI is: 18.25 You are considered healthy.
5
    Choose USA or Metric: USA
    Enter your weight in lbs: 500
    Enter height in inches: 30
    Your BMI is: 390.56 You are considered overweight.
6
    Choose USA or Metric: Metric
    Enter your weight in kgs: 2 
    Enter height in meters: 5
    Your BMI is: 0.08 You are considered underweight.
7
    Choose USA or Metric: USA
    Enter your weight in lbs: 100
    Enter height in inches: 0
    Traceback (most recent call last):
    File "c:\\Users\\darre\\Desktop\\CPP\\CS 2560 Python\\assignment1.py", line 85, in <module>
        BMI = 703 * (weight / (height**2))
                    ~~~~~~~^~~~~~~~~~~~~
    ZeroDivisionError: float division by zero
8
    Choose USA or Metric: Metric
    Enter your weight in kgs: -50
    Enter height in meters: 10
    Your BMI is: -0.50 You are considered underweight.
'''






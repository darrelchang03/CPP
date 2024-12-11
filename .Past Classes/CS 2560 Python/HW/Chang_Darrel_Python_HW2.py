import math
import time
import sympy



def task1() :
    x = float(input("To calculate sin(x), enter an x value (radians): "))
    accurateValue = math.sin(x)
    iterations = 1
    calculatedResult = x
    currentTerm = x

    while(abs(accurateValue - calculatedResult) > 0.000001) :
        currentTerm *= (-1) * (x**2)/(2*iterations*(2*iterations+1))
        calculatedResult += currentTerm
        iterations += 1

    print("It takes %d round of iterations to calculated sin(%.16f)" % (iterations, x))
    print("Estimated result:", calculatedResult)
    print("Sin(%d) from math library: %.16f" % (x, accurateValue))
    print("Difference between estimated and accurate values: %.16f" % (abs(accurateValue-calculatedResult)))
'''

In Main function. For loop to run through test cases
change def task1() to def task1(x)
testCases = [0.0, 1.5079, 3.14, -0.7854, 6.283, 0.001]
for testCase in testCases:
    task1(testCase)

Test Case 1: 0.0
To calculate sin(x), enter an x value (radians): 0.0
It takes 1 round of iterations to calculated sin(0.0000000000000000)
Estimated result: 0.0
Sin(0) from math library: 0.0000000000000000
Difference between estimated and accurate values: 0.0000000000000000

Test Case 2: 1.5079
To calculate sin(x), enter an x value (radians): 1.5709
It takes 6 round of iterations to calculated sin(1.5709000000000000)
Estimated result: 0.9999999383187816
Sin(1) from math library: 0.9999999946259333
Difference between estimated and accurate values: 0.0000000331035259

Test Case 3: 3.14
To calculate sin(x), enter an x value (radians): -3.14
It takes 8 round of iterations to calculated sin(-3.1400000000000001)
Estimated result: -0.0015918867417266131
Sin(-3) from math library: -0.0015926529164868
Difference between estimated and accurate values: 0.0000007661747602

Test Case 4: -0.7854
To calculate sin(x), enter an x value (radians): -0.7854
It takes 4 round of iterations to calculated sin(-0.7854000000000000)
Estimated result: -0.7071077682415541
Sin(0) from math library: -0.7071080798594735
Difference between estimated and accurate values: 0.0000003116179195

Test Case 5: 6.283
To calculate sin(x), enter an x value (radians): 6.283
It takes 13 round of iterations to calculated sin(6.2830000000000004)
Estimated result: -0.00018499615681011978
Sin(6) from math library: -0.0001853071785256
Difference between estimated and accurate values: 0.0000003110217155

Test Case 6: 0.001
To calculate sin(x), enter an x value (radians): 0.001
It takes 1 round of iterations to calculated sin(0.0010000000000000)
Estimated result: 0.001
Sin(0) from math library: 0.0009999998333333
Difference between estimated and accurate values: 0.0000000001666667
'''

# Functions for task 2
def get_input():
    string = input("Enter a sentence or phrase: ")
    print("You entered:", string)
    print("Total number of characters:", len(string))
    return string
def get_num_of_letters(string):
    numLetters = 0
    for char in string:
        if(char.isalpha()):
            numLetters += 1
    return "Number of letters in the sentence: " + str(numLetters)
def output_without_whitespace(string):
    noSpaceString = string.replace(" ", "")
    noWhiteSpaceString = noSpaceString.replace("\t", "")
    return "String with no whitespace: " + noWhiteSpaceString
def get_first(string):
    output = ""
    words = string.split()
    for word in words:
        if(word[0].isalpha()):
            output += word[0].upper()
    return "First letters of words in uppercase: " + output 
# Task 2: Calling functions
def task2() :
    userInput = get_input()
    print(get_num_of_letters(userInput))
    print(output_without_whitespace(userInput))
    print(get_first(userInput))
'''
Test Case 1
Enter a sentence or phrase: The only thing we have to fear is fear itself.
You entered: The only thing we have to fear is fear itself.
Total number of characters: 46
Number of letters in the sentence:36
String with no whitespace: Theonlythingwehavetofearisfearitself.
First letters of words in uppercase: TOTWHTFIFI

Test Case 2
You entered: Chemistry is fun, but sometimes -- very confusing  .
Total number of characters: 51
Number of letters in the sentence:39
String with no whitespace: Chemistryisfun,butsometimes--veryconfusing.
First letters of words in uppercase: CIFBSVC

Test Case 3
Enter a sentence or phrase: The pillows at IKEA are fluffy and soft...
You entered: The pillows at IKEA are fluffy and soft...
Total number of characters: 42
Number of letters in the sentence:32
String with no whitespace: ThepillowsatIKEAarefluffyandsoft...
First letters of words in uppercase: TPAIAFAS
'''

# Prime number generator for task 3
def generate_prime():
    num = 2
    while True:
        if sympy.isprime(num):
            yield num
        num += 1
# Task 3: Generating first 50 primes then timing/printing 101st to 1110th prime number
def task3() :
    generator = generate_prime()

    # Step 1: Generate the first 50 prime numbers
    first_50_primes = [next(generator) for _ in range(50)]
    print("First 50 prime numbers:", first_50_primes)

    # Step 2: Skip 50 prime numbers and generate additional 1000 prime numbers
    start = time.time()
    for _ in range (50):
        next(generator)
    otherPrimes = [next(generator) for _ in range(1000)]
    end = time.time()
    print("101st Prime number:", otherPrimes[0])
    print("1100st Prime number:", otherPrimes[-1])
    print("Time to generate prime numbers 51st to 1001st: %.6f seconds" % (end - start))

def main() :
    print("Task 1")
    task1()
    print("\nTask 2")
    task2()
    print("\nTask 3")
    task3()
if __name__ == '__main__':
    main() #call main to run



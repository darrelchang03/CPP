def task1():
    def firstDigit(n):
       if n < 10:
           return n
       else:
           return firstDigit(n // 10)
    def lastDigit(n):
        return n % 10
    def digits(n):
        if n == 0:
            return 0
        elif n < 0:
            return digits(-n)
        else:
            return 1 + digits(n // 10)
    n = int(input("Enter an integer n: "))
    first = firstDigit(n)
    last = lastDigit(n)
    numDigits = digits(n)
    return first, last, numDigits
'''
Test Case 1) 1729
Enter an integer n: 1729
First digit: 1
Last digit: 9
Total digits: 4

Test Case 2) 394800
Enter an integer n: 394800
First digit: 3
Last digit: 0
Total digits: 6

Test Case 3) 8
Enter an integer n: 8
First digit: 8
Last digit: 8
Total digits: 1
'''
    
def task2():
    n = int(input("Enter an integer n: "))
    
    if n < 0:
        return
    elif n == 0:
        return 0
    
    result = 0

    for i in range(1, n+1):
        if i % 2 == 0:
            term = (-1) * (i ** 2)
        else:
            term = i ** 2
        result += term
    
    return result

'''
Test Case 1) 10
Enter an integer n: 10
Task 2 result: -55

Test Case 2) 25
Enter an integer n: 25
Task 2 result: 325

Test Case 3) -1
Enter an integer n: -1
Task 2 result: None
'''

def main():
    first, last, numDigits = task1()
    print("First digit:", first)
    print("Last digit:", last)
    print("Total digits:", numDigits)
    
    task2Result = task2()
    print("Task 2 result:", task2Result)

main()

import random
from sympy import primerange

def task1():
    '''
Username rules
    usernaes must be unique
Password rules
    at least 8 characters
    at least one uppercase letter 
    at least one lowercase letter
    at least one digit
    at least one special character
'''

    usernames = ('lyang', 'kSimon', 'danny', 'tomatcpp', 'csDept', 'CoScpp', 'broncoWins', 'ponyExp', 'BldgAndRooms', 'helloKitty')
    passwords = ['sheCodes#123', 'catchAllGood1%', '@my2Choices', '123abc;;;', 'Hello2Monday$', 'GoodFriday@Cpp2', 'CS2520@Python', 'JavaIsHot2!', '2ManyRainingDays!', '1Startup@Starbucks']

    loginInfo = dict(zip(usernames, passwords))

    def authenticateUser(user_dict):
        attempts_left = 3
        
        while attempts_left > 0:
            username = input("Enter your username: ")
            if username in user_dict:
                password = input("Enter password: ")
                if user_dict[username] == password:
                    print("Login successful")
                    return username
                else:
                    print("Incorrect password")
                    attempts_left -= 1
            else:
                print("Username not found")
                attempts_left -= 1
        print("Login failed. Out of attempts")
        return None
    
    def createUser(users_dict):
        username = input("Please enter a username: ")
        if username in users_dict:
            print("Username taken")
            return None
        password = input("Please enter password (at least 8 characters, a lowercase letter, an uppercase letter, and a special symbol): ")
        if not (len(password) >= 8 
            and any(char.islower() for char in password) 
            and any(char.isupper() for char in password) 
            and any(char.isdigit() for char in password) 
            and any(char.isascii() 
            and not char.isalnum() for char in password)):
            print("Password does not meet requirements")
            return None
        else:
            users_dict[username] = password
            print("User " + username + " created successfully")
            return username
        
    def updatePassword(users_dict, username):
        currentPassword = input("Please enter your current password:")
        if users_dict[username] == currentPassword:
            newPassword = input("Please enter a new password: ")
            
            while not (len(newPassword) >= 8 
                and any(char.islower() for char in newPassword) 
                and any(char.isupper() for char in newPassword) 
                and any(char.isdigit() for char in newPassword) 
                and any(char.isascii() 
                and not char.isalnum() for char in newPassword)):
                print("Password does not meet requirements")
                newPassword = input("Please enter a new password:")

            users_dict[username] == newPassword
            return True
        else:
            return False
    
    # Test run 1
    print("Test run 1")
    print("Testing authenticate user function")
    username = authenticateUser(loginInfo)
    if username:
        print(f"Logged in as {username}")

    print("Testing create user function:")
    newUser = createUser(loginInfo)
    if newUser:
        print(f"Welcome {newUser}")

    if newUser:
        print("Testing update password function")
        updatePassword(loginInfo, newUser)

    # Test run 2

    # Setting up users
    testUsers = ('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l')
    testPasswords = ['aA1234456!', 'bB1234456!', 'cC1234456!', 'dD1234456!', 'eE1234456!', 'fF1234456!', 
                     'gG1234456!', 'hH1234456!', 'iI1234456!', 'jJ1234456!', 'kK1234456!', 'lL1234456!']
    loginInfo2 = dict(zip(testUsers, testPasswords))

    # Displaying current runs users/pass
    print("Test run #2 usernames and passwords")
    print(loginInfo2)

    print("Testing authenticate user function")
    username2 = authenticateUser(loginInfo2)
    if username2:
        print(f"Logged in as {username2}")

    print("Testing create user function:")
    newUser2 = createUser(loginInfo2)
    if newUser2:
        print(f"Welcome {newUser2}")

    if newUser2:
        print("Testing update password function")
        updatePassword(loginInfo2, newUser2)

    '''
    Test run 1
    Testing authenticate user function
    Enter your username: lyang
    Enter password:sheCodes123 
    Incorrect password
    Enter your username: lyang
    Enter password:sheCodes#123
    Login successful
    Logged in as lyang
    Testing create user function:
    Please enter a username: darrel
    Please enter password (at least 8 characters, a lowercase letter, an uppercase letter, and a special symbol): Darrel123!
    User darrel created successfully
    Welcome darrel
    Testing update password function
    Please enter your current password:Darrel123!
    Please enter a new password: Darrel123456!
    '''
    '''
    Test run #2 usernames and passwords
    {'a': 'aA1234456!', 'b': 'bB1234456!', 'c': 'cC1234456!', 'd': 'dD1234456!', 'e': 'eE1234456!', 'f': 'fF1234456!', 'g': 'gG1234456!', 'h': 'hH1234456!', 'i': 'iI1234456!', 'j': 'jJ1234456!', 'k': 'kK1234456!', 'l': 'lL1234456!'}
    Testing authenticate user function
    Enter your username: a
    Enter password:aA1234456!
    Login successful
    Logged in as a
    Testing create user function:
    Please enter a username: z
    Please enter password (at least 8 characters, a lowercase letter, an uppercase letter, and a special symbol): zZ123456!
    User z created successfully
    Welcome z
    Testing update password function
    Please enter your current password:zZ123456!
    Please enter a new password: Darrel1234!
    '''
def task2():
    # Test run number 1
    print("First test run:")
    L1 = list(primerange(2, 231))[:50]  
    L2 = [random.randint(0, 100) for _ in range(50)]  

    S1 = set(L1)
    S2 = set(L2)

    print(f"Number of elements in set S1: {len(S1)}")
    print(f"Number of elements in set S2: {len(S2)}")

    R1 = S1.intersection(S2)  
    R2 = S1.symmetric_difference(S2)  

    print(f"Number of elements in set R1: {len(R1)}")
    print(f"Number of elements in set R2: {len(R2)}")

    # Test run number 2
    print("Test run 2")

    # List of 50 first 50 primes numbers random
    L1 = list(primerange(2, 251))[:50]
    # List of 50 random intergers between 50-150
    L2 = [random.randint(50, 150) for _ in range(50)]

    S1 = set(L1)
    S2 = set(L2)

    print(f"Number of elements in set S1 (Test Run 2): {len(S1)}")
    print(f"Number of elements in set S2 (Test Run 2): {len(S2)}")

    R1 = S1.intersection(S2)  
    R2 = S1.symmetric_difference(S2)  
    
    print(f"Number of elements in set R1 (Test Run 2): {len(R1)}")
    print(f"Number of elements in set R2 (Test Run 2): {len(R2)}")  

'''Task 2
    First test run:
    Number of elements in set S1: 50
    Number of elements in set S2: 41
    Number of elements in set R1: 13
    Number of elements in set R2: 65

    Test run 2:
    Number of elements in set S1 (Test Run 2): 50
    Number of elements in set S2 (Test Run 2): 39
    Number of elements in set R1 (Test Run 2): 10
    Number of elements in set R2 (Test Run 2): 69
'''
def task3():

    def tryTuple(*args):
        min = args[0]
        max = args[0]
        for arg in args:
            if arg < min:
                min = arg
            if arg > max:
                max = arg
        return min, max, len(args)
    
    print("Test run 1: tryTuple(3, 5, 12, 9, 1, 2)")
    result1 = tryTuple(3, 5, 12, 9, 1, 2)
    print("Test Run 1 Result:", result1)

    print('Test run 2: tryTuple("hi", "bye", "happy")')
    result2 = tryTuple("hi", "bye", "happy")
    print("Test Run 2 Result:", result2)

    print('Test run 3: tryTuple(["cat", 3], ["dog", 2]')
    result3 = tryTuple(["cat", 3], ["dog", 2])
    print("Test Run 3 Result:", result3)

'''
Task 3
Test run 1: tryTuple(3, 5, 12, 9, 1, 2)
Test Run 1 Result: (1, 12, 6)

Test run 2: tryTuple("hi", "bye", "happy")
Test Run 2 Result: ('bye', 'hi', 3)

Test run 3: tryTuple(["cat", 3], ["dog", 2]
Test Run 3 Result: (['cat', 3], ['dog', 2], 2)
'''

def main():
    print("Task 1")
    task1()
    print()
    print("Task 2")
    task2()
    print()
    print("Task 3")
    task3()
main()
import re
from collections import Counter
from wordcloud import WordCloud
import matplotlib.pyplot as plt

class Pair:
    def __init__(self, x=0, y=0):
        self.x = x
        self.y = y
    
    def __str__(self):
        return f'{self.x},{self.y}'

    def __add__(self, p2):
        res_x = self.x + p2.x
        res_y = self.y + p2.y

        return Pair(res_x, res_y)
    
    def __mul__(self, p2):
        res_x = self.x * p2.x
        res_y = self.y * p2.y

        return Pair(res_x, res_y)
    #p1 / p2 => <x1*y1-x2*y2, x1*x2 – y1*y2>
    def __truediv__(self, p2):
        res_x = (self.x * self.y) - (p2.x * p2.y)
        res_y = (self.x / p2.x) - (self.y * p2.y)

        return Pair(res_x, res_y)
    
class Bike:

    def __init__(self, gear, speed):
        self.gear = gear
        self.speed = speed
        self.light = False

    def applyBrake(self, decrementAmt):
        self.speed -= decrementAmt
        if self.speed < 0:
            self.speed = 0
    def speedUp(self, incrementAmt):
        self.speed += incrementAmt
    
    def __str__(self):
        return f'No of gears are {self.gear}\nSpeed of the bicycle is {self.speed}\n'
    
    def isLightOn(self):
        return self.light

    def lightOn(self):
        if self.light:
            print('Light already on')
        else:
            self.light = True
    def lightOff(self):
        if not self.light:
            print('Light already off')
        else:
            self.light = False

class MountainBike(Bike):

    def __init__(self, gear, speed, startHeight):
        super().__init__(gear, speed)
        self.seatHeight = startHeight
    
    # Slows faster since mountain bike brakes are better than regular bikes
    def applyBrake(self, decrementAmt):
        self.speed -= 2 * decrementAmt 

    def ringBell(self):
        print("Ding Ding Ding")

    def setHeight(self, seatHeight):
        self.seatHeight = seatHeight

    def __str__(self):
        return f'{super().__str__()}Seat height is {self.seatHeight}\n'
    
def task1():
    attempts = 0
    while attempts < 3:
        try:
            filename = input("Enter the name of the text file: ")
            with open(filename, 'r') as file:
                lines = file.readlines()
            break
        except FileNotFoundError:
            print("File not found. Please try again.")
            attempts += 1
            if attempts == 3:
                print("Max attempts of 3 reached")
                return

    words = []

    for line in lines:
        # remove non-lettered words then convert to lowercase
        cleanLine = re.sub(r'[^a-zA-Z\s]', '', line).lower()
        cleanWords = cleanLine.split()
        words.extend(cleanWords)

    totalLines = len(lines)
    totalWords = len(words)

    print(f'Total number of lines: {totalLines}\nTotal number of words: {totalWords}')

    distinctWords = set()

    # Word Count dictionary using Counter
    wordCount = Counter(words)

    # Sorting words by count decsending
    sortedWords = sorted(wordCount.items(), key=lambda x: -x[1])

    # for word, count in sortedWords:
    #     print(f'({word}, {count})')

    results_str = ', '.join(f"({word}, {count})" for word, count in sortedWords)
    print(results_str)

    wordCloud = WordCloud(width=800, height=400, background_color='white').generate_from_frequencies(wordCount)
    plt.figure(figsize=(10, 5))
    plt.imshow(wordCloud)
    plt.axis('off')
    plt.show()
    
'''
    Test Case 0
    Enter the name of the text file: a
    File not found. Please try again.
    Enter the name of the text file: a
    File not found. Please try again.
    Enter the name of the text file: a
    File not found. Please try again.
    Max attempts of 3 reached

    Test Case 1
    Enter the name of the text file: Python.txt
    Total number of lines: 12
    Total number of words: 128
    (the, 9), (machine, 6), (learning, 6), (python, 5), (is, 5), (a, 5), (of, 5), (to, 5), (learn, 4), (and, 4), (computer, 3), (programming, 2), (that, 2), (from, 2), (data, 2), (into, 2), (high, 1), (level, 1), (general, 1), (purpose, 1), (language, 1), (design, 1), (philosophy, 1), (emphasizes, 1), (code, 1), (readability, 1), (consistently, 1), (ranks, 1), (as, 1), (one, 1), (most, 1), (popular, 1), (languages, 1), (field, 1), (science, 1), (uses, 1), (statistical, 1), (techniques, 1), (give, 1), (programs, 1), (ability, 1), (past, 1), (experiences, 1), (improve, 1), (how, 1), (they, 1), (perform, 1), (specific, 1), (tasks, 1), (you, 1), (will, 1), (steps, 1), (necessary, 1), (create, 1), (successful, 1), (application, 1), (with, 1), (scikit, 1), (library, 1), (making, 1), (studying, 1), (statistics, 1), (step, 1), (direction, 1), (artificial, 1), (intelligence, 1), (program, 1), (analyses, 1), (learns, 1), (predict, 1), (outcome, 1), (get, 1), (ready, 1), (dive, 1), (world, 1), (by, 1), (using, 1)

    Test Case 2
    Enter the name of the text file: a            
    File not found. Please try again.
    Enter the name of the text file: b
    File not found. Please try again.
    Enter the name of the text file: bee-movie.txt
    Total number of lines: 99
    Total number of words: 313
    (barry, 23), (the, 11), (adam, 11), (a, 10), (is, 9), (black, 6), (janet, 6), (you, 6), (yellow, 5), (of, 4), (to, 4), (and, 4), (i, 4), (be, 3), (little, 3), (flies, 3), (benson, 3), (in, 3), (three, 3), (days, 3), (bees, 2), (can, 2), (all, 2), (bee, 2), (its, 2), (out, 2), (it, 2), (up, 2), (on, 2), (phone, 2), (through, 2), (stairs, 2), (martin, 2), (your, 2), (those, 2), (im, 2), (were, 2), (very, 2), (proud, 2), (barrys, 2), (got, 2), (fuzz, 2), (house, 2), (by, 2), (who, 2), (hey, 2), (day, 2), (school, 2), (artie, 2), (narrator, 1), (screen, 1), (with, 1), (text, 1), (sound, 1), (buzzing, 1), (heard, 1), (according, 1), (known, 1), (laws, 1), (aviation, 1), (there, 1), (no, 1), (way, 1), (should, 1), (able, 1), (fly, 1), (wings, 1), (are, 1), (too, 1), (small, 1), (get, 1), (fat, 1), (body, 1), (off, 1), (ground, 1), (course, 1), (anyway, 1), (because, 1), (dont, 1), (care, 1), (what, 1), (humans, 1), (think, 1), (impossible, 1), (picking, 1), (shirt, 1), (ooh, 1), (lets, 
    1), (shake, 1), (breakfast, 1), (ready, 1), (coming, 1), (hang, 1), (second, 1), (uses, 1), (his, 1), (antenna, 1), (like, 1), (hello, 1), (flayman, 1), (believe, 1), (this, 1), (happening, 1), (cant, 1), (ill, 1), (pick, 1), (down, 1), (looking, 1), (sharp, 1), (use, 1), (father, 1), (paid, 1), (good, 1), (money, 1), (for, 1), (sorry, 1), (excited, 1), (heres, 1), (graduate, 1), (son, 1), (perfect, 1), (report, 1), (card, 1), (bs, 1), (rubs, 1), (hair, 1), (ma, 1), (thing, 1), (going, 1), (here, 1), (lint, 1), (ow, 1), (thats, 1), (me, 1), (wave, 1), (us, 1), (well, 1), (row, 1), (bye, 1), (door, 1), (told, 1), (stop, 1), (flying, 1), (drives, 1), (hiveand, 1), (waved, 1), (at, 1), (reading, 1), (newspaper, 1), (gets, 1), (car, 1), (that, 1), (gel, 1), (special, 1), (graduation, 1), (never, 1), (thought, 1), (id, 1), (make, 1), (pulls, 1), (away, 1), (from, 1), (continues, 1), (driving, 1), (grade, 1), (high, 1), (awkward, 1), (college, 1), (glad, 1), (took, 1), (hitchhiked, 1), 
    (around, 1), (hive, 1), (did, 1), (come, 1), (back, 1), (different, 1), (pass, 1), (jogging, 1), (hi, 1)
    '''

def task2():
    # Test Case 1
    p1 = Pair(3, 2)
    p2 = Pair(1, 5)
    p3 = Pair(4,3)

    res1 = p1 + p2
    res2 = p1 * p2
    res3 = p1 / p2

    res4 = p1 + p2 * p3
    res5 = p1 * p2 + p1

    pList = [p1 , p2, p3, res1, res2, res3, res4, res5]
    print('Test Case 1')
    for pair in pList:
        print(pair)

    # Test Case 2
    p1 = Pair(1,1)
    p2 = Pair(2,2)
    p3 = Pair(3,3)

    res1 = p1 + p2
    res2 = p1 * p2
    res3 = p2 / p1
    
    res4 = p1 * p3 / p2
    res5 = p2 / p1 / p3

    pList = [p1 , p2, p3, res1, res2, res3, res4, res5]
    print('Test Case 2')
    for pair in pList:
        print(pair)
    '''
    Test Case 1
        3,2
        1,5
        4,3
        4,7
        3,10
        1,-7.0
        7,17
        6,12
    Test Case 2
        1,1
        2,2
        3,3
        3,3
        2,2
        3,0.0
        5,-4.5
        -9.0,1.0
'''

def task3():
    # Bike setup
    bike = Bike(5, 0)
    print(f'Bike:\n{bike}')

    speedUpAmt = 200
    bike.speedUp(speedUpAmt)
    print(f'Calling speedUp({speedUpAmt}):\n{bike}')

    brakeAmt = 100
    bike.applyBrake(brakeAmt)
    print(f'Calling applyBrake({brakeAmt}):\n{bike}')

    print(f'Calling lightOff() when light is already off')
    bike.lightOff()

    print('Calling lightOn()')
    bike.lightOn()
    print(f'The bike light is on: {bike.isLightOn()}')

    # Mountain bike setup
    mb = MountainBike(3, 100, 25)
    print(f'Mountain bike:\n{mb}')

    print(f'Mountain bike before methods called:\n{mb}')
    print('Calling setHeight(30), applyBreak(25), and ringBell()')
    mb.setHeight(30)
    mb.applyBrake(25)
    mb.ringBell()
    print(mb)

    '''
    Bike:
    No of gears are 5
    Speed of the bicycle is 0

    Calling speedUp(200):
    No of gears are 5
    Speed of the bicycle is 200

    Calling applyBrake(100):
    No of gears are 5
    Speed of the bicycle is 100

    Calling lightOff() when light is already off
    Light already off
    Call lightOn()
    The bike light is on: True

    Mountain bike:
    No of gears are 3
    Speed of the bicycle is 100
    Seat height is 25

    Mountain bike before methods called:
    No of gears are 3
    Speed of the bicycle is 100
    Seat height is 25

    Calling setHeight(30), applyBreak(25), and ringBell()
    Ding Ding Ding
    No of gears are 3
    Speed of the bicycle is 50
    Seat height is 30
    '''

def main():
    # task1()
    # task2()
    task3()
    
if __name__ == '__main__':
    main()

        

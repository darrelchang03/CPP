'''
(1) create a name list by reading in names one by one. (For test 1, read in 5 names: "Ben", "Ada", "Jane", "Ken", "Rose".)
(2) sort the name list in ascending order of names. 
(3) use list comprehension feature (i.e. one line of code) to create a tuple of scores.
Note: the tuple has the same length as the name list; scores randomly generated integers in range [0, 10]. 
(4) create a dictionary from the above two lists with names as key and scores as value.
(5) calculate the maximum and minimum score by going through each dictionary element.
(6) print out the maximum and minimum scores.
'''
import random

name = input("Enter a name (\"\" to finish): ")
names = []
while name != "":
    names.append(name)
    name = input("Enter a name (\"\" to finish): ")
names.sort()
scores = tuple(random.randint(0,10) for _ in names)
d = dict(zip(names, scores))

print(scores)
minScore = scores[0]
maxScore = scores[0]
for score in d.values():
    minScore = min(score, minScore)
    maxScore = max(score, maxScore)

print("Max score: %d" % maxScore)
print("Min value: %d" % minScore)

'''
Test run 1
names: "Ben", "Ada", "Jane", "Ken", "Rose"
Enter a name ("" to finish): Ben
Enter a name ("" to finish): Ada
Enter a name ("" to finish): Jane
Enter a name ("" to finish): Ken
Enter a name ("" to finish): Rose
Enter a name ("" to finish): 
(6, 0, 8, 7, 7)
Max score: 6
Min value: 0

Test run 2:
names: "Darrel", "Ben", "Billy", "Bob", "Brick", "Boe", "Bing", "Barrel", "Boston", "Breezey"
Enter a name ("" to finish): Darrel
Enter a name ("" to finish): Ben
Enter a name ("" to finish): Billy
Enter a name ("" to finish): Bob
Enter a name ("" to finish): Brick
Enter a name ("" to finish): Boe
Enter a name ("" to finish): Bing
Enter a name ("" to finish): Barrel
Enter a name ("" to finish): Boston
Enter a name ("" to finish): Breezey
Enter a name ("" to finish): 
(1, 0, 2, 0, 6, 9, 5, 4, 0, 10)
Max score: 10
Min value: 0
'''

    
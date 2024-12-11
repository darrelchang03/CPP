import random

nameLst = ['Kevin', 'Ada', 'Jenny', 'Ade', 'Betty', 'Sam', 'Kenny', 'Beta', 'Berry', 'Terry', 'Nathan', 'Jess']

ageLst = [random.randint(18,25) for _ in nameLst]

infoLst = list(zip(nameLst, ageLst))

def aveAge(L):
    if not L:
        return 0 

    total_age = sum(age for _, age in infoLst)
    return total_age / len(L)

def sortLst(L):
    if not L:
        return 0
    
    sorted_list = sorted(L)
    reversed_list = sorted(L, reverse=True)
    return sorted_list, reversed_list

def main():
    nameLst = ['Kevin', 'Ada', 'Jenny', 'Ade', 'Betty', 'Sam', 'Kenny', 'Beta', 'Berry', 'Terry', 'Nathan', 'Jess']

    ageLst = [random.randint(18,25) for _ in nameLst]

    infoLst = list(zip(nameLst, ageLst))

    avg = aveAge(infoLst)
    print("Average:", avg)

    sorted_list, reversed_list = sortLst(infoLst)
    print("Sorted list:", sorted_list)
    print("Reversed list:", reversed_list)

main()

'''
Test run 
Average: 21.75
Sorted list: [('Ada', 22), ('Ade', 23), ('Berry', 25), ('Beta', 23), ('Betty', 20), ('Jenny', 24), ('Jess', 23), ('Kenny', 18), ('Kevin', 20), ('Nathan', 24), ('Sam', 20), ('Terry', 25)]
Reversed list: [('Terry', 25), ('Sam', 20), ('Nathan', 24), ('Kevin', 20), ('Kenny', 18), ('Jess', 23), ('Jenny', 24), ('Betty', 20), ('Beta', 23), ('Berry', 25), ('Ade', 23), ('Ada', 22)]
'''
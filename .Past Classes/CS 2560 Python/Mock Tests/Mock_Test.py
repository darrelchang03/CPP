# import random

# list = [random.randint(0,50) for _ in range (100)]
# for i, x in enumerate(list):
#     print(x, end=' ')
#     if i > 19 and i % 19 == 0:
#         print()

# for i in range(-10,11, 2):
#     # print(i)


# import time
# def ackerman(m,n):
#     if m == 0:
#         return n+1
#     if m > 0 and n == 0:
#         return ackerman(m-1,1)
#     if m > 0 and n > 0:
#         return ackerman(m-1, ackerman(m, n-1))
# def main():
#     start = time.time()
#     print(ackerman(3,6))
#     end = time.time()
#     print("Execution time %.3f" % (end-start))

# if __name__ == '__main__':
#     main()
# '''
# 2
# Execution time 0.001
# '''

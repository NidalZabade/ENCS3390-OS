from threading import Thread
import time


array = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
evenArray = []
oddArray = []
mergeArray = []
flag = [True, True]


def even(array):
    global evenArray, flag
    for i in array:
        if i % 2 == 0:
            evenArray.append(i)
    evenArray.sort()
    flag[0] = False


def odd(array):
    global oddArray, flag
    for i in array:
        if i % 2 != 0:
            oddArray.append(i)
    oddArray.sort()
    flag[1] = False


def merge(a1, a2):
    global mergeArray
    mergeArray = a1+a2


def main():
    global evenArray, oddArray, mergeArray, array

    t1 = Thread(target=even, args=(array,))
    t2 = Thread(target=odd, args=(array,))
    t3 = Thread(target=merge, args=(evenArray, oddArray))

    t1.start()
    t2.start()
    while flag[0] or flag[1]:
        continue
    t3.start()

    print("Even Array: ", evenArray)
    print("Odd Array: ", oddArray)
    print("Merge Array: ", mergeArray)


main()
